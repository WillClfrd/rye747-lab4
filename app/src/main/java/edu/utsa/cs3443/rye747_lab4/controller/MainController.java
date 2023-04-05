package edu.utsa.cs3443.rye747_lab4.controller;

import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.rye747_lab4.MainActivity;
import edu.utsa.cs3443.rye747_lab4.R;
import edu.utsa.cs3443.rye747_lab4.StarshipActivity;

/**
 * This class represents MainController objects.
 * Each MainController object is instantiated with a MainActivity object.
 * MainController objects are responsible for implementing the OnClickListener for view elements declared in the MainActivity object that is used in the MainController constructor.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 4
 * Spring 2023
 */
public class MainController implements View.OnClickListener{
    private MainActivity activity;
    private String key = "ship_registry";

    /**
     * The MainController constructor creates a new MainController object and initializes the activity and manager attributes
     *
     * @param activity the MainActivity object used to initialize the activity attribute of the MainController
     */
    public MainController(MainActivity activity){
        this.activity = activity;
    }

    /**
     * The MainController onClick method handles click events for the view parameter from the activity attribute and directs the flow of the program according to which button was clicked.
     *
     * @param view the View object that is passed as a parameter from the click event
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, StarshipActivity.class);
        if(view.getId() == R.id.NCC1701A){
            intent.putExtra(key, "NCC-1701-A");
            activity.startActivity(intent);
        }
        else if(view.getId() == R.id.NCC75646){
            intent.putExtra(key, "NCC-74656");
            activity.startActivity(intent);
        }
        else if(view.getId() == R.id.NCC1701D){
            intent.putExtra(key, "NCC-1701-D");
            activity.startActivity(intent);
        }
    }
}
