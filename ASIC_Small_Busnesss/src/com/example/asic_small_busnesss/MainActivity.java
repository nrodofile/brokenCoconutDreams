package com.example.asic_small_busnesss;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Home");

		final ListView listview = (ListView) findViewById(R.id.home_list_view);

		String[] values = new String[] { "Overview",
				"Starting a Small Business", "Complience for a Small Business",
				"Closing a Small Business", "Small Business Resources",
				"Hot Topics", "Top 10 FAQ's For Small Businesses",
				"e-Newsletter For Small Businesses" };

		final Class<?>[] activities = new Class<?>[] { OverviewActivity.class,
				StartingActivity.class, ComplianceActivity.class,
				ClosingActivity.class, ResorucesActivity.class,
				HotTopicsActivity.class, FAQsActivity.class,
				EnewsActivity.class };

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
				Intent intent = new Intent(getApplicationContext(),
						activities[position]);
				startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_about:;
	        Intent intent = new Intent(getApplicationContext(),
					AboutActivity.class);
	        startActivity(intent);
	            return true;
	        default:
			return super.onOptionsItemSelected(item);
		}
	}
}
