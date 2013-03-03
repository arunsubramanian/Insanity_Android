package com.Insanity_WR_app.android;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
 

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
	  //	ExerciseInfoData entry = new ExerciseInfoData(context);
	  //	entry.open();
	  //	ArrayList<String[]> notificationList = entry.getData2();
	  //	entry.close();
	  	
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
			
			 
			
        mNM = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        mNM.cancel(1);
        Notification notification = new Notification(R.drawable.ic_launcher, "New Excercise Today",
        System.currentTimeMillis());
       
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, Status.class), 0);
        CharSequence contentText;
		if(notificationList2.size()!=0 ){
			  if (intent.getAction()!=null ){
				  if(!date.after(rightnow) && date.get(Calendar.YEAR)!=0){
				  contentText = notificationList2.get(0)[1].toString();
				  notification.setLatestEventInfo(context, "Today's Workout", contentText, contentIntent);
			      mNM.notify(1, notification);
				  }
			  }
			  else{
			  contentText = notificationList2.get(0)[1].toString();
			  notification.setLatestEventInfo(context, "Today's Workout", contentText, contentIntent);
		      mNM.notify(1, notification);
			  }
			 }
			 else{
				 contentText = " Congratulations, You're Finished!"; 
				 notification.setLatestEventInfo(context, "Today's Workout", contentText, contentIntent);
			     mNM.notify(1, notification);
			 }
	
		 }
		}
        // Send the notification.
        // We use a layout id because it is a unique number. We use it later to cancel.
        
    }

	
