
import java.util.ArrayList;

// Here is where the super powers will be handled
public class SuperHV extends Character{
    private ArrayList<String> powers;
    
    public SuperHV(){
        this.powers = new ArrayList<>();
    }
    public SuperHV(String name, String team, String universe, String homePlanet, Stats s, int intelligence, int strength, int stamina, int speed, int skills, ArrayList<String> powers) {
        super(name, team, universe, homePlanet, s, intelligence, strength, stamina, speed, skills);
        this.powers = powers;
    }

    public ArrayList<String> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<String> powers) {
        this.powers = powers;
    }
    
    public void setPower(String attribute){
       this.powers.add(attribute);
    }
    
    public int getAddPowers(){  //Add up 10 points for every power in the powers arraylist
        int totalPowerPoints = 0;
        for (String power: powers) {
            totalPowerPoints += 10;
        }
        return totalPowerPoints;
    }
    
    @Override
    public String toString(){
        String pow = powers.toString();
        pow = pow.substring(1, pow.length()-1); //Get rid of the brackets
        String information = "";
        information += String.format("   Name:         %s\n", getName());
        information += String.format("   Team:         %s\n", getTeam());
        information += String.format("   Universe:     %s\n", getUniverse());
        information += String.format("   Home Planet:  %s\n", getHomePlanet());
        information += getS().toString();   //Call the STATS toString() method
        information += String.format("   Powers:       %s\n", pow);
        return information; 
    }
    
}
