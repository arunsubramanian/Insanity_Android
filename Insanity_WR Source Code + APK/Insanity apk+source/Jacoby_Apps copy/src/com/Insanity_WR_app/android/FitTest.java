package com.Insanity_WR_app.android;

import java.util.ArrayList;

import com.Insanity_WR_app.android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FitTest extends Activity {
private	ArrayList<String> values = new ArrayList<String>();
DisplayMetrics displaymetrics;

int ht;
int wt;

 ArrayList<String[]> weight;
 int count =0;

 
 float size= (float) ( .10*Math.pow(Math.pow(wt, 2)+ Math.pow(ht, 2),.5));
private ImageView iv1;
private ImageView iv2;
private ImageView iv3;
private ImageView iv4;
private double factor;
 
 
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		 displaymetrics= new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
		setContentView(R.layout.fittest_list_view);
		if(ht<330){
			factor=.45;
		}
		else{
			factor=.6;
		}	 
	iv1= (ImageView)findViewById(R.id.imageView1);
	iv2= (ImageView)findViewById(R.id.imageView2);
	iv3= (ImageView)findViewById(R.id.imageView3);
	iv4= (ImageView)findViewById(R.id.imageView4);
	 iv1.setMaxWidth((int) (factor*wt));
	   iv2.setMaxWidth((int) (factor*wt));
	   iv3.setMaxWidth((int) (factor*wt));
	   iv4.setMaxWidth((int) (factor*wt));
	   
	   iv1.setPadding(0, 0, 0, (int) (.03*ht));
		 iv2.setPadding(0, 0, 0, (int) (.03*ht));
		 iv3.setPadding(0, 0, 0, (int) (.03*ht));
		 iv4.setPadding(0, 0, 0, (int) (.03*ht));
	 
	

	}
public void urlToPro(View v){
	
	
	Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.Insanity_WR_app.android.pro&feature=more_from_developer#?t=W251bGwsMSwyLDEwMiwiY29tLkluc2FuaXR5X1dSX2FwcC5hbmRyb2lkLnBybyJd");
	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	 startActivity(intent); 
	
	
	
}

 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 
	    menu.add(0, 1, 0, "STATUS");
	    menu.add(0, 2, 0, "WORKOUT LIST");
	    menu.add(0, 3, 0, "CALENDER");
	    menu.add(0, 4, 0, "PICTURES");
	    menu.add(0, 5, 0, "MORE");
	   
	    return true;
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(FitTest.this,Status.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(FitTest.this,WorkoutList.class);
	        	startActivity(i2);                   
	        break;
	        
	        case 3: 
	        	Uri uri = Uri.parse("http://www.motivationmagnet.com/insanity-workout-calendar-schedule/");
	        	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	        	 startActivity(intent);                     
	        break;
	        
	        case 4: 
	        	Intent i3= new Intent(FitTest.this,Pictures.class);
	        	startActivity(i3);  
		        break;
	        case 5: 
	        	Intent i4= new Intent(FitTest.this,More.class);
	        	startActivity(i4);  
		        break;
	        
	    }
	    return true;
	}
	
	
}
