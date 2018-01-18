package com.kavsoftware.kaveer.number2words.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by kaveer on 11/22/2017.
 */

public class Common {

    public  boolean isNetworkConnected(FragmentActivity activity, Context context){
        try {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) activity.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            return (mNetworkInfo == null) ? false : true;

        }catch (NullPointerException e){
            return false;

        }
    }

    public void DisplayToastFromFragment(FragmentActivity activity, String message){
        Toast messageBox = Toast.makeText(activity , message , Toast.LENGTH_LONG);
        messageBox.show();
    }


}
