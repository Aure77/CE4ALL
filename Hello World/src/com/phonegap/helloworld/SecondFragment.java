package com.phonegap.helloworld;


import org.apache.cordova.Config;
import org.apache.cordova.CordovaWebView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends CordovaFragmentAbstract {

	
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

        return rootView;
    }
    
    
}
