package works.examples.Syllabus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Setting extends Activity{
	
	Spinner sp1,sp2,sp3;
	SharedPreferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		sp1=(Spinner)findViewById(R.id.settingSpinner1);
		sp2=(Spinner)findViewById(R.id.settingSpinner2);
		sp3=(Spinner)findViewById(R.id.settingSpinner3);
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
		
	}
	
	public void save(View v)
	{
		 SharedPreferences.Editor editor=pref.edit();
	        
	        editor.putString("branch",(String) sp1.getSelectedItem());
	        editor.putString("year",(String) sp2.getSelectedItem());
	        editor.putString("sem",(String) sp3.getSelectedItem());
	        editor.commit();//to save data permanent
	        this.finish();
	}
	
	public void back(View v)
	{
		this.finish();
	}

}
