package com.phonegap.helloworld;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaWebView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActualityFragment extends CordovaFragmentAbstract {
     
    public ActualityFragment(){}
    
    public static final int MENU_ID_TO_HIGHLIGHT = 1;
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
    	  LayoutInflater localInflater = inflater.cloneInContext(new CordovaContext(getActivity(), this));
          View rootView = localInflater.inflate(R.layout.my_cordova_frag, container, false);
          myWebView = (CordovaWebView) rootView.findViewById(R.id.myWebView);
          Config.init(getActivity());
          myWebView.getSettings().setJavaScriptEnabled(true);

          myWebView.loadUrl("file:///android_asset/www/html/actualite.html");

          return rootView;
    }
}