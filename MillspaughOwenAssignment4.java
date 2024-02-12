import java.util.Scanner;
import java.io.*;

/* Owen Millspaugh
 * CS1450-003
 * Assignment 4
 * Due Date: 02/19/2024
 * Create a program to model a cargo terminal loaded with semi-trucks and cargo planes
 * consisting of a cargo terminal,  loading dock, tarmac, and stand
 */

public class MillspaughOwenAssignment4 {
	

	public static void main(String[] args) throws IOException 
	{
	

	}

}

class CargoTerminal 
{
	private int numberDocks;
	private int numberStands;
	private SemiTruck[] loadingDock;
	private CargoPlane[] tarmac;


	public CargoTerminal (int numberDocks, int numberStands) 
	{
		this.numberDocks = numberDocks;
		this.numberStands = numberStands;
		loadingDock = new SemiTruck[numberDocks];
		tarmac = new CargoPlane[numberStands];
	}
	
	//Getter for numberDocks
	public int getNumberDocks()
	{
		return numberDocks;
	}
	
	//Getter for numberStands
	public int getNumberStands() 
	{
		return numberStands;
	}
	
	//Adds semi-truck object into loading dock at specific array slot
	public void addSemiTruck(int dock, SemiTruck semiTruck)
	{
		
	}
	
	//Adds Cargo-plane object into loading dock at specific array slot
	public void addCargoPlane(int stand, CargoPlane plane)
	{
		
	}
	
	//returns a specific semi-truck from a dock location
	public SemiTruck getSemiTruck (int dock)
	{
		return loadingDock[dock];
	}
	
	//returns a specific cargo plane from a stand location
	public CargoPlane getCargoPlane(int stand)
	{
		return tarmac[stand];
	}
	
	//Displays formatted version of the tarmac and loading dock
	public void displayTrucksAndPlanes()
	{
		
	}
	
}
class SemiTruck 
{
	
}

class CargoPlane
{
	
}

class PlaneReport
{
	
}