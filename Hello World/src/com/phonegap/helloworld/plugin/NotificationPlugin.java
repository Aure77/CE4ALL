package com.phonegap.helloworld.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.phonegap.helloworld.HomeActivity;
import com.phonegap.helloworld.R;
import com.phonegap.helloworld.fake.Billet;
import com.phonegap.helloworld.fake.BilletterieFactory;

public class NotificationPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
		
		if (action.equals("buy-ticket")){
            try {
            	//final String responseText = "Le billet #" + args.getInt(0) + " a bien été achété !"; 
            	Billet ticket = BilletterieFactory.findTicket(args.getInt(0));
//                Map<String, String> copyFrom = new HashMap<String, String>();
//                copyFrom.put("ticket", ticket.toString());
//                copyFrom.put("ticketMessage", "Le billet #" + args.getInt(0) + " a bien été achété !");
				JSONObject jsonTicket = new JSONObject();
				jsonTicket.put("id", ticket.getId());
				jsonTicket.put("title", ticket.getTitle());
				jsonTicket.put("validity", ticket.getValidity());
				jsonTicket.put("text", ticket.getText());
				jsonTicket.put("price", ticket.getPrice());
				jsonTicket.put("type", ticket.getType());
				jsonTicket.put("imageUrl", ticket.getImageUrl());
				JSONObject responseText = new JSONObject();
				responseText.put("ticket", jsonTicket);
				responseText.put("ticketMessage", "Le billet #" + args.getInt(0) + " a bien été achété !");
				callbackContext.success(responseText );
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
						
							Bitmap icon = BitmapFactory.decodeResource(activity.getResources(), R.drawable.notif_icon_96);
							NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(activity)
									.setSmallIcon(R.drawable.notif_icon)
									.setLargeIcon(icon)
									.setContentTitle(title)
									.setContentText(message)
									.setVibrate(new long[] { 200, 800, 200 });
	
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
