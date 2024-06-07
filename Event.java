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

  public abstract void run();
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
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   * @param player The player to be used
   */
  public Event6(Player player) {
    super(player);
  }

  /** 
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   * @param player The player to be used
   */
  public Event8(Player player) {
    super(player);
  }

  /** 
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   * @param player The player to be used
   */
  public Event10(Player player) {
    super(player);
  }

  /** 
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
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
   * @param player The player to be used
   */
  public Event12(Player player) {
    super(player);
  }

  /** 
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
  }
}

/**
 * This class contains the one of the events of the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Event13 extends Event {

  /** 
   * Creates an event for a given player
   * @param player The player to be used
   */
  public Event13(Player player) {
    super(player);
  }

  /** 
   * Executes the event
   */
  @Override
  public void run() {
    System.out.println("You are walking through a forest and you see a wild bear. What do you do?");
    System.out.println("Select an option: 1. Attack the bear\n2. Run away\n3. Calmly approach the bear\n4. Quit");
    int choice = -1;
    while (choice >= 4 || choice <= 1) {
      choice = Input.intIn();
    }

    switch (choice) {
      case 1:
        Battle.battleInstance(player, "Bear", 20);
        break;

      case 2:
        System.out.println("You run away, but trip on a branch as you run away and drop your weapon.");
        player.setWeapon(null);
        break;

      case 3:
        System.out.println("You approach the bear calmly and it slowly walks away.");
        break;

      case 4:// quit
        break;
    }
  }
}