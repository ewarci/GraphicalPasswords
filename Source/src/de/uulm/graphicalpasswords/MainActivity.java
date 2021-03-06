/*******************************************************************************
 * Copyright 2013 Marcel Walch, Florian Schaub
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.uulm.graphicalpasswords;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startMIBA(View view) {
		Intent intent = new Intent(this,
				de.uulm.graphicalpasswords.openmiba.MIBAActivity.class);
		startActivity(intent);
	}
	
	public void startPassGo(View view) {
		Intent intent = new Intent(this,
				de.uulm.graphicalpasswords.openpassgo.PassGoActivity.class);
		startActivity(intent);
	}

	public void startTAPI(View view) {
		Intent intent = new Intent(this,
				de.uulm.graphicalpasswords.opentapi.TAPIActivity.class);
		startActivity(intent);
	}
	
	public void startUYI(View view) {
		Intent intent = new Intent(this,
				de.uulm.graphicalpasswords.openuyi.UYIActivity.class);
		startActivity(intent);
	}

}
