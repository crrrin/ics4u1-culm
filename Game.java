import java.util.*;

/**
 * Object containing the game for the player to play
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Game {
  protected Player player;
  protected final int SCRIPTED_CYCLE = 3;
  protected final int TOTAL_EVENTS = 12;
  protected HashMap<Integer, Event> eventMap = new HashMap<Integer, Event>();
  
  protected final int STARTING_MONEY = 150;
  protected final int STARTING_SMALL_POTS = 3;
  
  protected final int SMALL_PRICE = 50;
  protected final int BIG_PRICE = 125;

  /**
   * Creates a game for the player to play
   * @param player The player playing the game
   */
  public Game(Player player) {
    this.player = player;
    eventMap.put(1, new Event1(player));
    eventMap.put(2, new Event2(player));
    eventMap.put(3, new Event3(player));
    eventMap.put(4, new Event4(player));
    eventMap.put(5, new Event5(player));
    eventMap.put(6, new Event6(player));
    eventMap.put(7, new Event7(player));
    eventMap.put(8, new Event8(player));
    eventMap.put(9, new Event9(player));
    eventMap.put(10, new Event10(player));
    eventMap.put(11, new Event11(player));
    eventMap.put(12, new Event12(player));
  }

  /**
   * Provides information and starting items for a new game
   */
  public void firstPlay() {
    GameIO.wait(GameIO.LONG_DELAY);
    GameIO.lore(
      "Welcome to the game!\n" + 
      "You are a brave knight who has been tasked by the king with finding an ancient village that nobody has found in centuries. It is rumoured that within the village, a secret recipe exists for an immortality potion. The king wishes for you to find out if the rumours are true, and to retrieve the recipe if they are. To aid you on your mission, you have been given a sword, " + STARTING_SMALL_POTS + " basic potions, and $" + STARTING_MONEY + ".");
    GameIO.lore(Sword.description());

    this.player.setWeapon(new Sword());
    this.player.setMoney(STARTING_MONEY);
    this.player.setSmallHeals(STARTING_SMALL_POTS);
  }

  /**
   * Contains the main game loop
   */
  public void play() {
    GameIO.wait(GameIO.LONG_DELAY);

    //runs the game until the player plays every event or dies
    while (this.player.getEventsPassed() < this.TOTAL_EVENTS) {

      //runs random events until the cycle for a scripted event is met
      do {
        
        //runs the event, exits main game loop if player dies or wants to leave
        if (runRandomEvent()) {
          return;
        }
        
        GameIO.clearConsole();
      }
      while (this.player.getEventsPassed() % SCRIPTED_CYCLE != 0);

      //runs the scripted event, exits main game loop if player dies or wants to leave
      if (runSpecialEvent()) {
        return;
      }
      
      GameIO.clearConsole();
    }
    gameWin(); //if player has passed all events, they win
  }

  /**
   * Executes random events
   * @return Returns true if the player died or wants to leave, false otherwise
   */
  public boolean runRandomEvent() {
    GameIO.wait(GameIO.LONG_DELAY);
    int randomEvent = -1;

    //runs until a random event that has not been played is found
    while (!this.player.getEventNumbers().contains(randomEvent)) {
      randomEvent = (int) (Math.round(Math.random() * (this.TOTAL_EVENTS - 1)) + 1); //gets a random event corresponding to a key in eventMap
    }

    //runs the random event
    Event event = this.eventMap.get(randomEvent);
    boolean leave = event.run();

    //updates information and shows the player their current money and HP if they aren't dead or leaving, returns false
    if (!leave) {
      this.player.getEventNumbers().remove(this.player.getEventNumbers().indexOf(randomEvent));
      this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      
      GameIO.lore("\n" +
        "Money: $" + this.player.getMoney() + "\n" +
        "HP: " + this.player.getHealth());
      return leave;
    }

    //if the player is dead
    if (this.player.getHealth() == 0) {
      gameLoss();
    }

    //if the player wants to leave
    else {
      quitGame();
    }
    
    return leave; //returns true
  }

  /**
   * Executes scripted events
   * @return Returns true if the player died or wants to leave, false otherwise
   */
  public boolean runSpecialEvent() {
    GameIO.wait(GameIO.LONG_DELAY);
    boolean death = false;

    //runs a scripted event depending on how many events the player has passed
    switch (this.player.getEventsPassed() / SCRIPTED_CYCLE) {

      //first scripted event - player encounters a dragon
      case 1:
        GameIO.lore("You walk into a clearing and see a large, black dragon. It is terrorizing a poor shopkeeper. You run to his aid, but now the dragon shifts its attention to you. You have no hope of outrunning it, you must fight!");
        
        death = Battle.battleInstance(this.player, Enemy.DRAGON);

        //if the player is dead, returns true immediately
        if (death) {
          gameLoss();
          return death;
        }
        
        GameIO.lore("By defeating the dragon, you have saved the shopkeeper's life! The shopkeeper is thankful, and is willing to sell you his items right now, despite the trauma he has just experienced.");
        break;

      //second scripted event - player encounters some soldiers
      case 2:
        GameIO.lore("You wander into a town at night... but nobody is outside. You notice people inside their houses as you walk past them. But things seem off. These people are hiding behind furniture, and they seem terrified. As you enter the town square, you see why. There are 5 fully armed soldiers demolishing the buildings there. They turn around and see you, attacking without hesitation. You have no choice but to fight.");
        
        death = Battle.battleInstance(this.player, Enemy.SOLDIERS);
        
        //if the player is dead, returns true immediately
        if (death) {
          gameLoss();
          return death;
        }
        
        GameIO.lore("The town is extremely grateful to you for defeating the rogue soldiers that were terrorizing the town. They allow you to rest in their town overnight. You wake up feeling refreshed the next morning, and head to the town square to visit the shop.");
        break;
      
      //third scripted event - player encounters some giant spiders
      case 3:
        GameIO.lore("After a long day of travel, you find a cave to sleep in for the night. However, you hear a strange noise coming from deeper inside the cave. You decide to investigate. As you head deeper though, you start to notice an unnatural amount of cobwebs. Eventually, you find a group of people huddled in a corner, and they are cowering in fear. You turn around, and realize that there are dozens of giant spiders behind you! Before you know it, you are surrounded on all sides, and have to fight your way out.");
        
        death = Battle.battleInstance(this.player, Enemy.SPIDERS);
        
        //if the player is dead, returns true immediately
        if (death) {
          gameLoss();
          return death;
        }
        
        GameIO.lore("Having defeated the spiders, you tend to the others' wounds and then rest for the night. The next morning, they thank you for your help, and offer to sell you some of their items to help you on your journey.");
        break;
      
      //fourth scripted event - player encounters an immortal man named Damien
      case 4:
        GameIO.lore("Your long journey appears to finally be at its end. After all the trials you have faced, you have reached the ancient village. However, you are shocked to find that the village is in ruins. In the middle of it all stands none other than Damien Bartholomew Burnell-Jones Burthwright.");
        GameIO.lore("Damien: So, it's you again. Excellent. I've been waiting for a chance at revenge.");
        GameIO.lore("You: But how are you here? Nobody has found this village in centuries! And ... were you the one who caused all this ruin?");
        GameIO.lore("Damien: Well, to get my revenge, I decided to follow you. However, one day, I lost track of where you were. Completely lost, I accidentally wandered into this village. Nobody was guarding the place - they were so arrogant, to think nobody could find them. Let's just say, they would regret their arrogance. MWAHAHAHAHA");
        GameIO.lore("You: You ... how could you? This is unacceptable! How were you even able to cause so much damage???");
        GameIO.lore("Damien: The arrogant fools gave me the immortality potion. They thought I would use it to protect them from outsiders. They were wrong.");
        GameIO.lore("You: They gave YOU the ... wait a second. 'The'? You mean there's only one?");
        GameIO.lore("Damien: That's right. Now, there is no one left who can create another one. I'm the only immortal person in the world! You, a mere mortal, are no match for me! AND NOW, I SHALL HAVE MY REVENGE! MWAHAHAHAHA");
        
        death = Battle.battleInstance(this.player, Enemy.IMMORTAL);
        
        //if the player is dead
        if (death) {
          gameLoss();
        }
        
        return death; //always returns after last event
    }
    
    boolean exit = false;
    GameIO.clearConsole();

    //runs shop until player chooses to leave
    while (!exit) {
      exit = shop();
    }
    return death;
  }

  /**
   * Allows player to quit in the middle of a game, and choose if they wish to save their data
   */
  public void quitGame() {
    GameIO.wait(GameIO.LONG_DELAY);
    GameIO.dialogueln("Would you like to save your game? (y/n) (not case sensitive)");
    String save = "";

    //runs until player chooses to save or not
    while (!save.equals("y") && !save.equals("n")) {
      save = GameIO.strIn().toLowerCase();
    }

    //if player chooses not to save, exits game loop
    if (save.equals("n")) {
      gameOver();
      return;
    }

    //if player chooses to save, saves their progress to file
    else {

      //loads data if not already loaded
      if (Data.players.size() == 0) {
        Data.loadData();
      }
      
      Data.addPlayer(this.player);
      Data.saveData();
    }
  }

  /**
   * Updates related information and prints a win message after the player wins
   */
  public void gameWin() {
    GameIO.wait(GameIO.LONG_DELAY);
    
    GameIO.lore("You did it. You defeated an immortal, and you have avenged the ancient village. Now, you must journey home. You have no immortal potion to show for your efforts, but perhaps that's for the better. You have made the world a safer place, and the king will surely reward you for your efforts.");
    GameIO.dialogueln("Congratulations! You have won the game!");
    
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    this.player.setGamesWon(this.player.getGamesWon() + 1);
    gameOver();
  }

  /**
   * Updates related information and prints a loss message after the player loses
   */
  public void gameLoss() {
    GameIO.wait(GameIO.LONG_DELAY);
    
    GameIO.dialogueln("GAME OVER! You have lost this time, but you can always try again!");
    
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    gameOver();
  }

  /**
   * Updates information at the end of any game
   */
  public void gameOver() {
    this.player = new Player(this.player.getUsername(), this.player.getPlaythroughs(), this.player.getGamesWon()); //resets all player data related to the current game

    //loads data if not already loaded
    if (Data.players.size() == 0) {
      Data.loadData();
    }

    Data.addPlayer(this.player);
    Data.saveData();
  }

  /**
   * Collects information about a player's weapon, healing, and money into a 2D String array
   * @return Returns the player's current inventory in the form of a 2D String array
   */
  public String[][] inventory() {
    String[][] inventory = {
      {"Weapon: ", this.player.getWeapon().toString()},
      {"Healing: ", "Basic Potions: " + this.player.getSmallHeals() + " | ", "Super Potions: " + this.player.getBigHeals()},
      {"Money: " + this.player.getMoney()}
    };
    
    return inventory;
  }

  /**
   * Shows the player's inventory as a String
   * @return Returns a String containing the player's inventory
   */
  public String viewInventory() {
    String[][] inventory = inventory();
    String invUI = "";
    
    //adds each element of the 2D array to the String
    for (int i = 0; i < inventory.length; i++) {
      for (int j = 0; j < inventory[i].length; j++) {
        invUI += inventory[i][j];
      }
      invUI += "\n";
    }
    return invUI;
  }

  /**
   * Runs a shop where the player can buy items during the game
   * @return Returns true if the player chooses to leave the shop, false otherwise
   */
  public boolean shop() {
    boolean leave = false;
    
    String[] shopItems = {
      "SHOP",
      "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n",
      "1. Dagger: $" + Dagger.getPrice() + "\n" + Dagger.description() + "\n", 
      "2. Sword: $" + Sword.getPrice() + "\n" + Sword.description() + "\n", 
      "3. Bow: $" + Bow.getPrice() + "\n" + Bow.description() + "\n", 
      "4. Small Heal: $" + SMALL_PRICE + "\n", 
      "5. Big Heal: $" + BIG_PRICE + "\n",
      "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
    };
    
    System.out.println(
      "Welcome to the shop!\n" + 
      "1. View inventory\n" + 
      "2. View shop\n" + 
      "3. Leave");
    int choice = GameIO.intCheck(1, 3);

    //runs the player's choice
    switch (choice) {
      case 1:
        System.out.print(
          "INVENTORY\n" +                 
          "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n" + 
          viewInventory() +     
          "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        
        GameIO.lore(""); //enter check
        break;

      case 2:
        GameIO.dialogueln("Your money: " + this.player.getMoney());
        System.out.println();

        //prints shop items
        for (int i = 0; i < shopItems.length; i++) {
          System.out.print(shopItems[i]);
          System.out.println();
        }

        GameIO.dialogueln("Enter the number corrosponding to the item you would like to buy, or enter 0 if you don't want to buy anything right now.");
        int itemChoice = GameIO.intCheck(0, 5);

        //runs the player's shop choice
        switch (itemChoice) {
          case 0: //back to first switch
            break;
          
          case 1: 
            buyWeapon(new Dagger(), Dagger.getPrice());
            break;
          
          case 2:
            buyWeapon(new Sword(), Sword.getPrice());
            break;
          
          case 3:
            buyWeapon(new Bow(), Bow.getPrice());
            break;
          
          case 4:
            buyHeals(SMALL_PRICE);
            break;
          
          case 5:
            buyHeals(BIG_PRICE);
            break;
        }
        break;

      case 3: //leaves shop, returns to game loop
        leave = true;
        break;
    }
    
    GameIO.clearConsole();
    return leave;
  }

  /**
   * Has the player purchase a given weapon if they have enough money
   * @param weapon The weapon the player wants to buy
   * @param price The price of the weapon
   */
  public void buyWeapon(Weapon weapon, int price) {

    //if player doesn't have enough money to buy, steals any money they have instead
    if (this.player.getMoney() < price) {
      GameIO.lore("You do not have enough money to buy this weapon.");
      
      //prints a special message if the player has money that is about to be stolen
      if (this.player.getMoney() != 0) {
        GameIO.lore("The shopkeeper is outraged as he believes you tried to fleece him. He takes all your money.");
      }
      
      this.player.setMoney(0);
      return;  
    }

    //purchases weapon
    this.player.setMoney(this.player.getMoney() - price);
    this.player.setWeapon(weapon);
    GameIO.lore(weapon.toString() + " purchased!");
  }

  /**
   * Has the player purchase a given potion if they have enough money
   * @param healPrice The price of the potion the player wants to buy
   */
  public void buyHeals(int healPrice) {

    //if player doesn't have enough money to buy, steals any money they have instead
    if (this.player.getMoney() < healPrice) {
      GameIO.lore("You do not have enough money to buy this potion.");

      //prints a special message if the player has money that is about to be stolen
      if (this.player.getMoney() != 0) {
        GameIO.lore("The shopkeeper is outraged as he believes you tried to fleece him. He takes all your money.");
      }

      this.player.setMoney(0);
      return;  
    }

    //purchases potion
    this.player.setMoney(this.player.getMoney() - healPrice);

    //determines the potion the player bought, and updates their inventory
    switch (healPrice) {
      case SMALL_PRICE:
        this.player.setSmallHeals(this.player.getSmallHeals() + 1);
        break;
        
      case BIG_PRICE:
        this.player.setBigHeals(this.player.getBigHeals() + 1);
        break;
    }
    
    GameIO.lore("Heal purchased!");
  }
}