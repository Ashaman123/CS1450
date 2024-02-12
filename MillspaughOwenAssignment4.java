import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
		//Creates file reference
		File planeInput = new File("FedExPlanes.txt");
		File truckInput = new File("FedExTrucks.txt");
		
		//Creates scanner for files based on reference
		Scanner planeScan = new Scanner(planeInput);
		Scanner truckScan = new Scanner(truckInput);
		
		//Creates int for array size and Terminal instantiation
		int numberDocks = truckScan.nextInt();
		int numberStands = planeScan.nextInt();
		
		//Creates cargo terminal object using above variables
		CargoTerminal terminal = new CargoTerminal(numberDocks, numberStands);
		
		//While loop to deal with truck file and object creation
		while(truckScan.hasNext())
		{
			int dock = truckScan.nextInt();
			int truckNumber = truckScan.nextInt();
			String destinationCity = truckScan.next();
			SemiTruck truck = new SemiTruck(truckNumber, destinationCity);
			terminal.addSemiTruck(dock, truck);
		}
		
		//while loop to deal with plane file and object creation
		while(planeScan.hasNext())
		{
			int stand = planeScan.nextInt();
			int flightNumber = planeScan.nextInt();
			String type = planeScan.next();
			double capacity = planeScan.nextDouble();
			String destinationCity = planeScan.next();
			CargoPlane plane = new CargoPlane(flightNumber, type, capacity, destinationCity);
			terminal.addCargoPlane(stand, plane);
		}
		
		//Calls the method to print info in Cargo Terminal class
		terminal.displayTrucksAndPlanes();
		
		//Call method to print info 
		printTarmacStatus(terminal);
		
		//Close scanners
		planeScan.close();
		truckScan.close();
	}

	public static void printTarmacStatus(CargoTerminal terminal)
	{
		//Create an arrayList to handle plane reports
		ArrayList<PlaneReport> planeReportList = new ArrayList<>(); 
		
		System.out.println("\n\n");
		System.out.println("_________________________________________________________________________________________");
		System.out.println("                                         TARMAC STATUS                                   ");
		System.out.println("                         (Capacity Printed From Lowest to Highest)                       ");
		System.out.println("_________________________________________________________________________________________");
		System.out.println("");
		
		System.out.printf("%-10s%-10s%-20s%-15s%-15s\n", "Flight", "Stand", "Departing To", "Type", "Capacity (lbs.");
		//System.out.printf("Flight\t\tStand\t\tDeparting To\t\tType\t\tCapacity (lbs.)\n");
		System.out.println("_________________________________________________________________________________________");
		
		//Create loop size variable 
		int loopLength = terminal.getNumberStands();
		
		//Create for loop to create Plane Reports for each plane
		for(int i = 0; i < loopLength; i++) {
			//Grab details using the terminal class and getter methods
			if(terminal.getCargoPlane(i) != null) {
			int flightNumber = terminal.getCargoPlane(i).getFlightNumber();
			String type = terminal.getCargoPlane(i).getType();
			double capacity = terminal.getCargoPlane(i).getCapacity();
		    String destinationCity = terminal.getCargoPlane(i).getDestinationCity();
			PlaneReport report = new PlaneReport(i, flightNumber, type, capacity, destinationCity);
			planeReportList.add(report);
			}
		}
		
		//Sort the arrayList with Collections.sort
		Collections.sort(planeReportList);
		
		System.out.println("");
		//For each loop to print all results for list
		for (PlaneReport report : planeReportList) {
		    System.out.println(report.print());
		}
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
		loadingDock[dock] = semiTruck;
	}
	
	//Adds Cargo-plane object into loading dock at specific array slot
	public void addCargoPlane(int stand, CargoPlane plane)
	{
		tarmac[stand] = plane;
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
	public void displayTrucksAndPlanes() {
	    System.out.println("\nLoading semi-trucks and planes into cargo terminal\n");

	    // Display loading docks
	    System.out.print("\nLoading Docks: \n");
	    for (int i = 1; i < loadingDock.length; i++) {
	        if (loadingDock[i] == null) {
	            System.out.printf("Dock #%d: -----\t", i);
	        } else {
	            System.out.printf("Dock #%d: %d\t", i, loadingDock[i].getTruckNumber());
	        }
	    }

	    // Display tarmac stands
	    System.out.println("\n\nTarmac Stands: ");
	    for (int i = 1; i < tarmac.length; i++) {
	        if (tarmac[i] == null) {
	            System.out.printf("Stand #%d: -----\t", i);
	        } else {
	            System.out.printf("Stand #%d: %d\t", i, tarmac[i].getFlightNumber());
	        }
	    }

	    System.out.println();  // Add an extra line for better separation
	}

	
}
class SemiTruck 
{
	private int truckNumber;
	private String destinationCity;
	
	//Constructor for semi truck object
	public SemiTruck(int truckNumber, String destinationCity)
	{
		this.truckNumber = truckNumber;
		this.destinationCity = destinationCity;
	}
	
	//getter
	public int getTruckNumber()
	{
		return truckNumber;
	}
	
	//getter
	public String getDestinationCity()
	{
		return destinationCity;
	}
}

class CargoPlane
{
	private int flightNumber;
	private String type;
	private double capacity;
	private String destinationCity;
	
	//Constructor for cargo plane object
	public CargoPlane(int flightNumber, String type, double capacity, String destinationCity)
	{
		this.flightNumber = flightNumber;
		this.type = type;
		this.capacity = capacity;
		this.destinationCity = destinationCity;
	}
	
	//Getter
	public int getFlightNumber()
	{
		return flightNumber;
	}
	
	//Getter
	public String getType()
	{
		return type;
	}
	
	//Getter
	public double getCapacity()
	{
		return capacity;
	}
	
	//Getter
	public String getDestinationCity()
	{
		return destinationCity;
	}
}

class PlaneReport implements Printable, Comparable<PlaneReport>
{
	private int stand;
	private int flightNumber;
	private String type;
	private double capacity;
	private String destinationCity;
	
	public PlaneReport (int stand, int flightNumber, String type, double capacity, String destinationCity)
	{
		this.stand = stand;
		this.flightNumber = flightNumber;
		this.type = type;
		this.capacity = capacity;
		this.destinationCity = destinationCity;
	}
	
	//Prints information about plane, overriding printable interface
	@Override
	public String print() {
	    return String.format("%-10d%-10d%-20s%-15s%-15.2f\n",
	            this.flightNumber,
	            this.stand,
	            this.destinationCity,
	            this.type,
	            this.capacity);
	}



	//Compares the two plane reports based on capacity, then returns a value accordingly
	@Override
    public int compareTo(PlaneReport otherReport) {
        // Compare based on capacity values
        return Double.compare(this.capacity, otherReport.capacity);
    }
}

interface Printable
{
	public String print();
}