package telephony.internal.android.com.wifi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import telephony.internal.android.com.wifi.R;


public class DisconnectFragmen extends Fragment {
    public static  final  int INDX = 2;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_disconnect,container,false);
    }
}
