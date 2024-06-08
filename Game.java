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
    System.out.println("Welcome to the game!");
    System.out.println("You are a brave knight who has been tasked by the king with xyz."); //TODO finish lore
    System.out.println("You have been given a sword and $1000.");
    this.player.setMoney(1000);
    gameLoop();
    System.out.println("Returning to main menu");
    Sleep.wait(Sleep.GENERIC_SHORT_DELAY_MS);
  }
  
  /**
   * The main game
   */
  public void gameLoop() {
    while (this.player.getEventsPassed() < this.player.TOTAL_EVENTS) {
      while (this.player.getEventsPassed() % SCRIPTED_CYCLE != SCRIPTED_CYCLE - 1) {
        if(runRandomEvent()) {
          return;
        }
      }
      if(runRandomEvent()) {
        return;
      }
      runSpecialEvent();
    }
    if(this.player.getHealth() > 0) {
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
    
    int randomEvent = (int) (Math.round(Math.random() * (this.player.getEventNumbers().size() - 1)) + 1);
    Event event = this.eventMap.get(randomEvent);
    boolean leave = event.run();
    if(leave) {
      if(this.player.getHealth() == 0) {
        gameLoss();
      }
      else {
        quitGame();
      }
    }
    else {
      this.player.getEventNumbers().remove(randomEvent - 1);
      this.player.setEventsPassed(this.player.getEventsPassed() + 1);
    }
    return leave;
  }

  /**
   * Executes scripted events
   */
  public void runSpecialEvent() {
    switch (this.player.getEventsPassed() / SCRIPTED_CYCLE) {
      case 1:
        //run first special event
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
    System.out.println("Would you like to save your game? (y/n)");
    String save = "";
    while(!save.equals("y") && !save.equals("n")) {
      save = Input.strIn().toLowerCase();
    }
    if(save.equals("n")) {
      gameOver();
    }
    else {
      if(Data.players.size() == 0) {
        Data.loadData();
      }
      Data.addPlayer(this.player);
      Data.saveData();
    }
  }

  public void gameWin() {
    System.out.println("Congratulations! You have won the game!");
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    this.player.setGamesWon(this.player.getGamesWon() + 1);
    gameOver();
  }

  public void gameLoss() {
    System.out.println("You have lost the game.");
    this.player.setPlaythroughs(this.player.getPlaythroughs() + 1);
    gameOver();
  }

  public void gameOver() {
    this.player = new Player(this.player.getUsername(), this.player.getPlaythroughs(), this.player.getGamesWon());
    
    if(Data.players.size() == 0) {
      Data.loadData();
    }

    Data.addPlayer(this.player);
    Data.saveData();
  }

  /*
  public void inventoryViewer(String[][] player) {
  
  }
  */
}






// below is for getting the names of events in a class
// dynamically 

// import java.lang.reflect.Method;
// Method[] methods = CLASSNAME.getClass().getDeclaredMethods();

// for (int i = 0; i < methods.length; i++){
//     System.out.println(methods[i].getName);
// }