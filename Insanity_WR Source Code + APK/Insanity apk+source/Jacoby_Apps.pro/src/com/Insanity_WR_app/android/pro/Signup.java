package com.Insanity_WR_app.android.pro;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 

public class Signup extends Activity {
	int ht;
	int wt;
	Spinner spinner;
	Uri selectedImage;
	ImageView iV1;
	String emailInput="0" ; 
	float size= (float) ( Math.pow(Math.pow(wt*.01, 2)+ Math.pow(ht*.001, 2),.5));
	ExerciseInfoData exerciseEntry = new ExerciseInfoData(this);
	ExerciseInfoData2 exerciseEntry2 = new ExerciseInfoData2 (this);
	PhotoInfoData photoEntry = new PhotoInfoData(this);
	ArrayAdapter<String> m_adapterForSpinner;
	ArrayAdapter <String> timeZonespinner_adapterForSpinner;
	Spinner timeZonespinner ;
	String goal;
	String[] value={"Fit Test", 
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
	
	String[] valuewithRime={"Fit Test (26 min)", 
			"Plyometric Cardio Circuit (42 min)" ,
			"Cardio Power & Resistance (40 min)",
			"Cardio Recovery (35 min)",
			"Pure Cardio (39 min)",
			"Plyometric Cardio Circuit (42 min)",
			"Rest",
			"Cardio Power & Resistance (40 min)",
			"Pure Cardio (39 min)",
			"Plyometric Cardio Circuit (42 min)",
			"Cardio Recovery (35 min)",
			"Cardio Power & Resistance (40 min)",
			"Pure Cardio & Cardio Abs (56 min)",
			"Rest",
			"Fit Test (26 min)", 
			"Plyometric Cardio Circuit (42 min)",
			"Pure Cardio & Cardio Abs (56 min)",
			"Cardio Recovery (35 min)",
			"Cardio Power & Resistance (40 min)",
			"Plyometric Cardio Circuit (42 min)",
			"Rest",
			"Pure Cardio & Cardio Abs (56 min)",
			"Cardio Power & Resistance (40 min)",
			"Plyometric Cardio Circuit (42 min)",
			"Cardio Recovery (35 min)",
			"Pure Cardio & Cardio Abs (56 min)",
			"Plyometric Cardio Circuit (42 min)",
			"Rest",
			"Core Cardio & Balance (40 min)",
			"Core Cardio & Balance (40 min)",
			"Core Cardio & Balance (40 min)",
			"Core Cardio & Balance (40 min)",
			"Core Cardio & Balance (40 min)",
			"Core Cardio & Balance (40 min)",
			"Rest",
			"Fit Test & Max Interval Circuit (86 min)",
			"Max Interval Plyo (56 min)",
			"Max Cardio Conditioning (48 min)",
			"Max Recovery (50 min)",
			"Max Interval Circuit (60 min)",
			"Max Interval Plyo (56 min)",
			"Rest",
			"Max Cardio Conditioning (48 min)",
			"Max Interval Circuit (60 min)",
			"Max Interval Plyo (56 min)",
			"Max Recovery (50 min)",
			"Max Cardio Conditioning & Cardio Abs (65 min)",
			"Core Cardio & Balance (40 min)",
			"Rest",
			"Fit Test & Max Interval Circuit (86 min)",
			"Max Interval Plyo (56 min)",
			"Max Cardio Conditioning & Cardio Abs (65 min)",
			"Max Recovery (50 min)",
			"Max Interval Circuit (60 min)",
			"Core Cardio & Balance (40 min)",
			"Rest",
			"Max Interval Plyo (56 min)",
			"Max Cardio Conditioning & Cardio Abs (65 min)",
			"Max Interval Circuit (60 min)",
			"Core Cardio & Balance (40 min)",
			"Max Interval Plyo (56 min)",
			"Max Cardio Conditioning & Cardio Abs (65 min)",
			"Fit Test (26 min)"
			};
	
	 
	 
	 
	 
	 
	 
 
	 
	 
	 
	 
	 
	
	private Bitmap imgBitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.main_menu);
		spinner = (Spinner)findViewById(R.id.workoutlist);
	 
		
		DisplayMetrics displaymetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        ht=displaymetrics.heightPixels;
        wt=displaymetrics.widthPixels;
        iV1 = (ImageView) findViewById(R.id.imageView1);
        iV1.setMaxWidth((int) (.5*wt));
        TextView whatday = (TextView) findViewById(R.id.whatday);
       
         whatday.setTextSize(size );
       
        
       
	   
		m_adapterForSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);  
		m_adapterForSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);        
		
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
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				

				
				//weightText.setText(exerciseEntry.getData());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}} );
	  
		 
		
		
	}

	public void pictureAdd(View v){
		 
		setContentView(R.layout.main_menu2);
		 iV1 = (ImageView) findViewById(R.id.imageView1);
	        iV1.setMaxWidth((int) (.5*wt));
		ImageView myPicture = (ImageView)findViewById(R.id.photo);
		TextView beforePicture1Text =  (TextView)findViewById(R.id.textView1);
		TextView beforePicture2Text =  (TextView)findViewById(R.id.textView2);
		beforePicture1Text.setTextSize(size);
		beforePicture2Text.setTextSize(size);
		myPicture.setMaxWidth((int) (.25*wt));
		 
		
		
		
	}
	public void getPicture(View v){
		
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 1);
	
		
	}
	public void getMyGoal(View v){
		EditText emailEditText = (EditText)findViewById(R.id.emailEditText);
		CheckBox cb = (CheckBox)findViewById(R.id.checkBox1);
		final Pattern emailPattern = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		final Matcher emailMatcher = emailPattern.matcher(emailEditText.getText()
				.toString().trim());
		
		if(emailMatcher.matches()){
			if(!cb.isChecked()){ 
			emailInput= emailEditText.getText().toString();
			}
			 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);  
			setContentView(R.layout.mygoal);
			 
           
			EditText goaleditText = (EditText)findViewById(R.id.editText1);
			
			goaleditText.setHeight((int) (.4*ht));
			iV1 = (ImageView) findViewById(R.id.imageView1);
	        iV1.setMaxWidth((int) (.5*wt));
			
			
			
		}
		else{
			if(!cb.isChecked()){
			 AlertDialog.Builder alertBox = new AlertDialog.Builder(this); 
			alertBox.setNeutralButton("Ok",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int arg1) {
							dialog.dismiss();

						}
					});
			alertBox.setTitle("Alert");
			alertBox.setMessage("Email format is incorrect");
			alertBox.show();
			}
			else{
				 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
				setContentView(R.layout.mygoal);
				 


	        
				EditText goaleditText = (EditText)findViewById(R.id.editText1);
				
				goaleditText.setHeight((int) (.4*ht));
				iV1 = (ImageView) findViewById(R.id.imageView1);
		        iV1.setMaxWidth((int) (.5*wt));
				
				
				
				
			}
		
		}
		
		
		
	}
public void getEmail(View v){
	setContentView(R.layout.main_menu3);
	 iV1 = (ImageView) findViewById(R.id.imageView1); 
     iV1.setMaxWidth((int) (.5*wt)); 
	TextView emailText1 =  (TextView)findViewById(R.id.emailText1);
	TextView emailText2 =  (TextView)findViewById(R.id.emailText2);
	 
	 
	emailText1.setTextSize(size);
	emailText2.setTextSize(size);
	 
	
		
	}
public String BitMapToString(Bitmap bitmap){
    ByteArrayOutputStream baos=new  ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
    byte [] b=baos.toByteArray();
    String temp=Base64.encodeToString(b, Base64.DEFAULT);
    return temp;
}
 public Bitmap StringToBitMap(String encodedString){
     try{
       byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
       Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
       return bitmap;
     }catch(Exception e){
       e.getMessage();
       return null;
     }
      }
 
 public String getRealPathFromURI(Uri contentUri) {
	    String[] proj = { MediaStore.Images.Media.DATA };
	    Cursor cursor = managedQuery(contentUri, proj, null, null, null);
	    int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	    
	    cursor.moveToFirst();
	    return cursor.getString(column_index);
	}

public void goToMain(View v){
	
	 EditText goalEditText = (EditText)findViewById(R.id.editText1);
	goal = goalEditText.getText().toString();
	
	 new Register().execute();
	

	

	
	
	
}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  try{
		  ImageView myPicture = (ImageView)findViewById(R.id.photo);
		 
		    if (resultCode == Activity.RESULT_OK) {
		    	
		    	if(data.getData()!=null){
		    	selectedImage = data.getData();
		    	BitmapFactory.Options bounds = new BitmapFactory.Options();
		   	 bounds.inSampleSize = 8;
		   	 imgBitmap = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
		        
		      myPicture.setMaxHeight((int) (ht*.20));
		      myPicture.setMaxWidth((int) (wt*.50));
		      myPicture.setImageBitmap(imgBitmap);
		    	}
		    	 
		    	
		 
		   
		}
		     
		}
		  catch (Exception e){
			  e.printStackTrace();
			  Toast.makeText(this, "Please Try Again", Toast.LENGTH_SHORT);
		  }
	}
	
	
 public class Register extends AsyncTask<Void, Void,String>{
		 
		 
			 
			  ProgressDialog progressDialog;
				
		 @Override
			protected void onPreExecute() {
				 
				super.onPreExecute();
				progressDialog	= ProgressDialog.show(Signup.this, "Please Wait", "Loading...");
				
				
			}
@Override
         protected String doInBackground(Void... arg0) {
	  
	   
	MyGoalInfoData  goalselector = new MyGoalInfoData (Signup.this);
    goalselector.open();
	if(goal!=null){
		
		 
	   
		goalselector.createEntry(goal);
	 
		
	}
	else{
		goalselector.createEntry("No Goal");
		
	}
	goalselector.close();
	String [] time = {"0","0"};
	TimeInfoData tID = new TimeInfoData(Signup.this);
	tID.open();
	tID.createEntry(time);
	tID.close();
	Selector selector = new Selector(Signup.this);
    selector.open();
	selector.createEntry("0");
	selector.close();
	 
	String result = null;
	
	 
	 if(imgBitmap!=null){
	String[] photoEntry={BitMapToString(imgBitmap),"0","0","0","0","0"};
	PhotoInfoData photoData = new PhotoInfoData(Signup.this);
	photoData.open();
	
	photoData.createEntry(photoEntry);
	photoData.close();
	 }
	 else{
		 String[] photoEntry={"0","0","0","0","0","0"};
			PhotoInfoData photoData = new PhotoInfoData(Signup.this);
			photoData.open();
			
			photoData.createEntry(photoEntry);
			photoData.close();
	 }
	 
	String[] date={"0","0","0","0","0","0","0"};
	DateInfoData dateEntry = new DateInfoData(Signup.this);
	dateEntry.open();
	
	dateEntry.createEntry(date);
	dateEntry.close();
    
	
	
	 
	try{
		
	 
	UserInfoData entry = new UserInfoData(Signup.this);
	entry.open();
	
	entry.createEntry(emailInput);
	entry.close();
	int k=	(int) spinner.getSelectedItemId();
	exerciseEntry.open();
	exerciseEntry2.open();
	for (int i = 0; i < value.length; ++i){
		if(i<k){
		String[] input={value[i],"1"};
		String[] input2={valuewithRime[i],"1"}; 
		 
		
		exerciseEntry.createEntry(input);
		exerciseEntry2.createEntry(input2);
		 
		}
	else{
			String[] input={value[i],"0"};
			String[] input2={valuewithRime[i],"0"};
			
			exerciseEntry.createEntry(input);
			exerciseEntry2.createEntry(input2);
			 
		}
	}
	exerciseEntry.close();
	exerciseEntry2.close();
	result="Done";
	
	
	}
	catch(Exception e){
	}
	 
	FitTestInfoData ft= new FitTestInfoData(Signup.this);
	 String[] value={"","","","","","","",""};
	 ft.open();
	 
	 ft.createEntry(value);
	 ft.createEntry(value);
	 ft.createEntry(value);
	 ft.createEntry(value);
	 ft.createEntry(value);
	 ft.close();
	return result;	 
 
}	    
	
			

			protected void onPostExecute(String result) {
 				super.onPostExecute(result);
 				progressDialog.cancel();
 				Intent i= new Intent(Signup.this,Main_Menu.class);
 				 
 				 
 				
 				startActivity(i); 
 				
 				finish();
 				 
 				  
			}






		
			

			
	    	   
	       }
	
	
	
	
	
	
	
	
	}
