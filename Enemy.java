/**
 * This class contains information about enemies, the format for the array of the enemies is the name, health, standard attack damage, charged attack damage, and money dropped by the enemy.
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Enemy {

  public static final String[] BEAR = {
    "the Bear", 
    "30", 
    "5", "10", 
    "10",
    "false"
  };

  public static final String[] BANDITS = {
    "the group of Bandits", 
    "35", 
    "6", "10", 
    "40"
  };
    
  public static final String[] VILLAGE_GUARD = {
    "the Villager Guard", 
    "40", 
    "7", "14", 
    "70"
  };

  public static final String[] DAMIEN = {
    "Damien", 
    "60", 
    "13", "25",
    "90"
  };

  public static final String[] ENRAGED_DAMIEN = {
    "enraged Damien", 
    "150", 
    "22", "50",
    "90"
  };

  public static final String[] POSEIDON = {
    "enraged Poseidon", 
    "175", 
    "12", "40",
    "200"
  };

  public static final String[] SPIRIT = {
    "the Spirit", 
    "70", 
    "0", "0",
    "0"
  };

  public static final String[] SUSSY = {
    "the Impostor", 
    "70",
    "10", "15",
    "50"
  };

  public static final String[] CULT = {
    "the Cult of the Sacrificed", 
    "90",
    "13", "22",
    "190"
  };

  public static final String[] ANCIENT_GUARDS = {
    "the Defenders of the Ancient", // :P
    "140",
    "16", "27",
    "200"
  };

  public static final String[] RATS = {
    "the group of Rats", 
    "40", 
    "5", "15", 
    "10"
  };

  public static final String[] DRAGON = {
    "the Dragon", 
    "150",
    "17", "60",
    "160"
  };

  public static final String[] SOLDIERS = {
    "the group of Soldiers", 
    "200", 
    "13", "25",
    "140"
    };

  public static final String[] SPIDERS = {
    "the group of Spiders", 
    "300", 
    "20", "40",
    "110"
    };

  public static final String[] IMMORTAL = {
    "immortal Damien", 
    "500",
    "30", "85",
    "0" // no money because he is the final boss- we cant continue this save file after defeating the final boss
    };
  
}