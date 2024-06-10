import java.util.*;
/**
 * Creates the game for the player to play
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Game {
  protected Player player;
  public final int SCRIPTED_CYCLE = 3;
  protected HashMap<Integer, Event> eventMap = new HashMap<Integer, Event>();

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
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    Input.lore("Welcome to the game!\nYou are a brave knight who has been tasked by the king with xyz.\nYou have been given a sword and $1000."); //TODO Finish lore
    this.player.setMoney(1000);
    gameLoop();
    System.out.println("Returning to main menu");
  }
  
  /**
   * The main game
   */
  public void gameLoop() {
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    while (this.player.getEventsPassed() < this.player.TOTAL_EVENTS) {
      while (this.player.getEventsPassed() % SCRIPTED_CYCLE != SCRIPTED_CYCLE - 1) {
        if (runRandomEvent()) {
          return;
        }
      }
      if (runRandomEvent()) {
        return;
      }
      runSpecialEvent();
    }
    if (this.player.getHealth() > 0) {
      gameWin();
    }
    else {
      gameLoss();
    }
  }

  /**
   * Executes random events
   */
  public boolean runRandomEvent() {
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    int randomEvent = (int) (Math.round(Math.random() * (this.player.getEventNumbers().size() - 1)) + 1);
    Event event = this.eventMap.get(randomEvent);
    boolean leave = event.run();
    if (!leave) {
      this.player.getEventNumbers().remove(randomEvent - 1);
      this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      return leave;
    }
    if (this.player.getHealth() == 0) {
      gameLoss();
    }
    else {
      quitGame();
    }
    return leave;
  }

  /**
   * Executes scripted events
   */
  public void runSpecialEvent() {
    // immediate boss battle, harder each time, if they win they get random boss drops? + access to a shop where they can buy stuff so money is actually useful
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    switch (this.player.getEventsPassed() / SCRIPTED_CYCLE) {
      case 1:
        Input.lore("You come into a clearing and see a large, black dragon. It is terrorizing a poor shopkeeper. You run to his aid, but now the dragon shifts its attention to you. You have no hope of outrunning it, you must fight!");
        Battle.battleInstance(this.player, "Dragon", 150, {15, 40});
        if (this.player.getHealth() == 0) {}
        else {
          
        }
        break;
      case 2:
        //run second special event
        break;
      case 3:
        //run third special event
        break;
      case 4:
        //run final event
        break;
    }
  }

  public void quitGame() {
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    System.out.println("Would you like to save your game? (y/n)");
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
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    System.out.println("Congratulations! You have won the game!");
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    this.player.setGamesWon(this.player.getGamesWon() + 1);
    gameOver();
  }

  public void gameLoss() {
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    System.out.println("You have lost the game.");
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
  
  
  public void inventoryViewer() {
    int[][] inventory = {
      {DAGGER_ID, SWORD_ID, BOW_ID}, //weapon
      {MINI_ID, BIG_POT_ID}, //healing
      {RUNE1_ID, RUNE2_ID, RUNE3_ID}; //runes
      {MONEY_COUNT,  ,asf } //misc
    };
    
  }
  
}






// below is for getting the names of events in a class
// dynamically 

// import java.lang.reflect.Method;
// Method[] methods = CLASSNAME.getClass().getDeclaredMethods();

// for (int i = 0; i < methods.length; i++){
//     System.out.println(methods[i].getName);
// }