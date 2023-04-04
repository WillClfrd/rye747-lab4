package edu.utsa.cs3443.rye747_lab4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab4.controller.StarshipController;

/**
 * This class represents StarshipActivity objects.
 * Each StarshipActivity object is instantiated with a Bundle object
 * StarshipActivity objects are responsible for initializing the activity_starship layout
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 4
 * Spring 2023
 */
public class StarshipActivity extends AppCompatActivity{
    private StarshipController controller;

    /**
     * This method is responsible for initializing the application view for the activity_starship layout
     *
     * @param savedInstanceState a Bundle class object that is passed into the inherited class onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_starship);

            controller = new StarshipController(this);
        }
}
