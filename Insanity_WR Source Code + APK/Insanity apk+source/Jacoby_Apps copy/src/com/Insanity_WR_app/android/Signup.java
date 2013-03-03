package com.Insanity_WR_app.android;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Insanity_WR_app.android.R;

public class Signup extends Activity {
	int ht;
	int wt;
	Spinner spinner;
	Uri selectedImage;
	ImageView iV1;
	 
	 
	float size= (float) ( Math.pow(Math.pow(wt*.01, 2)+ Math.pow(ht*.001, 2),.5));
	ExerciseInfoData exerciseEntry = new ExerciseInfoData(this);
	ExerciseInfoData2 exerciseEntry2 = new ExerciseInfoData2 (this);
	PhotoInfoData photoEntry = new PhotoInfoData(this);
	ArrayAdapter<String> m_adapterForSpinner;
	ArrayAdapter <String> timeZonespinner_adapterForSpinner;
	Spinner timeZonespinner ;
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
	private Bitmap imgBitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.main_menu);
		spinner = (Spinner)findViewById(R.id.workoutlist);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		DisplayMetrics displaymetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        ht=displaymetrics.heightPixels;
        wt=displaymetrics.widthPixels;
        iV1 = (ImageView) findViewById(R.id.imageView1);
        iV1.setMaxWidth((int) (.5*wt));
        TextView whatday = (TextView) findViewById(R.id.whatday);
       
         Button next = (Button) findViewById(R.id.button1);
       
         
       
       
        
         
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
	
	EditText emailInput = (EditText)findViewById(R.id.emailEditText);
	final Pattern emailPattern = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	final Matcher emailMatcher = emailPattern.matcher(emailInput.getText()
			.toString().trim());
	CheckBox cb= (CheckBox)findViewById(R.id.checkBox1);
	if(emailMatcher.matches()){
		if(cb.isChecked()){
			emailInput.setText("N/A");
	 new Register().execute();
		}
		else{
			new Register().execute();
		}
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
			emailInput.setText("N/A");
			new Register().execute();
		}
	}

	

	
	
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
			private UserInfoData entry;
			private Selector selector;
			private EditText emailInput;
			private String result;
			private PhotoInfoData photoData;
			private DateInfoData dateEntry;
		 
		 @Override
			protected void onPreExecute() {
				 
				super.onPreExecute();
				progressDialog	= ProgressDialog.show(Signup.this, "Please Wait", "Loading...");
				
				
			}
@Override
         protected String doInBackground(Void... arg0) {
	
	try{
	selector = new Selector(Signup.this);
    selector.open();
	selector.createEntry("0");
	} 
	catch(Exception e){
		 e.printStackTrace();
	}
	finally{
	
	selector.close();
	}

	
	
	try{ 
	 if(imgBitmap!=null){
	String[] photoEntry={BitMapToString(imgBitmap),"0","0","0","0","0"};
	photoData = new PhotoInfoData(Signup.this);
	photoData.open();
	
	photoData.createEntry(photoEntry);
	 
	 }
	 else{
		 String[] photoEntry={"0","0","0","0","0","0"};
			PhotoInfoData photoData = new PhotoInfoData(Signup.this);
			photoData.open();
			
			photoData.createEntry(photoEntry);
			photoData.close();
			 
	 }
	}
	catch(Exception e){
		 e.printStackTrace();
	}
	 
	
	try{
	String[] date={"0","0","0","0","0","0","0"};
	dateEntry = new DateInfoData(Signup.this);
	dateEntry.open();
	
	dateEntry.createEntry(date);
	dateEntry.close();
	}
	catch(Exception e){
		
		 e.printStackTrace();
	}
	 
	
	
	 
	try{
    emailInput = (EditText)findViewById(R.id.emailEditText);	
	 
	entry = new UserInfoData(Signup.this);
	entry.open();
	
	if(emailInput.getText().toString()!=null){
	entry.createEntry(emailInput.getText().toString());
	}
	
	else{
	entry.createEntry("");
	}
	
	}
	catch(Exception e){
		 e.printStackTrace();
	}
	
	finally{
	entry.close();
	
	}
	
	try{
	int k=	(int) spinner.getSelectedItemId();
	exerciseEntry.open();
	exerciseEntry2.open();
	for (int i = 0; i < value.length; ++i){
		if(i<k){
		String[] input={value[i],"1"};
		
		 
		
		exerciseEntry.createEntry(input);
		exerciseEntry2.createEntry(input);
		 
		}
	else{
			String[] input={value[i],"0"};
			 
			
			exerciseEntry.createEntry(input);
			exerciseEntry2.createEntry(input);
			 
		}
	}
	}
	
	catch(Exception e){
		 e.printStackTrace();
	}
	
	finally{
	exerciseEntry2.close();
	exerciseEntry.close();
	result="Done";
	}
	
	
	
	 
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
