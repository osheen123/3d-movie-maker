package com.osheen.crosseye;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button b1,b2,b3,b4,b5;
	TextView t;
	String left,right;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        Bundle bundle = getIntent().getExtras();
       
        try
        	{ left = bundle.getString("left");
        	  right=bundle.getString("right");
        	}
             catch(Exception e){}
      
       
        // b1 is used to play the video
        b1.setOnClickListener(new View.OnClickListener() 
       {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,Play.class);
				intent.putExtra("left", left);
				intent.putExtra("right", right);
				startActivity(intent);
				
			}
		}); 
   
        
       
       
       // b2 is used to select a file
       b2.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent i;
		    	i=new Intent(MainActivity.this,FileSelect.class);
		    	startActivity(i);
				
				
			}
		});
        
        
       
      //b3 is used to view the sample video 
       b3.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent i;
		    	i=new Intent(MainActivity.this,Sample.class);
		    	startActivity(i);
				
				
			}
		});
     
        
      // b4 is nothing but instructions on how to use this app 
       b4.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent( MainActivity.this,Howtouse.class);
				startActivity(intent);
				
			}
		});

        
       
       // b5 is the credits section..
       b5.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent( MainActivity.this,About.class);
				startActivity(intent);
				
			}
		});
            
   }

}
