/**
 * Abstract class that runs an event during the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
public abstract class Event {
  protected Player player;

  /**
   * Creates an event for a given player
   * @param player The player playing the game
   */
  public Event(Player player) {
    this.player = player;
  }

  /**
   * Executes an event
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  public abstract boolean run();
}

/**
 * Object containing the first event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player encounters a bear
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You are walking through a forest and you see a wild bear. What do you do?\n\n" + 
      "1. Attack the bear\n" + 
      "2. Run away\n" + 
      "3. Calmly approach the bear\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, Enemy.BEAR);
        break;

      case 2:
        GameIO.lore("You run away, but trip on a branch as you run away and drop your weapon.");
        GameIO.lore("You can now only use your fists. ");
        
        this.player.setWeapon(new Fists());
        
        GameIO.lore(Fists.description());
        GameIO.lore("You continue on your journey.");
        break;

      case 3:
        GameIO.lore("You approach the bear calmly and it slowly walks away. As you explore the area, you find a super potion on the ground, likely dropped by another traveler.");
        
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
 * Object containing the second event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player encounters bandits
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You were navigating the rivers but a group of bandits spot you, demanding your money. What do you do?\n\n" + 
      "1. Fight the bandits\n" + 
      "2. Run away\n" + 
      "3. Give the bandits your money\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, Enemy.BANDITS);
        break;

      case 2:
        GameIO.lore("You cowardly run away, accidently dropping some money and losing some dignity.");
        
        this.player.setMoney(this.player.getMoney() - 100);
        break;

      case 3:
        //runs a battle instead if player has less than $50
        if (this.player.getMoney() < 50) {
          GameIO.lore("The bandits laugh at your pathetic lack of money. Then they attack.");
          leave = Battle.battleInstance(this.player, Enemy.BANDITS);
        }

        //gives bandits $50
        else {
          GameIO.lore("You give the bandits $50. They leave you alone.");
          this.player.setMoney(this.player.getMoney() - 50);
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
 * Object containing the third event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player reaches a village
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "It is the evening, you are tired. You find a small village and move towards it. What do you do?\n\n" + 
      "1. Sneak in and scavenge for food\n" + 
      "2. Ask a villager to let you stay the night\n" + 
      "3. Ignore the village and walk away.\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You got caught by one of the guards! They attack you.");
        
        leave = Battle.battleInstance(this.player, Enemy.VILLAGE_GUARD);
        break;

      case 2:
        GameIO.lore("A friendly villager welcomes you and offers their hospitality. You stay the night there and feel refreshed in the morning. You suspect that the villager healed some of your injuries in the night.");
        
        this.player.setHealth(this.player.getHealth() + 10);
        break;

      case 3:
        GameIO.lore("You continue walking towards your destination. You fainted from your fatigue, and injured yourself in the process.");
        
        this.player.setHealth(this.player.getHealth() - 20);

        //checks if player died
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
 * Object containing the fourth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player discovers a lone house and meets a man named Damien
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You are famished, you find yourself in front of a mysterious, lone house. The homeowner greets you and introduces himself. His name is Damien Bartholomew Burnell-Jones Burthwright. He invites you to have a meal with him. What do you do?\n\n" + 
      "1. Accept his offer\n" + 
      "2. Run away\n" + 
      "3. Insult him\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You accept his offer and he invites you to sit down at his table. He serves you a meat pie.");
        GameIO.lore("You: Exquisite. This reminds me of the famous pork pie we have at home.");
        GameIO.lore("Damien: Thank you good sir! It is a secret recipe.");
        GameIO.lore("You: You have to tell me how to make it sir.");
        GameIO.lore("Damien: You would like to know? Well, I am running low on meat.");
        GameIO.lore("Damien leads you into a room, and you leave your equipment outside. It smells horrible in there.");
        GameIO.lore("Damien: Sit down, I will show you the meat I use.");
        GameIO.lore("You sit down and Damien gets his cleaver. Instead of going to his storage, he motions towards you. You begin to realize what meat you just ate. He smiles and chuckles.");
        GameIO.lore("Damien: Looks like I will be eating good tonight!");
        GameIO.lore(
          "You're not ready to die. You quickly get up from the chair and kick him, sending him into the wall. He drops his cleaver. You make a dash out the door and grab your items.\n" + 
          "You prepare yourself to fight to the death.");
        
        leave = Battle.battleInstance(this.player, Enemy.DAMIEN);
        break;

      case 2:
        GameIO.lore("You run away, he starts chasing you with a cleaver. He manages to catch up to you. You must fight him.");
        
        leave = Battle.battleInstance(this.player, Enemy.DAMIEN);
        break;

      case 3:
        GameIO.lore("Damien: Hello sir, would you be interested in my food?");
        GameIO.lore("You: No, I don't want your crusty, goopy, pizza sub. Eating your \"food\" is an insult to my stomach.");
        GameIO.lore("Damien is taken aback. He gets enraged and charges at you.");
        
        leave = Battle.battleInstance(this.player, Enemy.ENRAGED_DAMIEN);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * Object containing the fifth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player encounters a wishing well
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You walk into a village and find yourself in front of a wishing well. What do you do?\n\n" + 
      "1. Offer all your money\n" + 
      "2. Ignore the well\n" + 
      "3. Throw your garbage in\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You throw in all your money, you get nothing in return.");
        
        this.player.setMoney(0);
        break;

      case 2:
        GameIO.lore("You ignore the well and walk away. Mysteriously, some of your money dissapears.");
        
        this.player.setMoney((int) (this.player.getMoney() * 0.8));
        break;

      case 3:
        GameIO.lore("You throw a rotten piece of meat in the well. An enraged Poseidon comes flying out of the well and attacks you.");
        
        leave = Battle.battleInstance(this.player, Enemy.POSEIDON);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * Object containing the sixth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Event6 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event6(Player player) {
    super(player);
  }

  /**
   * Executes an event where the player encounters a strange statue
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You find a strange looking statue, it reads \"The One Who Sacrificed\". The ground seems soft. You suspect there is hidden treasure under the statue. What do you do?\n\n" + 
      "1. Dig up the ground\n" + 
      "2. Worship the statue\n" + 
      "3. Leave money at the statue and walk away\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You dig up the ground in search for treasure. You find a wooden box and open it. Inside is a spirit of the Sacrificed, he is enraged that his rest has been disturbed. He flails at you, but phases through you. You decide to fight it.");
        
        leave = Battle.battleInstance(this.player, Enemy.SPIRIT);
        break;

      case 2:
        GameIO.lore("You bow down and worship the statue. Money comes flying out of the statue's mouth.");
        
        this.player.setMoney(this.player.getMoney() + 200);
        break;

      case 3:

        //gives player money instead if they don't have $50
        if (this.player.getMoney() < 50) {
          GameIO.lore("The statue refuses to accept your money. It must realize that it is a bad financial decision for you. Instead, it showers you with some money.");
          this.player.setMoney(this.player.getMoney() + 50);
        }

        //takes $50 from player
        else {
          GameIO.lore("You leave some money at the statue and walk away. When you turn back to look, you notice that the money is gone.");
          this.player.setMoney(this.player.getMoney() - 50);
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
 * Object containing the seventh event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player finds a monastery
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "After a long trek in the wilderness, you discover a hidden monastery. What do you do?\n\n" + 
      "1. Talk to the monks\n" + 
      "2. Sneak into the monastery\n" + 
      "3. Walk around it\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You approach the monks, and they welcome you with open arms. As you talk with them, they convince you to forget about your quest and your other worldly concerns, and to become a monk with them instead. You become a monk and live a long and happy life. Eventually, you die of old age.");
        
        this.player.setHealth(0);
        leave = true;
        break;

      case 2:
        System.out.println(
          "You sneak past the monks in the shadows and enter the monastery. You find a room filled with broadswords, and you could take one if you want to. " + Broadsword.description() + "\n" + 
          "Do you take the broadsword?\n" + 
          "1. Yes\n" + 
          "2. No");
        int pickup = GameIO.intCheck(1, 2);

        //player wants broadsword
        if (pickup == 1) {
          this.player.setWeapon(new Broadsword());
        }
        break;

      case 3:
        GameIO.lore("You walk around the monastery, and you run into a monk. However, he does not look like the other monks. Quickly, you realize that he is not really a monk, but rather an impostor, trying to blend in. You call him out; furious, he attacks you.");
        
        leave = Battle.battleInstance(this.player, Enemy.SUSSY);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * Object containing the eighth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Event8 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event8(Player player) {
    super(player);
  }

  /**
   * Executes an event where the player finds a fountain in an abandoned church
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You find an abandoned church, you go inside and find a fountain running with a red liquid. What do you do?\n\n" + 
      "1. Drink a little bit of it\n" + 
      "2. Drink a lot of it\n" + 
      "3. Ignore the fountain\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You drink a little bit of the liquid, and you feel better.");
        
        this.player.setHealth(this.player.getHealth() + 30);
        break;

      case 2:
        GameIO.lore("You drink a lot of the liquid, you feel a little sick.");
        
        this.player.setHealth(this.player.getHealth() - 20);

        //checks if player died
        if (this.player.getHealth() == 0) {
          leave = true;
        }
        break;

      case 3:
        GameIO.lore("You ignore the fountain and walk away. You slip on a puddle of the liquid, and injure yourself when you fall. You wish you had drunk some of the liquid now.");
        
        this.player.setHealth(this.player.getHealth() - 10);

        //checks if player died
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
 * Object containing the ninth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player finds a woman in a cave
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You find a cave and you enter it. Inside is a mysterious woman. What do you do?\n\n" + 
      "1. Call out to her\n" + 
      "2. Sneakily approach her\n" + 
      "3. Attack her\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore(
          "You call out to her, but she doesn't respond.\n" + 
          "You begin to approach her, repeatedly calling out to her. She doesn't move or respond.\n" + 
          "You begin to feel something bad in your gut.\nYou feel a sharp pain in your stomach.\n" + 
          "You collapse to the ground, fainting.");
        
        this.player.setHealth(this.player.getHealth() - 40);

        //checks if player died
        if (this.player.getHealth() == 0) {
          leave = true;
        }
        break;

      case 2:
        GameIO.lore(
          "You slowly walk towards her. She doesn't move.\n" + 
          "As you inch towards her, you hear a deafening noise in your ears. You get scared and run away, dropping some money in the process.");
        
        this.player.setMoney(this.player.getMoney() - 100);
        break;

      case 3:
        GameIO.lore(
          "You ready your weapon and make to attack the woman. As you approach her, she turns around.\n" + 
          "You freeze, you try to ready your weapon but your hands are frozen.\n" + 
          "She screams in agony, scaring you.\n" + 
          "You drop your weapon and run away as fast as possible.");
        GameIO.lore("You can now only use your fists in battle.");
        
        this.player.setWeapon(new Fists());
        
        GameIO.lore(Fists.description());
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}

/**
 * Object containing the tenth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Event10 extends Event {
  
  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event10(Player player) {
    super(player);
  }

  /**
   * Executes an event where the player encounters an allied kingdom
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "You find yourself in a castle of an allied kingdom. What do you do?\n\n" + 
      "1. Visit the restaurant\n" + 
      "2. Go to the tavern\n" + 
      "3. Go to the town square\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You visit the restaurant and you order some rabbit stew and fresh bread. You eat it and feel full and refreshed.");
        
        this.player.setHealth(this.player.getHealth() + 50);
        break;

      case 2:
        GameIO.lore("You visit the tavern and order a few beers. You get drunk and pass out.");
        GameIO.lore("You can now only use your fists in battle.");
        
        this.player.setHealth(this.player.getHealth() - 20);

        //checks if player died
        if (this.player.getHealth() == 0) {
          leave = true;
        }
        break;

      case 3:
        GameIO.lore(
          "You go to the town square. The villagers recognize you as the most famous knight in the land, sent on a dangerous mission.\n" + 
          "They celebrate your visit and shower you with money and some potions.");
        
        this.player.setMoney(this.player.getMoney() + 225);
        this.player.setSmallHeals(this.player.getSmallHeals() + 2);
        this.player.setBigHeals(this.player.getBigHeals() + 2);

        //if the player has no weapon, the player gets a sword
        if (this.player.getWeapon().toString().equals("Fists")) {
          GameIO.lore("They see you are missing a weapon and give you a new sword forged by their finest blacksmiths");
          
          this.player.setWeapon(new Sword());
          
          GameIO.lore(Sword.description());
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
 * Object containing the eleventh event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Executes an event where the player sees a mysterious light
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println(
      "It is night time, you see a mysterious light in the distance. What do you do?\n\n" + 
      "1. Go to the light\n" + 
      "2. Sneak around and investigate\n" + 
      "3. Ignore the light\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore("You go to the light. You see a big bonfire and a group of people doing a ritual. They sacrifice a person into the fire. They spot you and run towards you. They are yelling that you are the next to be sacrificed.");
        
        leave = Battle.battleInstance(this.player, Enemy.CULT);
        break;

      case 2:
        GameIO.lore("You sneak around the bushes trying to observe. You accidently bump into a mysterious person.");
        GameIO.lore("Mysterious person (quiet voice): Shhhh... it's a cult, they're doing a ritual, do not make much noise or sudden movement.");
        GameIO.lore("You (quiet voice): What is this? Who are they?");
        GameIO.lore("Mysterious person (quiet voice): They are the Cult of the Sacrificed, an ancient cult. They sacrifice people into the fire, which adds years to their leader's life. Their leader has been alive for over a thousand years.");
        GameIO.lore("You (quiet voice): So who are you?");
        GameIO.lore("Mysterious person (quiet voice): I am here to take down the leader, they sacrificed my entire family. I must take revenge.");
        GameIO.lore("You (quiet voice): What are you waiting for then? Let's go!");
        GameIO.lore(
          "Mysterious person (quiet voice): Not right now.\n" + 
          "I have this feeling they know we are here, we have to relocate.");
        GameIO.lore("You and the mysterious person quietly move on top of a hill, gaining the high ground. The mysterious person hands you his spare crossbow."); 
        GameIO.lore(
          "You and the mysterious person take aim, trying to shoot the leader, however both of you miss and accidently shoot some cult members instead.\n" + 
          "The cult members are alarmed and begin to look out for where the bolts are coming from, they quickly spot you."); 
        GameIO.lore("Mysterious person: SHOOT! They've spotted us! MOVE! MOVE! MOVE!"); 
        GameIO.lore("You panic and drop the crossbow, but there's no time to pick it up. The cult members sprint towards you. You ready yourself to fight."); 
        
        leave = Battle.battleInstance(this.player, Enemy.CULT); //first half of battle

        //if player dies in first battle, immediately returns
        if (leave) { 
          return leave;
        }
        
        GameIO.lore("All the cult members except the leader are gone, but the leader will not back down.");
        
        leave = Battle.battleInstance(this.player, Enemy.CULT_LEADER); //second half of battle

        //if player dies in second battle, immediately returns
        if (leave) { 
          return leave;
        }
        
        GameIO.lore("The mysterious person deals the final blow to the leader. Unfortunately, the leader managed to stab him before dying. You never find out your friend's identity, but you will never forget his bravery.");
        break;

      case 3:
        GameIO.lore("You ignore the light and walk away, but you accidentally step on a branch and make a loud noise. You hear what sounds like multiple people getting up, and you don't wait to find out what is happening. You sprint into the woods, only to fall into a bear trap.");
        GameIO.lore("Soon, a group of people wearing strange clothes find you, and carry you back to a bonfire. You are unable to escape. They declare that you will be the next to be sacrificed. They throw you into the fire, and you die.");
        
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
 * Object containing the twelfth event of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Event12 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event12(Player player) {
    super(player);
  }

  /**
   * Executes the event where the player discovers an ancient underground city
   * @return Returns true if the player wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() { 
    boolean leave = false; 
    System.out.println(
      "You approach a large mountain obstructing your path, but you see a path leading into the mountain itself.\n" + 
      "Inside you find an ancient underground city, with an altar at its centre. What do you do?\n\n" + 
      "1. Go to the altar\n" + 
      "2. Go to the city's only cemetary\n" + 
      "3. Explore deeper within the city\n" + 
      "4. Quit\n");
    int choice = GameIO.intCheck(1, 4);

    //runs choice
    switch (choice) {
      case 1:
        GameIO.lore(
          "As you move up the steps towards the altar, you notice dead bodies covered in armour lying on the ground. You start hearing an ominous sound.\n" + 
          "You turn around and notice the bodies slowly getting up. The guards of the city have risen from the dead, and they start attacking you."); 
        
        leave = Battle.battleInstance(this.player, Enemy.ANCIENT_GUARDS);
        break;

      case 2:
        GameIO.lore(
          "You move towards the cemetery. You decide to check out the old tombstones, but one of them appears to have no name on it. However, as you approach it, you notice a some water leaking out of it.\n" + 
          "You touch it, and feel strangely strong, as if the water is healing you."); 
        
        this.player.setHealth(this.player.getHealth() + 15); 
        break;

      case 3:
        GameIO.lore("Your curiosity leads you deeper into the city. You walk across old abandoned homes and find an old trapdoor. You open it and a lot of rats start coming out.");
        
        leave = Battle.battleInstance(this.player, Enemy.RATS);
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}