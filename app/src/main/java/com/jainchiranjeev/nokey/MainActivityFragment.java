package com.jainchiranjeev.nokey;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    AppCompatTextView tagIdTv1;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        tagIdTv1 = (AppCompatTextView) view.findViewById(R.id.tagid_tv1);

        try {
            Intent intent = getActivity().getIntent();
            Tag nfcTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            tagIdTv1.setText(nfcTag.getId().toString());
            Log.d("Tag",nfcTag.toString());
        } catch (NullPointerException NPE) {
            Log.e("Tag Reader",NPE.toString());
        }

        return view;
    }
}
