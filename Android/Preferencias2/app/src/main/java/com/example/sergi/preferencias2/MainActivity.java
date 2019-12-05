package com.example.sergi.preferencias2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button      jbn, jbn2;
    Intent      i, itn;
    int         TAKE_PICTURE = 1;
    int         SELECT_PICTURE = 2;
    String      s = "", l;
    SharedPreferences sp;
    String      nombre;
    Bundle      bdl;
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        s = Environment.getExternalStorageDirectory() + "/test.jpg";
        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        l = sp.getString("Nombre", "ESCOM");
        jbn = (Button)findViewById(R.id.xbn1);
        jbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                int code = 0;
                i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                code = SELECT_PICTURE;
                startActivityForResult(i, code);
            }
        });
        jbn2 = (Button)findViewById(R.id.xbn2);
        jbn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString();
                SharedPreferences.Editor miEditor = sp.edit();
                miEditor.putString("Nombre", l);
                miEditor.commit();
                Toast.makeText(getActivity(), "Preferencias guardadas", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PICTURE) {
            if (data != null) {
                if (data.hasExtra("data")) {
                    ImageView iv = (ImageView) findViewById(R.id.xiv1);
                    iv.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
                }
            } else {
                ImageView iv = (ImageView) findViewById(R.id.xiv1);
                iv.setImageBitmap(BitmapFactory.decodeFile(s));
                new MediaScannerConnection.MediaScannerConnectionClient() {
                    private MediaScannerConnection msc = null;
                    {
                        msc = new MediaScannerConnection(getApplicationContext(), this);
                        msc.connect();
                    }

                    public void onMediaScannerConnected() {
                        msc.scanFile(s, null);
                    }

                    public void onScanCompleted(String path, Uri uri) {
                        msc.disconnect();
                    }
                };
            }
        } else if (requestCode == SELECT_PICTURE) {
            Uri image = data.getData();
            InputStream is;
            try {
                is = getContentResolver().openInputStream(image);
                BufferedInputStream bis = new BufferedInputStream(is);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                ImageView iv = (ImageView) findViewById(R.id.xiv1);
                iv.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
            }
        }
    }

    public Context getActivity() {
        return this;
    }
}