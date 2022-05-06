# MARVEL_vs_DC

This is a fight simulator between characters of the Marvel and DC universes. This method demonstrates the understanding of polymorphism and inheritance using Java. There are ten user options. FIGHT, ADDCHARACTER, SEARCHCHARACTER, ADDPOWER, DISPLAYSTATS, DISPLAYHEROES, DISPLAYVILLAINS, DISPLAYMARVEL, DISPLAYDC, and QUIT. 

****Note there is no exception handling in this program. Be sure to input everything as specified here.****

FIGHT - On one line, first type "FIGHT" followed by a comma with the two characters you wish to fight.

ADDCHARACTER - On one line, first type "ADDCHARACTER," followed by the following characteristics separated by commas:
    1. Name of the Character (Black Widow)
    2. The team of that character (i.e. Heroes or Villains)
    3. The universe of that character (i.e. Marvel or DC)
    4. The homeplanet of that character (i.e. Earth)
    5-10: The intelligence, strength, stamina, speed, and skill
  ****If the character is a superhero or villain, then we handle this differently****
    This is the notation for a superhv(SuperHero or Villain)
    1. superhv
    2. Name of the character (Hulk)
    3. The team of that character (Heroes or Villains)
    4. The universe of that character (i.e. Marvel or DC)
    5. The homeplanet of that character (i.e. Planet X) 
    6-11: The intelligence, strength, stamina, speed, and skill 
    After this, you list the superpowers of this individual separated by commas
    
  Example: 
  npc(Non-Powered Character) - "ADDCHARACTER,Black Widow,Heroes,Marvel,Earth,7,4,4,5,10"
  superhv - "ADDCHARACTER,superhv,Hulk,Heroes,Marvel,Earth,1,8,8,4,3,Superhuman Strength" 
    
SEARCHCHARACTER - Find the character in the system

  Example: "SEARCHCHARACTER,Tony Stark"
  
ADDPOWER - Add power to an individual that is ALREADY superpowered
    1. ADDPOWER
    2. The name of the character
    3. The super power you want to add 
  Example: "ADDPOWER,The Flash, Superhuman Strength"
  
FIGHT - Make two characters fight. This adds up all of their stats and whoever has the most wins. 
    1. FIGHT
    2. The name of fighter 1
    3. The name of fighter 2
  Example: "FIGHT,Captain Marvel,Thanos"
  
DISPLAYHEROES - Displays all heroes

DISPLAYVILLAINS - Displays all villains

DISPLAYMARVEL - Displays all Marvel characters 

DISPLAYDC - Displays all DC characters

DISPLAYSTATS - Displays stats for all heroes and villains of both Marvel and DC universes 

QUIT - Exit the program.
  
  
  
