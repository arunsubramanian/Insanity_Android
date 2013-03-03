package com.Insanity_WR_app.android;

import java.util.ArrayList;

import com.Insanity_WR_app.android.R;
 
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdViewSDK;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WorkoutList extends Activity {

	private ArrayList<String[]> values2;
	private DisplayMetrics displaymetrics;
	private int ht;
	private int wt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		 displaymetrics = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
		 setContentView(R.layout.workout_list) ;
		 RelativeLayout.LayoutParams adlayoutparams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		 
		 RelativeLayout ad1 = (RelativeLayout)findViewById(R.id.ad1);
		 
			adlayoutparams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
			 
			adlayoutparams1.height=(int) (.10*ht);
			MMAdView interAdView = null;
			if(interAdView == null)
			    interAdView = new MMAdView(this, "86805", MMAdView.FULLSCREEN_AD_TRANSITION, true, null);
			 interAdView.setId(MMAdViewSDK.DEFAULT_VIEWID);

			interAdView.callForAd();
		 
	 
			
			
			 
			AdView adView = new AdView(WorkoutList.this, AdSize.BANNER, "a14fb9a11f39212");
			 
			 
			 
		    
			 
			 ad1.addView(adView);
			 
			 AdRequest request = new AdRequest();
			 
			 request.addTestDevice(AdRequest.TEST_EMULATOR);
			adView.loadAd(request);
			 
		 ListView  lv = (ListView) findViewById(R.id.listView1);
		 lv.setDivider(null);
		 lv.setDividerHeight(0);
		 ExerciseInfoData2 entry = new ExerciseInfoData2(this);
	  	 entry.open();
	  	
	  	 values2 = entry.getData();
	  	 entry.close();
		
		   
			
		    CustomAdapter adapter = new CustomAdapter(WorkoutList.this,
		  	          R.layout.excercise_list, values2);
		    lv.setAdapter(adapter); 
		
		
		
	}
	public static class ViewHolder{
	    public TextView textView1;
	    public TextView textView2;
	    public ImageView imageView1;
	     
	}


	public class CustomAdapter extends ArrayAdapter<String[]>{
		private final Context context;
		private final ArrayList<String[]> values;
		private int textViewResourceId;
		

		public CustomAdapter(Context context, int textViewResourceId,
				ArrayList<String[]> values) {
			super(context, textViewResourceId, values);
			this.context = context;
			this.values = values;
			this.textViewResourceId=textViewResourceId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder holder=new ViewHolder();
		ViewGroup p = parent;
			if(rowView==null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(textViewResourceId,p, false);
			 holder.textView1 = (TextView) rowView.findViewById(R.id.textView1);
			 holder.textView2 = (TextView) rowView.findViewById(R.id.textView2);
			 holder.imageView1 = (ImageView) rowView.findViewById(R.id.imageView1);
			 
			rowView.setTag(holder);
			}
			else{
				holder = (ViewHolder)rowView.getTag();
			}
			if(values!=null){
			
			holder.textView1.setText("DAY"+" "+values.get(position)[0]);
			holder.textView2.setText(values.get(position)[1]);
			holder.imageView1.setMaxWidth((int) (.15*wt));
			if(Integer.parseInt(values.get(position)[2])==0){
				holder.imageView1.setImageResource(R.drawable.graycheck);
				
			}
			else{
				holder.imageView1.setImageResource(R.drawable.greencheck);
			}
			}
			return rowView;
			
		}
		
		 

		
		
	}
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 
	    menu.add(0, 1, 0, "STATUS");
	    menu.add(0, 2, 0, "PICTURES");
	    menu.add(0, 3, 0, "CALENDER");
	    menu.add(0, 4, 0, "MORE");
	   
	    return true;
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(WorkoutList.this,Status.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(WorkoutList.this,Pictures.class);
	        	startActivity(i2);                   
	        break;
	        
	        case 3: 
	        	 Uri uri = Uri.parse("http://www.motivationmagnet.com/insanity-workout-calendar-schedule/");
	        	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	        	 startActivity(intent);                     
	        break;
	        
	        case 4: 
	        	Intent i3= new Intent(WorkoutList.this,More.class);
	        	startActivity(i3);  
		        break;
		        
	        
	    }
	    return true;
	}
	
	
	
	
	
	
	
	
	
}
