package com.example.asic_small_busnesss;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OverviewContentActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		String title = intent.getStringExtra(OverviewActivity.EXTRA_TITLE);
	    int resid = intent.getIntExtra(OverviewActivity.EXTRA_SELECTION, R.string.app_error);
		
		setContentView(R.layout.activity_overview_content);
		
		setTitle("Overview");		
		updateTextView(title, R.id.overviewTitle, false);
		updateTextView(getResources().getString(resid), R.id.overviewContent, true);
		
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.overview_content, menu);
		return true;
	}

	public void updateTextView(String string, int resid, Boolean html) {
		TextView textView = (TextView) findViewById(resid);
		if(html){
			textView.setText(Html.fromHtml(string));
		}
		textView.setText(string);
	}
	
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		onBackPressed();
		return true;
	}
}
