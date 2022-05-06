// Here is where we will make the NPC's and super powered people 
public class Character  extends Stats{
    private String name; // The private modifier closes visibility to these data members so that they are 
    private String team;    // only visible in this class
    private String universe;
    private String homePlanet; 
    private Stats s; 
    private static int numHeroes = 0;   //Static keyword indicates that this data members belongs to the class itself. 
    
    //A public modifier means that this can be seen outside of the class and package.
    public Character(){ //This is a constructor. A constructor actually just takes in all of the data members as parameters for the class.
    numHeroes++;    //If no constructor is created, a no argument constructor is made by DEFAULT...
    this.s = new Stats();       //However, if constructors that pass all other data members are created then 
    }                   // A no-argument constructor will not exist.
    
    
    public Character(String name, String team, String universe, String homePlanet, Stats s, int intelligence, int strength, int stamina, int speed, int skills){
        super(intelligence, strength, stamina, speed, skills);
        this.name = name;
        this.team = team;
        this.universe = universe;
        this.homePlanet = homePlanet;
        this.s = new Stats(intelligence, strength, stamina, speed, skills); 
        numHeroes++;
    }
    public String getName() {   // This is a getter. It's also called an ACCESSOR. It essentially grabs a trait from a class Object. 
        return name;    // This getter returns the name of the character
    }

    public void setName(String name) {  // This is a setter. It's also called a MUTATOR. It SETS or changes something about a class Object
        this.name = name;   // This setter makes the name of the character
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }

    public Stats getS() {
        return s;
    }

    public void setS(Stats s) {
        this.s = s;
    }
   
    public static int getNumHeroes(){
        return numHeroes;   //This returns the amount of total people in the system
    }
    
    // A method is overloaded when we have two or method with the same signature.
    // For example, a method would is overloaded when it has the same name, but different parameter types
    //For example, if I had a method called plusMethod that adds two numbers, I could have:
    //      public static void plusMethod(int x, int y){}
    // and also...
    //      public static void plusMethod(double x, double y){}
    
    // We override the toString() method here. This allows us to change how something is printed 
        // when we call the print method 
    
    // We already have the ability to print a Character, but it's ass, so we want to modify it to print what we want it to be
    @Override 
    public String toString(){
     String information = "";
     information += String.format("   Name:         %s\n", name);
     information += String.format("   Team:         %s\n", team);
     information += String.format("   Universe:     %s\n", universe);
     information += String.format("   Home Planet:  %s\n", homePlanet);
     information += s.toString();
     return information;
    }
    
}
