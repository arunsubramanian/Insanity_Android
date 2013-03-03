package com.Insanity_WR_app.android.pro;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 


public class FitTestInfoData {
	ArrayList<String[]> values = new ArrayList<String[]>();
	ArrayList<String[]> values2 = new ArrayList<String[]>();
	public static final String KEY_ROWID="_id";
	public static final String KEY_01 = "SwitchKicks";
	public static final String KEY_02 = "PowerJacks";
	public static final String KEY_03 = "PowerKnees";
	public static final String KEY_04 = "PowerJumps";
	public static final String KEY_05 = "GlobeJumps";
	public static final String KEY_06 = "SuicideJumps";
	public static final String KEY_07 = "PushUpJacksJacks";
	public static final String KEY_08 = "LowPlankOblique";

	private static final String DATABASE_NAME = "FitTestPro";
	private static final String DATABASE_TABLE="FittestTablePro";
	private static final int DATABASE_VERSION= 1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static final String DATABASE_CREATE =
            " create table " + DATABASE_TABLE  + " ("
            + KEY_ROWID + " integer primary key autoincrement,"
            + KEY_01 + " text not null,"+ KEY_02 + " text not null,"+ KEY_03 + " text not null,"+ KEY_04 + " text not null,"+ KEY_05 + " text not null,"
            + KEY_06 + " text not null,"+ KEY_07 + " text not null,"+ KEY_08 + " text not null);";

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
	public FitTestInfoData(Context c){
		ourContext=c;
	}
	public FitTestInfoData open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void  close(){
		ourHelper.close();
	}
	public long createEntry(String[] value) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_01, value[0].toString());
		cv.put(KEY_02, value[1].toString());
		cv.put(KEY_03, value[2].toString());
		cv.put(KEY_04, value[3].toString());
		cv.put(KEY_05, value[4].toString());
		cv.put(KEY_06, value[5].toString());
		cv.put(KEY_07, value[6].toString());
		cv.put(KEY_08, value[7].toString());
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public ArrayList<String[]> getData(){
		String [] columns = new String[]{KEY_01,KEY_02,KEY_03,KEY_04,KEY_05,KEY_06,KEY_07,KEY_08};
		ourDatabase = ourHelper.getReadableDatabase();
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		//String result="";
		int i1 = c.getColumnIndex(KEY_01);
		int i2 = c.getColumnIndex(KEY_02);
		int i3 = c.getColumnIndex(KEY_03);
		int i4 = c.getColumnIndex(KEY_04);
		int i5 = c.getColumnIndex(KEY_05);
		int i6 = c.getColumnIndex(KEY_06);
		int i7 = c.getColumnIndex(KEY_07);
		int i8 = c.getColumnIndex(KEY_08);
		
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
			String[] result={c.getString(i1),c.getString(i2),c.getString(i3),c.getString(i4),c.getString(i5),c.getString(i6),c.getString(i7),c.getString(i8)};
			values.add(result);
			
			//result=result+" "+c.getString(iRow)+" "+c.getString(iExercise)+" "+c.getString(iFinished);
 
		}
		
		c.close();
		return values;
			
	}

	public void updateEntry(int id,String key,String entry) {
		ContentValues cv = new ContentValues();
		cv.put(key, entry);
		
		ourDatabase.update(DATABASE_TABLE, cv, KEY_ROWID+"="+id, null);
		
	}
}
