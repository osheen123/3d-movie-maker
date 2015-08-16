package com.osheen.crosseye;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Play extends Activity {
	VideoView mVideoView;
	TextView lll,rrr;
	VideoView mVideoView1;
	String left,right;
	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		Bundle bundle = getIntent().getExtras();
		try
		   { 
			 left = bundle.getString("left");// recieve path for left view 
             right=bundle.getString("right");// ----------------right view
            } catch(Exception e){/*nothing here*/}
		
		
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

	      
	    mVideoView  = (VideoView)findViewById(R.id.lu);//lu is left uni-view(left side of screen)
	    mVideoView1=  (VideoView)findViewById(R.id.ru);//ru is right uni-view
	   lll=(TextView)findViewById(R.id.lll); 
	   rrr=(TextView)findViewById(R.id.rrr); 
	    /*media controller is the seek-bar that is used to scroll the video*/
	    MediaController a = new MediaController(this);
	    MediaController b = new MediaController(this);   
	    
	   try{   
		   mVideoView1.setMediaController(a);
	       mVideoView.setMediaController(b);
	       mVideoView1.setVideoPath(right);
	       mVideoView.setVideoPath(left);
	       
	       }  // in case user don't select any file and directly hit play
	        catch(Exception e)
	                 {
	        			AlertDialog.Builder ba;
	        			ba=new AlertDialog.Builder(Play.this);
	        			ba.setMessage("GO BACK AND SELECT A FILE !").setTitle("Set path").
	        			setPositiveButton("OK", new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface arg0, int arg1) 
					           {
						         // TODO Auto-generated method stub
						         //goto main
						           
								  
						         
					            }});
			 	        ba.create().show();
	                 }
	   
	  /* final Thread t1 = new Thread(){
	       public void run(){
	           
				//gate.await();
	           
	           //do stuff    
	       }};*/
	   final Thread t = new Thread(){
	       public void run(){
	         
			//	gate.await();
	    	   mVideoView1.start();
	           mVideoView.start();
	           //do stuff    
	       }};


	   // At this point, t1 and t2 are blocking on the gate. 
	   // Since we gave "3" as the argument, gate is not opened yet.
	   // Now if we block on the gate from the main thread, it will open
	   // and all threads will start to do stuff!

	   new CountDownTimer(11000, 1000) {//CountDownTimer(edittext1.getText()+edittext2.getText()) also parse it to long

		   public void onTick(long millisUntilFinished) {
		       lll.setText( "" + millisUntilFinished / 1000);
		       rrr.setText("" + millisUntilFinished / 1000);
		       //here you can have your logic to set text to edittext
		   }

		   public void onFinish() {
			   lll.setText( ""); rrr.setText( "");
		       //mTextField.setText("done!");
			   
			   t.start();
			   
			  
			  
		   }
		  }
		  .start();
	   
	   
	   
	   

		   
	
	  
	       	  
	}

	
}
