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
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
    System.out.println("You were navigating the rivers but a group of bandits spot you, demanding your money. What do you do?");
    System.out.println("Select an option:\n1. Fight the bandits\n2. Run away\n3. Give the bandits your money\n4. Quit");
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bandit", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
        break;

      case 2:
        System.out.println("You cowardly run away, accidently dropping more money than the bandits asked for and losing some dignity.");
        this.player.setMoney(this.player.getMoney() - 100);
        break;

      case 3:
        System.out.println("You gave the bandits $50. They leave you alone.");
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
    System.out.println("It is the evening, you are tired. You find a small village and move towards it. What do you do?");
    System.out.println("Select an option:\n1. Sneak in and scavenge for food\n2. Ask a villager to let you stay the night\n3. Ignore the village and walk away.\n4. Quit");
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        System.out.println("You got caught by one of the guards! They attack you.");
        Battle.battleInstance(this.player, "villagerGuard", 20); 
        if (this.player.getHealth() == 0) {
          leave = true;
        }
        break;

      case 2:
        System.out.println("A friendly villager welcomes you and offers their hospitality. You stay the night there and feel refreshed in the morning.");
        // this.player.setWeapon(null);
        break;

      case 3:
        System.out.println("You continue walking towards your destination. You fainted from your fatigue.");
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
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are famished, you find yourself in front of a mysterious, lone house. The homeowner greets you and introduces himself. His name is Damien Bartholomew Burnell-Jones Burthwright. and invites you to have a meal with him. Do you accept?");
    System.out.println("Select an option:\n1. Accept his offer\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Input.lore("You accept his offer and he invites you to sit down at his table. He serves you a meat pie.");
        System.out.println("You: Exquisite. This reminds me of the famous pork pie we have at home.");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("Damien: Thank you good sir! It is a secret recipe.");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("You: You have to tell me how to make it sir.");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("Damien: You would like to know? Well, I am running low on meat.");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("Damien leads you into a room, you left your equipment outside. It smells horrible in there.");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("Damien: Sit down, I will show you the meat I use");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("You sit down and Damien gets his cleaver. Instead of going to his storage, he motions towards you. You begin to realize what meat you just ate. He smiles and chuckles.");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("Damien: Looks like I will be eating good tonight");
        Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
        System.out.println();
        System.out.println("You're not ready to die. You quickly get up from the chair and kick him, sending him into the wall. He drops his cleaver. You make a dash out the door and grab your weapon");
        
        
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
class Event5 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event5(Player player) {
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
   * Executes the event
   * @return Returns true if the user wants to quit or has died, false otherwise
   */
  @Override
  public boolean run() {
    boolean leave = false;
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option:\n1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
class Event7 extends Event {

  /**
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event7(Player player) {
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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
    int choice = -1;
    while (choice > 4 || choice < 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(this.player, "Bear", 20);
        if (this.player.getHealth() == 0) {
          leave = true;
        }
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