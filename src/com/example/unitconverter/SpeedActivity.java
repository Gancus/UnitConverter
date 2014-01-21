package com.example.unitconverter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpeedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speed);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void convert(View view) {
		Spinner spinner1 = (Spinner) findViewById(R.id.speedSpinner1);
		Spinner spinner2 = (Spinner) findViewById(R.id.speedSpinner2);
		int s1 = spinner1.getSelectedItemPosition();
		int s2 = spinner2.getSelectedItemPosition();
		EditText editText = (EditText)findViewById(R.id.EditSpeed);
		Speed speed = new Speed();
		double value;
		try{
			value = Double.parseDouble(editText.getText().toString());
		} catch (Exception e) {
			Toast toast = Toast.makeText(this, "Enter correct value", Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
		
		double after = 0;
		if(s1 == 0)
			speed.setKilometersPerHour(value);
		else if(s1 == 1)
			speed.setKilometersPerSecond(value);
		else if(s1 == 2)
			speed.setMetersPerHour(value);
		else if(s1 == 3)
			speed.setMetersPerSecond(value);
		else if(s1 == 4)
			speed.setMilesPerHour(value);
		else if(s1 == 5)
			speed.setFeetsPerSecond(value);
		else if(s1 == 6)
			speed.setKnots(value);
		else if(s1 == 7)
			speed.setMach(value);
		
		if(s2 == 0)
			after = speed.getKilometersPerHour();
		else if(s2 == 1)
			after = speed.getKilometersPerSecond();
		else if(s2 == 2)
			after = speed.getMetersPerHour();
		else if(s2 == 3)
			after = speed.getMetersPerSecond();
		else if(s2 == 4)
			after = speed.getMilesPerHour();
		else if(s2 == 5)
			after = speed.getFeetsPerSecond();
		else if(s2 == 6)
			after = speed.getKnots();
		else if(s2 == 7)
			after = speed.getMach();
		String result = "" + value + " " + spinner1.getSelectedItem() + 
				" = " + after + " " + spinner2.getSelectedItem(); 
		TextView txt = (TextView) findViewById(R.id.textSpeed);
		txt.setText(result);
			
	}
}
