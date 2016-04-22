package works.examples.Syllabus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;

public class Credits extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credits);
		
		final View l = findViewById(R.id.creditstv1);

        Animation a = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        a.setDuration(5000);
        a.setAnimationListener(new AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

            public void onAnimationRepeat(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

            public void onAnimationStart(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

        });
        l.startAnimation(a);
        
        final View ll = findViewById(R.id.credittv2);

        Animation aa = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        aa.setDuration(5000);
        aa.setAnimationListener(new AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

            public void onAnimationRepeat(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

            public void onAnimationStart(Animation animation) {
                    // Do what ever you need, if not remove it.  
            }

        });
        ll.startAnimation(aa);
		
	}

}
