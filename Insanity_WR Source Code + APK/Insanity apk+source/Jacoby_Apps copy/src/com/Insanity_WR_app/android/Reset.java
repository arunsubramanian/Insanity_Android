package com.Insanity_WR_app.android;

import com.Insanity_WR_app.android.Signup.Register;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Reset extends Activity {

	private static final String DATABASE_NAME = "Activities";
	private static final String DATABASE_NAME2 = "Activities2";
	ArrayAdapter<String> m_adapterForSpinner;
	private Spinner spinner;
	private ExerciseInfoData exerciseEntry = new ExerciseInfoData(this);
	private ExerciseInfoData2 exerciseEntry2 = new ExerciseInfoData2 (this);
	private String[] value={"Fit Test", 
			"Plyometric Cardio Circuit",
			"Cardio Power & Resistance",
			"Cardio Recovery",
			"Pure Cardio",
			"Plyometric Cardio Circuit",
			"Rest",
			"Cardio Power & Resistance",
			"Pure Cardio",
			"Plyometric Cardio Circuit",
			"Cardio Recovery",
			"Cardio Power & Resistance",
			"Pure Cardio & Cardio Abs",
			"Rest",
			"Fit Test", 
			"Plyometric Cardio Circuit",
			"Pure Cardio & Cardio Abs",
			"Cardio Recovery",
			"Cardio Power & Resistance",
			"Plyometric Cardio Circuit",
			"Rest",
			"Pure Cardio & Cardio Abs",
			"Cardio Power & Resistance",
			"Plyometric Cardio Circuit",
			"Cardio Recovery",
			"Pure Cardio & Cardio Abs",
			"Plyometric Cardio Circuit",
			"Rest",
			"Core Cardio & Balance",
			"Core Cardio & Balance",
			"Core Cardio & Balance",
			"Core Cardio & Balance",
			"Core Cardio & Balance",
			"Core Cardio & Balance",
			"Rest",
			"Fit Test & Max Interval Circuit",
			"Max Interval Plyo",
			"Max Cardio Conditioning",
			"Max Recovery",
			"Max Interval Circuit",
			"Max Interval Plyo",
			"Rest",
			"Max Cardio Conditioning",
			"Max Interval Circuit",
			"Max Interval Plyo",
			"Max Recovery",
			"Max Cardio Conditioning & Cardio Abs",
			"Core Cardio & Balance",
			"Rest",
			"Fit Test & Max Interval Circuit",
			"Max Interval Plyo",
			"Max Cardio Conditioning & Cardio Abs",
			"Max Recovery",
			"Max Interval Circuit",
			"Core Cardio & Balance",
			"Rest",
			"Max Interval Plyo",
			"Max Cardio Conditioning & Cardio Abs",
			"Max Interval Circuit",
			"Core Cardio & Balance",
			"Max Interval Plyo",
			"Max Cardio Conditioning & Cardio Abs",
			"Fit Test"};
	private NotificationManager mNotificationManager;
	private ImageView iV1;
	private int ht;
	private int wt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_menu);
		DisplayMetrics displaymetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        
        wt=displaymetrics.widthPixels;
		 iV1 = (ImageView) findViewById(R.id.imageView1);
	     iV1.setMaxWidth((int) (.5*wt));
		 String ns = Context.NOTIFICATION_SERVICE;
	      mNotificationManager = (NotificationManager) getSystemService(ns);
		m_adapterForSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);  
		m_adapterForSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
		spinner = (Spinner)findViewById(R.id.workoutlist);
		m_adapterForSpinner.add("Day 01.  Fit Test");   
		m_adapterForSpinner.add("Day 02.  Plyometric Cardio Circuit"); 
		m_adapterForSpinner.add("Day 03.  Cardio Power & Resistance");
		m_adapterForSpinner.add("Day 04.  Cardio Recovery");
		m_adapterForSpinner.add("Day 05.  Pure Cardio");
		m_adapterForSpinner.add("Day 06.  Plyometric Cardio Circuit");
		m_adapterForSpinner.add("Day 07.  Rest");
		m_adapterForSpinner.add("Day 08.  Cardio Power & Resistance");
		m_adapterForSpinner.add("Day 09.  Pure Cardio");
		m_adapterForSpinner.add("Day 10.  Plyometric Cardio Circuit");
		m_adapterForSpinner.add("Day 11.  Cardio Recovery");   
		m_adapterForSpinner.add("Day 12.  Cardio Power & Resistance"); 
		m_adapterForSpinner.add("Day 13.  Pure Cardio & Cardio Abs");
		m_adapterForSpinner.add("Day 14.  Rest");
		m_adapterForSpinner.add("Day 15.  Fit Test");
		m_adapterForSpinner.add("Day 16.  Plyometric Cardio Circuit");
		m_adapterForSpinner.add("Day 17.  Pure Cardio & Cardio Abs");
		m_adapterForSpinner.add("Day 18.  Cardio Recovery");
		m_adapterForSpinner.add("Day 19.  Cardio Power & Resistance");
		m_adapterForSpinner.add("Day 20.  Plyometric Cardio Circuit");
		m_adapterForSpinner.add("Day 21.  Rest");   
		m_adapterForSpinner.add("Day 22.  Pure Cardio & Cardio Abs"); 
		m_adapterForSpinner.add("Day 23.  Cardio Power & Resistance");
		m_adapterForSpinner.add("Day 24.  Plyometric Cardio Circuit");
		m_adapterForSpinner.add("Day 25.  Cardio Recovery");
		m_adapterForSpinner.add("Day 26.  Pure Cardio & Cardio Abs");
		m_adapterForSpinner.add("Day 27.  Plyometric Cardio Circuit");
		m_adapterForSpinner.add("Day 28.  Rest");
		m_adapterForSpinner.add("Day 29.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 30.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 31.  Core Cardio & Balance");   
		m_adapterForSpinner.add("Day 32.  Core Cardio & Balance"); 
		m_adapterForSpinner.add("Day 33.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 34.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 35.  Rest");
		m_adapterForSpinner.add("Day 36.  Fit Test & Max Interval Circuit");
		m_adapterForSpinner.add("Day 37.  Max Interval Plyo");
		m_adapterForSpinner.add("Day 38.  Max Cardio Conditioning");
		m_adapterForSpinner.add("Day 39.  Max Recovery");
		m_adapterForSpinner.add("Day 40.  Max Interval Circuit");
		m_adapterForSpinner.add("Day 41.  Max Interval Plyo");   
		m_adapterForSpinner.add("Day 42.  Rest"); 
		m_adapterForSpinner.add("Day 43.  Max Cardio Conditioning");
		m_adapterForSpinner.add("Day 44.  Max Interval Circuit");
		m_adapterForSpinner.add("Day 45.  Max Interval Plyo");
		m_adapterForSpinner.add("Day 46.  Max Recovery");
		m_adapterForSpinner.add("Day 47.  Max Cardio Conditioning & Cardio Abs");
		m_adapterForSpinner.add("Day 48.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 49.  Rest");
		m_adapterForSpinner.add("Day 50.  Fit Test & Max Interval Circuit");
		m_adapterForSpinner.add("Day 51.  Max Interval Plyo");   
		m_adapterForSpinner.add("Day 52.  Max Cardio Conditioning & Cardio Abs"); 
		m_adapterForSpinner.add("Day 53.  Max Recovery");
		m_adapterForSpinner.add("Day 54.  Max Interval Circuit");
		m_adapterForSpinner.add("Day 55.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 56.  Rest");
		m_adapterForSpinner.add("Day 57.  Max Interval Plyo");
		m_adapterForSpinner.add("Day 58.  Max Cardio Conditioning & Cardio Abs");
		m_adapterForSpinner.add("Day 59.  Max Interval Circuit");
		m_adapterForSpinner.add("Day 60.  Core Cardio & Balance");
		m_adapterForSpinner.add("Day 61.  Max Interval Plyo");
		m_adapterForSpinner.add("Day 62.  Max Cardio Conditioning & Cardio Abs");
		m_adapterForSpinner.add("Day 63.  Fit Test");
		spinner.setAdapter(m_adapterForSpinner);
	 
		
		
		
	}
	
public void pictureAdd(View v){//Doesn't add pictures, just recycled method
	new GoToMain().execute();
}

public class GoToMain extends AsyncTask<Void, Void, String>{

	


	private Dialog dialog;
	private String result;

	 

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		 dialog = new Dialog(Reset.this);
		 dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		  dialog.setCancelable(false);
		  dialog.setContentView(R.layout.customprogressdialog);
		  dialog.show();
		
		
	}

	 

	@Override
	protected String doInBackground(Void... arg0) {
		int k=	(int) spinner.getSelectedItemId();
		 
		Selector selector = new Selector(Reset.this);
	    selector.open();
	    selector.updateEntry(1,"Selector","0");
		selector.close();
		String[] date={"0","0","0","0","0","0","0"};
		
		DateInfoData dateEntry = new DateInfoData(Reset.this);
		dateEntry.open();
		dateEntry.updateEntry(1,date);
		dateEntry.close();
		
		exerciseEntry.open();
		exerciseEntry2.open();
		 
		for (int i = 0; i < value.length; ++i){
			if(i<k){
		 
			
			 
			
			exerciseEntry.updateEntry(i+1,"Completed","1");
			exerciseEntry2.updateEntry(i+1,"Completed","1");
			 
			}
		else{
			 
				 
				
				exerciseEntry.updateEntry(i+1,"Completed","0");
				exerciseEntry2.updateEntry(i+1,"Completed","0");
				 
			}
		}
		 
		exerciseEntry2.close();
		exerciseEntry.close();
		mNotificationManager.cancel(1);
		result="Done";
		return result;
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		dialog.dismiss();
		Intent i= new Intent(Reset.this,Main_Menu.class);
		startActivity(i); 
		finish();
	}
	
	
}




}
 

