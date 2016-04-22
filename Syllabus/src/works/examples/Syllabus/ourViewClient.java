package works.examples.Syllabus;


import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourViewClient extends WebViewClient {
	
	@Override
	public void onLoadResource(WebView view, String url) {
		// TODO Auto-generated method stub
		//view.clearHistory();
		super.onLoadResource(view, url);
	}

	

}
