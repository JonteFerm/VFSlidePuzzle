package com.example.vf.vfslidepuzzle;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Jonathan on 2015-03-24.
 */
public class BrickAdapter extends BaseAdapter {
    private SharedPreferences preferences;
    private Context context;
    private ArrayList<BrickView> bricks = new ArrayList<BrickView>();

    public BrickAdapter(Context context) {
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void save() {
        //Saves the state of the bricks arraylist
    }
    public void load(){
        //Loads the saved bricks arraylist
    }

    public void move(int fromPos, int toPos){
        //Move a brick from position to another
    }

    public boolean checkMove(int pos){
        //Check if a move is possible for the brick at the specified position
        return false;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
