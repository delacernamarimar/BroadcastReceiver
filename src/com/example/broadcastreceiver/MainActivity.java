package com.example.broadcastreceiver;

import android.support.v7.app.ActionBarActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
	
	private BroadcastReceiver receiver = new BroadcastReceiver(){
		@Override
		public void onReceive(Context context, Intent intent){
			Toast.makeText(getBaseContext(), "Ticking", Toast.LENGTH_LONG).show();
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.registerReceiver(receiver, filter);
		
	}
	@Override
	protected void onResume(){
		this.registerReceiver(receiver, filter);
		super.onResume();
	}
	@Override
	protected void onPause(){
		this.unregisterReceiver(receiver);
		super.onPause();
	}
	

}
