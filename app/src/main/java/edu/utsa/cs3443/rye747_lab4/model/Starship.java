package edu.utsa.cs3443.rye747_lab4.model;
import java.util.ArrayList;
/**
 * This class represents Starship objects. 
 * Each Starship object can be instantiated with a name, a registry, and a starshipClass. 
 * Starship objects also contain an ArrayList of CrewMember objects. 
 * 
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */
public class Starship {
	private String name;
	private String registry;
	private String starshipClass;
	private ArrayList<CrewMember> Crew;
	
	/**
	 * Constructs a Starship class object with a given name, registry, and starshipClass. 
	 * Upon creation of the Starship object the Crew ArrayList is initialized. 
	 * 
	 * @param nm the value to be assigned to the Starship object name attribute
	 * @param reg the value to be assigned to the Starship object registry attribute
	 * @param cl the value to be assigned to the Starship object class attribute
	 */
	public Starship (String nm, String reg, String cl){
		this.name = nm;
		this.registry = reg;
		this.starshipClass = cl;
		this.Crew = new ArrayList<CrewMember>();
	}
	
	/**
	 * Returns a formatted string representation of the Starship class name, registry, and class attributes. 
	 * Included in the output string is the formatted string output from the toString method called for each CrewMember object present in the Crew ArrayList. 
	 * 
	 * @return A formatted string that combines the Starship class name, registry, and class attributes with the formatted string output for CrewMember objects within the Crew ArrayList.
	 */
	public String toString() {
		String outStr = this.name + ", " + this.starshipClass + ". Registry: " + this.registry + "\n" + Crew.size() + " crew members assigned.\n";
		for(int i = 0; i < Crew.size(); ++i) {
			outStr += Crew.get(i).toString();
		}
		return outStr;
	}
	
	/**
	 * Adds a specified CrewMember object to the current Crew ArrayList
	 * 
	 * @param newCrew the CrewMember object to be added to the Crew ArrayList
	 */
	public void addCrewMember(CrewMember newCrew) {
		this.Crew.add(newCrew);
	}
	
	/**
	 * Returns the size of the Crew ArrayList as an integer. 
	 * 
	 * @return the size of the Crew ArrayList as an integer
	 */
	public int getNumberOfPersonnel() {
		return this.Crew.size();
	}
	
	/**
	 * Returns the Starship object name attribute
	 * 
	 * @return the string type name attribute for the Starship object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the Starship object registry attribute
	 * 
	 * @return the string type registry attribute for the Starship object
	 */
	public String getRegistry() {
		return this.registry;
	}
	
	/**
	 * Returns the Starship object starshipClass attribute
	 * 
	 * @return the string type starshipClass attribute for the Starship object
	 */
	public String getStarshipClass() {
		return this.starshipClass;
	}

	/**
	 * This method is used to return the CrewMember object at the specified index of the ArrayList Crew
	 *
	 * @param ind the index of the CrewMember object to be returned
	 * @return the CrewMember object at the specified index
	 */
	public CrewMember getCrewMember(int ind){
		return Crew.get(ind);
	}
	/**
	 * Changes the value of the Starship object name attribute to the value specified by newName
	 * 
	 * @param newName the new value to be assigned to the Starship object name attribute
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Changes the value of the Starship object registry attribute to the value specified by newReg
	 * 
	 * @param newReg the new value to be assigned to the Starship object registry attribute
	 */
	public void setRegistry(String newReg) {
		this.registry = newReg;
	}
	
	/**
	 * Changes the value of the Starship object starshipClass attribute to the value specified by newSSC
	 * 
	 * @param newSSC the value to be assigned to the Starship object starshipClass attribute
	 */
	public void setStarshipClass(String newSSC) {
		this.starshipClass = newSSC;
	}
}
