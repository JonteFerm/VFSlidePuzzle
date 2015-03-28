package com.example.vf.vfslidepuzzle;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class GameActivity extends ActionBarActivity {

    public static String SavedData;
    private SharedPreferences preferences;
    private GridView grid;
    private BrickAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        SavedData = "hah";
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        adapter = new BrickAdapter((this));
        grid = (GridView) findViewById(R.id.game_grid);
        grid.setAdapter(adapter);

        // If shared preference set, load in BrickAdapter
        if (preferences.getString("savedData", null) != null) {
            adapter.load();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Save game progress in the BrickAdapter
    @Override
    public void onPause() {
        super.onPause();

        adapter.save();

    }
}