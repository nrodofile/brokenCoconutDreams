package com.example.asic_small_busnesss;

import java.util.ArrayList;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification.Action;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class OverviewActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overview);
		
		setTitle("Overview");
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		final ListView listview = (ListView) findViewById(R.id.overview_list_view);

		String[] values = new String[] { "What is a 'small business'?",
				"Why small business is importaint to ASIC", 
				"Complience for a Small Business",
				"Why complying with law is important" };
/*
		final Class<?>[] activities = new Class<?>[] { OverviewActivity.class,
				StartingActivity.class, ComplianceActivity.class,
				ClosingActivity.class, ResorucesActivity.class,
				HotTopicsActivity.class, FAQsActivity.class,
				EnewsActivity.class };
*/
		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);
		}
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// final String item = (String)
				// parent.getItemAtPosition(position);
				view.animate().setDuration(500);
//				Intent intent = new Intent(getApplicationContext(),activities[position]);
//				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.overview, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem menuItem)
    {       
        onBackPressed();
        return true;
    }

}
