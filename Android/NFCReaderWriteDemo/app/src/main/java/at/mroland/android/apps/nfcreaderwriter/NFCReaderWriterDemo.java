package at.mroland.android.apps.nfcreaderwriter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.nio.charset.Charset;
import java.util.Arrays;

public class NFCReaderWriterDemo extends AppCompatActivity {
    private static final int    DIALOG_NEW_TAG = 3;
    private static final String ARG_MESSAGE = "message";
    private static final int    DIALOG_WRITE_URL = 1;
    private EditText            mMyUrl;
    private Button              mMyWriteUrlButton;
    private boolean             mWriteUrl = false;
    private static final int    PENDING_INTENT_TECH_DISCOVERED =1;
    private NfcAdapter          mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcreader_writer_demo);
        mMyUrl = (EditText) findViewById(R.id.myUrl);
        mMyWriteUrlButton = (Button) findViewById(R.id.myWriteUrlButton);
        mMyWriteUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWriteUrl = true;
                NFCReaderWriterDemo.this.showDialog(DIALOG_WRITE_URL);
            }
        });
    }

    public Dialog onCreateDialog(int id, Bundle args){
        switch(id){
            case DIALOG_WRITE_URL:
                return new AlertDialog.Builder(this)
                        .setTitle("WriteURL to tag...")
                        .setMessage("Touch tag to start writting")
                        .setCancelable(true)
                        .setNeutralButton(android.R.string.cancel,
                                new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface d, int arg){
                                        d.cancel();
                                    }
                                })
                        .setOnCancelListener(new DialogInterface.OnCancelListener(){
                            public void onCancel(DialogInterface d){
                                mWriteUrl = false;
                            }
                        }).create();
            case DIALOG_NEW_TAG:
                return new AlertDialog.Builder(this)
                        .setTitle("Tag detected")
                        .setCancelable(true)
                        .setNeutralButton(android.R.string.ok,
                                        new DialogInterface.OnClickListener(){
                                            public void onClick(DialogInterface d, int arg){
                                                d.dismiss();
                                            }
                                        }).create();
        }
        return null;
    }

    protected void onPrepareDialog(int id, Dialog dialog, Bundle args){
        switch(id){
            case DIALOG_NEW_TAG:
                String message = args.getString(ARG_MESSAGE);
                if(message != null)
                    ((AlertDialog) dialog).setMessage(message);
                break;
        }
    }

    public void onResume(){
        super.onResume();
        NfcManager nfcManager = (NfcManager)this.getSystemService(Context.NFC_SERVICE);
        mNfcAdapter = nfcManager.getDefaultAdapter();
        PendingIntent pi = createPendingResult(PENDING_INTENT_TECH_DISCOVERED, new Intent(), 0);
        mNfcAdapter.enableForegroundDispatch(
                this,
                pi,
                new IntentFilter[]{new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED)},
                new String[][]{
                        new String[]{"android.nfc.tech.NdefFormatable"},
                        new String[]{"android.nfc.tech.Ndef"},
                });
    }

    public void onPause(){
        super.onPause();
        mNfcAdapter.disableForegroundDispatch(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case PENDING_INTENT_TECH_DISCOVERED:
                resolveIntent(data, true);
                break;
        }
    }

    private void resolveIntent(Intent data, boolean foregroundDispatch){
        String action = data.getAction();
        if(NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)){
            Tag tag = data.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if(foregroundDispatch && mWriteUrl){
                mWriteUrl = false;
                String urlStr = mMyUrl.getText().toString();
                byte[] urlBytes = urlStr.getBytes(Charset.forName("UTF-8"));
                byte[] urlPayload = new byte[urlBytes.length + 1];
                urlPayload[0] = 0;
                System.arraycopy(urlBytes, 0, urlPayload, 1, urlBytes.length);
                NdefRecord urlRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                        NdefRecord.RTD_URI,
                        new byte[0],
                        urlPayload);
                NdefMessage msg = new NdefMessage(new NdefRecord[]{urlRecord});
                Ndef ndefTag = Ndef.get(tag);
                if(ndefTag != null){
                    try{
                        ndefTag.connect();
                        ndefTag.writeNdefMessage(msg);
                    } catch(Exception e){
                    } finally{
                        try{
                            ndefTag.close();
                        } catch(Exception e) { }
                    }
                } else{
                    NdefFormatable ndefFormatableTag = NdefFormatable.get(tag);
                    if(ndefFormatableTag != null){
                        try{
                            ndefFormatableTag.connect();
                            ndefFormatableTag.format(msg);
                        } catch(Exception e){
                        } finally {
                            try{
                                ndefFormatableTag.close();
                            }catch(Exception e){ }
                        }
                    }
                }
                dismissDialog(DIALOG_WRITE_URL);
            }
            else{
                StringBuilder tagInfo = new StringBuilder();
                byte[] uid = tag.getId();
                tagInfo.append("UID: ")
                        .append(StringUtils.convertByteArrayToHexString(uid))
                        .append("\n\n");
            }
        }


        Parcelable[] ndefRaw =
                data.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        NdefMessage[] ndefMsgs =  null;
        if(ndefRaw != null){
            ndefMsgs = new NdefMessage[ndefRaw.length];
            for(int i = 0; i < ndefMsgs.length; i++){
                ndefMsgs[i] = (NdefMessage) ndefRaw[i];
            }
        }


        if(ndefMsgs != null){
            for(int i = 0; i < ndefMsgs.length; i++){
                NdefRecord[] records = ndefMsgs[i].getRecords();
                if(records != null){
                    for(int j = 0; j < records.length; j++){
                        if((records[j].getTnf() == NdefRecord.TNF_WELL_KNOWN) &&
                                Arrays.equals(records[j].getType(), NdefRecord.RTD_URI)){
                            byte[] payload = records[j].getPayload();
                            String uri = new String(Arrays.copyOfRange(payload, 1, payload.length),
                                    Charset.forName("UTF-8"));
                            tagInfo.append("URI: ").append(uri).append("\n");
                        }
                    }
                }
            }
        }


    }
}
