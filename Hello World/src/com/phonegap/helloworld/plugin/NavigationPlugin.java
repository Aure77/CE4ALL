package com.phonegap.helloworld.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.phonegap.helloworld.HomeActivity;

public class NavigationPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("navigate")) {
			try {
				final HomeActivity homeActivity = (HomeActivity) cordova.getActivity();
				homeActivity.runOnUiThread(new Runnable() {					
					@Override
					public void run() {						
						try {
							homeActivity.highlightMenu(args.getInt(0));
							Log.d("Menu", "highlighted menu : " + args.getInt(0));
						} catch (JSONException e) {
							callbackContext.error("Failed to parse parameters");
						}
						callbackContext.success("ok");
					}
				});
				return true;
			} catch (Exception e) {
				callbackContext.error("Unable to run activity : " + e.getMessage());
			}
		}
		return false;
	}

}
