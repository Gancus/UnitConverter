package com.example.unitconverter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MassActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mass);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//setSpinner((Spinner) findViewById(R.id.mass_spinner1));
		//setSpinner((Spinner) findViewById(R.id.mass_spinner2));
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
	
	public void setSpinner(Spinner spinner){
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.mass_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
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
		Spinner spinner1 = (Spinner) findViewById(R.id.mass_spinner1);
		Spinner spinner2 = (Spinner) findViewById(R.id.mass_spinner2);
		int s1 = spinner1.getSelectedItemPosition();
		int s2 = spinner2.getSelectedItemPosition();
		EditText editText = (EditText)findViewById(R.id.EditText2);
		Mass mass = new Mass();
		double value;
		try{
			value = Double.parseDouble(editText.getText().toString());
		} catch (Exception e) {
			Toast toast = Toast.makeText(this, "Enter correct value", Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
		double after = 0;
		if (s1 == 0) 
			mass.setGrams(value);
		else if(s1 == 1)
			mass.setKilograms(value);
		else if(s1 == 2)
			mass.setTonnes(value);
		else if(s1 == 3)
			mass.setOunces(value);
		else if(s1 == 4)
			mass.setPounds(value);
		else if(s1 == 5)
			mass.setCarats(value);
		
		if (s2 == 0) 
			after = mass.getGrams();
		else if(s2 == 1)
			after = mass.getKilograms();
		else if(s2 == 2)
			after = mass.getTonnes();
		else if(s2 == 3)
			after = mass.getOunces();
		else if(s2 == 4)
			after = mass.getPounds();
		else if(s2 == 5)
			after = mass.getCarats();
		
		String result = "" + value + " " + spinner1.getSelectedItem() + 
				" = " + after + " " + spinner2.getSelectedItem(); 
		TextView txt = (TextView) findViewById(R.id.textMass);
		txt.setText(result);
	}

}
