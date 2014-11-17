package com.phonegap.helloworld.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class NotificationPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("buy-ticket")){
            try {
                String responseText = "Billet acheté : " + args.getString(0);
                callbackContext.success(responseText);
            } catch (JSONException e){
                callbackContext.error("Failed to parse parameters");
            }
            return true;
        }
        return false;
	}

}
