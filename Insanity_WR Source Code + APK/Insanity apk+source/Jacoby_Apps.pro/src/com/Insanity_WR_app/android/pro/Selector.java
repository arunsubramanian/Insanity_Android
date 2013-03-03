package com.Insanity_WR_app.android.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 



public class Selector {
	public static final String KEY_ROWID="_id";
	public static final String KEY_Selector = "Selector";
	 
	
	
	private static final String DATABASE_NAME = "Selector";
	private static final String DATABASE_TABLE="SelectorTable";
	private static final int DATABASE_VERSION= 1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static final String DATABASE_CREATE =
            " create table " + DATABASE_TABLE  + " ("
            + KEY_ROWID + " integer primary key autoincrement,"
            + KEY_Selector + " text not null);";

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
	public Selector(Context c){
		ourContext=c;
	}
	public Selector open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void  close(){
		ourHelper.close();
	}
	public long createEntry(String entry) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_Selector, entry);
		 
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public String getData(){
		String [] columns = new String[]{KEY_ROWID,KEY_Selector};
		ourDatabase = ourHelper.getReadableDatabase();
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iSelector = c.getColumnIndex(KEY_Selector);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
			
			result=c.getString(iSelector);
		
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
