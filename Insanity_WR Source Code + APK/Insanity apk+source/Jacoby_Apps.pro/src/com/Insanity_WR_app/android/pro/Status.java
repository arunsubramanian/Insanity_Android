package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

 

public class Status extends Activity {
	 ArrayList<String[]> values2=new ArrayList<String[]>();
	 ArrayList<String[]> values3=new ArrayList<String[]>();
	private DisplayMetrics displaymetrics;
	private int ht;
	private int wt;
	private String selection;
	public Selector selector;
	private Timer t=new Timer();
	private Handler handler=new Handler();
	AlarmManager am;
	private ArrayList<String[]> values4=new ArrayList<String[]>();
	private String dateYear;
	public TextView tv5;
	private ImageView iv1;
	private TextView tv7;
	private TextView tv1;
	private CheckBox cb;
	 
	private TextView tv2;
	public String exerciseA = "";
	public String exerciseB = "";
	private int hour_of_the_day;
	private int minute;
    private int second=0;
    private int millisecond=0;
    private int day=1;
    
	
    boolean hasBeenCheckedBefore=false;
	private TimeInfoData  reminderTime;
	private ArrayList<String[]> reminderTimeVal;
	private ImageView iv2;
	private double factor;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		 displaymetrics = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
	     reminderTime = new  TimeInfoData(this);
	     reminderTime.open();
	     reminderTimeVal=reminderTime.getData();
	     reminderTime.close();
	     hour_of_the_day=Integer.parseInt(reminderTimeVal.get(0)[0]);
	 	 minute=Integer.parseInt(reminderTimeVal.get(0)[1]);
	    
	     ExerciseInfoData entry = new ExerciseInfoData(this);
	  	 entry.open();
	  	 values3=entry.getData2(); 
	  	 values2 = entry.getData();
	  	 entry.close();
	  	 DateInfoData dateEntry = new DateInfoData(this);
		 dateEntry.open();
	     values4= dateEntry.getData();
		 dateEntry.close();
		 String ns = Context.NOTIFICATION_SERVICE;
	     final NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
	      
	     
		 
		 setContentView(R.layout.status_page);
		 
         
		
		 
		 
		 if(values4.size()!=0){ // Fail Safe Check
		 
		 dateYear=values4.get(0)[1];
		  
		 if (!dateYear.equals("0")){
			 Calendar date = Calendar.getInstance();
			  date.set(Calendar.YEAR,Integer.parseInt(values4.get(0)[1]));
				date.set(Calendar.MONTH,Integer.parseInt(values4.get(0)[2]));
				date.set(Calendar.DATE,Integer.parseInt(values4.get(0)[3]));
				date.set(Calendar.HOUR_OF_DAY,Integer.parseInt(values4.get(0)[4]));
				date.set(Calendar.MINUTE,Integer.parseInt(values4.get(0)[5]));
				date.set(Calendar.SECOND,Integer.parseInt(values4.get(0)[6]));
				date.set(Calendar.MILLISECOND,Integer.parseInt(values4.get(0)[7]));
			    t.schedule(new UpdateList(), date.getTime());
			     
		 }
		 }
		 final TodayorTomorrow tot=new TodayorTomorrow();
		 tot.today();
		 selector = new Selector(Status.this);
			selector.open();
			selection=selector.getData();
			selector.close();
		 
		 
		 iv1= (ImageView) findViewById(R.id.imageView1);
		 iv2=(ImageView)findViewById(R.id.imageView2);
		 iv1.setMaxWidth((int) (.60*wt));
		 tv1=(TextView)findViewById(R.id.textView1);
		 tv2=(TextView)findViewById(R.id.textView2);
		 tv5=(TextView)findViewById(R.id.textView5);
		 tv7=(TextView)findViewById(R.id.textView7);
		 
		 
			if(ht<330){
				factor=.33;
			}
			else{
				factor=.6;
			}
		 iv2.setMaxWidth((int) (factor*wt));
		 iv2.setOnClickListener(new OnClickListener(){
			 
			@Override
			public void onClick(View arg0) {
			 
			if(iv2.getTag().equals("Tom")){
			tot.tomorrow();
			//bt1.setText("Today");
			iv2.setTag("Tod");
			iv2.setImageResource(R.drawable.todaystatusbut);
			 
			}
			else{
				tot.today();
				//bt1.setText("Tomorrow");
				iv2.setTag("Tom");
				iv2.setImageResource(R.drawable.tomrrowbut);
				 
			}
				
			}});
		 tv5.setTextSize(23);
		 tv7.setTextSize(23);
		 cb = (CheckBox)findViewById(R.id.checkBox1);
		 
		 
		 cb.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
			
				
                  if ( cb.isChecked() ){
                	   
                	  cb.setClickable(false);
                	  mNotificationManager.cancel(1);
                	  if(!hasBeenCheckedBefore){
                	  
                	  final Dialog dialog = new Dialog(Status.this);
					  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					  dialog.setCancelable(false);
					  dialog.setContentView(R.layout.customprogressdialog);
					  dialog.show();
                	  if(values3.size()>0){
                		  
							selector.open();
							selector.updateEntry(1,"Selector","1");
							selector.close();
							selector = new Selector(Status.this);
							selector.open();
							selection=selector.getData();
							selector.close();
							 
					 	 
					 ExerciseInfoData2 entry2 = new ExerciseInfoData2(Status.this);
				  	 entry2.open();
				  	
				  	  entry2.updateEntry(Integer.parseInt(values3.get(0)[0]),"Completed","1");
				  	 entry2.close();
				  	Calendar date = Calendar.getInstance();
					date.set(Calendar.HOUR_OF_DAY,hour_of_the_day);
					date.set(Calendar.MINUTE,minute);
					date.set(Calendar.SECOND, second);
					date.add(Calendar.MILLISECOND, millisecond);
					date.add(Calendar.DATE, day);
					 
					int year = date.get(Calendar.YEAR);
					int month=date.get(Calendar.MONTH);
					int day=date.get(Calendar.DATE);
					int hour_of_day =date.get(Calendar.HOUR_OF_DAY);
					int minute =date.get(Calendar.MINUTE);
					int second =date.get(Calendar.SECOND);
					int millisecond =date.get(Calendar.MILLISECOND);
					
					 String [] time ={String.valueOf(year),String.valueOf(month),String.valueOf(day),String.valueOf(hour_of_day),String.valueOf(minute),String.valueOf(second),String.valueOf(millisecond)};
					
					 DateInfoData dateEntry = new DateInfoData(Status.this);
					 dateEntry.open();
					 dateEntry.updateEntry(1,time);
					 dateEntry.close();
					  
					  
					  
					     
					 
					  
                     
					 AlarmService notify = new AlarmService(getBaseContext());
			 
					 notify.startAlarm();
					 
					 Timer t=new Timer();
					 
					 
					 t.schedule(new UpdateList(), date.getTime());
					
					 


                	  }
                	         
                	  dialog.cancel();
                	  }
                  }
                  
                  
                  
                  
                  
                  
					}
				 
				
			
			 
	
		 });
		
		 
			
 if(selection.equals("0")){
	 
			 cb.setChecked(false);
			 mNotificationManager.cancel(1);
			 
		}
		else{
			hasBeenCheckedBefore=true; 
			 
			 cb.setChecked(true);
			 
			 
			  
	 
			  
		 }  
			
		 
		tv1.setPadding(0, (int)(.02*ht), 0, (int)(.005*ht));
		tv2.setPadding(0, 0, 0, (int)(.02*ht));
		 tv5.setPadding(0, (int) (.10*ht),0, 0);
		 
		  
		 
		 
		
		 
		 
		   
		  
		 
		 
		
		 
 
	
	 
		
		
		 
	 
		
		
		
		
		
		
	}
	
	
	public class AlarmService {
	    private Context context;
	    private PendingIntent mAlarmSender;
	    public AlarmService(Context context) {
	        this.context = context;
	        mAlarmSender = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);
	    }

	    public void startAlarm(){
	        
	        Calendar c = Calendar.getInstance();
	        c.set(Calendar.HOUR_OF_DAY, hour_of_the_day);
			c.set(Calendar.MINUTE,minute);
			c.set(Calendar.SECOND, second);
			c.add(Calendar.MILLISECOND, millisecond);
			c.add(Calendar.DATE, day);
	        long firstTime = c.getTimeInMillis();
	        // Schedule the alarm!
	        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
	       
	        am.set(AlarmManager.RTC_WAKEUP, firstTime, mAlarmSender);
	       
	    }
	}
	
	
	public class TodayorTomorrow{
		 
		public void today(){
			  
			    tv1=(TextView)findViewById(R.id.textView1);
				tv2=(TextView)findViewById(R.id.textView2);
				tv5=(TextView)findViewById(R.id.textView5); 
				tv7=(TextView)findViewById(R.id.textView7);
				cb = (CheckBox)findViewById(R.id.checkBox1);
				cb.setVisibility(View.VISIBLE);
				 
				tv1.setText("TODAY");
				tv1.setTextSize(23);
				tv2.setTextSize(16);
				
				if(values3.size()!=0){
				tv5.setText(values3.get(0)[0].toString() +" "+"DAYS");
				tv7.setText("DONE");
				 
				 }
				 else{
				 tv1.setText("");
				 tv2.setText("");	 
				 tv5.setText("YOUR");
				 tv7.setText("FINISHED!");
				 cb.setVisibility(View.GONE);
				 iv2.setVisibility(View.GONE);
				 
				 
				
				 
					
					  
					 
				 }
			
			new SetElements().setExerciseTextToday();
			
		}
		
		public void tomorrow(){
			if(values3.size()!=0){
				tv1=(TextView)findViewById(R.id.textView1);
				tv5=(TextView)findViewById(R.id.textView5);
				tv7=(TextView)findViewById(R.id.textView7);
				cb = (CheckBox)findViewById(R.id.checkBox1);
				cb.setVisibility(View.GONE);
				tv1.setText("TOMORROW");
				tv1.setTextSize(23);
				tv2.setTextSize(16);
				tv5.setText(String.valueOf(values2.size()-Integer.parseInt(values3.get(0)[0])) + " "+ "DAYS");
				tv7.setText("TO GO");
				 
				 }
				 else{
					 
					 tv1.setText("");
					 tv2.setText("");	 
					 tv5.setText("YOUR");
					 tv7.setText("FINISHED!");
					
					 
					 
				 }
			new SetElements().setExerciseTextTomorrow();
			
		}
	}
	
	 public class SetElements{

		 public void setExerciseTextToday(){
			  
			 
				 if(values3.size()!=0){
				int count=0;
				 
				  for(int i = 0;i<values2.size();i++){
					 
					  
					  if(values2.get(i)[2].toString().equals("0") && values2.get(i)[2].toString() != null){
						  
						  if(count==1){
						  
						 
							 
					 
						 
						exerciseB=  values2.get(i)[1].toString();
						  break;
						  
						}
						  
						  else{
							  
							   
									 tv2.setText(values2.get(i)[1].toString()); 
								 
							  exerciseA=  values2.get(i)[1].toString();
							  count++;
							  
						  }
					  }
					 
				  }
				  
				 }
				 

				
				
			 
			 
			 
			 
			 
			} 

		 
		public void setExerciseTextTomorrow(){
			
			 if(values3.size()!=0){
					int count=0;
					 
					  for(int i = 0;i<values2.size();i++){
						  if(i==values2.size()-1){
							  
							  tv2.setText("YOUR DONE !");  
							  
						  }
						  
						  if(values2.get(i)[2].toString().equals("0") && values2.get(i)[2].toString() != null){
							  
							  if(count==1){
							  
							 
								 tv2.setText(values2.get(i)[1].toString()); 
						 
							 
							exerciseB=  values2.get(i)[1].toString();
							  break;
							  
							}
							  
							  else{
								  
								   
										  
									 
								  exerciseA=  values2.get(i)[1].toString();
								  count++;
								  
							  }
						  }
						 
					  }
					  
					 }

					
					
			
			
			
			
			
		}
		 
		 
	 }

	public class UpdateList extends TimerTask {
		 
			
			
	 
		
		@Override
		public void run() {
			
			ExerciseInfoData entry = new ExerciseInfoData (Status.this);
		  	 entry.open();
		  	 entry.updateEntry(Integer.parseInt(values3.get(0)[0]),"Completed","1");
		  	 entry.close();
		  	 selector.open();
			 selector.updateEntry(1,"Selector","0");
			 selector.close();
			 DateInfoData dateEntry = new DateInfoData(Status.this);
			 String [] time ={"0","0","0","0","0","0","0"};
			 dateEntry.open();
			 dateEntry.updateEntry(1,time);
			 dateEntry.close();
			 
				handler.post(new Runnable() {
					@Override
						public void run() {
						values2=new ArrayList<String[]>();
						      values3=new ArrayList<String[]>();
							 ExerciseInfoData entry = new ExerciseInfoData(Status.this);
						  	 entry.open();
						  	 values3=entry.getData2(); 
						  	 values2 = entry.getData();
						  	 entry.close();
								
						  	 
								selector.open();
								selection=selector.getData();
								selector.close();
								
								 cb.setChecked(false);
								 cb.setClickable(true);
								hasBeenCheckedBefore=false; //MAKES SURE THE LOGIC IS FALSE IF ONDESTROY IS NOT CALLED
								  
								  
								  
								 
								 if(values3.size()!=0){
									 
									 tv5.setText(values3.get(0)[0].toString() + " "+"DAYS");
									 tv2.setText(values3.get(0)[1].toString());
									
									 }
									 else{
										 tv1.setText("");
										 tv2.setText("");	 
										 tv5.setText("YOUR");
										 tv7.setText("FINISHED!");
										 cb.setVisibility(View.GONE);
										iv2.setVisibility(View.GONE);
										 
										
									 }
									
					 
							 
						}
					});
				 
                    
			

		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//MenuInflater inflater = getMenuInflater();
	    //inflater.inflate(R.menu.menu, menu);
	    menu.add(0, 1, 0, "WORKOUT LIST");
	    menu.add(0, 2, 0, "PICTURES");
	   
	    menu.add(0, 3, 0, "FIT TEST");
	    menu.add(0, 4, 0, "REMINDER");
	    menu.add(0, 5, 0, "MY GOAL");
	   
	    return true;
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case 1:   
	        	Intent i= new Intent(Status.this,WorkoutList.class);
	        	startActivity(i); 
	        break;
	       
	        case 2:     
	        	Intent i2= new Intent(Status.this,Pictures.class);
	        	startActivity(i2);                   
	        break;
	        
	      
	        
	        case 3: 
	        	Intent i3= new Intent(Status.this,PreviousFitTest.class);
	        	startActivity(i3);  
		        break;
	        case 4: 
	        	Intent i4= new Intent(Status.this,Reminder.class);
	        	startActivity(i4);  
		        break;
	        case 5: 
	        	Intent i5= new Intent(Status.this,Goal.class);
	        	startActivity(i5);  
		        break;
		        
	        
	    }
	    return true;
	}
	
	 
	
	
	
}
	
	
	
	
	

 
