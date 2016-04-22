package works.examples.Syllabus;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	Spinner sp1,sp2,sp3;
	WebView wv;
	Button b,f;
	String URL,url;
	SharedPreferences pref;
	int i=0,set=1;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		final View l = findViewById(R.id.main);

        Animation a = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        a.setDuration(4000);
        a.setAnimationListener(new AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                    // Do what ever you need, if not remove it.  
            	l.setVisibility(View.GONE);
            }

            public void onAnimationRepeat(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

            public void onAnimationStart(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

        });
        l.startAnimation(a);
		
		
		
		URL="file:///android_asset/syll/"; 
		sp1=(Spinner)findViewById(R.id.mainspinnerbranch);
		sp2=(Spinner)findViewById(R.id.mainspinneryear);
		sp3=(Spinner)findViewById(R.id.mainspinnersem);
		pref=getSharedPreferences("mypref",MODE_APPEND);
		
		String branch= pref.getString("branch","puss");
    	String year  = pref.getString("year","puss");
    	String sem   = pref.getString("sem","puss");
    	if(!branch.equals("puss"))
    	{
    		ArrayAdapter<String> adb=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.branch));
    		ArrayAdapter<String> ady=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.year));
    		ArrayAdapter<String> ads=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.sem));
    	sp1.setSelection(adb.getPosition(branch));
    	sp2.setSelection(ady.getPosition(year));
    	sp3.setSelection(ads.getPosition(sem));
    	}
		f=(Button)findViewById(R.id.frontbutton1);
		b=(Button)findViewById(R.id.backbutton2);
		wv=(WebView)findViewById(R.id.mainwebView);
		wv.setWebViewClient(new ourViewClient());
		
    	
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				settingFun();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				settingFun();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				settingFun();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	

	private void settingFun() {
		// TODO Auto-generated method stub
		url=(String)sp1.getSelectedItem().toString().toLowerCase()+"/"+returnNum(sp2.getSelectedItem())+"/"+sp3.getSelectedItem()+"/txt.html";
		Log.v("data",url);
		wv.loadUrl(URL+url);
		Log.v("data",""+wv.canGoBack());
		Thread myThread = new Thread(new Runnable(){
		    @Override
		    public void run()
		    {
		    	try{
		        Thread.sleep(500);
				wv.clearHistory();
		    	}
		    	catch(Exception e){
		    		
		    	}
		    }
		});

		myThread.start();
	}

	private String returnNum(Object selectedItem) {
		// TODO Auto-generated method stub
		if(selectedItem.equals("I"))
		{
			return "1";
		}
		else if (selectedItem.equals("II")) {
			return "2";
		}
		else if (selectedItem.equals("III")) {
			return "3";
		}
		else {
			return "4";
		}
	}


	public void onBackPressed (){
		finish();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		wv.clearCache(true);
		this.deleteDatabase("webview.db");
		this.deleteDatabase("webviewCache.db");
	}
	
	public void front(View v)
	{
		if(wv.canGoForward())
			wv.goForward();
	}
	
	public void back(View v)
	{
		if(wv.canGoBack())
		wv.goBack();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add("Settings");
		//menu.add("News");
		menu.add("Credits");
		
		
		return super.onCreateOptionsMenu(menu);
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getTitle().toString().equals("News"))
		{
			Intent i=new Intent(this,OUSite.class);
			startActivity(i);

		}
		else if (item.getTitle().toString().equals("Settings")) {
			Intent i=new Intent(this,Setting.class);
			startActivity(i);
		}
		
		else if(item.getTitle().toString().equals("Credits"))
		{
		Intent i=new Intent(this,Credits.class);
		startActivity(i);
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	public void settings(View v){
		openOptionsMenu();
	}

}
