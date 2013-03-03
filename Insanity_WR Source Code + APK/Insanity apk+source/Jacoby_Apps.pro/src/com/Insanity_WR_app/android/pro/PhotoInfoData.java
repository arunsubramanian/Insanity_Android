package com.Insanity_WR_app.android.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 


public class PhotoInfoData {
	public static final String KEY_ROWID="_id";
	public static final String KEY_1 = "Photo1";
	public static final String KEY_2 = "Photo2";
	public static final String KEY_3 = "Photo3";
	public static final String KEY_4 = "Photo4";
	public static final String KEY_5 = "Photo5";
	public static final String KEY_6 = "Photo6";
	
	private static final String DATABASE_NAME = "PhotoPro";
	private static final String DATABASE_TABLE="PhotoTablePro";
	private static final int DATABASE_VERSION= 1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static final String DATABASE_CREATE =
            " create table " + DATABASE_TABLE  + " ("
            + KEY_ROWID + " integer primary key autoincrement,"+KEY_1 + " text not null,"+KEY_2 + " text not null,"+
            KEY_3 + " text not null,"+ KEY_4 + " text not null,"+ KEY_5 + " text not null,"+ KEY_6 + " text not null);";

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
	public PhotoInfoData(Context c){
		ourContext=c;
	}
	public PhotoInfoData open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void  close(){
		ourHelper.close();
	}
	public long createEntry(String[] values) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_1, values[0]);
		cv.put(KEY_2, values[1]);
		cv.put(KEY_3, values[2]);
		cv.put(KEY_4, values[3]);
		cv.put(KEY_5, values[4]);
		cv.put(KEY_6, values[5]);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public String getData(String Index){
		String [] columns = new String[]{KEY_ROWID,KEY_1,KEY_2,KEY_3,KEY_4,KEY_5,KEY_6};
		ourDatabase = ourHelper.getReadableDatabase();
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result="";
		int iPhoto1 = c.getColumnIndex(Index);
		
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
			
			  result=c.getString(iPhoto1);
			  
		}
		c.close();
		return result;
		
	
		
			
	}
	public void updateEntry(int id,String key,String entry) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(key, entry);
		
		ourDatabase.update(DATABASE_TABLE, cv, KEY_ROWID+"="+id, null);
		 
		 
	}

}
