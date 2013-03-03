package com.Insanity_WR_app.android.pro;

 
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;



 


public class More extends Activity 
{

	

	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(android.view.Window.FEATURE_PROGRESS);
		
		setContentView(R.layout.more);
		
		 
	   
		   

	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		this.finish();
		Intent i= new Intent(More.this,Main_Menu.class);
    	startActivity(i); 
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 
	    menu.add(0, 1, 0, "STATUS");
	    menu.add(0, 2, 0, "WORKOUT LIST");
	    menu.add(0, 3, 0, "CALENDER");
	    menu.add(0, 4, 0, "PICTURES");
	   
	    return true;
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(More.this,Status.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(More.this,WorkoutList.class);
	        	startActivity(i2);                   
	        break;
	        
	        case 3: 
	        	 Uri uri = Uri.parse("http://www.google.com");
	        	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	        	 startActivity(intent);                     
	        break;
	        
	        case 4: 
	        	Intent i3= new Intent(More.this,Pictures.class);
	        	startActivity(i3);  
		        break;
		        
	        
	    }
	    return true;
	}
	
	
	
	
	
	
	
	
	
	
  
}