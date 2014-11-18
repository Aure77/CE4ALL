package com.phonegap.helloworld;

import com.phonegap.helloworld.util.DeviceDetector;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {

	 // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
    /** Called when the activity is first created. */
   	private static int myProgress=0;
   	private ProgressBar progressBar;
   	private int progressStatus=0;
   	private Handler myHandler=new Handler();
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if(DeviceDetector.isTablet(this)) {
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // force landscape on tablet
        }
        
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        beginYourTask(getCurrentFocus());
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    
    public void beginYourTask(View view)
    {
    	myProgress=0;
        progressBar=(ProgressBar)findViewById(R.id.myProgress);
        progressBar.setMax(100);
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(progressStatus<100)
				{
					progressStatus=performTask();
					myHandler.post(new Runnable()
					{
					public void run() {
					progressBar.setProgress(progressStatus);
					}
					});
					
				}
				myHandler.post(new Runnable() {
					
					@Override
					public void run() {
	                   progressStatus=0; 
	                   myProgress=0;
						
					}
				});
				
			}
			private int performTask()
			{
				try {
					//---Do some task---
					Thread.sleep(100);
					} catch (InterruptedException e)
					{
					e.printStackTrace();
					}
					return ++myProgress*5;	
			}
		}).start();
   }


}
