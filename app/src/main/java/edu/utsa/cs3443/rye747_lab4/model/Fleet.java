package edu.utsa.cs3443.rye747_lab4.model;

import java.io.File;
import java.io.FileNotFoundException;
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
	 * Loads the files contained within the specified directory in order to open the files, parse the data contained within, and create new Starship or CrewMember objects based on the data.
	 * 
	 * @param dirName the directory name that will be checked for Starship data files
	 * @throws FileNotFoundException Error thrown when failing to open the specified file
	 */
	public void loadStarships(String dirName) throws FileNotFoundException {
		File dataDir = new File(dirName);
		String[] filenames = dataDir.list();
		String[] tokens;
		String lineIn;
		
		for(int i = 0; i < filenames.length; ++i) {
			try {
				Scanner read = new Scanner(new File(dirName + "/" + filenames[i]));
				int n = 0;
				while(read.hasNextLine()) {
					lineIn = read.nextLine();
					tokens = lineIn.split(",");
					assignData(tokens, n);
					++n;
				}
				read.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Takes the data read in from the loadStarships method and creates either a new Starship object or a new CrewMember object based on the specifics of that data and the state parameter. 
	 * Once an object is created it is added to the relevant ArrayList. (fleet for Starship objects, Crew for CrewMember objects)
	 * 
	 * @param tokens array of strings obtained by using split method on read in data from loadStarships method. Used to create either Starship or CrewMember objects
	 * @param state integer used to determine what object to create
	 */
	private void assignData(String[] tokens, int state) {
		switch(state) {
			case 0:
				Starship tempShip = new Starship(tokens[0], tokens[1], tokens[2]);
				addStarship(tempShip);
				break;
			default:
				if(tokens.length == 4) {
					CrewMember newCrew = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[3]);
					fleet.get(fleet.size() - 1).addCrewMember(newCrew);
				}
				else if(tokens.length == 5){
					CrewMember newCrew = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
					fleet.get(fleet.size()).addCrewMember(newCrew);
				}	
				break;
		}
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
	
}
