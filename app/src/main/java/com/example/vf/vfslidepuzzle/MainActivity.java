package com.example.vf.vfslidepuzzle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View continueButton = findViewById(R.id.continueGame);
        if(savedInstanceState == null){
            continueButton.setEnabled(false);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    // Clears shared prefs of the GameActivity and enables the continuebutton for resuming
    public void newGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        View continueButton = findViewById(R.id.continueGame);

        try{
            preferences = getSharedPreferences(GameActivity.SavedData, Context.MODE_PRIVATE);
            preferences.edit().clear().commit();
        }catch (Exception e){
            Log.e("MainActivity","Shared preferences hittades inte");
        }

        startActivity(intent);
        continueButton.setEnabled(true);
    }

    // Resumes the game with saved shared preferences
    public void continueGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
