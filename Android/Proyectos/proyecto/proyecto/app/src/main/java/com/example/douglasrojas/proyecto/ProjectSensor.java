package com.example.douglasrojas.proyecto;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class ProjectSensor extends AppCompatActivity {

    ProgressBar progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    TextView txtRes;
    TextView txtMag;
    TextView txtTemp;
    TextView txtRpm;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    String address = null;
    Button btnDis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_sensor);

        Intent newint = getIntent();
        address = newint.getStringExtra(MainActivity.EXTRA_ADDRESS);
        progress = findViewById(R.id.progressBar);

        txtRes = findViewById(R.id.txtRes);
        txtMag = findViewById(R.id.txtMag);
        txtRpm = findViewById(R.id.txtRPM);
        txtTemp = findViewById(R.id.txtTemp);

        new ConnectBT().execute();

        btnDis = findViewById(R.id.btnDis1);
        btnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disconnect(); //close connection
            }
        });
    }

    private void Disconnect() {
        if (btSocket != null) //If the btSocket is busy
        {
            try {
                btSocket.close(); //close connection
                isBtConnected = false;
            } catch (IOException e) {
                msg("Error");
            }
        }
        finish(); //return to the first layout

    }


    private void msg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true;

        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... devices) {
            try {
                if (btSocket == null || !isBtConnected) {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();

                }
            } catch (IOException e) {
                ConnectSuccess = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess) {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            } else {
                msg("Connected.");
                isBtConnected = true;
                new BluetoothReader().execute();
            }
            progress.setVisibility(View.INVISIBLE);
        }

        public void execute() {
        }
    }


    private class BluetoothReader extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... devices) {
            while (btSocket != null && isBtConnected) {
                try {
                    btSocket.getOutputStream().write(0);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(btSocket.getInputStream()));
                    String line = reader.readLine();
                    String values[] = line.split(",");
                    if (values.length == 4) {
                        txtRes.setText("Resistencia: " + values[0]);
                        txtMag.setText("Magnetico: " + values[1]);
                        txtTemp.setText("Temperatura: " + values[2]);
                        txtRpm.setText("RPM : " + values[3]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }
}
