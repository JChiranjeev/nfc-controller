package com.jainchiranjeev.nokey;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //NFC Manager and Adapter for checking whether NFC on the device is enabled or not.
    NfcManager nfcManager;
    NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize NFC Manager and Adapter
        nfcManager = (NfcManager) getApplicationContext().getSystemService(Context.NFC_SERVICE);
        nfcAdapter = nfcManager.getDefaultAdapter();

        //Check if NFC is enabled or not
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            //Action when NFC is enabled
            Snackbar.make(findViewById(R.id.fragment),"NFC Enabled",Snackbar.LENGTH_SHORT).show();
        } else {
            //Action when NFC is disabled
            Snackbar.make(findViewById(R.id.fragment),"NFC Disabled",Snackbar.LENGTH_INDEFINITE)
                    .setAction("Enable", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent("android.settings.NFC_SETTINGS"));
                        }
                    }).show();
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
