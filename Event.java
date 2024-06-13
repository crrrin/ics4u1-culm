/**
 * This class contains events that will happen during the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

public abstract class Event {
  protected Player player;

  public Event(Player player) {
    this.player = player;
  }

  public abstract boolean run();
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event1 extends Event {          

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event1(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user encounters a bear
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "the Bear", 30, new int[] {5, 10});
        break;

      case 2:
        Input.lore("You run away, but trip on a branch as you run away and drop your weapon.");
        Input.lore("You can now only use your fists. " + Fists.description());
        this.player.setWeapon(new Fists());
        break;

      case 3:
        Input.lore("You approach the bear calmly and it slowly walks away. As you explore the area, you find a super potion on the ground, likely dropped by another traveler.");
        this.player.setBigHeals(this.player.getBigHeals() + 1);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event2 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event2(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user encounters bandits
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false; //bandits WE SHOULD CHANGE THE JAVADOCS FOR EACH EVENT TO ACTUALLY DESCRIBE THE EVENT
    System.out.println("You were navigating the rivers but a group of bandits spot you, demanding your money. What do you do?\n1. Fight the bandits\n2. Run away\n3. Give the bandits your money\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "the Bandits", 35, new int[] {6, 10});
        break;

      case 2:
        Input.lore("You cowardly run away, accidently dropping more money than the bandits asked for and losing some dignity.");
        this.player.setMoney(this.player.getMoney() - 100);
        break;

      case 3:
        Input.lore("You gave the bandits $50. They leave you alone.");
        this.player.setMoney(this.player.getMoney() - 50);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event3 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event3(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user reaches a village
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false; //VILLAGE SCENARIO
    System.out.println("It is the evening, you are tired. You find a small village and move towards it. What do you do?\n1. Sneak in and scavenge for food\n2. Ask a villager to let you stay the night\n3. Ignore the village and walk away.\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You got caught by one of the guards! They attack you.");
        leave = Battle.battleInstance(this.player, "the Villager Guard", 350, new int[] {7, 14}); 
        break;

      case 2:
        Input.lore("A friendly villager welcomes you and offers their hospitality. You stay the night there and feel refreshed in the morning. You suspect that the villager healed some of your injuries in the night.");
        this.player.setHealth(this.player.getHealth() + 10);
        break;

      case 3:
        Input.lore("You continue walking towards your destination. You fainted from your fatigue, and injured yourself in the process.");
        this.player.setHealth(this.player.getHealth() - 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event4 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event4(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user meets a man named Damien
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are famished, you find yourself in front of a mysterious, lone house. The homeowner greets you and introduces himself. His name is Damien Bartholomew Burnell-Jones Burthwright. He invites you to have a meal with him. What do you do?\n1. Accept his offer\n2. Run away\n3. Insult him\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1: //TODO for loop with string array of dialogue
        Input.lore("You accept his offer and he invites you to sit down at his table. He serves you a meat pie.");
        Input.lore("You: Exquisite. This reminds me of the famous pork pie we have at home.");
        Input.lore("Damien: Thank you good sir! It is a secret recipe.");
        Input.lore("You: You have to tell me how to make it sir.");
        Input.lore("Damien: You would like to know? Well, I am running low on meat.");
        Input.lore("Damien leads you into a room, and you leave your equipment outside. It smells horrible in there.");
        Input.lore("Damien: Sit down, I will show you the meat I use.");
        Input.lore("You sit down and Damien gets his cleaver. Instead of going to his storage, he motions towards you. You begin to realize what meat you just ate. He smiles and chuckles.");
        Input.lore("Damien: Looks like I will be eating good tonight");
        Input.lore("You're not ready to die. You quickly get up from the chair and kick him, sending him into the wall. He drops his cleaver. You make a dash out the door and grab your items.\nYou prepare yourself to fight to the death.");
        
        leave = Battle.battleInstance(this.player, "Damien", 60, new int[] {13, 25});
        break;

      case 2:
        Input.lore("You run away, he starts chasing you with a cleaver. He manages to catch up to you. You must fight him.");
         leave = Battle.battleInstance(this.player, "Damien", 60, new int[] {13, 25});
        break;

      case 3:
        Input.lore("Damien: Hello sir, would you be interested in my food?");
        Input.lore("You: No, I don't want your crusty, goopy, pizza sub. Eating your \"food\" is an insult to my stomach.");
        Input.lore("Damien is taken aback. He gets enraged and charges at you.");
        leave = Battle.battleInstance(this.player, "Enraged Damien", 150, new int[] {22, 50});
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event5 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event5(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user encounters a wishing well
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You walk into a village and find yourself in front of a wishing well. What do you do?\n1. Offer all your money\n2. Ignore the well\n3. Throw your garbage in\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You throw in all your money, you get nothing in return.");
        this.player.setMoney(0);
        break;

      case 2:
        Input.lore("You ignore the well and walk away. Mysteriously, some of your money dissapears.");
        this.player.setMoney((int) (this.player.getMoney() * 0.8));
        break;

      case 3:
        Input.lore("You throw a rotten piece of meat in the well. An enraged Poseidon comes flying out of the well and attacks you.");
        Battle.battleInstance(this.player, "Enraged Poseidon", 175, new int[] {12, 40});
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event6 extends Event {

  /**
   * Creates an event for a given player
   * 
   * @param player The player to be used
   */
  public Event6(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user encounters a strange statue
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You find a strange looking statue, it reads \"The One Who Sacrificed\". The ground seems soft. You suspect there is hidden treasure under the statue. What do you do?\n1. Dig up the ground\n2. Worship the statue\n3. Leave money at the statue and walk away\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You dig up the ground in search for treasure. You find a wooden box and open it. Inside is a spirit of the Sacrificed, he is enraged that his rest has been disturbed. He flails at you, but phases through you. You decide to fight it.");
        leave = Battle.battleInstance(this.player, "Spirit", 70, new int[] {0, 0});
        break;

      case 2:
        Input.lore("You bow down and worship the statue. Money comes flying out of the statue's mouth");
        this.player.setMoney(this.player.getMoney() + 200);
        break;

      case 3:
        Input.lore("You leave some money at the statue and walk away. When you turn back to look, you notice that the money is gone.");
        this.player.setMoney(this.player.getMoney() - 50);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event7 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event7(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user finds a monastery
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("After a long trek in the wilderness, you discover a hidden monastery. What do you do?\n1. Talk to the monks\n2. Sneak into the monastery\n3. Walk around it\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You approach the monks, and they welcome you with open arms. As you talk with them, they convince you to forget about your quest and your other worldly concerns, and to become a monk with them instead. You become a monk and live a long and happy life. Eventually, you die of old age.");
        this.player.setHealth(0);
        leave = true;
        break;

      case 2:
        System.out.println("You sneak past the monks in the shadows and enter the monastery. You find a room filled with broadswords, and you could take one if you want to. " + Broadsword.description() + "\nDo you take the sword?\n1. Yes\n2. No");
        int pickup = Input.intCheck(1, 2);
        if (pickup == 1) {
          this.player.setWeapon(new Broadsword());
        }
        break;

      case 3:
        Input.lore("You walk around the monastery, and you run into a monk. However, he does not look like the other monks. Quickly, you realize that he is not really a monk, but rather an impostor, trying to blend in. You call him out; furious, he attacks you.");
        leave = Battle.battleInstance(this.player, "the Impostor", 100, new int[] {3, 5});
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event8 extends Event {

  /**
   * Creates an event for a given player
   * 
   * @param player The player to be used
   */
  public Event8(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user finds a fountain
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You find an abandoned church, you go inside and find a fountain running with a red liquid. What do you do?\n1. Drink a little bit of it\n2. Drink a lot of it\n3. Ignore the fountain\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You drink a little bit of the liquid, and you feel better.");
        this.player.setHealth(this.player.getHealth() + 30); //TODO TRY INCREASE MAX HEALTH?
        break;

      case 2:
        Input.lore("You drink a lot of the liquid, you feel a little sick.");
        this.player.setHealth(this.player.getHealth() - 20);
        break;

      case 3:
        Input.lore("You ignore the fountain and walk away. You slip on a puddle of the liquid, and injure yourself when you fall. You wish you had drunk some of the liquid now.");
        this.player.setHealth(this.player.getHealth() - 10);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event9 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event9(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user finds a woman in a cave
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You find a cave and you enter it. Inside is a mysterious woman. What do you do?\n1. Call out to her\n2. Sneakily approach her\n3. Attack her\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You call out to her, but she doesn't respond.\nYou begin to approach her, repeatedly calling out to her. She doesn't move or respond.\nYou begin to feel something bad in your gut.\nYou feel a sharp pain in your stomach.\nYou collapse to the ground, fainting.");
        this.player.setHealth(this.player.getHealth() - 40);
        break;

      case 2:
        Input.lore("You slowly walk towards her. She doesn't move.\nAs you inch towards her, you hear a deafening noise in your ears. You get scared and run away, dropping some money in the process.");
        this.player.setMoney(this.player.getMoney() - 100);
        break;

      case 3:
        Input.lore("You ready your weapon and make to attack the woman. As you approach her, she turns around.\nYou freeze, you try to ready your weapon but your hands are frozen.\nShe screams in agony, scaring you.\nYou drop your weapon and run away as fast as possible.");
        this.player.setWeapon(new Fists());
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event10 extends Event {
  /**
   * Creates an event for a given player
   * 
   * @param player The player to be used
   */
  public Event10(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user encounters an allied kingdom
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You find yourself in a castle of an allied kingdom. What do you do?\n1. Visit the restaurant\n2. Go to the tavern\n3. Go to the town square\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You visit the restaurant and you order some rabbit stew and fresh bread. You eat it and feel full and refreshed.");
        this.player.setHealth(this.player.getHealth() + 50);
        break;

      case 2:
        Input.lore("You visit the tavern and order a few beers. You get drunk and pass out, losing your weapon.");
        this.player.setHealth(this.player.getHealth() - 20);
        this.player.setWeapon(new Fists());
        break;

      case 3:
        Input.lore("You go to the town square. The villagers recognize you as the most famous knight in the land, sent on a dangerous mission.\nThey celebrate your visit and shower you with money and some potions.");
        this.player.setMoney(this.player.getMoney() + 175);
        this.player.setSmallHeals(this.player.getSmallHeals() + 1);
        this.player.setBigHeals(this.player.getBigHeals() + 1);
        
        if (this.player.getWeapon().toString().equals("Fists")) {
          Input.lore("They see you are missing a weapon and give you a new sword forged by their finest blacksmiths");
          this.player.setWeapon(new Sword());
        }
        break;
        
      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event11 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event11(Player player) {
    super(player);
  }

  /**
   * Executes an event where the user sees a mysterious light
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("It is night time, you see a mysterious light in the distance. What do you do?\n1. Go to the light\n2. Sneak around and investigate\n3. Ignore the light\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        Input.lore("You go to the light. You see a big bonfire and a group of people doing a ritual. They sacrifice a person into the fire. They spot you and run towards you. They are yelling that you are the next to be sacrificed.");
        leave = Battle.battleInstance(this.player, "the Cult of the Sacrified", 150, new int[] {20, 30});
        break;

      case 2:
        Input.lore("You sneak around the bushes trying to observe. You accidently bump into a mysterious person.");
        Input.lore("Mysterious person (quiet voice): Shhhh... it's a cult, they're doing a ritual, do not make much noise or sudden movement.");
        Input.lore("You (quiet voice): What is this? Who are they?");
        Input.lore("Mysterious person (quiet voice): They are the Cult of the Sacrificed, an ancient cult. They sacrifice people into the fire, which adds years to their leader's life. Their leader has been alive for over a thousand years.");
        Input.lore("You (quiet voice): So who are you?");
        Input.lore("Mysterious person (quiet voice): I am here to take down the leader, they sacrificed my entire family. I must take revenge.");
        Input.lore("You (quiet voice): What are you waiting for then? Let's go!");
        Input.lore("Mysterious person (quiet voice): Not right now. \nI have this feeling they know we are here, we have to relocate.");
        Input.lore("You and the mysterious person quietly move on top of a hill, gaining the high ground. The mysterious person hands you an his spare crossbow."); 
        Input.lore("You and the mysterious person take aim, trying to shoot the leader, however both of you miss and accidently shoot some cult members.\nThe cult members are alarmed and begin to look out for where the bolts are coming from, they quickly spot you."); 
        Input.lore("Mysterious person: SHOOT! They've spotted us! MOVE! MOVE! MOVE!"); 
        Input.lore("You panic and drop the crossbow, but there's no time to pick it up. The cult members sprint towards you. You ready yourself to fight."); 
        leave = Battle.battleInstance(this.player, "the Cult of the Sacrificed", 90, new int[] {15, 20});
        if (leave) { 
          return leave;
        }
        Input.lore("All the cult members except the leader are gone, but the leader will not back down.");
        leave = Battle.battleInstance(this.player, "the Leader of the Sacrificed", 120, new int[] {30, 45}); 
        Input.lore("The mysterious person deals the final blow to the leader. Unfortunately, the leader managed to stab him before dying. You never find out your friend's identity, but you will never forget his bravery.");
        break;

      case 3:
        Input.lore("You ignore the light and walk away, but you accidentally step on a branch and make a loud noise. You hear what sounds like multiple people getting up, and you don't wait to find out what is happening. You sprint into the woods, only to fall into a bear trap.");
        Input.lore("Soon, a group of people wearing strange clothes find you, and carry you back to a bonfire. You are unable to escape. They declare that you will be the next to be sacrificed. They throw you into the fire, and you die.");
        this.player.setHealth(0);
        leave = true;
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event12 extends Event {

  /**
   * Creates an event for a given player
   * 
   * @param player The player to be used
   */
  public Event12(Player player) {
    super(player);
  }

  /**
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() { 
    boolean leave = false; 
    System.out.println("You approach a large mountain obstructing your path, but you see a path leading into the mountain itself.\nInside you find an ancient underground city, with an altar at its centre. What do you do?\n1. Go to the altar\n2. Go to the city's only cemetary\n3. Explore deeper within the city\n4. Quit");
    int choice = Input.intCheck(1, 4); //yeah i know this is a lot of code but it works so i'm not gonna change it <-- ai comment
    
    switch (choice) {
      case 1:
        Input.lore("As you move up the steps towards the altar, you notice dead bodies covered in armour lying on the ground. You start hearing an ominous sound.\nYou turn around and notice the bodies slowly getting up. The guards of the city have risen from the dead, and they start attacking you."); 
        leave = Battle.battleInstance(this.player, "the Ancient Guards", 65, new int[] {14, 28}); 
        break;

      case 2:
        Input.lore("You move towards the cemetery. You decide to check out the old tombstones, but one of them appears to have no name on it. However, as you approach it, you notice a some water leaking out of it.\nYou touch it, and feel strangely strong, as if the water is healing you."); 
        this.player.setHealth(this.player.getHealth() + 15); 
        break;

      case 3:
        Input.lore("Your curiosity leads you deeper into the city. You walk across old abandoned homes and find an old trapdoor. You open it and a lot of rats start coming out.");
        leave = Battle.battleInstance(this.player, "the Rats", 30, new int[] {7, 14});
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}