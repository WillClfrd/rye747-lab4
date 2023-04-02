package edu.utsa.cs3443.rye747_lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab4.controller.MainController;

public class MainActivity extends AppCompatActivity {
    private MainController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);
        Button voyager = findViewById(R.id.voyager);
        Button enterprise_1 = findViewById(R.id.enterprise1);
        Button enterprise_2 = findViewById(R.id.enterprise2);
        setupButton(voyager);
        setupButton(enterprise_1);
        setupButton(enterprise_2);
    }

    public void setupButton(View view){
        view.setOnClickListener(controller);
    }
}