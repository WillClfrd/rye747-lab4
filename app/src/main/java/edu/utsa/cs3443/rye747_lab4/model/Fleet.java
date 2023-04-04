package edu.utsa.cs3443.rye747_lab4.model;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents Fleet objects. 
 * Each Fleet object can be instantiated with a name value. 
 * Fleet objects contain an ArrayList of Starship objects. 
 * 
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */
public class Fleet {
	private String name;
	private ArrayList<Starship> fleet;
	
	/**
	 * Constructs a Fleet object with a given name. 
	 * After the object is created the fleet ArrayList of Starship objects is initialized. 
	 * 
	 * @param nm the given value for the Fleet object name attribute
	 */
	public Fleet(String nm){
		this.name = nm;
		fleet = new ArrayList<Starship>();
	}
	
	/**
	 * Returns a formatted string representation of the Fleet object name attribute. 
	 * Included in the output string is the formatted output string from the Starship toString method for the Starship objects within the fleet ArrayList, which also contains the output from the CrewMember toString method for the CrewMember objects in the Starship Crew ArrayList. 
	 * 
	 * @return the formatted string representation for the Fleet name attribute and the fleet ArrayList
	 */
	public String toString() {
		String outStr = "----------------------------\n" + this.name + "\n----------------------------";
		for(int i = 0; i < fleet.size(); ++i) {
			outStr += "\n" + fleet.get(i).toString();
		}
		return outStr;
	}
	
	/**
	 * Returns the size of the fleet ArrayList as an integer. 
	 * 
	 * @return an integer value representing the size of the fleet ArrayList
	 */
	public int getSizeOfFleet() {
		return fleet.size();
	}
	
	/**
	 * Adds a Starship object to the fleet ArrayList. 
	 * 
	 * @param newShip the specified Starship object to be added to the fleet ArrayList
	 */
	public void addStarship(Starship newShip) {
		fleet.add(newShip);
	}
	
	/**
	 * Loads the specified asset files using an AssetManager to open the files. After opening the files this method will parse the data contained within, and create new Starship and CrewMember objects based on the data within the opened files.
	 * 
	 * @param manager the asset manager used to retrieve the necessary data files
	 * @throws IOException Error thrown when failing to open the specified file
	 */
	public void loadStarships(AssetManager manager) throws IOException {
		if(fleet == null){
			fleet = new ArrayList<Starship>();
		}

		InputStream inFile = manager.open("fleet.csv");
		Scanner read = new Scanner(inFile);
		String[] tokens;
		String lineIn;
		int i;

		while(read.hasNext()){
			lineIn = read.nextLine();
			tokens = lineIn.split(",");
			Starship tempShip = new Starship(tokens[0], tokens[1], tokens[2]);
			addStarship(tempShip);
		}
		inFile.close();
		read.close();
		inFile = manager.open("personnel.csv");
		read = new Scanner(inFile);
		while(read.hasNext()){
			lineIn = read.nextLine();
			tokens = lineIn.split(",");
			for(i = 0; i < fleet.size(); ++i) {
				if (tokens[3].equals(fleet.get(i).getRegistry())){
					if(tokens.length == 4) {
						CrewMember newCrew = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[3]);
						fleet.get(i).addCrewMember(newCrew);
					}
					else if(tokens.length == 5){
						CrewMember newCrew = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
						fleet.get(i).addCrewMember(newCrew);
					}
				}
			}
		}
		inFile.close();
		read.close();
	}
	
	/**
	 * Returns the Fleet object name attribute. 
	 * 
	 * @return the string type name attribute for the Fleet object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Changes the value of the Fleet object name attribute to the value specified by newName
	 * 
	 * @param newName the value to be assigned to the Fleet object name attribute
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Returns the Starship object located at the specified index of the fleet ArrayList
	 *
	 * @param ind the index of the Starship object that is to be returned
	 * @return the Starship object at the index specified by ind
	 */
	public Starship getStarship(int ind){
		return fleet.get(ind);
	}
	
}
