package edu.utsa.cs3443.rye747_lab4;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import edu.utsa.cs3443.rye747_lab4.controller.StarshipController;
import edu.utsa.cs3443.rye747_lab4.model.Fleet;

public class StarshipActivity extends AppCompatActivity{
        private StarshipController controller;
        private String key = "ship_registry";
        private String shipReg;
        private int shipInd;
        private Fleet fleet;
        private AssetManager manager;
        private LinearLayout crewll;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_starship);

            controller = new StarshipController(this);
            manager = getAssets();
            crewll = findViewById(R.id.crew_info);

            shipReg = getIntent().getStringExtra(key);

            fleet = new Fleet("United Federation of Planets");
            try {
                fleet.loadStarships(manager);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            shipInd = findShip(shipReg);
            addCrewmembers();
            setHeader();
        }

        public void setupButton(View view) {
            view.setOnClickListener(controller);
        }

        private int findShip(String reg){
            int i;

            for(i = 0; i < fleet.getSizeOfFleet(); ++i){
                if(fleet.getStarship(i).getRegistry().equals(reg)){
                    return i;
                }
            }
            return 0;
        }

        private void addCrewmembers(){
            TextView tv1;
            TextView tv2;
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(MATCH_PARENT, 100);

            for(int i = 0; i < fleet.getStarship(this.shipInd).getNumberOfPersonnel(); ++i){
                tv1 = new TextView(this);
                tv2 = new TextView(this);
                String crewString = fleet.getStarship(shipInd).getCrewMember(i).getPosition() + "\n" + fleet.getStarship(shipInd).getCrewMember(i).getName();
//                String tempString = String.valueOf(shipInd);

                tv1.setTextSize(30);
                tv1.setTextColor(Color.BLACK);
                tv1.setText(fleet.getStarship(shipInd).getCrewMember(i).getPosition());
                tv1.setPadding(20,0,0,0);
                crewll.addView(tv1, lp);

                tv2.setTextSize(25);
                tv2.setTextColor(Color.BLACK);
                tv2.setText(fleet.getStarship(shipInd).getCrewMember(i).getName());
                tv2.setPadding(20,0,0,0);
                crewll.addView(tv2, lp);
            }
        }

        private void setHeader(){
            TextView tv = findViewById(R.id.Header);
            String shipString = fleet.getStarship(shipInd).getName() + " " + fleet.getStarship(shipInd).getRegistry();
//            String tempString = String.valueOf(shipInd);
            tv.setText(shipString);
        }
}
