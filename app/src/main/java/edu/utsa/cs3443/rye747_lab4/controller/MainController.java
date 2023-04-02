package edu.utsa.cs3443.rye747_lab4.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

import java.io.IOException;

import edu.utsa.cs3443.rye747_lab4.MainActivity;
import edu.utsa.cs3443.rye747_lab4.R;
import edu.utsa.cs3443.rye747_lab4.StarshipActivity;
import edu.utsa.cs3443.rye747_lab4.model.Fleet;

public class MainController implements View.OnClickListener{
    private MainActivity activity;
    private Fleet fleet;
    private AssetManager manager;
    public MainController(MainActivity activity){
        this.activity = activity;
        this.manager =this.activity.getAssets();
        Fleet fleet = new Fleet("United Federation of Planets");
        try {
            fleet.loadStarships(manager);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, StarshipActivity.class);
        activity.startActivity(intent);
        if(view.getId() == R.id.voyager){

        }
        else if(view.getId() == R.id.enterprise1){

        }
        else if(view.getId() == R.id.enterprise2){

        }
    }
}
