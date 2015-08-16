package com.osheen.crosseye;



import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FileSelect extends Activity {

	String l,r;
	int a,fl,fr;
	Button b,bl,br;
	public String l1;
	public String r1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_select);
		
		fl=fr=0;//we use 2 flag fl(left) and fr(right)
		b=(Button) findViewById(R.id.bu);//bu is the save button
		bl=(Button) findViewById(R.id.butt1);//butt1 is for left
		br=(Button) findViewById(R.id.butt2);//butt2 is for right
		
		
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				try{
					 l1=l; 
					 r1=r;
					}catch(Exception e)
					                     {Toast.makeText(FileSelect.this, "ERROR", Toast.LENGTH_SHORT).show();}
				Intent intent = new Intent(FileSelect.this, MainActivity.class);
				intent.putExtra("left", l1);
				intent.putExtra("right", r1);
				startActivity(intent);
			
			}
		});
		
		
		
		bl.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				 Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
			        fileintent.setType("*/.mp4");
			        try 
			        {   fl=1;
			            startActivityForResult(fileintent, a);
			        }
			        catch (ActivityNotFoundException e) 
			        {
			            Log.e("tag", "No activity can handle picking a file. Showing alternatives.");
			        }
			}
		});
		
		
		
		
		br.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				 Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
			        fileintent.setType("*/.mp4");
			        try 
			        {   fr=1;
			            startActivityForResult(fileintent, a);
			        }
			        catch (ActivityNotFoundException e) 
			        {
			            Log.e("tag", "No activity can handle picking a file. Showing alternatives.");
			        }
			}
		});
	   
	
	}

	   protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	    {
	        // TODO Fix no activity available
	        if (data == null)
	            return;
	       
	        
	            if (resultCode == RESULT_OK) 
	            {
	                if(fl==1)
	                	{
	                	l = data.getData().getPath();
	                	fl=0;
	                	}
	                if(fr==1)
                	{
                	r = data.getData().getPath();
                	fr=0;
                	}
	               //FilePath is your file as a string
	            }
	        
	    
	    
	    }

}
