package com.example.vf.vfslidepuzzle;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jonathan on 2015-03-24.
 */
public class BrickAdapter extends BaseAdapter {
    private SharedPreferences preferences;
    private Context context;
    private ArrayList<Integer> brickOrder = new ArrayList<Integer>();
    private LayoutInflater inflater;

    public BrickAdapter(Context context) {
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);

        init();
    }

    public void init(){
        for(int i=0; i<15; i++){
            brickOrder.add(i+1);
        }

        Collections.shuffle(brickOrder);
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
        return brickOrder.size();
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
        BrickView brickView;

        if(convertView == null){
            brickView = new BrickView(context);
            brickView.setLayoutParams(new GridView.LayoutParams(250,250));
        }else{
            brickView = (BrickView)convertView;
        }

        brickView.setId(brickOrder.get(position));

        return brickView;
    }
}
