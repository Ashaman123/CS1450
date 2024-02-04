import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/* Owen Millspaugh
 * CS1450-003
 * Assignment 2
 * Due Date: 02/05/2024
 * Program Overview: Create an array of different turtle types read in from a file
 * diplay these details and practice using inheritance and abstraction.
 */

public class MillspaughOwenAssignment2 {
//Handles the reading from the file and the creation and printing of the array of turtles
    public static void main(String[] args) throws IOException {

        //Open reference to file and scanner to read
        File inputFile = new File("SeaTurtles.txt");
        Scanner scanner = new Scanner(inputFile);

        //Create and intitialize tutleArray size by reading the first value in the file
        int arraySize = scanner.nextInt();
        SeaTurtle[] turtleArray = new SeaTurtle[arraySize];

        //while loop to handle reading the file and assigning variables
        int arrayCount = 0;
        while (scanner.hasNext()) {
            String type = scanner.next();
            int daysTracked = scanner.nextInt();
            double milesTraveled = scanner.nextDouble();
            String name = scanner.next(); // Corrected this line

            //Switch case to handle different turtle type inititialization
            switch (type) {
                case "lh":
                    turtleArray[arrayCount] = new Loggerhead(name, type, daysTracked, milesTraveled);
                    break;
                case "hb":
                    turtleArray[arrayCount] = new Hawksbill(name, type, daysTracked, milesTraveled);
                    break;
                case "gt":
                    turtleArray[arrayCount] = new GreenTurtle(name, type, daysTracked, milesTraveled);
                    break;
                case "lb":
                    turtleArray[arrayCount] = new Leatherback(name, type, daysTracked, milesTraveled);
                    break;
                default:
                    // Handle unknown type or provide an error message
                    break;
            }
            arrayCount++;
        }

     // print table headers using formatting
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s\t%-15s\t%-15s\t%-15s\t\t%s\n", "Name", "Type", "Days Tracked", "Miles Traveled", "Threats to Survival");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        //Use for each array to read through array and print the values using the getter methods in the SeaTurtle class
        for (SeaTurtle turtle : turtleArray) {
            if (turtle != null) {  // Check for null, as the array may have unused elements
                System.out.printf("%-10s\t%-15s\t%-15d\t%-15.2f\t\t%s\n",
                        turtle.getName(), turtle.getType(), turtle.getDaysTracked(), turtle.getMilesTraveled(),
                        turtle.getSurvivalThreat());
            }
        }
    }
    
}

//super class for the broad SeaTurtle class
class SeaTurtle {

    //define private classes
    private String type;
    private int daysTracked;
    private double milesTraveled;
    private String name;
    private String survivalThreat = "You Messed up something";

    //constructor for SeaTurtle
    public SeaTurtle(String type, String name, int daysTracked, double milesTraveled) {
        this.type = type;
        this.name = name;
        this.daysTracked = daysTracked;
        this.milesTraveled = milesTraveled;
    }

    //Getter method for type
    public String getType() {
        return type;
    }

    //getter method for daysTracked
    public int getDaysTracked() {
        return daysTracked;
    }

    //getter method for milesTraveled
    public double getMilesTraveled() {
        return milesTraveled;
    }

    //getter method for name
    public String getName() {
        return name;
    }

    //getter for survivalThreat, no use, make abstract
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

//subclass for loggerhead
class Loggerhead extends SeaTurtle {
    private String survivalThreat = "Loss of nesting habitat";

    //constructor using Turtle constructor
    Loggerhead(String name, String type, int daysTracked, double milesTraveled) {
        super("Loggerhead", name, daysTracked, milesTraveled);
    }

    //override method survivalThreat in superclass
    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

//subclass to GreenTurtle
class GreenTurtle extends SeaTurtle {
    private String survivalThreat = "Commercial harvest for eggs and food";
    
    //constructor using Turtle constructor
    GreenTurtle(String name, String type, int daysTracked, double milesTraveled) {
        super("Green Turtle", name, daysTracked, milesTraveled);
    }

    //override method survivalThreat in superclass
    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

//subclass to turtle hawksbill
class Hawksbill extends SeaTurtle {
    private String survivalThreat = "Harvesting of their shell";

    //constructor using Turtle constructor
    Hawksbill(String name, String type, int daysTracked, double milesTraveled) {
        super("Hawksbill", name, daysTracked, milesTraveled);
    }

    //override method for super
    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

//leatherback subclass
class Leatherback extends SeaTurtle {
    private String survivalThreat = "Plastic bag mistaken for jellyfish";

    //constructor using Turtle constructor
    Leatherback(String name, String type, int daysTracked, double milesTraveled) {
        super("Leatherhead", name, daysTracked, milesTraveled);
    }

    //override threatSurvival method
    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}
