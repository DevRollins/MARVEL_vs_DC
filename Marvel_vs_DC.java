// Name: Devin Rollins 
// Date: 04/06/2022
// Marvel_vs_DC
        /* “I will practice academic and personal integrity and excellence of character and expect the same 
        from others.” As an academic community, Florida Southern College is firmly committed to honor and integrity 
        in the pursuit of knowledge.  Therefore, as a member of this academic community, each student 
        acknowledges  responsibility  for  his  or  her  actions  and  commits  to  the  highest  standards  of 
        integrity.  In doing so through this Honor Code, each student makes a covenant with the college 
        not to engage in any form of academic dishonesty, fraud, cheating, or theft.  Further information 
        on the Honor Code is available in the current Catalog.
        */ 
import java.util.*;

public class Marvel_vs_DC {
    
    // ADDCHARACTER()
    // Parameters:  String[] input, Character ArrayList fighters
    // Return Type: Void
    // Description: Add a character to the character ArrayList fighters.
        //Using the Character, SuperHV, and Stats classes to give them their well known traits.
    public static void ADDCHARACTER(String[] input, ArrayList<Character> fighters){
        Stats traits;
        System.out.println("Command: ADDCHARACTER");
        if (input[1].equals("superhv")) {   //If they identify as a super hero or villain
            //Set the super powered person's identifiers 
           SuperHV superPerson = new SuperHV(); 
           superPerson.setName(input[2]);
           superPerson.setTeam(input[3]);
           superPerson.setUniverse(input[4]);
           superPerson.setHomePlanet(input[5]);
           
           //Set the stats for the super powered character
           int intelligence = Integer.parseInt(input[6]);
           int strength = Integer.parseInt(input[7]);
           int stamina = Integer.parseInt(input[8]);
           int speed = Integer.parseInt(input[9]);
           int skills = Integer.parseInt(input[10]);
           
           //Create a new Stats object with their traits 
           traits = new Stats(intelligence, strength, stamina, speed, skills); 
           
           //Set the Stats of that superpowered individual to be the Stats object we just created
           superPerson.setS(traits);
           
           //Add all powers to a string
            for (int i = 11; i < input.length; i++) {
                superPerson.setPower(input[i]);
            }
            
           //Add the super powered individual to the fighters arraylist 
           fighters.add(superPerson);       
           System.out.println(superPerson);
        }
        else{   //In this case, the person had no powers. So, they're a npc(non-powered-character)
            Character npc = new Character();    //Create an empty character object
            npc.setName(input[1]);  //Set their identifiers
            npc.setTeam(input[2]);
            npc.setUniverse(input[3]);
            npc.setHomePlanet(input[4]);
            
            //Set the stats for the super powered Character
            int intelligence = Integer.parseInt(input[5]);
            int strength = Integer.parseInt(input[6]);
            int stamina = Integer.parseInt(input[7]);
            int speed = Integer.parseInt(input[8]);
            int skills = Integer.parseInt(input[9]); 
            
            //Create new stats objects using the stats we just set
            traits = new Stats(intelligence, strength, stamina, speed, skills);
            npc.setS(traits);   //Set the stats of that npc to be the stats object we just created
            fighters.add(npc); //Add the non-super-powered individual to the fighters arraylist
            
            System.out.println(npc);
        }
    }   // End of ADDCHARACTER()
    
    // SEARCHCHARACTER()
    // Parameters:  String[] input, character arraylist people
    // Return Type: Void
    // Description: Look through the all of the characters in the arraylist and find the person that matches
            //the user's input
    public static void SEARCHCHARACTER(String[] input, ArrayList<Character> people){
        System.out.println("Command: SEARCHCHARACTER");
        boolean foundSomeone = false;
        if (Character.getNumHeroes() < 1) { //If nobody is present in the character array, say so
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{   //Otherwise, loop through everyone in the character ArrayList
            for (int i = 0; i < people.size(); i++) {
                if (input[1].equals(people.get(i).getName())) { //If the input matches a name
                    foundSomeone = true;
                    System.out.println(people.get(i));      //Print out the information of that character
                }
            }
            if (foundSomeone == false) {
            System.out.printf("   ERROR: %s is not a character currently in the system.\n", input[1]); //Nobody was found
            }
        }   //End of if/else
    }   //End of SEARCHCHARACTER()
    
    
    // ADDPOWER()
    // Parameters:  String[] input, Character arraylist people
    // Return Type: Void 
    // Description: Add another power to someone who already 
    public static void ADDPOWER(String[] input, ArrayList<Character> people){
        System.out.println("Command: ADDPOWER");
        boolean foundSomeone = false;
        boolean samePower = false;
        if (Character.getNumHeroes() < 1) {
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }   //If nobody is in the system, nobody can have powers added to them
        else{
            String power = input[2];    //This is the index of the new power
            OUTER:
            while (true){
                for (int i = 0; i < people.size(); i++) {   //Loop through every Character object
                    if (people.get(i).getName().equals(input[1])) { //If the character at that index matches the name of the person in the input 
                        foundSomeone = true;
                        if (people.get(i) instanceof SuperHV) { //and that person is from the SuperHV class
                            Character superPerson = people.get(i);
                            SuperHV empoweredPerson = ((SuperHV)(superPerson)); //Set them to be a SuperHV 

                            //Now, we have to check to make sure the character does not already have this power.
                            for (int j = 0; j < empoweredPerson.getPowers().size(); j++) { //Loop through the arraylist of their powers
                                if (empoweredPerson.getPowers().get(j).equals(power)) { //If we find a String that matches the input's String, they already have it
                                    System.out.printf("   ERROR: %s already has the superpower of %s.\n", input[1], power);    //Let them know that
                                    samePower = true;
                                    break OUTER;
                                }
                            }   //End of for inner for-loop
                            if (samePower == false) {
                                empoweredPerson.getPowers().add(power);
                                System.out.printf("   %s now has the new superpower of %s.\n", input[1], power);
                                break OUTER;                                 
                            }
                        }
                        else{
                            System.out.printf("   ERROR: cannot execute command. %s is an npc.\n", input[1]);
                            break OUTER;
                        }
                    } 
                }   //End of outer for-loop 
                if (foundSomeone == false) {
                    System.out.printf("   ERROR: %s is not a character currently in the system.\n", input[1]);
                    break OUTER;
                }
            }
        } 
    }   //End of ADDPOWER()  
    
    // FIGHT()
    // Parameters: String[] input, Character ArrayList Fighters
    // Return Type: Void
    // Description/Purpose: Simulate a fight between two fighters based on their attack power
    public static void FIGHT(String[] input, ArrayList<Character> Fighters){
        System.out.println("Command: FIGHT");
        if (Character.getNumHeroes() < 1) { //If nobody is currently in the system, then we can't do anything else
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.\n");
        }
        else{
            String name1 = input[1];    //Otherwise, we should set the names of our fighters
            String name2 = input[2];
            Character Fighter1 = new Character();
            Character Fighter2 = new Character();   //Set them to the general Character object 
            
            for (int i = 0; i < Fighters.size(); i++) { //Search through the Fighters arraylist to find each fighter
                if (name1.equals(Fighters.get(i).getName())) {
                    Fighter1 = Fighters.get(i);
                }
                else if (name2.equals(Fighters.get(i).getName())) {
                    Fighter2 = Fighters.get(i);
                }
                
            }    //If either of the Fighters are null by this point, then somebody wasn't found 

            if (Objects.isNull(Fighter1.getName()) && Objects.isNull(Fighter2.getName())) {
                System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.");
                System.out.printf("      %s is not a character currently in the system.\n", name1);
                System.out.printf("      %s is not a character currently in the system.\n", name2);   
            }
            else if (Objects.isNull(Fighter1.getName())) {
                System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.");
                System.out.printf("      %s is not a character currently in the system.\n", name1);
            }   //Print out specialized information about what character is not in the system.
            else if (Objects.isNull(Fighter2.getName())) {
                System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.");
                System.out.printf("      %s is not a character currently in the system.\n", name2);
            } else{

                //If neither of them are null, then print their respective information
                System.out.printf("   %s vs %s\n\n", name1, name2); //Put their names on a billboard to advertise the fight
                System.out.println("   Fighter #1:");
                System.out.println(Fighter1);
                System.out.println("   Fighter #2:");
                System.out.println(Fighter2);
                System.out.println("   Fight Results:");

                //Once they are found, we must now check if one of them is a SuperHV
                if (Fighter1 instanceof SuperHV == false && Fighter2 instanceof SuperHV == true) {   //If one is a SuperHV and the other isn't...   
                    System.out.printf("      %s has no superpowers. Thus, %s wins every time.\n", Fighter1.getName(), Fighter2.getName());
                } else if (Fighter1 instanceof SuperHV == true && Fighter2 instanceof SuperHV == false) {   //The SuperHV wins every time
                    System.out.printf("      %s has no superpowers. Thus, %s wins every time.\n", Fighter2.getName(), Fighter1.getName());

                } else if (Fighter1 instanceof SuperHV && Fighter2 instanceof SuperHV) {    //To find out who wins between two SuperHV's 
                   SuperHV SuperPerson1 = ((SuperHV)Fighter1);
                   SuperHV SuperPerson2 = ((SuperHV)Fighter2);  //Cast them into a SuperHV so that we can access their additional powers 
                   int totalAttack1 = SuperPerson1.getAddPowers() + SuperPerson1.getS().getTotal();
                   int totalAttack2 = SuperPerson2.getAddPowers() + SuperPerson2.getS().getTotal();    //Set totalAttackPower for each fighter
                   
                   System.out.printf("      %s's total attack power: %d\n", Fighter1.getName(), totalAttack1);    //Print their attack powers so the user knows who's about to lose
                   System.out.printf("      %s's total attack power: %d\n", Fighter2.getName(), totalAttack2);
                    if (totalAttack1 > totalAttack2) {  //If Fighter1 has more attack power, then they win
                        System.out.printf("      Winner: %s\n", Fighter1.getName());
                    } else{ //Otherwise, Fighter2 wins 
                        System.out.printf("      Winner: %s\n", Fighter2.getName());
                    }
                }
                
                else {  //In this case, nobody has powers. Simply get their total attack power and whoever has more wins 
                    int totalAttack1 = Fighter1.getS().getTotal();
                    int totalAttack2 = Fighter2.getS().getTotal();

                    System.out.printf("      %s's total attack power: %d\n", Fighter1.getName(), totalAttack1);
                    System.out.printf("      %s's total attack power: %d\n", Fighter2.getName(), totalAttack2);

                    if (totalAttack1 > totalAttack2) {
                        System.out.printf("      Winner: %s\n", Fighter1.getName());
                    } else{
                        System.out.printf("      Winner: %s\n", Fighter2.getName());
                    }
                }                
            }
        }
    }   //End of FIGHT()
    
    // DISPLAYHEROES()
    // Parameters: Character ArrayList Fighters
    // Return Type: Void
    // Description: Print out all of the registered fighters that are heroes
    public static void DISPLAYHEROES(ArrayList<Character> Fighters){
        System.out.println("Command: DISPLAYHEROES");
        if (Character.getNumHeroes() < 1) { //If nobody is registered, nobody should be printed
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{
            for (Character fighter: Fighters) {
                if (fighter.getTeam().equals("Heroes")) {
                    System.out.println("   -----------------------------------------"); //Divide each hero when printing to avoid confusion
                    System.out.println(fighter);
                }
            }
        }  
    }//End of DISPLAYHEROES
    
    // DISPLAYVILLAINS()
    // Parameters: Character ArrayList Fighters
    // Return Type: Void
    // Description: Print out all of the registered fighters that are villains
    public static void DISPLAYVILLAINS(ArrayList<Character> Fighters){
        System.out.println("Command: DISPLAYVILLAINS");
        if (Character.getNumHeroes() < 1) { //If nobody is registered, then nobody can be printed 
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        } else{
            for (Character fighter: Fighters) {
                if (fighter.getTeam().equals("Villains")) {
                    System.out.println("   -----------------------------------------"); //Divide each villain
                    System.out.println(fighter);
                }  
            }   
        }
    }   //End of DISPLAYVILLAINS
    
    // DISPLAYMARVEL()
    // Parameters: Character ArrayList Fighters
    // Return Type: Void
    // Description: Print out all of the registered fighters that are in Marvel
    public static void DISPLAYMARVEL(ArrayList<Character> Fighters){
        System.out.println("Command: DISPLAYMARVEL");
        if (Character.getNumHeroes() < 1) {
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");            
        } else{
            for (Character fighter: Fighters) {
                if (fighter.getUniverse().equals("Marvel")) {
                    System.out.println("   -----------------------------------------"); //Separate each Marvel character
                    System.out.println(fighter);
                }
            }            
        }
    }   //End of DISPLAYMARVEL
    
    // DISPLAYDC()
    // Parameters: Character ArrayList Fighters
    // Return Type: Void
    // Description: Print out all of the registered fighters that are in DC
    public static void DISPLAYDC(ArrayList<Character> Fighters){
        System.out.println("Command: DISPLAYDC");
        if (Character.getNumHeroes() < 1) {
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        } else{
            for (Character fighter: Fighters) {
                if (fighter.getUniverse().equals("DC")) {
                    System.out.println("   -----------------------------------------"); //Separate each DC Character
                    System.out.println(fighter);
                }
            }            
        }
    }   //End of DISPLAYDC
    
    // DISPLAYSTATS()
    // Parameters:  Character ArrayList Fighters
    // Return Type: Void
    // Description: Print out the average statistics for each aspect of stats
    public static void DISPLAYSTATS(ArrayList<Character> Fighters){
        System.out.println("Command: DISPLAYSTATS");    //Initialize average variables  
        int avIntelligence = 0, avStrength = 0, avStamina = 0, avSpeed = 0, avSkill = 0, numSuper = 0, numNPC = 0, numHero = 0, numVillain = 0;
        ArrayList<String> powers = new ArrayList<>();   //Initialize arraylists for the powers
        ArrayList<String> uniquePowers = new ArrayList<>(); //Initialize an arraylist to move all unique powers to 
        
        if (Character.getNumHeroes() < 1) { //If nobody is registered, then nobody can be displayed
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{

            System.out.println("   Marvel Characters"); //This is specifically for marvel heroes
            System.out.println("      Hero Stats:");

                for (int i = 0; i < Fighters.size(); i++) {
                    Character person = Fighters.get(i); //person reprents the specific hero at index i 
                    if (person.getTeam().equals("Heroes") && person.getUniverse().equals("Marvel")) {   //If they are a hero and in the Marvel Universe
                        avIntelligence += person.getS().getIntelligence();  //Grab all of their specific statistic units
                        avStrength += person.getS().getStrength();
                        avStamina += person.getS().getStamina();
                        avSpeed += person.getS().getSpeed();
                        avSkill += person.getS().getSkills();  
                        numHero++;  //Increase the amount of heroes 
                        if (person instanceof SuperHV) {    //If they are an instance of the SuperHV class, then set them to be a SuperHV object
                            SuperHV superPerson = ((SuperHV)person);    
                        for (int j = 0; j < superPerson.getPowers().size(); j++) {
                           powers.add(superPerson.getPowers().get(j)); //Add their powers to the powers arraylist
                        }
                            for (String power: powers) {    //For every power in the powers arraylist
                                if (!uniquePowers.contains(power)) {    //Check if it is unique,
                                    uniquePowers.add(power);    //If it is, add it to the unique powers arraylist
                                }
                            }
                        numSuper++; //Increase the amount of super powered people
                        } else{
                            numNPC++;   //Increase the amoutn of non-powered-characters 
                        }  
                    }
            }   //End of search for Marvel Heroes
                
            System.out.printf("         Average Intelligence: %.2f\n", (double)avIntelligence/numHero); //Print out Marvel hero stats
            System.out.printf("         Average Strength:     %.2f\n", (double)avStrength/numHero);
            System.out.printf("         Average Stamina:      %.2f\n", (double)avStamina/numHero);
            System.out.printf("         Average Speed:        %.2f\n", (double)avSpeed/numHero);
            System.out.printf("         Average Skill:        %.2f\n", (double)avSkill/numHero);
            System.out.printf("      Number of Normal-Person Heroes:    %d\n", numNPC);
            System.out.printf("      Number of Heroes with Superpowers: %d\n", numSuper);
           
            Collections.sort(uniquePowers); //Sort the unique powers arraylist alphabetically
            String pow = uniquePowers.toString();   //Call the toString() method for the array
            pow = pow.substring(1, pow.length()-1); //Get rid of the brackets
            System.out.println("      Aggregate Superpowers:");
            System.out.println(pow);    //Print the powers
            System.out.println("");
            
            powers.removeAll(powers); //Wipe the memory of everything we've worked with thus far 
            uniquePowers.removeAll(uniquePowers);
            pow = "";
            numNPC = 0;
            numSuper = 0;   //Set counters back to 0 as well
            avIntelligence = 0;
            avStrength = 0;
            avStamina = 0;
            avSpeed = 0;
            avSkill = 0;
            numHero = 0;
            
            System.out.println("      Villain Stats:"); //Marvel Villains 
            
                for (int i = 0; i < Fighters.size(); i++) {
                    Character person = Fighters.get(i);
                    if (person.getTeam().equals("Villains") && person.getUniverse().equals("Marvel")) {
                        avIntelligence += person.getS().getIntelligence();
                        avStrength += person.getS().getStrength();
                        avStamina += person.getS().getStamina();
                        avSpeed += person.getS().getSpeed();
                        avSkill += person.getS().getSkills();  
                        numVillain++;
                        if (person instanceof SuperHV) {
                            SuperHV superPerson = ((SuperHV)person);
                        for (int j = 0; j < superPerson.getPowers().size(); j++) {
                           powers.add(superPerson.getPowers().get(j)); 
                        }
                            for (String power: powers) {
                                if (!uniquePowers.contains(power)) {
                                    uniquePowers.add(power);
                                }
                            }
                        numSuper++;
                        } 
                    }
            }   //End of search for Marvel Villains 
                
            System.out.printf("         Average Intelligence: %.2f\n", (double)avIntelligence/numVillain);  //Print out their information
            System.out.printf("         Average Strength:     %.2f\n", (double)avStrength/numVillain);
            System.out.printf("         Average Stamina:      %.2f\n", (double)avStamina/numVillain);
            System.out.printf("         Average Speed:        %.2f\n", (double)avSpeed/numVillain);
            System.out.printf("         Average Skill:        %.2f\n", (double)avSkill/numVillain);
            System.out.printf("      Number of Normal-Person Villains:    %d\n", numNPC);
            System.out.printf("      Number of Villains with Superpowers: %d\n", numSuper);
            
            System.out.println("      Aggregate Superpowers:"); //Set up the printing for the powers
            Collections.sort(uniquePowers);
            pow = uniquePowers.toString();  
            pow = pow.substring(1, pow.length()-1);
            System.out.println(pow);    //Print the powers
            System.out.println("");
            
            boolean isDC = false; //Let's see if there are any DC characters in the system
            for (int i = 0; i < Fighters.size(); i++) { //Loop through ALL characters
                if (Fighters.get(i).getUniverse().equals("DC")) {   //Check that there are DC characters in there
                    isDC = true;    //If there are, then someone is a DC character and we can run the stats for DC 
                }
            }
            
            if (isDC) {
                System.out.println("   DC Characters");
                System.out.println("      Hero Stats:");    //This is for DC heroes
            
                powers.removeAll(powers); //Wipe java's memory
                uniquePowers.removeAll(uniquePowers);
                pow = "";
                numNPC = 0;
                numSuper = 0;   //Set counters back to 0 as well
                avIntelligence = 0;
                avStrength = 0;
                avStamina = 0;
                avSpeed = 0;
                avSkill = 0;
                numVillain = 0;
            
                for (int i = 0; i < Fighters.size(); i++) {
                    Character person = Fighters.get(i);
                    if (person.getTeam().equals("Heroes") && person.getUniverse().equals("DC")) {  //Get their stats
                        avIntelligence += person.getS().getIntelligence();
                        avStrength += person.getS().getStrength();
                        avStamina += person.getS().getStamina();
                        avSpeed += person.getS().getSpeed();
                        avSkill += person.getS().getSkills();  
                        numHero++;
                        if (person instanceof SuperHV) {    //instanceof tells us if an Object is an isntance of superclass
                            SuperHV superPerson = ((SuperHV)person);
                        for (int j = 0; j < superPerson.getPowers().size(); j++) {
                           powers.add(superPerson.getPowers().get(j)); 
                        }
                            for (String power: powers) {
                                if (!uniquePowers.contains(power)) {
                                    uniquePowers.add(power);
                                }
                            }
                        numSuper++;
                        } else{
                            numNPC++;
                        }  
                    }
                }   //End of DC hero search 
                System.out.printf("         Average Intelligence: %.2f\n", (double)avIntelligence/numHero); //Print their stats information 
                System.out.printf("         Average Strength:     %.2f\n", (double)avStrength/numHero);
                System.out.printf("         Average Stamina:      %.2f\n", (double)avStamina/numHero);
                System.out.printf("         Average Speed:        %.2f\n", (double)avSpeed/numHero);
                System.out.printf("         Average Skill:        %.2f\n", (double)avSkill/numHero);
                System.out.printf("      Number of Normal-Person Heroes:    %d\n", numNPC);
                System.out.printf("      Number of Heroes with Superpowers: %d\n", numSuper);
        
                System.out.println("      Aggregate Superpowers:");
                Collections.sort(uniquePowers);
                pow = uniquePowers.toString();
                pow = pow.substring(1, pow.length()-1);
                System.out.println(pow);    //Print their powers 
                System.out.println("");
            
                powers.removeAll(powers); //Wipe the memory of everything
                uniquePowers.removeAll(uniquePowers);
                pow = "";
                numNPC = 0;
                numSuper = 0;   //Set counters back to 0 as well
                avIntelligence = 0;
                avStrength = 0;
                avStamina = 0;
                avSpeed = 0;
                avSkill = 0;
                
                System.out.println("      Villain Stats:"); //DC villains 
            
                for (int i = 0; i < Fighters.size(); i++) {
                    Character person = Fighters.get(i);
                    if (person.getTeam().equals("Villains") && person.getUniverse().equals("DC")) { //Find out their stats 
                        avIntelligence += person.getS().getIntelligence();
                        avStrength += person.getS().getStrength();
                        avStamina += person.getS().getStamina();
                        avSpeed += person.getS().getSpeed();
                        avSkill += person.getS().getSkills();  
                        numVillain++;
                        if (person instanceof SuperHV) {
                            SuperHV superPerson = ((SuperHV)person);
                        for (int j = 0; j < superPerson.getPowers().size(); j++) {
                           powers.add(superPerson.getPowers().get(j)); 
                        }
                            for (String power: powers) {
                                if (!uniquePowers.contains(power)) {
                                    uniquePowers.add(power);
                                }
                            }
                        numSuper++;
                        } else{
                            numNPC++;
                        }  
                    }
                }
                System.out.printf("         Average Intelligence: %.2f\n", (double)avIntelligence/numVillain);  //Print their stats 
                System.out.printf("         Average Strength:     %.2f\n", (double)avStrength/numVillain);
                System.out.printf("         Average Stamina:      %.2f\n", (double)avStamina/numVillain);
                System.out.printf("         Average Speed:        %.2f\n", (double)avSpeed/numVillain);
                System.out.printf("         Average Skill:        %.2f\n", (double)avSkill/numVillain);
                System.out.printf("      Number of Normal-Person Villains:    %d\n", numNPC);
                System.out.printf("      Number of Villains with Superpowers: %d\n", numSuper);
                
            } else{
                System.out.println("   DC Characters"); //If isDC is false, then come here and tell the user that nobody from DC is in here
                System.out.println("      There are currently no DC characters in the system.");
            }
        } 
    }   //End of DISPLAYSTATS()

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Character> Fighters = new ArrayList<>();
        Scanner input = new Scanner(System.in); 
        String[] line;
        OUTER:
         while (true){          //***CONVERT THIS TO A SWITCH-CASE BLOCK***
            line = input.nextLine().split(",");
            switch (line[0]) {
                case "ADDCHARACTER":    //If line[0] is ADDCHARACTER
                    ADDCHARACTER(line, Fighters);
                    break;
                case "SEARCHCHARACTER": //If line[0] is SEARCHCHARACTER
                    SEARCHCHARACTER(line, Fighters);
                    break;
                case "ADDPOWER":    //If line[0] is ADDPOWER
                    ADDPOWER(line, Fighters);
                    break;
                case "FIGHT":   //If line[0] is FIGHT
                    FIGHT(line, Fighters);
                    break;
                case "DISPLAYHEROES": //If line[0] is DISPLAYHEROES
                    DISPLAYHEROES(Fighters);
                    break;
                case "DISPLAYVILLAINS": //If line[0] is DISPLAYVILLAINS
                    DISPLAYVILLAINS(Fighters);
                    break;
                case "DISPLAYMARVEL":   //If line[0] is DISPLAYMARVEL
                    DISPLAYMARVEL(Fighters);
                    break;
                case "DISPLAYDC":   //If line[0] is DISPLAYDC
                    DISPLAYDC(Fighters);
                    break;
                case "DISPLAYSTATS":    //If line[0] is DISPLAYSTATS
                    DISPLAYSTATS(Fighters);
                    break;
                default:
                    //Else, exit the program
                   System.out.println("Goodbye.");
                   break OUTER;    
            }   //End of switch case block
         }  //End of while(true)   
    }   //End of main() 
}   //End of Marvel_vs_DC