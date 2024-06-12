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
        Input.lore("Damien: Sit down, I will show you the meat I use");
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
        Input.lore("You approach the monks, and they welcome you with open arms. However, they seem overly friendly, and as they lead you into the monastery, you realize that you have been led into a trap! You must now fight them.");
        leave = Battle.battleInstance(this.player, "the Monks", 40, new int[] {10, 30});
        break;

      case 2:
        Input.lore("You sneak past the monks in the shadows and enter the monastery. You find a room filled with broadswords, and you could take one if you want to. " + Broadsword.description());
        String 
        
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
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
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "Bear", 20, new int[] {3, 10});
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
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
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "Bear", 20, new int[] {3, 10});
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
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
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "Bear", 20, new int[] {3, 10});
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
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
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "Bear", 20, new int[] {3, 10});
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
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
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = Input.intCheck(1, 4);

    switch (choice) {
      case 1:
        leave = Battle.battleInstance(this.player, "Bear", 20, new int[] {3, 10});
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:
        leave = true;
        break;
    }
    return leave;
  }
}