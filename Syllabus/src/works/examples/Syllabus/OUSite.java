package works.examples.Syllabus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class OUSite  extends Activity{
	
	
	WebView wv;
	ProgressDialog pd;
	
	@SuppressLint("SetJavaScriptEnabled")
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.site );
        
        pd=new ProgressDialog(this);
        pd.setMessage("Loading page");
        

		wv=(WebView)findViewById(R.id.sitewebView1);		
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new myWebClient());
        wv.loadUrl("http://www.osmania.ac.in/");

    }
	
	
	public class myWebClient extends WebViewClient
	    {
	     @Override
	     public void onPageStarted(WebView view, String url, Bitmap favicon) {
	    	 pd.show();
	      super.onPageStarted(view, url, favicon);
	     }

	     @Override
	 	public void onLoadResource(WebView view, String url) {
	 		// TODO Auto-generated method stub
	 		//view.clearHistory();
	 		super.onLoadResource(view, url);
	 	}

	     @Override
	     public void onPageFinished(WebView view, String url) {
	      super.onPageFinished(view, url);
	      pd.dismiss();
	     }

	    }

	
	
	
	public void front(View v)
	{
		if(wv.canGoForward())
			wv.goForward();
		else {
			Toast.makeText(this,"Last page",100).show();
		}
	}
	
	public void back(View v)
	{
		if(wv.canGoBack())
			wv.goBack();
		else {
			Toast.makeText(this,"First page",100).show();
		}
	}

}
