package com.example.androidregisteremailaccount;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
//TextView registeraccount;
String str="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		registeraccount=(TextView)findViewById(R.id.textView1);

		   try{
			       Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");
			       for (Account account : accounts) {
			    	str +=account.name+" \n"; 
			       }
			  }
		      catch(Exception e)
		      {
		    	   Log.i("Exception", "Exception:"+e) ; 
		      }
	
		   try{

			       Account[] accounts = AccountManager.get(this).getAccounts();
			       for (Account account : accounts) {
			         
			    	  str += account.name+" \n";
		       }
			  }
		      catch(Exception e)
		      {
		    	   Log.i("Exception", "Exception:"+e) ; 
		      }
		      
		   String possibleEmail=str;
		   
		   // Show on screen    
//		      registeraccount.setText(possibleEmail);
	       Log.i("Exception", "mails:"+possibleEmail) ;
	       Intent i=new Intent(MainActivity.this,EmailList.class);
	       i.putExtra("email",possibleEmail );
			startActivity(i);
//			MainActivity.this.finish();
	}
}