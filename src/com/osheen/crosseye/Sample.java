package com.osheen.crosseye;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;

public class Sample extends Activity {
	
	VideoView v;
	MediaController m;
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
		v=(VideoView) findViewById(R.id.vv);
		m=new MediaController(this);
		v.setMediaController(m);
		String path="android.resource://com.osheen.crosseye/"+R.raw.rcoaster;
	    v.setVideoPath(path);
	    /*this code hides soft keys and status bar*/
		View decorView = getWindow().getDecorView();
	    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	    decorView.setSystemUiVisibility(uiOptions);
	    ActionBar actionBar = getActionBar();
	    actionBar.hide();
        View vvv = getWindow().getDecorView();
	    int uuu = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
	    vvv.setSystemUiVisibility(uuu);
	    /*now the navigation bar and status bar is hidden*/
	    
	    //we change the orientation to landscape for better viewing
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	    v.start();
	}



}
