package com.phonegap.helloworld.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.phonegap.helloworld.HomeActivity;
import com.phonegap.helloworld.R;

public class NotificationPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
		
		if (action.equals("buy-ticket")){
            try {
            	final String responseText = "Le billet #" + args.getInt(0) + " a bien été achété !";
                callbackContext.success(responseText);
                return true;
            } catch (JSONException e) {
                callbackContext.error("Failed to parse parameters");
            }
            return false;
        } else if (action.equals("notify")) {
			try {
				final Activity activity = cordova.getActivity();
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						try {
							int notificationId = args.getInt(0);
							String title = args.getString(1);
							String message = args.getString(2);
						
							NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(activity)
									.setSmallIcon(R.drawable.icon_notif)
									.setContentTitle(title)
									.setContentText(message);
	
							Intent viewIntent = new Intent(activity, HomeActivity.class);
	
							PendingIntent viewPendingIntent = PendingIntent.getActivity(activity, 0, viewIntent, 0);
	
							mBuilder.setContentIntent(viewPendingIntent);
	
							NotificationManager mNotificationManager = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
							// mId allows you to update the notification later on.
							mNotificationManager.notify(notificationId,	mBuilder.build());
	
							callbackContext.success("ok");
						} catch (JSONException e) {
							callbackContext.error("Failed to parse parameters");
						}
					}
				});
				return true;
			} catch (Exception e) {
				callbackContext.error("Unable to run activity : " + e.getMessage());
			}
		} else if (action.equals("navigate")) {
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
