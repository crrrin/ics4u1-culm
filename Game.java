
/**
 * Creates the game for the player to play
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Game extends Events {
  protected Player player;

  public Game(Player player) {
    this.player = player;
  }

  public void play() {
    System.out.println("Welcome to the game!");
    System.out.println("You are a brave knight who has been tasked by the king with xyz."); //TODO finish lore
    System.out.println("You have been given a sword and $1000.");
    this.player.setWeapon(new Sword());
    this.player.setMoney(1000);
    gameLoop();
  }
  
  public void gameLoop() {
    while(this.player.unusedEvents.size() > 0) {
      while(this.player.unusedEvents.size() % 3 != 1) {
        runRandomEvent();
        this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      }
      runRandomEvent();
      this.player.setEventsPassed(this.player.getEventsPassed() + 1);
      runSpecialEvent();
    }
  }
  
  public void runRandomEvent() {
    // int randomEvent = (int) (Math.random() * (ALL_EVENTS.size() - 1);
    // String event = ALL_EVENTS.get(randomEvent);
    // this.player.unusedEvents.remove(event);
  }

  public void runSpecialEvent() {
    switch(this.player.eventsPassed / 3) {
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