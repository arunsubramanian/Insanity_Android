package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Goal extends Activity {

	private EditText goaleditText;
	private ImageView iv1;
	private double factor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		 DisplayMetrics displaymetrics = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     int ht = displaymetrics.heightPixels;
	     int wt = displaymetrics.widthPixels;
		setContentView(R.layout.mygoalmainmenu);
		MyGoalInfoData  goalselector = new MyGoalInfoData (Goal.this);
	    goalselector.open();
	    
	   ArrayList<String[]> goalvalue = goalselector.getData();
	    
	    goalselector.close();
		goaleditText= (EditText)findViewById(R.id.editText1);
		goaleditText.setText(goalvalue.get(0)[1]);
		goaleditText.setHeight((int) (.4*ht));
		goaleditText.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				iv1.setTag("save");
				iv1.setImageResource(R.drawable.savebut);
				return false;
			}});
		TextView tv2 =(TextView)findViewById(R.id.textView2);
		 iv1 = (ImageView)findViewById(R.id.imageView1);
		 if(ht<330){
				factor=.33;
			}
			else{
				factor=.6;
			}
		 iv1.setMaxWidth((int) (factor*wt));
		tv2.setVisibility(View.GONE);
		 
		
	}

	
	public void save(View v) {
		 
		 
		MyGoalInfoData  goalselector = new MyGoalInfoData (Goal.this);
	    goalselector.open();
		goalselector.updateEntry(1, "Goal", goaleditText.getText().toString());
		goalselector.close();
		iv1.setTag("saved");
		iv1.setImageResource(R.drawable.savedbut);	
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//MenuInflater inflater = getMenuInflater();
	    //inflater.inflate(R.menu.menu, menu);
	    menu.add(0, 1, 0, "WORKOUT LIST");
	    menu.add(0, 2, 0, "PICTURES");
	    
	    menu.add(0, 3, 0, "STATUS");
	    menu.add(0, 4, 0, "REMINDER");
	    menu.add(0, 5, 0, "FIT TEST");
	   
	    return true;
	}	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(Goal.this,WorkoutList.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(Goal.this,Pictures.class);
	        	startActivity(i2);                   
	        break;
	        
	       
	        case 3: 
	        	Intent i3= new Intent(Goal.this,Status.class);
	        	startActivity(i3);  
		        break;
	        case 4: 
	        	Intent i4= new Intent(Goal.this,Reminder.class);
	        	startActivity(i4);  
		        break;
	        case 5: 
	        	Intent i5= new Intent(Goal.this,FitTest.class);
	        	startActivity(i5);  
		        break;
		        
	        
	    }
	    return true;
	}

}
