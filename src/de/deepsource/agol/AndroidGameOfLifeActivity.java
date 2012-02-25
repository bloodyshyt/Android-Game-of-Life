package de.deepsource.agol;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import de.deepsource.agol.rules.Conway;

/**
 * @author Sebastian Ullrich
 * 
 * Seriously, No one cares about activities!
 */
public class AndroidGameOfLifeActivity extends Activity {

	private AndroidGameOfLifeView agolView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		agolView = new AndroidGameOfLifeView(this);
		agolView.setBackgroundColor(Color.BLACK);
		setContentView(agolView);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			agolView.lock();
			agolView.runLoop(new Conway());
			break;

		case R.id.item2:
			agolView.unlock();
			break;
			
		case R.id.item3:
			agolView.initMap();
			break;
		}
		return true;
	}
}