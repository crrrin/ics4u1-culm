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
  //protected ArrayList<Event> events;
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
    
    // for(int i = 0; i < player.getEventNames().size(); i++) {
    //   switch(player.getEventNames().get(i)) {
    //     case "event1":
    //       this.events.add(new Event1(player));
    //       break;
    //     case "event2":
    //       this.events.add(new Event2(player));
    //       break;
    //     case "event3":
    //       this.events.add(new Event3(player));
    //       break;
    //     case "event4":
    //       this.events.add(new Event4(player));
    //       break;
    //     case "event5":
    //       this.events.add(new Event5(player));
    //       break;
    //     case "event6":
    //       this.events.add(new Event6(player));
    //       break;
    //     case "event7":
    //       this.events.add(new Event7(player));
    //       break;
    //     case "event8":
    //       this.events.add(new Event8(player));
    //       break;
    //     case "event9":
    //       this.events.add(new Event9(player));
    //       break;
    //     case "event10":
    //       this.events.add(new Event10(player));
    //       break;
    //     case "event11":
    //       this.events.add(new Event11(player));
    //       break;
    //     case "event12":
    //       this.events.add(new Event12(player));
    //       break;
    //    }
    // }
  }

  /**
   * Starts the game
   */
  public void play() {
    System.out.println("Welcome to the game!");
    System.out.println("You are a brave knight who has been tasked by the king with xyz."); //TODO finish lore
    System.out.println("You have been given a sword and $1000.");
    this.player.setWeapon(new Sword());
    this.player.setMoney(1000);
    gameLoop();
  }
  
  /**
   * The main game
   */
  public void gameLoop() {
    while (this.player.getEventsPassed() < this.player.TOTAL_EVENTS) {
      while (this.player.getEventsPassed() % SCRIPTED_CYCLE != SCRIPTED_CYCLE - 1) {
        runRandomEvent();
        this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      }
      runRandomEvent();
      this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      runSpecialEvent();
    }
  }

  /**
   * Executes random events
   */
  public void runRandomEvent() {
    
    int randomEvent = (int) (Math.round(Math.random() * (this.player.getEventNumbers().size() - 1)) + 1);
    Event event = this.eventMap.get(randomEvent);
    this.player.getEventNumbers().remove(randomEvent);
    event.run();
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
}





// below is for getting the names of events in a class
// dynamically 

// import java.lang.reflect.Method;
// Method[] methods = CLASSNAME.getClass().getDeclaredMethods();

// for (int i = 0; i < methods.length; i++){
//     System.out.println(methods[i].getName);
// }