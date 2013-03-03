package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 



public class DateInfoData {
	
	ArrayList<String[]> values = new ArrayList<String[]>();
	public static final String KEY_ROWID="_id";
	public static final String KEY_01 = "Year";
	public static final String KEY_02 = "Month";
	public static final String KEY_03 = "DAY";
	public static final String KEY_04 = "Hour";
	public static final String KEY_05 = "Minutes";
	public static final String KEY_06 = "Seconds";
	public static final String KEY_07 = "MilliSeconds";
	 

	private static final String DATABASE_NAME = "DateDatabasePro";
	private static final String DATABASE_TABLE="DateTablePro";
	private static final int DATABASE_VERSION= 1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static final String DATABASE_CREATE =
            " create table " + DATABASE_TABLE  + " ("
            + KEY_ROWID + " integer primary key autoincrement,"+KEY_01 + " text not null,"+KEY_02 + " text not null,"+KEY_03 + 
            " text not null,"+KEY_04 + " text not null,"+KEY_05 + " text not null,"+KEY_06 + " text not null,"+
             KEY_07 + " text not null);";

	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(DATABASE_CREATE);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_TABLE);
			onCreate(db);
		}

		
		
	}
	public DateInfoData(Context c){
		ourContext=c;
	}
	public DateInfoData open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void  close(){
		ourHelper.close();
	}
	public long createEntry(String [] value) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_01, value[0]);
		cv.put(KEY_02, value[1]);
		cv.put(KEY_03, value[2]);
		cv.put(KEY_04, value[3]);
		cv.put(KEY_05, value[4]);
		cv.put(KEY_06, value[5]);
		cv.put(KEY_07, value[6]);
		 
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public void updateEntry(int id,String[] entry) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_01, entry[0]);
		cv.put(KEY_02, entry[1]);
		cv.put(KEY_03, entry[2]);
		cv.put(KEY_04, entry[3]);
		cv.put(KEY_05, entry[4]);
		cv.put(KEY_06, entry[5]);
		cv.put(KEY_07, entry[6]);
		
		ourDatabase.update(DATABASE_TABLE, cv, KEY_ROWID+"="+id, null);
		 
		 
	}
	
	public ArrayList<String[]> getData(){
		String [] columns = new String[]{KEY_ROWID,KEY_01,KEY_02,KEY_03,KEY_04,KEY_05,KEY_06,KEY_07};
		ourDatabase = ourHelper.getReadableDatabase();
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		 
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iYear = c.getColumnIndex(KEY_01);
		int iMonth = c.getColumnIndex(KEY_02);
		int iDay = c.getColumnIndex(KEY_03);
		int iHour = c.getColumnIndex(KEY_04);
		int iMinutes = c.getColumnIndex(KEY_05);
		int iSeconds = c.getColumnIndex(KEY_06);
		int iMilliSeconds = c.getColumnIndex(KEY_07);
		 
		
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
		String[] result={c.getString(iRow),c.getString(iYear),c.getString(iMonth),c.getString(iDay),c.getString(iHour),c.getString(iMinutes),c.getString(iSeconds),c.getString(iMilliSeconds)};
			values.add(result);
			
			 
 
		}
		
		c.close();
		return values;
			
	}

}
