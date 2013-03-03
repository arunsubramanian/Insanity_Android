package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class Reminder extends Activity {

	private TimePicker tp;
	private TimeInfoData tID;
	private ImageView iv1;
	private int ht;
	private double factor;
	private double wt;
	private DisplayMetrics displaymetrics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 displaymetrics = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
		setContentView(R.layout.reminder);
		tp= (TimePicker)findViewById(R.id.timePicker1);
		 
		 tp.setOnTimeChangedListener(new OnTimeChangedListener(){

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				iv1.setImageResource(R.drawable.savebut);
				
			}});
		 iv1=(ImageView)findViewById(R.id.imageView1);
		 if(ht<330){
				factor=.40;
			}
			else{
				factor=.6;
			}
		 iv1.setMaxWidth((int) (factor*wt));
		 
		tID = new TimeInfoData(this);
		tID.open();
		ArrayList<String[]> timevalue = tID.getData();
		tID.close();
		tp.setCurrentHour(Integer.parseInt(timevalue.get(0)[0]));
		tp.setCurrentMinute(Integer.parseInt(timevalue.get(0)[1]));
		 
	 
		
	}
	public void save(View v){
		final Dialog dialog = new Dialog(Reminder.this);
		  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		  dialog.setCancelable(false);
		  dialog.setContentView(R.layout.customprogressdialog);
		  dialog.show();
		tID.open();
		String[] entry={String.valueOf(tp.getCurrentHour()),String.valueOf(tp.getCurrentMinute())};
		tID.updateEntry(1, entry);
		tID.close(); 
		 
		iv1.setImageResource(R.drawable.savedbut);	
		dialog.cancel();
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//MenuInflater inflater = getMenuInflater();
	    //inflater.inflate(R.menu.menu, menu);
	    menu.add(0, 1, 0, "WORKOUT LIST");
	    menu.add(0, 2, 0, "PICTURES");
	    
	    menu.add(0, 3, 0, "STATUS");
	    menu.add(0, 4, 0, "FIT TEST");
	    menu.add(0, 5, 0, "MY GOAL");
	   
	    return true;
	}	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(Reminder.this,WorkoutList.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(Reminder.this,Pictures.class);
	        	startActivity(i2);                   
	        break;
	        
	       
	        case 3: 
	        	Intent i3= new Intent(Reminder.this,Status.class);
	        	startActivity(i3);  
		        break;
	        case 4: 
	        	Intent i4= new Intent(Reminder.this,PreviousFitTest.class);
	        	startActivity(i4);  
		        break;
	        case 5: 
	        	Intent i5= new Intent(Reminder.this,Goal.class);
	        	startActivity(i5);  
		        break;
		        
	        
	    }
	    return true;
	}


}
