// Here is where the stats of the characters will be handled and the winner will be determined for the fights
public class Stats {
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;
    
    public Stats(){
        
    }
    
    public Stats(int intelligence, int strength, int stamina, int speed, int skills){
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
        
    }
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }

    
    public int getTotal(){  //Add up all of the stats points 
        int totalPowers = 0;
        totalPowers += intelligence;
        totalPowers += stamina;
        totalPowers += strength;
        totalPowers += speed;
        totalPowers += skills;
        return totalPowers;   
    }
    @Override
    public String toString(){
        String information = "";
        information += String.format("   Stats:        Intelligence: %d\n", intelligence);
        information += String.format("                 Strength:     %d\n", strength);
        information += String.format("                 Stamina:      %d\n", stamina);
        information += String.format("                 Speed:        %d\n", speed);
        information += String.format("                 Skills:       %d\n", skills);
        return information; 
    }
    
}
