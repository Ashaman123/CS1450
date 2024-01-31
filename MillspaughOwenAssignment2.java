import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MillspaughOwenAssignment2 {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("SeaTurtles.txt");
        Scanner scanner = new Scanner(inputFile);

        int arraySize = scanner.nextInt();
        SeaTurtle[] turtleArray = new SeaTurtle[arraySize];

        int arrayCount = 0;
        while (scanner.hasNext()) {
            String type = scanner.next();
            int daysTracked = scanner.nextInt();
            double milesTraveled = scanner.nextDouble();
            String name = scanner.next(); // Corrected this line

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

        // print table headers
        System.out.printf("Name\t\tType\t\tDays Tracked\t\tMiles Traveled\t\tThreats to Survival\n");

        for (SeaTurtle turtle : turtleArray) {
            if (turtle != null) {  // Check for null, as the array may have unused elements
                System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\t\t%s\n",
                        turtle.getName(), turtle.getType(), turtle.getDaysTracked(), turtle.getMilesTraveled(),
                        turtle.getSurvivalThreat());
            }
        }
    }
}

class SeaTurtle {
    private String type;
    private int daysTracked;
    private double milesTraveled;
    private String name;
    private String survivalThreat = "You Messed up something";

    public SeaTurtle(String type, String name, int daysTracked, double milesTraveled) {
        this.type = type;
        this.name = name;
        this.daysTracked = daysTracked;
        this.milesTraveled = milesTraveled;
    }

    public String getType() {
        return type;
    }

    public int getDaysTracked() {
        return daysTracked;
    }

    public double getMilesTraveled() {
        return milesTraveled;
    }

    public String getName() {
        return name;
    }

    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

class Loggerhead extends SeaTurtle {
    private String survivalThreat = "Loss of nesting habitat";

    Loggerhead(String name, String type, int daysTracked, double milesTraveled) {
        super("Loggerhead", name, daysTracked, milesTraveled);
    }

    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

class GreenTurtle extends SeaTurtle {
    private String survivalThreat = "Commercial harvest for eggs and food";

    GreenTurtle(String name, String type, int daysTracked, double milesTraveled) {
        super("Green Turtle", name, daysTracked, milesTraveled);
    }

    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

class Hawksbill extends SeaTurtle {
    private String survivalThreat = "Harvesting of their shell";

    Hawksbill(String name, String type, int daysTracked, double milesTraveled) {
        super("Hawksbill", name, daysTracked, milesTraveled);
    }

    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}

class Leatherback extends SeaTurtle {
    private String survivalThreat = "Plastic bag mistaken for jellyfish";

    Leatherback(String name, String type, int daysTracked, double milesTraveled) {
        super("Leatherhead", name, daysTracked, milesTraveled);
    }

    @Override
    public String getSurvivalThreat() {
        return survivalThreat;
    }
}
