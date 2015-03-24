package com.example.vf.vfslidepuzzle;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.GridView;

public class GameActivity extends ActionBarActivity {

    public static final String SavedData = "SavedData" ;
    private SharedPreferences preferences;
    private EditText textField;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        preferences = getSharedPreferences(SavedData, Context.MODE_PRIVATE);
        grid = (GridView) findViewById(R.id.game_grid);
        grid.setAdapter(new BrickAdapter(this));

        textField = (EditText)findViewById(R.id.testText);

        // If shared preference set, load to textField
        if(preferences.getString("savedText", null) != null){
            textField.setText(preferences.getString("savedText", null));
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

    @Override
    public void onPause() {
        super.onPause();

        preferences.edit().putString("savedText", this.textField.getText().toString()).commit();

    }
}
