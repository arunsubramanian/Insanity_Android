package com.Insanity_WR_app.android.pro;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PreviousFitTest extends Activity {

	private TextView tv14;
	private FitTestInfoData ft;
	private EditText eT1;
	private EditText eT2;
	private EditText eT3;
	private EditText eT4;
	private EditText eT5;
	private EditText eT6;
	private EditText eT7;
	private EditText eT8;
 
	private DisplayMetrics displaymetrics;
	private int ht;
	private int wt;
	private ImageView iv1;
	private ImageView iv2;
	private ImageView iv3;
	private ImageView iv5;
	private ImageView iv4;
	private double factor;
	private ImageView iv6;
	private RelativeLayout rl1;
	public static final String KEY_01 = "SwitchKicks";
	public static final String KEY_02 = "PowerJacks";
	public static final String KEY_03 = "PowerKnees";
	public static final String KEY_04 = "PowerJumps";
	public static final String KEY_05 = "GlobeJumps";
	public static final String KEY_06 = "SuicideJumps";
	public static final String KEY_07 = "PushUpJacksJacks";
	public static final String KEY_08 = "LowPlankOblique";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		 displaymetrics = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	     ht=displaymetrics.heightPixels;
	     wt=displaymetrics.widthPixels;
		 
		 setContentView(R.layout.pastfittest);
		 rl1 = (RelativeLayout)findViewById(R.id.rl1);
		 
		
		 rl1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(iv6.getTag().equals("saved")){
				iv6.setImageResource(R.drawable.savebut);
				iv6.setTag("save");	
					
				}
				
			}} );
		 tv14=(TextView)findViewById(R.id.textView14); 
		 eT1 = (EditText) findViewById(R.id.editText1);
		 eT2 = (EditText) findViewById(R.id.editText2);
	     eT3 = (EditText) findViewById(R.id.editText3);
		 eT4 = (EditText) findViewById(R.id.editText4);
		 eT5 = (EditText) findViewById(R.id.editText5);
		 eT6 = (EditText) findViewById(R.id.editText6);
		 eT7 = (EditText) findViewById(R.id.editText7);
		 eT8 = (EditText) findViewById(R.id.editText8);
		 
		 eT1.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		 eT2.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		  
		 eT3.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				iv6.setImageResource(R.drawable.savebut);
				iv6.setTag("save");	
				return false;
			}}
		 
				 );
		 eT4.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		 eT5.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		 eT6.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		 eT7.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		 eT8.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					iv6.setImageResource(R.drawable.savebut);
					iv6.setTag("save");	
					return false;
				}}
			 
					 );
		 
		 
		 
		 
		 
		 
		 
		 iv1 = (ImageView) findViewById(R.id.imageView1);
		 iv2 = (ImageView) findViewById(R.id.imageView2);
		 iv3 = (ImageView) findViewById(R.id.imageView3);
		 iv4 = (ImageView) findViewById(R.id.imageView4);
		 iv5 = (ImageView) findViewById(R.id.imageView5);
		 iv6 = (ImageView) findViewById(R.id.imageView6);
		 
		 
		 iv1.setMaxWidth((int) (.2*wt));
		 iv2.setMaxWidth((int) (.2*wt));
		 iv3.setMaxWidth((int) (.2*wt));
		 iv4.setMaxWidth((int) (.2*wt));
		 iv5.setMaxWidth((int) (.2*wt));
		 
		 eT1.setTextSize((float) 14);
		 eT2.setTextSize((float) 14);
		 eT3.setTextSize((float) 14);
		 eT4.setTextSize((float) 14);
		 eT5.setTextSize((float) 14);
		 eT6.setTextSize((float) 14);
		 eT7.setTextSize((float) 14);
		 eT8.setTextSize((float) 14);
		 
		 if(ht<330){
				factor=.33;
			}
			else{
				factor=.6;
			}
		 iv6.setMaxWidth((int) (factor*wt));
		 
		 ft = new FitTestInfoData(this);
		 ft.open();
		

	
		 ArrayList<String[]> values = ft.getData();
		 
		 
		 
		 
		 ft.close();
	 if (values.size()>=1){
	 eT1.setText(values.get(0)[0]);
		 eT2.setText(values.get(0)[1]);
		 eT3.setText(values.get(0)[2]);
		 eT4.setText(values.get(0)[3]);
		 eT5.setText(values.get(0)[4]);
		 eT6.setText(values.get(0)[5]);
		 eT7.setText(values.get(0)[6]);
		 eT8.setText(values.get(0)[7]);
		 
			 
		 }
	 else{
		 eT1.setText(null);
		 eT2.setText(null);
		 eT3.setText(null);
		 eT4.setText(null);
		 eT5.setText(null);
		 eT6.setText(null);
		 eT7.setText(null);
		 eT8.setText(null);
		 
	 }
		tv14.setText("FT 1");
		 
		   
	}
	
	public void saved(View v){
		
		 ft = new FitTestInfoData(this);
		 ft.open();
		 if(tv14.getText().toString().equals("FT 1")){
				int id =1;
				ft.updateEntry(id, KEY_01, eT1.getText().toString());	
				ft.updateEntry(id, KEY_02, eT2.getText().toString());
				ft.updateEntry(id, KEY_03, eT3.getText().toString());
				ft.updateEntry(id, KEY_04, eT4.getText().toString());
				ft.updateEntry(id, KEY_05, eT5.getText().toString());	
				ft.updateEntry(id, KEY_06, eT6.getText().toString());
				ft.updateEntry(id, KEY_07, eT7.getText().toString());
				ft.updateEntry(id, KEY_08, eT8.getText().toString());
					
					
				}
	if(tv14.getText().toString().equals("FT 2")){
		int id =2;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
			
			
		}
	if(tv14.getText().toString().equals("FT 3")){
		int id =3;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
		
	}
	if(tv14.getText().toString().equals("FT 4")){
		int id =4;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
	}
	if(tv14.getText().toString().equals("FT 5")){
		int id =5;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
	}
	iv6.setTag("saved");
	iv6.setImageResource(R.drawable.savedbut);	
	 
		
	}
public void ft1(View v){
	iv6.setImageResource(R.drawable.savebut);
	iv6.setTag("save");	
	 ft = new FitTestInfoData(this);
	 ft.open();
	 if(tv14.getText().toString().equals("FT 1")){
			int id =1;
			ft.updateEntry(id, KEY_01, eT1.getText().toString());	
			ft.updateEntry(id, KEY_02, eT2.getText().toString());
			ft.updateEntry(id, KEY_03, eT3.getText().toString());
			ft.updateEntry(id, KEY_04, eT4.getText().toString());
			ft.updateEntry(id, KEY_05, eT5.getText().toString());	
			ft.updateEntry(id, KEY_06, eT6.getText().toString());
			ft.updateEntry(id, KEY_07, eT7.getText().toString());
			ft.updateEntry(id, KEY_08, eT8.getText().toString());
				
				
			}
if(tv14.getText().toString().equals("FT 2")){
	int id =2;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
		
	}
if(tv14.getText().toString().equals("FT 3")){
	int id =3;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	
}
if(tv14.getText().toString().equals("FT 4")){
	int id =4;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
if(tv14.getText().toString().equals("FT 5")){
	int id =5;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
	 ArrayList<String[]> values = ft.getData();
	 
	 
	 
	 
	 ft.close();
 if (values.size()>=1){
 eT1.setText(values.get(0)[0]);
	 eT2.setText(values.get(0)[1]);
	 eT3.setText(values.get(0)[2]);
	 eT4.setText(values.get(0)[3]);
	 eT5.setText(values.get(0)[4]);
	 eT6.setText(values.get(0)[5]);
	 eT7.setText(values.get(0)[6]);
	 eT8.setText(values.get(0)[7]);
	 
		 
	 }
 else{
	 eT1.setText(null);
	 eT2.setText(null);
	 eT3.setText(null);
	 eT4.setText(null);
	 eT5.setText(null);
	 eT6.setText(null);
	 eT7.setText(null);
	 eT8.setText(null);
	 
 }
	tv14.setText("FT 1");
	
	
}




@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	
	ft = new FitTestInfoData(this);
	 ft.open();
	if(tv14.getText().toString().equals("FT 1")){
		int id =1;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}
	if(tv14.getText().toString().equals("FT 2")){
		int id =2;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}

if(tv14.getText().toString().equals("FT 3")){
	int id =3;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	
}
if(tv14.getText().toString().equals("FT 4")){
	int id =4;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
if(tv14.getText().toString().equals("FT 5")){
	int id =5;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
	  
	 
	 
	 
	 
	 ft.close();
	
	
	
}

public void ft2(View v){
	iv6.setImageResource(R.drawable.savebut);
	iv6.setTag("save");	
	 ft = new FitTestInfoData(this);
	 ft.open();
	if(tv14.getText().toString().equals("FT 1")){
		int id =1;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}
	if(tv14.getText().toString().equals("FT 2")){
		int id =2;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}

if(tv14.getText().toString().equals("FT 3")){
	int id =3;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	
}
if(tv14.getText().toString().equals("FT 4")){
	int id =4;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
if(tv14.getText().toString().equals("FT 5")){
	int id =5;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
	 ArrayList<String[]> values = ft.getData();
	 
	 
	 
	 
	 ft.close();
 if (values.size()>=2){
	 eT1.setText(values.get(1)[0]);
	 eT2.setText(values.get(1)[1]);
	 eT3.setText(values.get(1)[2]);
	 eT4.setText(values.get(1)[3]);
	 eT5.setText(values.get(1)[4]);
	 eT6.setText(values.get(1)[5]);
	 eT7.setText(values.get(1)[6]);
	 eT8.setText(values.get(1)[7]);
	 
		 
	 }
 else{
	 eT1.setText(null);
	 eT2.setText(null);
	 eT3.setText(null);
	 eT4.setText(null);
	 eT5.setText(null);
	 eT6.setText(null);
	 eT7.setText(null);
	 eT8.setText(null);
	 
 }
	tv14.setText("FT 2");
	
}
public void ft3(View v){
	iv6.setImageResource(R.drawable.savebut);
	iv6.setTag("save");	
	 ft = new FitTestInfoData(this);
	 ft.open();
	if(tv14.getText().toString().equals("FT 1")){
		int id =1;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}
if(tv14.getText().toString().equals("FT 2")){
	int id =2;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
		
	}
if(tv14.getText().toString().equals("FT 3")){
	int id =3;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
		
	}
 
 
if(tv14.getText().toString().equals("FT 4")){
	int id =4;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
if(tv14.getText().toString().equals("FT 5")){
	int id =5;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
	 ArrayList<String[]> values = ft.getData();
	 
	 
	 
	 
	 ft.close();
 if (values.size()>=3){
	 eT1.setText(values.get(2)[0]);
	 eT2.setText(values.get(2)[1]);
	 eT3.setText(values.get(2)[2]);
	 eT4.setText(values.get(2)[3]);
	 eT5.setText(values.get(2)[4]);
	 eT6.setText(values.get(2)[5]);
	 eT7.setText(values.get(2)[6]);
	 eT8.setText(values.get(2)[7]);
	 
		 
	 }
 else{
	 eT1.setText(null);
	 eT2.setText(null);
	 eT3.setText(null);
	 eT4.setText(null);
	 eT5.setText(null);
	 eT6.setText(null);
	 eT7.setText(null);
	 eT8.setText(null);
	 
 }
	tv14.setText("FT 3");
	
	
}
public void ft4(View v){
	iv6.setImageResource(R.drawable.savebut);
	iv6.setTag("save");	
	
	 ft = new FitTestInfoData(this);
	 ft.open();
	if(tv14.getText().toString().equals("FT 1")){
		int id =1;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}
if(tv14.getText().toString().equals("FT 2")){
	int id =2;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
		
	}
if(tv14.getText().toString().equals("FT 3")){
	int id =3;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	
}
if(tv14.getText().toString().equals("FT 4")){
	int id =4;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	
}

if(tv14.getText().toString().equals("FT 5")){
	int id =5;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}
	 ArrayList<String[]> values = ft.getData();
	 
	 
	 
	 
	 ft.close();
 if (values.size()>=4){
	 eT1.setText(values.get(3)[0]);
	 eT2.setText(values.get(3)[1]);
	 eT3.setText(values.get(3)[2]);
	 eT4.setText(values.get(3)[3]);
	 eT5.setText(values.get(3)[4]);
	 eT6.setText(values.get(3)[5]);
	 eT7.setText(values.get(3)[6]);
	 eT8.setText(values.get(3)[7]);
	 
		 
	 }
 else{
	 eT1.setText(null);
	 eT2.setText(null);
	 eT3.setText(null);
	 eT4.setText(null);
	 eT5.setText(null);
	 eT6.setText(null);
	 eT7.setText(null);
	 eT8.setText(null);
	 
 }
	tv14.setText("FT 4");
	
	
}
public void ft5(View v){
	iv6.setImageResource(R.drawable.savebut);
	iv6.setTag("save");	
	 ft = new FitTestInfoData(this);
	 ft.open();
	if(tv14.getText().toString().equals("FT 1")){
		int id =1;
		ft.updateEntry(id, KEY_01, eT1.getText().toString());	
		ft.updateEntry(id, KEY_02, eT2.getText().toString());
		ft.updateEntry(id, KEY_03, eT3.getText().toString());
		ft.updateEntry(id, KEY_04, eT4.getText().toString());
		ft.updateEntry(id, KEY_05, eT5.getText().toString());	
		ft.updateEntry(id, KEY_06, eT6.getText().toString());
		ft.updateEntry(id, KEY_07, eT7.getText().toString());
		ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	 
	
		
	}
if(tv14.getText().toString().equals("FT 2")){
	int id =2;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
		
		
	}
if(tv14.getText().toString().equals("FT 3")){
	int id =3;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
	
}
if(tv14.getText().toString().equals("FT 4")){
	int id =4;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
} if(tv14.getText().toString().equals("FT 5")){
	int id =5;
	ft.updateEntry(id, KEY_01, eT1.getText().toString());	
	ft.updateEntry(id, KEY_02, eT2.getText().toString());
	ft.updateEntry(id, KEY_03, eT3.getText().toString());
	ft.updateEntry(id, KEY_04, eT4.getText().toString());
	ft.updateEntry(id, KEY_05, eT5.getText().toString());	
	ft.updateEntry(id, KEY_06, eT6.getText().toString());
	ft.updateEntry(id, KEY_07, eT7.getText().toString());
	ft.updateEntry(id, KEY_08, eT8.getText().toString());
	
}

	 ArrayList<String[]> values = ft.getData();
	 
	 
	 
	 
	 ft.close();
 if (values.size()>=5){
	 eT1.setText(values.get(4)[0]);
	 eT2.setText(values.get(4)[1]);
	 eT3.setText(values.get(4)[2]);
	 eT4.setText(values.get(4)[3]);
	 eT5.setText(values.get(4)[4]);
	 eT6.setText(values.get(4)[5]);
	 eT7.setText(values.get(4)[6]);
	 eT8.setText(values.get(4)[7]);
	 
		 
	 }
 else{
	 eT1.setText(null);
	 eT2.setText(null);
	 eT3.setText(null);
	 eT4.setText(null);
	 eT5.setText(null);
	 eT6.setText(null);
	 eT7.setText(null);
	 eT8.setText(null);
	 
 }
	tv14.setText("FT 5");
	
	
	
	
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	//MenuInflater inflater = getMenuInflater();
    //inflater.inflate(R.menu.menu, menu);
    menu.add(0, 1, 0, "WORKOUT LIST");
    menu.add(0, 2, 0, "PICTURES");
    
    menu.add(0, 3, 0, "STATUS");
    menu.add(0, 4, 0, "REMINDER");
    menu.add(0, 5, 0, "MY GOAL");
   
    return true;
}	

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case 1:   
        	Intent i= new Intent(PreviousFitTest.this,WorkoutList.class);
        	startActivity(i); 
        break;
       
        case 2:     
        	Intent i2= new Intent(PreviousFitTest.this,Pictures.class);
        	startActivity(i2);                   
        break;
        
       
        case 3: 
        	Intent i3= new Intent(PreviousFitTest.this,Status.class);
        	startActivity(i3);  
	        break;
        case 4: 
        	Intent i4= new Intent(PreviousFitTest.this,Reminder.class);
        	startActivity(i4);  
	        break;
        case 5: 
        	Intent i5= new Intent(PreviousFitTest.this,Goal.class);
        	startActivity(i5);  
	        break;
	        
        
    }
    return true;
}


}
