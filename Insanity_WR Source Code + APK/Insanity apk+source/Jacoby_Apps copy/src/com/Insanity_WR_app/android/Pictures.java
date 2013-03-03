package com.Insanity_WR_app.android;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Pictures extends Activity{

	private int ht;
	private int wt;
	public Bitmap imgBitmap5;
	public Bitmap imgBitmap4;
	public Bitmap imgBitmap6;
	public Bitmap imgBitmap3;
	public Bitmap imgBitmap2;
	public Bitmap imgBitmap1;
	private ImageView iv1;
	private ImageView iv2;
	private ArrayList<String> pictures=new ArrayList<String>();
	private ImageView iv3;
	private ImageView iv4;
	private ImageView iv5;
	private ImageView iv6;
	 
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		DisplayMetrics displaymetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        ht=displaymetrics.heightPixels;
        wt = displaymetrics.widthPixels;
        PhotoInfoData photoData = new PhotoInfoData(this);
		photoData.open();
		pictures.add(0, photoData.getData("Photo1")); 
		pictures.add(1, photoData.getData("Photo2")); 
		pictures.add(2, photoData.getData("Photo3")); 
		pictures.add(3, photoData.getData("Photo4")); 
		pictures.add(4, photoData.getData("Photo5")); 
		pictures.add(5, photoData.getData("Photo6")); 
	    photoData.close();
		setContentView(R.layout.pictures);
		iv1 = (ImageView)findViewById(R.id.imageView1);
		iv2=(ImageView)findViewById(R.id.imageView2);
		iv3=(ImageView)findViewById(R.id.imageView3);
		iv4=(ImageView)findViewById(R.id.imageView4);
		iv5=(ImageView)findViewById(R.id.imageView5);
		iv6=(ImageView)findViewById(R.id.imageView6);
		RelativeLayout ad1 = (RelativeLayout)findViewById(R.id.ad1);
		 
		 
		RelativeLayout.LayoutParams adlayoutparams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		adlayoutparams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		adlayoutparams1.height=(int) (.10*ht);
	 
	   
		 
	 
		 AdView adView1 = new AdView(Pictures.this, AdSize.BANNER, "d5ed4c6684f244ed");
	     
		 ad1.addView(adView1); 
		 
		 AdRequest request1 = new AdRequest();
		 
		 
		 
		 adView1.loadAd(request1);
		  
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		TextView tv2 = (TextView)findViewById(R.id.textView2);
		RelativeLayout.LayoutParams layoutparams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams5 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams6 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams7 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams layoutparams8 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutparams1.topMargin=(int) (.07*ht);
		layoutparams2.topMargin=(int) (.26*ht);
		layoutparams3.topMargin=(int) (.45*ht);
		layoutparams1.leftMargin=(int) (.20*wt);
		layoutparams2.leftMargin=(int) (.20*wt);
		layoutparams3.leftMargin=(int) (.20*wt);
		layoutparams7.leftMargin=(int)(.17*wt);
		layoutparams4.topMargin=(int) (.07*ht);
		layoutparams5.topMargin=(int) (.26*ht);
		layoutparams6.topMargin=(int) (.45*ht);
		layoutparams4.rightMargin=(int) (.1*wt);
		layoutparams5.rightMargin=(int) (.1*wt);
		layoutparams6.rightMargin=(int) (.1*wt);
		layoutparams8.rightMargin=(int) (.1*wt);
		 
		ImageView iv1 = (ImageView)findViewById(R.id.imageView1);
		ImageView iv2 = (ImageView)findViewById(R.id.imageView2);
		ImageView iv3 = (ImageView)findViewById(R.id.imageView3);
		ImageView iv4 = (ImageView)findViewById(R.id.imageView4);
		ImageView iv5 = (ImageView)findViewById(R.id.imageView5);
		ImageView iv6 = (ImageView)findViewById(R.id.imageView6);
		 double frac=.15;
		 
		  
		 
			
			 
			 
			if(!pictures.get(0).equals("0")){
				
			 
			    
				iv1.setImageBitmap(StringToBitMap(pictures.get(0)));
				 
			 
			}
			if(!pictures.get(1).equals("0")){
				 
				 
			    
				iv2.setImageBitmap( StringToBitMap(pictures.get(1)));
				 
				
			}
			if(!pictures.get(2).equals("0")){
				 
				 
			     
				iv3.setImageBitmap(StringToBitMap(pictures.get(2)));
				 
				
			}
			if(!pictures.get(3).equals("0")){
			 
			    
				iv4.setImageBitmap(StringToBitMap(pictures.get(3)));
				 
				
			}
			if(!pictures.get(4).equals("0")){
				 
			 
			   
				iv5.setImageBitmap(  StringToBitMap(pictures.get(4)));
				 
				
			}
			if(!pictures.get(5).equals("0")){
				 
			    
			   
				iv6.setImageBitmap(StringToBitMap(pictures.get(5)));
				 
				
			}
				 iv1.setMaxWidth((int) (wt*frac));
				 iv2.setMaxWidth((int) (wt*frac));
				 iv3.setMaxWidth((int) (wt*frac));
				 iv4.setMaxWidth((int) (wt*frac));
				 iv5.setMaxWidth((int) (wt*frac));
				 iv6.setMaxWidth((int) (wt*frac));
				 
				
	 
		 
		
		 layoutparams1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 layoutparams2.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 layoutparams3.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 layoutparams7.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		 layoutparams8.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		 layoutparams4.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 layoutparams5.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 layoutparams6.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		 layoutparams4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		 layoutparams5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		 layoutparams6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		 iv1.setLayoutParams(layoutparams1);
		 iv2.setLayoutParams(layoutparams2);
		 iv3.setLayoutParams(layoutparams3);
		 iv4.setLayoutParams(layoutparams4);
		 iv5.setLayoutParams(layoutparams5);
		 iv6.setLayoutParams(layoutparams6);
		 tv1.setLayoutParams(layoutparams7);
		 tv2.setLayoutParams(layoutparams8);
		
		tv1.setTextSize(25);
		tv2.setTextSize(25);
		
		
		
	}
	public String getRealPathFromURI(Uri contentUri) {
	    String[] proj = { MediaStore.Images.Media.DATA };
	    Cursor cursor = managedQuery(contentUri, proj, null, null, null);
	    int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	    
	    cursor.moveToFirst();
	    return cursor.getString(column_index);
	}
	
	public void getPicture1(View v){
		
		 
		if (imgBitmap1!=null || !pictures.get(0).equals("0")){
		final Dialog dialog = new Dialog(Pictures.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		 
		dialog.setContentView(R.layout.enlargephotos);
		Button bt1= (Button)dialog.findViewById(R.id.button1);
		   
		bt1.setOnClickListener(new OnClickListener() {

		 

			@Override
			public void onClick(View arg0) {
				imgBitmap1=null;
				 
				PhotoInfoData photoData = new PhotoInfoData(dialog.getContext()); 
				photoData.open();
				
				photoData.updateEntry(1, "Photo1", "0");
				photoData.close();
				pictures.set(0, "0");
				iv1.setImageResource(R.drawable.addimage);
				dialog.cancel();
				
			}
      
			 
		    
			    
			});
			
			
			
		
		ImageView iv1 = (ImageView) dialog.findViewById(R.id.imageView1);
		 
		dialog.setCancelable(true);
		if(!pictures.get(0).equals("0")){
		iv1.setImageBitmap(StringToBitMap(pictures.get(0)));
		}
		else{
			iv1.setImageBitmap(imgBitmap1);
		}
		 
		dialog.show();
		}
		else{
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 1);
		}

		
	}
	
	 
	public void getPicture2(View v){
		if(imgBitmap2!=null || !pictures.get(1).equals("0")){
		final Dialog dialog = new Dialog(Pictures.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.enlargephotos);
		 
		Button bt1= (Button)dialog.findViewById(R.id.button1);
		   
		bt1.setOnClickListener(new OnClickListener() {

		 

			@Override
			public void onClick(View arg0) {
				imgBitmap2=null;
				 
				PhotoInfoData photoData = new PhotoInfoData(dialog.getContext()); 
				photoData.open();
				
				photoData.updateEntry(1, "Photo2", "0");
				photoData.close();
				pictures.set(1, "0");
				iv2.setImageResource(R.drawable.addimage);
				dialog.cancel();
				
			}
      
			 
		    
			    
			});
	    ImageView iv1 = (ImageView) dialog.findViewById(R.id.imageView1);
		 
		 
		dialog.setCancelable(true);
		if(!pictures.get(1).equals("0")){
		iv1.setImageBitmap(StringToBitMap(pictures.get(1)));
		}
		else{
			iv1.setImageBitmap(imgBitmap2);
		}
		
		dialog.show();
		}
		else{
		
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 2);
		}

		
	}
	public void getPicture3(View v){
		
		if(imgBitmap3!=null  || !pictures.get(2).equals("0")){
			final Dialog dialog = new Dialog(Pictures.this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.enlargephotos);
			Button bt1= (Button)dialog.findViewById(R.id.button1);
			   
			bt1.setOnClickListener(new OnClickListener() {

			 

				@Override
				public void onClick(View arg0) {
					imgBitmap3=null;
					 
					PhotoInfoData photoData = new PhotoInfoData(dialog.getContext()); 
					photoData.open();
					
					photoData.updateEntry(1, "Photo3", "0");
					photoData.close();
					pictures.set(2, "0");
					iv3.setImageResource(R.drawable.addimage);
					dialog.cancel();
					
				}
	      
				 
			    
				    
				});
				
		    ImageView iv1 = (ImageView) dialog.findViewById(R.id.imageView1);
		
			 
			dialog.setCancelable(true);
			if(!pictures.get(2).equals("0")){
			iv1.setImageBitmap(StringToBitMap(pictures.get(2)));
			}
			else{
				iv1.setImageBitmap(imgBitmap3);
			}
			
			dialog.show();
			 
			}
		else{
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 3);
		}

		
	}
	public void getPicture4(View v){
		
		if(imgBitmap4!=null || !pictures.get(3).equals("0")){
			final Dialog dialog = new Dialog(Pictures.this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.enlargephotos);
			Button bt1= (Button)dialog.findViewById(R.id.button1);
			   
			bt1.setOnClickListener(new OnClickListener() {

			 

				@Override
				public void onClick(View arg0) {
					imgBitmap4=null;
					 
					PhotoInfoData photoData = new PhotoInfoData(dialog.getContext()); 
					photoData.open();
					
					photoData.updateEntry(1, "Photo4", "0");
					photoData.close();
					pictures.set(3, "0");
					iv4.setImageResource(R.drawable.addimage);
					dialog.cancel();
					
				}
	      
				 
			    
				    
				});
		    ImageView iv1 = (ImageView) dialog.findViewById(R.id.imageView1);
			 
			 
			dialog.setCancelable(true);
			if(!pictures.get(3).equals("0")){
			iv1.setImageBitmap(StringToBitMap(pictures.get(3)));
			}
			else{
				iv1.setImageBitmap(imgBitmap4);
			}
			dialog.show();
			}
		else{
		
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 4);
		}

		
	}
	public void getPicture5(View v){
		if(imgBitmap5!=null || !pictures.get(4).equals("0")){
			final Dialog dialog = new Dialog(Pictures.this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.enlargephotos);
			Button bt1= (Button)dialog.findViewById(R.id.button1);
			   
			bt1.setOnClickListener(new OnClickListener() {

			 

				@Override
				public void onClick(View arg0) {
					imgBitmap5=null;
					 
					PhotoInfoData photoData = new PhotoInfoData(dialog.getContext()); 
					photoData.open();
					
					photoData.updateEntry(1, "Photo5", "0");
					photoData.close();
					pictures.set(4, "0");
					iv5.setImageResource(R.drawable.addimage);
					dialog.cancel();
					
				}
	      
				 
			    
				    
				});
			
			
			
			
			
		    ImageView iv1 = (ImageView) dialog.findViewById(R.id.imageView1);
			 
			 
			dialog.setCancelable(true);
			if(!pictures.get(4).equals("0")){
			iv1.setImageBitmap(StringToBitMap(pictures.get(4)));
			}
			else{
				iv1.setImageBitmap(imgBitmap5);
			}
			
			dialog.show();
			}
		else{
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 5);
		}

		
	}
	public void getPicture6(View v){
		if(imgBitmap6!=null || !pictures.get(5).equals("0")){
			final Dialog dialog = new Dialog(Pictures.this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.enlargephotos);
			Button bt1= (Button)dialog.findViewById(R.id.button1);
			   
			bt1.setOnClickListener(new OnClickListener() {

			 

				@Override
				public void onClick(View arg0) {
					imgBitmap6=null;
					 
					PhotoInfoData photoData = new PhotoInfoData(dialog.getContext()); 
					photoData.open();
					
					photoData.updateEntry(1, "Photo6", "0");
					photoData.close();
					pictures.set(5, "0");
					iv6.setImageResource(R.drawable.addimage);
					dialog.cancel();
					
				}
	      
				 
			    
				    
				});
			
			
		    ImageView iv1 = (ImageView) dialog.findViewById(R.id.imageView1);
			 
			 
			dialog.setCancelable(true);
			if(!pictures.get(5).equals("0")){
			iv1.setImageBitmap(StringToBitMap(pictures.get(5)));
			}
			else{
				iv1.setImageBitmap(imgBitmap6);
			}
			
			dialog.show();
			}
		else{
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 6);
		}
		
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
	 
		
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	     ImageView iv1 = (ImageView)findViewById(R.id.imageView1);
		 ImageView iv2 = (ImageView)findViewById(R.id.imageView2);
		 ImageView iv3 = (ImageView)findViewById(R.id.imageView3);
		 ImageView iv4 = (ImageView)findViewById(R.id.imageView4);
		 ImageView iv5 = (ImageView)findViewById(R.id.imageView5);
		 ImageView iv6 = (ImageView)findViewById(R.id.imageView6);
		  
	    if (resultCode == Activity.RESULT_OK) {
	      Uri selectedImage = data.getData();
	      BitmapFactory.Options bounds = new BitmapFactory.Options();
	      bounds.inSampleSize = 8;
	      PhotoInfoData photoData = new PhotoInfoData(this);
			photoData.open();
			 
		
			
	    if(requestCode==1){
	  	   

	       imgBitmap1 = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
	      photoData.updateEntry(1, "Photo1", BitMapToString(imgBitmap1));
	     
	    

	    	  iv1.setImageBitmap(imgBitmap1);
	  
	       
	      
	      }
	      if(requestCode==2){
	      	  
	           

	           imgBitmap2 = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
	          photoData.updateEntry(1, "Photo2", BitMapToString(imgBitmap2));
	        
	        

	        	  iv2.setImageBitmap(imgBitmap2);
	         
	           
	          }
	      if(requestCode==3){
	      	  
	           

	     imgBitmap3 = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
	          photoData.updateEntry(1, "Photo3", BitMapToString(imgBitmap3));
	         
	        

	        	  iv3.setImageBitmap(imgBitmap3);
	    
	           
	          }
	      if(requestCode==4){
	      	  
	           

	      imgBitmap4 = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
	          photoData.updateEntry(1, "Photo4", BitMapToString(imgBitmap4));
	         
	        

	        	  iv4.setImageBitmap(imgBitmap4);
	        
	           
	          }
	      if(requestCode==5){
	      	  
	           

	          imgBitmap5 = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
	          photoData.updateEntry(1, "Photo5", BitMapToString(imgBitmap5));
	          iv5.setImageBitmap(imgBitmap5);
	       
	           
	          }
	      if(requestCode==6){
	     
	         imgBitmap6 = BitmapFactory.decodeFile(getRealPathFromURI(selectedImage), bounds);
	         photoData.updateEntry(1, "Photo6", BitMapToString(imgBitmap6));
	         iv6.setImageBitmap(imgBitmap6);
	         
	           
	        }
	      
	      
	      photoData.close(); 
	   
	}
	    

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//MenuInflater inflater = getMenuInflater();
	    //inflater.inflate(R.menu.menu, menu);
	    menu.add(0, 1, 0, "STATUS");
	    menu.add(0, 2, 0, "WORKOUT LIST");
	    menu.add(0, 3, 0, "CALENDER");
	    menu.add(0, 4, 0, "MORE");
	   
	    return true;
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(Pictures.this,Status.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(Pictures.this,WorkoutList.class);
	        	startActivity(i2);                   
	        break;
	        
	        case 3: 
	        	 Uri uri = Uri.parse("http://www.motivationmagnet.com/insanity-workout-calendar-schedule/");
	        	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	        	 startActivity(intent);                     
	        break;
	        
	        case 4: 
	        	Intent i3= new Intent(Pictures.this,More.class);
	        	startActivity(i3);  
		        break;
		        
	        
	    }
	    return true;
	}


}
