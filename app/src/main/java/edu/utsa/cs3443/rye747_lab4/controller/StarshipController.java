package edu.utsa.cs3443.rye747_lab4.controller;

import android.content.res.AssetManager;
import android.view.View;

import java.io.IOException;

import edu.utsa.cs3443.rye747_lab4.StarshipActivity;
import edu.utsa.cs3443.rye747_lab4.model.Fleet;

public class StarshipController implements View.OnClickListener{
    private StarshipActivity activity;
    private AssetManager manager;
    private Fleet fleet;

    public StarshipController(StarshipActivity activity){
        this.activity = activity;
        this.manager = this.activity.getAssets();
        Fleet fleet = new Fleet("United Federation of Planets");

        try {
            fleet.loadStarships(manager);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onClick(View view) {

    }
}
