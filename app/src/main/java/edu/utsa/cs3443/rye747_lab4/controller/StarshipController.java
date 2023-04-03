package edu.utsa.cs3443.rye747_lab4.controller;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

import edu.utsa.cs3443.rye747_lab4.R;
import edu.utsa.cs3443.rye747_lab4.StarshipActivity;
import edu.utsa.cs3443.rye747_lab4.model.Fleet;

public class StarshipController implements View.OnClickListener{
    private StarshipActivity activity;
    private AssetManager manager;
    private Fleet fleet;
    private LinearLayout ll;
    private String shipReg;
    private String key = "ship_registry";
    private int shipInd;
    public StarshipController(StarshipActivity activity){
        this.activity = activity;
        this.manager = this.activity.getAssets();
        fleet = new Fleet("United Federation of Planets");

        ll = activity.findViewById(R.id.crew_info);
        shipReg = activity.getIntent().getStringExtra(key);

        try {
            fleet.loadStarships(manager);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        shipInd = findShip(shipReg);
        addCrewmembersView();
        setHeader();
    }

    @Override
    public void onClick(View view) {

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

    private void addCrewmembersView(){
        LinearLayout crewll;
        LinearLayout infoll;
        TextView tv1;
        TextView tv2;
        ImageView iv;

        LinearLayout.LayoutParams ll_lp = new LinearLayout.LayoutParams(MATCH_PARENT, 300);
        ViewGroup.LayoutParams iv_lp = new ViewGroup.LayoutParams(225, 300);
        ViewGroup.LayoutParams tv_lp = new ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        for(int i = 0; i < fleet.getStarship(this.shipInd).getNumberOfPersonnel(); ++i){
            crewll = new LinearLayout(activity);
            crewll.setOrientation(LinearLayout.HORIZONTAL);
            crewll.setLayoutParams(ll_lp);
            crewll.setPadding(30,10,0,10);
            ll.addView(crewll);

            Bitmap bm = BitmapFactory.decodeResource(activity.getResources(), pickCrewPicture(i));
            Bitmap scaledBM = Bitmap.createScaledBitmap(bm,225,300, true);
            iv = new ImageView(activity);
            iv.setImageBitmap(scaledBM);
            iv.setLayoutParams(iv_lp);
            crewll.addView(iv);

            infoll = new LinearLayout(activity);
            infoll.setLayoutParams(ll_lp);
            infoll.setPadding(30,0,0,0);
            infoll.setOrientation(VERTICAL);
            crewll.addView(infoll);

            tv1 = new TextView(activity);
            tv1.setTextSize(25);
            tv1.setTextColor(Color.BLACK);
            tv1.setText(fleet.getStarship(shipInd).getCrewMember(i).getPosition());
            tv1.setLayoutParams(tv_lp);
            infoll.addView(tv1);

            tv2 = new TextView(activity);
            tv2.setTextSize(15);
            tv2.setTextColor(Color.BLACK);
            String tempString = fleet.getStarship(shipInd).getCrewMember(i).getRank() + " " + fleet.getStarship(shipInd).getCrewMember(i).getName();
            if(fleet.getStarship(shipInd).getCrewMember(i).getRank().equals("no rank")){
                tempString = "(unranked) " + fleet.getStarship(shipInd).getCrewMember(i).getName();
            }
            tv2.setText(tempString);
            tv2.setLayoutParams(tv_lp);
            infoll.addView(tv2);
        }
    }

    private void setHeader(){
        TextView tv = activity.findViewById(R.id.Header);
        String shipString = fleet.getStarship(shipInd).getName() + " " + fleet.getStarship(shipInd).getRegistry();
        tv.setText(shipString);
    }

    private int pickCrewPicture(int crewInd){
        if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("kirk")){
            return R.drawable.kirk;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("spock")){
            return R.drawable.spock;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("mccoy")){
            return R.drawable.mccoy;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("scott")){
            return R.drawable.scott;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("picard")){
            return R.drawable.picard;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("riker")){
            return R.drawable.riker;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("crusher")){
            return R.drawable.crusher;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("forge")){
            return R.drawable.la_forge;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("troi")){
            return R.drawable.troi;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("worf")){
            return R.drawable.worf;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("data")){
            return R.drawable.data;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("yar")){
            return R.drawable.yar;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("chapel")){
            return R.drawable.chapel;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("torres")){
            return R.drawable.torres;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("paris")){
            return R.drawable.paris;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("doctor")){
            return R.drawable.doctor;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("uhura")){
            return R.drawable.uhura;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("neelix")){
            return R.drawable.neelix;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("sulu")){
            return R.drawable.sulu;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("kes")){
            return R.drawable.kes;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("chekov")){
            return R.drawable.chekov;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("janeway")){
            return R.drawable.janeway;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("chakotay")){
            return R.drawable.chakotay;
        }
        else if(fleet.getStarship(shipInd).getCrewMember(crewInd).getName().toLowerCase().contains("tuvok")){
            return R.drawable.tuvok;
        }
        return 0;
    }
}
