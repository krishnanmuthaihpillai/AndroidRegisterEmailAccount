package com.example.androidregisteremailaccount;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class EmailList extends Activity {
	ListView listView ;
	String Emailaccounts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_list);
		listView = (ListView) findViewById(R.id.list);
		
		  Intent i = getIntent();
		  Emailaccounts = i.getStringExtra("email");
		
		String[] values =Emailaccounts.split("\n");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		  android.R.layout.simple_list_item_1, android.R.id.text1, values);


		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
				
		       // ListView Clicked item index
			   int itemPosition     = position;
			   
			   // ListView Clicked item value
			   String  itemValue    = (String) listView.getItemAtPosition(position);
				  
			   
			   
			   AlertDialog.Builder builder = new AlertDialog.Builder(EmailList.this);
		        builder.setTitle("Make your selection");
		        builder.setMessage("You have selected  "+itemValue+" account");
		        builder.setNegativeButton("OK", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
							      "ok", Toast.LENGTH_LONG)
							      .show();
					}
				});
              builder.setPositiveButton("cancel", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
							      "cancel", Toast.LENGTH_LONG)
							      .show();
					}
				});
              builder.show();
			    // Show Alert 
//			    Toast.makeText(getApplicationContext(),
//			      "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//			      .show();
			 
			  }

			
			}); 
	}

}
