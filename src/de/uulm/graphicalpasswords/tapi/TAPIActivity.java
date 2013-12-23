/*******************************************************************************
 * Copyright 2013 Marcel Walch, Florian Schaub
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.uulm.graphicalpasswords.tapi;

import java.util.Arrays;
import java.util.Random;

import de.uulm.graphicalpasswords.R;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class TAPIActivity extends Activity {

	protected static final int[] IMAGES = { R.drawable.tapibasket,
			R.drawable.tapiblume, R.drawable.tapiespresso, R.drawable.tapieule,
			R.drawable.tapiflipflops, R.drawable.tapichick,
			R.drawable.tapikatze, R.drawable.tapikirschen,
			R.drawable.tapimotorrad, R.drawable.tapimuell,
			R.drawable.tapisnail, R.drawable.tapipilz, R.drawable.tapipizza,
			R.drawable.tapischinken, R.drawable.tapicube,
			R.drawable.tapiwerkzeug };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tapi);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Button login = (Button) findViewById(R.id.btn_login);
		SharedPreferences sharedPref = PreferenceManager
				.getDefaultSharedPreferences(this);
		if (sharedPref.getString("tapi_pw", "").equals(""))
			login.setEnabled(false);
		else
			login.setEnabled(true);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tapi, menu);
		return true;
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
		case R.id.action_settings:
			Intent intent = new Intent(this,
					de.uulm.graphicalpasswords.tapi.TAPISettingsActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	public void startCreatePassword(View view) {
		Intent intent = new Intent(
				this,
				de.uulm.graphicalpasswords.tapi.TAPICreatePasswordActivity.class);
		startActivity(intent);
	}

	public void startEnterPassword(View view) {
		Intent intent = new Intent(this,
				de.uulm.graphicalpasswords.tapi.TAPILoginActivity.class);
		startActivity(intent);
	}

}
