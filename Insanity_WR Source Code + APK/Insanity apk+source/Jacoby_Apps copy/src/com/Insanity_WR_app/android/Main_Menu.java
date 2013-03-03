package com.Insanity_WR_app.android;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Main_Menu extends Activity {
DisplayMetrics displaymetrics;
public static final int Option1 = 1;
public static final int Option2  = 2;
public static final int Option3 = 3;
public static final int Option4 = 4;
int ht;
int wt;
 EditText min;
 EditText sec;
 Uri uri;
 View r;
 TextView time;
 ArrayList<String[]> weight;
 int count =0;
 Bitmap imgBitmap1;
 Bitmap imgBitmap2;
 Bitmap imgBitmap3;
 Bitmap imgBitmap4;
 Bitmap imgBitmap5;
 Bitmap imgBitmap6;
 
 ImageView bt1;
 ImageView bt2;
 ImageView bt3;
 ImageView bt4;
 ImageView bt5;
 ImageView bt6;
 double factor;
 
 float size= (float) ( .10*Math.pow(Math.pow(wt, 2)+ Math.pow(ht, 2),.5));
 ArrayList<String[]> values3=new ArrayList<String[]>();
 ArrayList<String[]> values2=new ArrayList<String[]>();
 ArrayList<String> values = new ArrayList<String>();
 int avgRow;

final Handler handler = new Handler();
Timer t = new Timer();
ImageView jump;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		 
		
		 
		 displaymetrics= new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
	    
	     LayoutDimensions ld = new LayoutDimensions();
		 ld.mainMenu();
	     ExerciseInfoData entry = new ExerciseInfoData(this);
	  	 entry.open();
	  	 values3=entry.getData2(); 
	  	 values2 = entry.getData();
	  	 entry.close();
	  	 
	  
	  	 
	  	// WeightInfoData weightData = new WeightInfoData(this);
	  	// weightData.open();
	  	// weight=weightData.getData();
	  	// weightData.close();
	      
	}
	
	public class LayoutDimensions{
		
	 

		public void mainMenu(){
			setContentView(R.layout.main);
			if(ht<330){
				factor=.45;
			}
			else{
				factor=.6;
			}
			 
		   RelativeLayout ad = (RelativeLayout)findViewById(R.id.ad1);
			//RelativeLayout ad2 = (RelativeLayout)findViewById(R.id.ad2);
			AdView adView = new AdView(Main_Menu.this, AdSize.BANNER, "d5ed4c6684f244ed");
			 
			//ad.addView(adView);
			ad.addView(adView);
		//	AdRequest request = new AdRequest();
			AdRequest request = new AdRequest();
			 
			adView.loadAd(request);
			 
			bt1=(ImageView)findViewById(R.id.button1);
			bt2=(ImageView)findViewById(R.id.button2);
			bt3=(ImageView)findViewById(R.id.button3);
			bt4=(ImageView)findViewById(R.id.button4);
			bt5=(ImageView)findViewById(R.id.button5);
			bt6=(ImageView)findViewById(R.id.button6);
		 bt1.setPadding(0, 0, 0, (int) (.03*ht));
		 bt2.setPadding(0, 0, 0, (int) (.03*ht));
		 bt3.setPadding(0, 0, 0, (int) (.03*ht));
		 bt4.setPadding(0, 0, 0, (int) (.03*ht));
		// bt5.setPadding(0, 0, 0, (int) (.03*ht));
		 bt6.setPadding(0, 0, 0, (int) (.03*ht));
		 
	   bt1.setMaxWidth((int) (factor*wt));
	   bt2.setMaxWidth((int) (factor*wt));
	   bt3.setMaxWidth((int) (factor*wt));
	   bt4.setMaxWidth((int) (factor*wt));
	   bt5.setMaxWidth((int) (factor*wt));
	   bt6.setMaxWidth((int) (factor*wt));
	  bt1.setOnTouchListener(new OnTouchListener(){

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			if( arg1.getAction()==0){
			//	bt1.setImageResource(R.drawable.blank);
			}
			else{
				//bt1.setImageResource(R.drawable.footer);
			}
			
			return false;
		}
		  
		  
		  
		  
		  
	  });
	  
			
		
			
			
		}
		
		
	}
	
	public void goToMain(View v){
		 LayoutDimensions ld = new LayoutDimensions();
		 ld.mainMenu();
	}
	
	public void more(View v){
		startActivity(new Intent ("com.JacobyApps.android.more"));
	}

public void status(View v){
	
	

	Intent i= new Intent(Main_Menu.this,Status.class);
	startActivity(i);

		  }
	
		     
		   
		 
public void workoutlist(View v){
	 
	

	Intent i= new Intent(Main_Menu.this,WorkoutList.class);
	startActivity(i);
	
	}
public void fittestlog(View v){
	Intent i= new Intent(Main_Menu.this,FitTest.class);
	startActivity(i);
	
}
public void rate(View v){
	 Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.Insanity_WR_app.android&feature=search_result#?t=W251bGwsMSwxLDEsImNvbS5JbnNhbml0eV9XUl9hcHAuYW5kcm9pZCJd");
	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	 startActivity(intent);
}

public void pictures(View v){
	Intent i= new Intent(Main_Menu.this,Pictures.class);
	startActivity(i);
	
	
	
}







public void goToUrl(View v){
	 Uri uri = Uri.parse("http://www.motivationmagnet.com/insanity-workout-calendar-schedule/");
	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	 startActivity(intent);
	
}
public void reset(View v){
	Intent i= new Intent(Main_Menu.this,Reset.class);
	startActivity(i);
	
}

}	

 

     






