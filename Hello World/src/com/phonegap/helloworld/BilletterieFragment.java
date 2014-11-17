package com.phonegap.helloworld;


import org.apache.cordova.Config;
import org.apache.cordova.CordovaWebView;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BilletterieFragment extends CordovaFragmentAbstract {

	private Button toast;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutInflater localInflater = inflater.cloneInContext(new CordovaContext(getActivity(), this));
        View rootView = localInflater.inflate(R.layout.second_frag, container, false);
        myWebView = (CordovaWebView) rootView.findViewById(R.id.secondFragWebView);
        Config.init(getActivity());
        myWebView.getSettings().setJavaScriptEnabled(true);
//        myWebView.loadUrl(Config.getStartUrl());
        //myWebView.setWebChromeClient(new WebChromeClient());
//        myWebView.setWebChromeClient(new WebChromeClient() {
//        	   public void onProgressChanged(WebView view, int progress) {
//        	     // Activities and WebViews measure progress with different scales.
//        	     // The progress meter will automatically disappear when we reach 100%
//        	     //activity.setProgress(progress * 1000);
//        		   getActivity().setProgress(progress * 1000);
//        	   }
//        	 });
     //   myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("file:///android_asset/www/html/billeterie.html");
        
				
				NotificationCompat.Builder mBuilder =
				        new NotificationCompat.Builder(this.getActivity())
				        .setSmallIcon(R.drawable.icon_notif)
				        .setContentTitle("Une nouvelle actu")
				        .setContentText("Parc Asterix!");


				
				int notificationId = 001;
				Intent viewIntent = new Intent(this.getActivity(), HomeActivity.class);

				PendingIntent viewPendingIntent =
				        PendingIntent.getActivity(this.getActivity(), 0, viewIntent, 0);
				
				mBuilder.setContentIntent(viewPendingIntent);


				NotificationManager mNotificationManager =
			    (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
			// mId allows you to update the notification later on.
			mNotificationManager.notify(notificationId, mBuilder.build());


        return rootView;
    }
    
    
}
