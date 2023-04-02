package edu.utsa.cs3443.rye747_lab4.controller;

import android.view.View;

import edu.utsa.cs3443.rye747_lab4.MainActivity;
import edu.utsa.cs3443.rye747_lab4.R;
import edu.utsa.cs3443.rye747_lab4.model.Fleet;

public class MainController implements View.OnClickListener{
    private MainActivity activity;
    private Fleet fleet;

    public MainController(MainActivity activity){
        this.activity = activity;
    }
    @Override
    public void onClick(View view) {
        Fleet fleet = new Fleet("newFleet");

        if(view.getId() == R.id.voyager){
        }
    }
}
