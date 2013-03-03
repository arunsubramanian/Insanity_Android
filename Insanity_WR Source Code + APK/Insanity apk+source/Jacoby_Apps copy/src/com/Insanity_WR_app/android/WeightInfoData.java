package com.Insanity_WR_app.android;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.Insanity_WR_app.android.R;

 

public class WeightInfoData {
	
	
	ArrayList<String[]> values = new ArrayList<String[]>();
	public static final String KEY_ROWID="_id";
	public static final String KEY_01 = "Weight";
	 

	private static final String DATABASE_NAME = "UserStats";
	private static final String DATABASE_TABLE="Weight";
	private static final int DATABASE_VERSION= 1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static final String DATABASE_CREATE =
            " create table " + DATABASE_TABLE  + " ("
            + KEY_ROWID + " integer primary key autoincrement,"
            + KEY_01 + " text not null);";

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
			db.execSQL("DROP TABLE IF EXISTS"+ " "+DATABASE_TABLE);
			onCreate(db);
		}

		
		
	}
	public WeightInfoData(Context c){
		ourContext=c;
	}
	public WeightInfoData open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void  close(){
		ourHelper.close();
	}
	public long createEntry(String value) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_01, value);
		 
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public ArrayList<String[]> getData(){
		String [] columns = new String[]{KEY_ROWID,KEY_01};
		ourDatabase = ourHelper.getReadableDatabase();
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		//String result="";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iWeight = c.getColumnIndex(KEY_01);
		 
		
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
			String[] result={c.getString(iRow),c.getString(iWeight)};
			values.add(result);
			
			 
 
		}
		
		c.close();
		return values;
			
	}

}
