import java.util.ArrayList;
import java.util.Scanner; 
import java.io.File;
import java.io.IOException;

public class MillspaughOwenAssignment3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File inputFile = new File("athletes.txt");
	    Scanner input = new Scanner(inputFile);

	    int arraySize = input.nextInt();

	    Athlete[] athletes = new Athlete[arraySize];

	    public static ArrayList <Athlete> findBikers (Athlete[] athletes){
	    	
	    }

	    public static ArrayList <Athlete> findDoNotSwim (Athlete[] athletes){

	    }

	    public static int findSlowestRunner (Athlete[] athletes){

	    }
	}

}


abstract class Athlete {
    protected String name;
    protected String type;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String disciplines();
}

        interface Runner {
            void run();
        }

        interface Swimmer {
            void swim();
        }

        interface Biker{
            void bike();
        }

        

       class Triathlete extends Athlete implements Runner, Swimmer, Biker {

            private double runSpeed;
            private double swimSpeed;
            private double bikeSpeed;

            public Triathlete(String name, double runSpeed, double bikeSpeed, double swimSpeed) {
                name = getName();
                type = getType();
                this.runSpeed = runSpeed;
                this.bikeSpeed = bikeSpeed;
                this.swimSpeed = swimSpeed;
            }

            public double getRunSpeed() {
                return runSpeed;
            }

            
            public double getBikeSpeed() {
                return bikeSpeed;
            }

            
            public double getSwimSpeed() {
                return swimSpeed;
            }

            @Override
            public String disciplines() {
                return "During the Ironman triathlon, I swim 2.4 miles, bike 112 miles, then run 26.2 miles.";
            }

            @Override
            public void bike() {
                System.out.println("Biking at speed: " + getBikeSpeed());
            }

            @Override
            public void swim() {
                System.out.println("Swimming at speed: " + getSwimSpeed());
            }

            @Override
            public void run() {
                System.out.println("Running at speed: " + getRunSpeed());
            }
        }



class Duathlete extends Athlete implements Runner, Biker {
    private double runSpeed;
    private double bikeSpeed;
    
	String discipline = "I run, bike, then sometimes run again. In a long-distance duathlon, I run 6.2 miles, bike 93 miles, then run 18.6 miles.";


    public Duathlete (String name, double runSpeed, double bikeSpeed){
    	name = getName();
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
    public void bike() {
        System.out.println("Biking at speed: " + getBikeSpeed());
    }

    @Override
    public void run() {
        System.out.println("Running at speed: " + getRunSpeed());
    }
}




class Aquathlete extends Athlete implements Runner, Swimmer {
    String discipline = "I run, swim, then run again. In the Swedish OTILLO Championship, the race takes place over 24 islands and requires 6 miles of swimming between the islands and 40 miles of trail running.";

    @Override
    public String disciplines() {
        return discipline;
    }

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}




class Marathoner extends Athlete implements Runner {
    String discipline = "During a full marathon I run 26.2 miles!";

    @Override
    public String disciplines() {
        return discipline;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}