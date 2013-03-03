package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;
import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
 
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
		
		private ImageView imv1;
		private ImageView imv2;
		private ImageView imv3;
		private ImageView imv4;
		private ImageView imv5;
		private ImageView imv6;

		public void mainMenu(){
			setContentView(R.layout.main);
			if(ht<330){
				factor=.5;
			}
			else{
				factor=.6;
			}
			 
		   
			 
			imv1=(ImageView)findViewById(R.id.imageView1);
			imv2=(ImageView)findViewById(R.id.imageView2);
			imv3=(ImageView)findViewById(R.id.imageView3);
			imv4=(ImageView)findViewById(R.id.imageView4);
			imv5=(ImageView)findViewById(R.id.imageView5);
			imv6=(ImageView)findViewById(R.id.imageView6);
			imv1.setPadding(0, 0, 0, (int) (.03*ht));
			imv2.setPadding(0, 0, 0, (int) (.03*ht));
			imv3.setPadding(0, 0, 0, (int) (.03*ht));
			imv4.setPadding(0, 0, 0, (int) (.03*ht));
			imv5.setPadding(0, 0, 0, (int) (.03*ht));
			imv6.setPadding(0, 0, 0, (int) (.03*ht));
		 
			imv1.setMaxWidth((int) (factor*wt));
			imv2.setMaxWidth((int) (factor*wt));
			imv3.setMaxWidth((int) (factor*wt));
			imv4.setMaxWidth((int) (factor*wt));
			imv5.setMaxWidth((int) (factor*wt));
			imv6.setMaxWidth((int) (factor*wt));
			
		  
		  
		  

			
		
			
			
		}
		
		
	}
	
	public void goToMain(View v){
		 LayoutDimensions ld = new LayoutDimensions();
		 ld.mainMenu();
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
	Intent i= new Intent(Main_Menu.this,PreviousFitTest.class);
	startActivity(i);

	
}
public void pictures(View v){
	Intent i= new Intent(Main_Menu.this,Pictures.class);
	startActivity(i);
	 
	
}



public void reminder (View v){
	Intent i= new Intent(Main_Menu.this,Reminder.class);
	startActivity(i);
}

public void goal(View v){
	Intent i= new Intent(Main_Menu.this,Goal.class);
	startActivity(i);
}


	

public void goToUrl(View v){
	 Uri uri = Uri.parse("http://www.motivationmagnet.com/insanity-workout-calendar-schedule/");
	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	 startActivity(intent);
	
}





 

     

}




