package com.example.unitconverter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends Activity {

	private int fromSelector;
	private int toSelector;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temperature);
		// Show the Up button in the action bar.
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		//Intent intent = getIntent();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	

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
	
	public void fromSelect(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		
		switch(view.getId()) {
		case R.id.cels0:
			if(checked)
				fromSelector = 0;
			break;
		case R.id.fahr0:
			if(checked)
				fromSelector = 1;
			break;
		case R.id.kelv0:
			if(checked)
				fromSelector = 2;
			break;
		}
	}
	
	public void toSelect(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		
		switch(view.getId()) {
		case R.id.cels1:
			if(checked)
				toSelector = 0;
			break;
		case R.id.fahr1:
			if(checked)
				toSelector = 1;
			break;
		case R.id.kelv1:
			if(checked)
				toSelector = 2;
			break;
		}
	}
	
	public void setResultText(String result) {
		TextView results = (TextView) findViewById(R.id.resultText);
		results.setText(result);
	}
	
	public void convert(View view) {
		Temperature temp = new Temperature();
		EditText editText = (EditText) findViewById(R.id.editText1);
		String text = editText.getText().toString();
		float t;
		try{
			t = Float.parseFloat(editText.getText().toString());
		} catch (Exception e) {
			Toast toast = Toast.makeText(this, "Enter correct value", Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
		String result = "Result: " + Float.toString(t);
		switch(fromSelector) {
		case 0:
			temp.setCels(t);
			result += " C = ";
			break;
		case 1:
			temp.setFahr(t);
			result += " F = ";
			break;
		case 2:
			temp.setKelv(t);
			result += " K = ";
			break;
		}
		
		switch(toSelector) {
		case 0:
			result += Float.toString(temp.getCels()) + " C";
			break;
		case 1:
			result += Float.toString(temp.getFahr()) + " F";
			break;
		case 2:
			result += Float.toString(temp.getKelv()) + " K";
			break;
		}
		if(temp.getKelv()<0.0f)
			result = "Error: Temperature have to higher or equal absolute zero\nAbsolute zero = 0K, -273.15C and −459.67F";
		setResultText(result);
	}

}
