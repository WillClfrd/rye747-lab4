package edu.utsa.cs3443.rye747_lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab4.controller.MainController;

/**
 * This class represents MainActivity objects.
 * Each MainActivity object is instantiated with a Bundle object
 * MainActivity objects are responsible for initializing the activity_main layout
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 4
 * Spring 2023
 */
public class MainActivity extends AppCompatActivity {
    private MainController controller;

    /**
     * This method is responsible for initializing the application view, and instantiating the button views for the activity_main layout
     *
     * @param savedInstanceState a Bundle class object that is passed into the inherited class onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);

        Button voyager = findViewById(R.id.NCC75646);
        Button enterprise_1 = findViewById(R.id.NCC1701A);
        Button enterprise_2 = findViewById(R.id.NCC1701D);

        setupButton(voyager);
        setupButton(enterprise_1);
        setupButton(enterprise_2);
    }

    /**
     * This method initializes the view matching the specified id as a Button class object with an onClickListener
     *
     * @param view the view that is assigned an OnClickListener
     */
    public void setupButton(View view){
        view.setOnClickListener(controller);
    }
}