package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
 

public class AlarmReceiver extends BroadcastReceiver {
	 
	@Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager mNM;
       
        ExerciseInfoData2 entry2 = new ExerciseInfoData2(context);
	  	entry2.open();
	  	ArrayList<String[]> notificationList2 = entry2.getData2();
	  	entry2.close();
	  	DateInfoData dateEntry = new DateInfoData(context);
		 dateEntry.open();
	     ArrayList<String[]> values4 = dateEntry.getData();
		 dateEntry.close();
	  	//ExerciseInfoData entry = new ExerciseInfoData(context);
	  	//entry.open();
	  	//ArrayList<String[]> notificationList = entry.getData2();
	  	//entry.close();
	  	
		 Calendar date = Calendar.getInstance();
		 Calendar rightnow = Calendar.getInstance();
		 if(values4.size()!=0){
		    date.set(Calendar.YEAR,Integer.parseInt(values4.get(0)[1]));
			date.set(Calendar.MONTH,Integer.parseInt(values4.get(0)[2]));
			date.set(Calendar.DATE,Integer.parseInt(values4.get(0)[3]));
			date.set(Calendar.HOUR_OF_DAY,Integer.parseInt(values4.get(0)[4]));
			date.set(Calendar.MINUTE,Integer.parseInt(values4.get(0)[5]));
			date.set(Calendar.SECOND,Integer.parseInt(values4.get(0)[6]));
			date.set(Calendar.MILLISECOND,Integer.parseInt(values4.get(0)[7]));
			 
			 
			
        mNM = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
         
        Notification notification = new Notification(R.drawable.ic_launcher, "New Excercise Today",
        System.currentTimeMillis());
       
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, Status.class), 0);
        CharSequence contentText;
       

		if(notificationList2.size()!=0 ){
			  if (intent.getAction()!=null ){
				  if(!date.after(rightnow) && Integer.parseInt(values4.get(0)[1])!=0){
				  contentText = notificationList2.get(0)[1].toString();
				  notification.setLatestEventInfo(context, "Today's Workout", contentText, contentIntent);
				  // notification.sound=alert;
				 notification.sound=Uri.parse("android.resource://com.Insanity_WR_app.android.pro/raw/notification");
			      mNM.notify(1, notification);
			      Intent i= new Intent(context,NotificationAlert.class);
					 
					i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
					context.startActivity(i);
			      
				  }
			  }
			  else{
			  contentText = notificationList2.get(0)[1].toString();
			  notification.setLatestEventInfo(context, "Today's Workout", contentText, contentIntent);
			  
			 notification.sound=Uri.parse("android.resource://com.Insanity_WR_app.android.pro/raw/notification");
			 
		      mNM.notify(1, notification);
		      Intent i= new Intent(context,NotificationAlert.class);
				 
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
				context.startActivity(i);
			  }
			 }
			 else{
				 if(intent.getAction()!=null){
					 //DO NOTHING
				 }
				 else{
				 contentText = " Congratulations, You're Finished!"; 
				 notification.setLatestEventInfo(context, "Today's Workout", contentText, contentIntent);
				 notification.sound=Uri.parse("android.resource://com.Insanity_WR_app.android.pro/raw/notification");
			     mNM.notify(1, notification);
				 }
			     
			 }
	
	}
		}
        // Send the notification.
        // We use a layout id because it is a unique number. We use it later to cancel.
        
    }

	
