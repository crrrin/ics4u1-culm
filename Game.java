import java.util.*;
/**
 * Creates the game for the player to play
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Game {
  protected Player player;
  public final int SCRIPTED_CYCLE = 3;
  protected HashMap<Integer, Event> eventMap = new HashMap<Integer, Event>();
  
  public final int STARTING_MONEY = 150;
  public final int STARTING_SMALL_POTS = 3;
  
  public final int WEAPON_PRICE = 100;
  public final int SMALL_PRICE = 50;
  public final int BIG_PRICE = 125;

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
   * Starts the game
   */
  public void play() {
    
    gameLoop();
    
    Input.dialogueln("Returning to main menu...");
  }

  public void firstPlay(){
    Sleep.wait(Sleep.LONG_DELAY);
    Input.lore("Welcome to the game!\nYou are a brave knight who has been tasked by the king with finding an ancient village that nobody has found in centuries. It is rumoured that within the village, a secret recipe exists for an immortality potion. The king wishes for you to find out if the rumours are true, and to retrieve the recipe if they are. To aid you on your mission, you have been given a sword, " + STARTING_SMALL_POTS + " basic potions, and $" + STARTING_MONEY + "."); //TODO Finish lore
    Input.lore(Sword.description());
    this.player.setMoney(STARTING_MONEY);
    this.player.setSmallHeals(STARTING_SMALL_POTS);
  }

  /**
   * The main game
   */
  public void gameLoop() {
    
    
    Sleep.wait(Sleep.LONG_DELAY);
    while (this.player.getEventsPassed() < this.player.TOTAL_EVENTS) {
      
      do {
        if (runRandomEvent()) {
          return;
        }
        Input.clearConsole();
      }
      while (this.player.getEventsPassed() % SCRIPTED_CYCLE != 0);
      
      if (runSpecialEvent()) {
        return;
      }
      Input.clearConsole();
    }
    gameWin();
  }

  /**
   * Executes random events
   */
  public boolean runRandomEvent() {
    Sleep.wait(Sleep.LONG_DELAY);
    int randomEvent = -1;
    while (!this.player.getEventNumbers().contains(randomEvent)) {
      randomEvent = (int) (Math.round(Math.random() * (11)) + 1); //gets a random event from index 1 - 12
    }
    Event event = this.eventMap.get(randomEvent);
    boolean leave = event.run();
    if (!leave) {
      this.player.getEventNumbers().remove(this.player.getEventNumbers().indexOf(randomEvent));
      this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      Input.lore(
        "\n" +
        "Money: $" + this.player.getMoney() + "\n" +
        "HP: " + this.player.getHealth());
      return leave;
    }

    if (this.player.getHealth() == 0) {
      gameLoss();
    }
    else {
      quitGame();
    }

   // Input.clearConsole();
    return leave;
  }

  /**
   * Executes scripted events
   */
  public boolean runSpecialEvent() {
    // immediate boss battle, harder each time, if they win they get random boss drops? + access to a shop where they can buy stuff so money is actually useful
    Sleep.wait(Sleep.LONG_DELAY);
    boolean death = false;
    switch (this.player.getEventsPassed() / SCRIPTED_CYCLE) {
      case 1:
        Input.lore("You walk into a clearing and see a large, black dragon. It is terrorizing a poor shopkeeper. You run to his aid, but now the dragon shifts its attention to you. You have no hope of outrunning it, you must fight!");
        death = Battle.battleInstance(this.player, Enemy.DRAGON);
        if (death) {
          gameLoss();
          return death;
        }
        Input.lore("By defeating the dragon, you have saved the shopkeeper's life! The shopkeeper is thankful, and is willing to sell you his items right now, despite the trauma he has just experienced.");
        break;
      case 2:
        Input.lore("You wander into a town at night... but nobody is outside. You notice people inside their houses as you walk past them. But things seem off. These people are hiding behind furniture, and they seem terrified. As you enter the town square, you see why. There are 5 fully armed soldiers demolishing the buildings there. They turn around and see you, attacking without hesitation. You have no choice but to fight.");
        death = Battle.battleInstance(this.player, Enemy.SOLDIERS);
        if (death) {
          gameLoss();
          return death;
        }
        Input.lore("The town is extremely grateful to you for defeating the rogue soldiers that were terrorizing the town. They allow you to rest in their town overnight. You wake up feeling refreshed the next morning, and head to the town square to visit the shop.");
        break;
      case 3:
        Input.lore("After a long day of travel, you find a cave to sleep in for the night. However, you hear a strange noise coming from deeper inside the cave. You decide to investigate. As you head deeper though, you start to notice an unnatural amount of cobwebs. Eventually, you find a group of people huddled in a corner, and they are cowering in fear. You turn around, and realize that there are dozens of giant spiders behind you! Before you know it, you are surrounded on all sides, and have to fight your way out.");
        death = Battle.battleInstance(this.player, Enemy.SPIDERS);
        if (death) {
          gameLoss();
          return death;
        }
        Input.lore("Having defeated the spiders, you tend to the others' wounds and then rest for the night. The next morning, they thank you for your help, and offer to sell you some of their items to help you on your journey.");
        break;
      case 4:
        Input.lore("Your long journey appears to finally be at its end. After all the trials you have faced, you have reached the ancient village. However, you are shocked to find that the village is in ruins. In the middle of it all stands none other than Damien Bartholomew Burnell-Jones Burthwright.");
        Input.lore("Damien: So, it's you again. Excellent. I've been waiting for a chance at revenge.");
        Input.lore("You: But how are you here? Nobody has found this village in centuries! And ... were you the one who caused all this ruin?");
        Input.lore("Damien: Well, to get my revenge, I decided to follow you. However, one day, I lost track of where you were. Completely lost, I accidentally wandered into this village. Nobody was guarding the place - they were so arrogant, to think nobody could find them. Let's just say, they would regret their arrogance. MWAHAHAHAHA");
        Input.lore("You: You ... how could you? This is unacceptable! How were you even able to cause so much damage???");
        Input.lore("Damien: The arrogant fools gave me the immortality potion. They thought I would use it to protect them from outsiders. They were wrong.");
        Input.lore("You: They gave YOU the ... wait a second. 'The'? You mean there's only one?");
        Input.lore("Damien: That's right. Now, there is no one left who can create another one. I'm the only immortal person in the world! You, a mere mortal, are no match for me! AND NOW, I SHALL HAVE MY REVENGE! MWAHAHAHAHA");
        death = Battle.battleInstance(this.player, Enemy.IMMORTAL);
        if (death) {
          gameLoss();
        }
        return death;
    }
    boolean exit = false;

    Input.clearConsole();
    while (!exit) {
      exit = shop();
    }
    return death;
  }

  public void quitGame() {
    Sleep.wait(Sleep.LONG_DELAY);
    Input.dialogueln("Would you like to save your game? (y/n)");
    String save = "";
    while (!save.equals("y") && !save.equals("n")) {
      save = Input.strIn().toLowerCase();
    }
    if (save.equals("n")) {
      gameOver();
    }
    else {
      if (Data.players.size() == 0) {
        Data.loadData();
      }
      Data.addPlayer(this.player);
      Data.saveData();
    }
  }

  public void gameWin() {
    Sleep.wait(Sleep.LONG_DELAY);
    Input.lore("You did it. You defeated an immortal, and you have avenged the ancient village. Now, you must journey home. You have no immortal potion to show for your efforts, but perhaps that's for the better. You have made the world a safer place, and the king will surely reward you for your efforts.");
    Input.dialogueln("Congratulations! You have won the game!");
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    this.player.setGamesWon(this.player.getGamesWon() + 1);
    gameOver();
  }

  public void gameLoss() {
    Sleep.wait(Sleep.LONG_DELAY);
    Input.dialogueln("GAME OVER!");
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    gameOver();
  }

  public void gameOver() {
    this.player = new Player(this.player.getUsername(), this.player.getPlaythroughs(), this.player.getGamesWon());

    if (Data.players.size() == 0) {
      Data.loadData();
    }

    Data.addPlayer(this.player);
    Data.saveData();
  }


  public String[][] inventory() {
    String[][] inventory = {
      {"Weapon: ", this.player.getWeapon().toString()}, //weapon
      {"Healing: ", "Basic Potions: " + this.player.getSmallHeals() + " | ", "Super Potions: " + this.player.getBigHeals()}, //healing
      {"Money: " + this.player.getMoney()/*, RELIC_ID, LOOT_ID*/} //misc TODO more loot
    };

    return inventory;
  }

  public String viewInventory() {
    String[][] inventory = inventory();
    String invUI = "";
    // System.out.println("INVENTORY");
    // System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
    for (int i = 0; i < inventory.length; i++) {
      for (int j = 0; j < inventory[i].length; j++) {
        invUI += inventory[i][j];
      }
      invUI += "\n";
    }
    return invUI;
  }

  public boolean shop() { //TODO make format weapon to Name: $Cost \nDescription
    boolean leave = false;
    String[] shopItems = {
      "SHOP",
      "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n",
      "1. Dagger: $" + WEAPON_PRICE + "\n" + Dagger.description() + "\n", 
      "2. Sword: $" + WEAPON_PRICE + "\n" + Sword.description() + "\n", 
      "3. Bow: $" + WEAPON_PRICE + "\n" + Bow.description() + "\n", 
      "4. Small Heal: $" + SMALL_PRICE + "\n", 
      "5. Big Heal: $" + BIG_PRICE + "\n",
      "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
    };
    System.out.println("Welcome to the shop!\n1. View inventory\n2. View shop\n3. Leave");
    int choice = Input.intCheck(1, 3);

    switch (choice) {
      case 1:
        System.out.print(
          "INVENTORY" +                 
          "\n+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n" + 
          viewInventory() +     
          "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        Input.lore("");
        break;

      case 2:
        Input.dialogueln("Your money: " + this.player.getMoney());
        System.out.println();

        for (int i = 0; i < shopItems.length; i++) {
          System.out.print(shopItems[i]);
          System.out.println();
        }

        Input.dialogueln("Enter the number corrosponding to the item you would like to buy, or enter 0 to exit the shop."); //TODO MAKE ZERO EXIT TO MENU INSTEAD OF SHOP COMPLETELY
        int itemChoice = Input.intCheck(0, 5);

        switch (itemChoice) {
          case 0:
            break;

          case 1:
            buyWeapon(new Dagger());
            break;
          case 2:
            buyWeapon(new Sword());
            break;
          case 3:
            buyWeapon(new Bow());
            break;
          case 4:
            buyHeals(SMALL_PRICE);
            break;
          case 5:
            buyHeals(BIG_PRICE);
            break;
        }
        break;

      case 3: 
        leave = true;
        break;
    }
    Input.clearConsole();
    return leave;
  }

  public void buyWeapon(Weapon weapon) {
    if (this.player.getMoney() < WEAPON_PRICE) {
      
      this.player.setMoney(0);
      
      Input.lore("You do not have enough money to buy this weapon. ");
      
      if (this.player.getMoney() == 0) {
        Input.lore("The shopkeeper is outraged as he believes you tried to fleece him. He takes all your money.");
      }
      
      return;  
    }
    
    this.player.setMoney(this.player.getMoney() - 100);
    this.player.setWeapon(weapon);
    Input.dialogue(weapon.toString() + " purchased!");
  }

  public void buyHeals(int healPrice) {
    if (this.player.getMoney() < healPrice) {

      this.player.setMoney(0);

      Input.lore("You do not have enough money to buy this potion. ");

      if (this.player.getMoney() == 0) {
        Input.lore("The shopkeeper is outraged as he believes you tried to fleece him. He takes all your money.");
      }

      return;  
    }
    
    this.player.setMoney(this.player.getMoney() - healPrice);
    switch (healPrice) {
      case SMALL_PRICE:
        this.player.setSmallHeals(this.player.getSmallHeals() + 1);
        break;
      case BIG_PRICE:
        this.player.setBigHeals(this.player.getBigHeals() + 1);
        break;
    }
    
    Input.dialogue("Heal purchased!");
  }
  
}






// below is for getting the names of events in a class
// dynamically 

// import java.lang.reflect.Method;
// Method[] methods = CLASSNAME.getClass().getDeclaredMethods();

// for (int i = 0; i < methods.length; i++){
//     System.out.println(methods[i].getName);
// }