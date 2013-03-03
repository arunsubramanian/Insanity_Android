package com.Insanity_WR_app.android.pro;

 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
 

public class Jacoby_AppsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        UserInfoData entry = new UserInfoData(this);
    	
    	entry.open();
    	
    	final String data = entry.getData();
    	
    	entry.close();
        Thread splashTimer = new Thread(){
        	public void run(){
        		try{
        			sleep(3000);
        			
        	}
        		catch(InterruptedException e){
        			
        			e.printStackTrace();
        		}
            finally{
            	if (!data.equals("")){
        			startActivity(new Intent ("com.JacobyApps.android.mainMenuPro")); 
        	}
        		else{
         
        startActivity(new Intent ("android.intent.action.SignupPro"));
        	}
            	finish();
            	 
            }
        	 
        	}
        	
        };
        splashTimer.start();
    }
}