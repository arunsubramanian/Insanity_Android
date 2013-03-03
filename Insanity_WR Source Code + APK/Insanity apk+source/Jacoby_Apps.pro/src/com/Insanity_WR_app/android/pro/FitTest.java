package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class FitTest extends Activity {
DisplayMetrics displaymetrics;

int ht;
int wt;

 ArrayList<String[]> weight;
 int count =0;
private EditText eT1;
private EditText eT2;
private EditText eT3;
private EditText eT4;
private EditText eT5;
private EditText eT6;
private EditText eT7;
private EditText eT8;
private Button bt1;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		displaymetrics= new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
		 
		 eT1 = (EditText) findViewById(R.id.editText1);
		 eT2 = (EditText) findViewById(R.id.editText2);
	     eT3 = (EditText) findViewById(R.id.editText3);
		 eT4 = (EditText) findViewById(R.id.editText4);
		 eT5 = (EditText) findViewById(R.id.editText5);
		 eT6 = (EditText) findViewById(R.id.editText6);
		 eT7 = (EditText) findViewById(R.id.editText7);
		 eT8 = (EditText) findViewById(R.id.editText8);
		 bt1 = (Button) findViewById(R.id.button1);
		 bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				 FitTestInfoData ft= new FitTestInfoData(FitTest.this);
				 String[] value={eT1.getText().toString(),eT2.getText().toString(),eT3.getText().toString(),eT4.getText().toString(),eT5.getText().toString(),eT6.getText().toString(),eT7.getText().toString(),
				eT8.getText().toString()};
				 ft.open();
				 
				 ft.createEntry(value);
				 
				 
				 
				 ft.close(); 
				
			}});
		 eT1.getLayoutParams().height=(int) (.08*ht);
		 eT2.getLayoutParams().height=(int) (.08*ht);
		 eT3.getLayoutParams().height=(int) (.08*ht);
		 eT4.getLayoutParams().height=(int) (.08*ht);
		 eT5.getLayoutParams().height=(int) (.08*ht);
		 eT6.getLayoutParams().height=(int) (.08*ht);
		 eT7.getLayoutParams().height=(int) (.08*ht);
		 eT8.getLayoutParams().height=(int) (.08*ht);
		 eT1.setTextSize((float) 14);
		 eT2.setTextSize((float) 14);
		 eT3.setTextSize((float) 14);
		 eT4.setTextSize((float) 14);
		 eT5.setTextSize((float) 14);
		 eT6.setTextSize((float) 14);
		 eT7.setTextSize((float) 14);
		 eT8.setTextSize((float) 14);
		 
		 
		
	}	
  
public void pastFitTest(View v){
	 Intent i= new Intent(FitTest.this,PreviousFitTest.class);
		startActivity(i);
 }


@Override
public boolean onCreateOptionsMenu(Menu menu) {
	//MenuInflater inflater = getMenuInflater();
    //inflater.inflate(R.menu.menu, menu);
    menu.add(0, 1, 0, "WORKOUT LIST");
    menu.add(0, 2, 0, "PICTURES");
    
    menu.add(0, 3, 0, "STATUS");
    menu.add(0, 4, 0, "REMINDER");
    menu.add(0, 5, 0, "MY GOAL");
   
    return true;
}	

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case 1:   
        	Intent i= new Intent(FitTest.this,WorkoutList.class);
        	startActivity(i); 
        break;
       
        case 2:     
        	Intent i2= new Intent(FitTest.this,Pictures.class);
        	startActivity(i2);                   
        break;
        
       
        case 3: 
        	Intent i3= new Intent(FitTest.this,Status.class);
        	startActivity(i3);  
	        break;
        case 4: 
        	Intent i4= new Intent(FitTest.this,Reminder.class);
        	startActivity(i4);  
	        break;
        case 5: 
        	Intent i5= new Intent(FitTest.this,Goal.class);
        	startActivity(i5);  
	        break;
	        
        
    }
    return true;
}





}
