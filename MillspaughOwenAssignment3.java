import java.util.ArrayList;
import java.util.Scanner; 
import java.io.File;
import java.io.IOException;

/* Owen Millspaugh
 * CS1450-003
 * Assignment 3
 * Due Date: 02/12/2024
 * Program Overview: Practice with file reading and use
 * of abstract classes and interfaces for abstraction practice
 * by using arrays and ArrayLists to check instances of certain
 * types of racer objects
 */

public class MillspaughOwenAssignment3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File inputFile = new File("athletes.txt");
	    Scanner input = new Scanner(inputFile);
	    int arrayCount = 0;
	    
	    int arraySize = input.nextInt();

	    Athlete[] athletes = new Athlete[arraySize];
	    
	    //Handle reading input and assignment to object and arrays
	    while(input.hasNext()) {
	    	String type = input.next();
	    	double runSpeed = input.nextDouble();
	    	double swimSpeed = input.nextDouble();
	    	double bikeSpeed = input.nextDouble();
	    	String firstName = input.next();
	    	String lastName = input.next();
	    	String name = firstName + " " + lastName;
	    	
	    	//switch statement to handle assignment and creation
	    	// Inside the switch statement
	    	switch (type) {
	    	    case "t":
	    	        athletes[arrayCount] = new Triathlete(name, runSpeed, swimSpeed, bikeSpeed);
	    	        break;
	    	    case "d":
	    	        athletes[arrayCount] = new Duathlete(name, runSpeed, bikeSpeed);
	    	        break;
	    	    case "a":
	    	        athletes[arrayCount] = new Aquathlete(name, runSpeed, swimSpeed);
	    	        break;
	    	    case "m":
	    	        athletes[arrayCount] = new Marathoner(name, runSpeed);
	    	        break;
	    	    default:
	    	        break;
	    	}
	    	arrayCount++;
	    }
	    
	    
	    ArrayList<Athlete> bikerList = new ArrayList<>(); 
	    bikerList = findBikers(athletes);
	    
	    
	    ArrayList<Athlete> doNotSwim = new ArrayList<>();
        doNotSwim = findDoNotSwim(athletes);
        
        
        int slowestRunnerIndex = findSlowestRunner(athletes);

        // Task d: Display results
        printResultsBikers(bikerList);
        printResultsNonSwimmers(doNotSwim);
        System.out.println("----------------------------------------");
	    System.out.println("The slowest runner is " + athletes[slowestRunnerIndex].getName() + " who is a " + athletes[slowestRunnerIndex].getType() + " and runs " + ((Runner)athletes[slowestRunnerIndex]).run() + " MPH!");
        
	    input.close();
	}
	
    public static ArrayList<Athlete> findBikers (Athlete[] athletes){
    	ArrayList<Athlete> bikerList = new ArrayList<>();
    	
    	for (Athlete athlete : athletes) {
    		if(athlete instanceof Biker) {
    			bikerList.add(athlete);
    		}
    	}
    	return bikerList;
    }

    public static ArrayList<Athlete> findDoNotSwim(Athlete[] athletes) {
        ArrayList<Athlete> doNotSwimList = new ArrayList<>();

        for (Athlete athlete : athletes) {
            if (!(athlete instanceof Swimmer)) {
                doNotSwimList.add(athlete);
            }
        }
        return doNotSwimList;
    }


    public static int findSlowestRunner(Athlete[] athletes) {
        int slowestRunnerIndex = 0;
        double slowestRunnerSpeed = ((Runner) athletes[slowestRunnerIndex]).run();
        for (int i = 1; i < athletes.length; i++) {
            if (athletes[i] instanceof Runner) {
                double currentRunnerSpeed = ((Runner) athletes[i]).run();
                if (currentRunnerSpeed < slowestRunnerSpeed) {
                    slowestRunnerSpeed = currentRunnerSpeed;
                    slowestRunnerIndex = i;
                }
            }
        }

        return slowestRunnerIndex;
    }


    public static void printResultsBikers(ArrayList<Athlete> bikers) {
    	System.out.println("---------------------------------------");
    	System.out.println("|       ATHLETES THAT ARE BIKERS      |");
    	System.out.println("---------------------------------------");
    	for(Athlete athlete : bikers) {
    	System.out.printf("%s is a %s and is an athlete that bikes at %.2f MPH\n", athlete.getName(), athlete.getType(), ((Biker)athlete).bike());
    	System.out.println(athlete.disciplines());
    	System.out.println("");
    	
    	}
    }
    
    public static void printResultsNonSwimmers(ArrayList<Athlete> nonSwimmers) {
    	System.out.println("---------------------------------------");
    	System.out.println("|      ATHLETES THAT DO NOT SWIM      |");
    	System.out.println("---------------------------------------");
    	for(Athlete athlete : nonSwimmers) {
        	System.out.printf("%s is a %s and is an athlete that does not swim\n", athlete.getName(), athlete.getType());
        	System.out.println(athlete.disciplines());
        	System.out.println("");
        	}
    }
}


abstract class Athlete {
    private String name;
    private String type;

    

	public String getName() {
        return name;
    }

	public String getType() {
        return type;
    }
	
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String disciplines();
    
}



class Triathlete extends Athlete implements Runner, Swimmer, Biker {
    private double runSpeed;
    private double swimSpeed;
    private double bikeSpeed;

    public Triathlete(String name, double runSpeed, double swimSpeed, double bikeSpeed) {
        setName(name);
        setType("Triathlete");
        this.runSpeed = runSpeed;
        this.bikeSpeed = bikeSpeed;
        this.swimSpeed = swimSpeed;
    }


            @Override
            public String disciplines() {
                return "During the Ironman triathlon, I swim 2.4 miles, bike 112 miles, then run 26.2 miles.";
            }

            @Override
            public double bike() {
                return bikeSpeed;
            }

            @Override
            public double run() {
                return runSpeed;
            }

            @Override
            public double swim() {
                return swimSpeed;
            }

            
        }



class Duathlete extends Athlete implements Runner, Biker {

    private double bikeSpeed;
    private double runSpeed;

    String discipline = "I run, bike, then sometimes run again. In a long-distance duathlon, I run 6.2 miles, bike 93 miles, then run 18.6 miles.";

    public Duathlete(String name, double runSpeed, double bikeSpeed) {
    	setName(name);
        setType("Duathlete");
        this.bikeSpeed = bikeSpeed;
        this.runSpeed = runSpeed;
    }

    
    public double getRunSpeed() {
        return runSpeed;
    }

    
    public double getBikeSpeed() {
        return bikeSpeed;
    }

    @Override
    public String disciplines() {
        return discipline;
    }

    @Override
    public double bike() {
        return bikeSpeed;
    }

    @Override
    public double run() {
        return runSpeed;
    }
}

class Marathoner extends Athlete implements Runner {

    private double runSpeed;

    String discipline = "During a full marathon I run 26.2 miles!";

    public Marathoner(String name, double runSpeed) {
    	setName(name);
        setType("Marathoner");
        this.runSpeed = runSpeed;
    }

    @Override
    public double run() {
        return runSpeed;
    }

    @Override
    public String disciplines() {
        return discipline;
    }
}

class Aquathlete extends Athlete implements Runner, Swimmer {

    private double runSpeed;
    private double swimSpeed;

    String discipline = "I run, swim, then run again. In the Swedish OTILLO Championship, the race takes place over 24 islands and requires 6 miles of swimming between the islands and 40 miles of trail running.";

    public Aquathlete(String name, double runSpeed, double swimSpeed) {
    	setName(name);
        setType("Aquathlete");
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
    }

    @Override
    public double run() {
        return runSpeed;
    }

    @Override
    public double swim() {
        return swimSpeed;
    }

    @Override
    public String disciplines() {
        return discipline;
    }
}


interface Runner {
    double run();
}

interface Swimmer {
    double swim();
}

interface Biker{
    double bike();
}

