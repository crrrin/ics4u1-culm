/**
 * Creates an object Player containing data of a player.
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
import java.util.ArrayList;
class Player implements Comparable { //TODO comarable incomplete
  protected String username;
  protected int health, eventsPassed, money, playthroughs, gamesWon;
  protected Weapon weapon;
  protected final int MAX_HEALTH = 100;
  protected ArrayList<String> unusedEvents;
  
  /** 
   * Creates a player with the specified information if the player already exists
   * @param username The username of the player
   * @param eventsPassed The number of events the player has passed
   * @param money The amount of money the player has
   * @param playthroughs The number of playthroughs the player has
   * @param gamesWon The number of games the player has won
   */
  public Player(String username, int health, int eventsPassed, int money, Weapon weapon, int playthroughs, int gamesWon, ArrayList<String> unusedEvents){
    this.username = username;
    this.health = health;
    this.eventsPassed = eventsPassed;
    this.money = money;
    this.weapon = weapon;
    this.playthroughs = playthroughs;
    this.gamesWon = gamesWon;
    this.unusedEvents = unusedEvents;
  }
  
  /** 
   * Creates a new player with blank stats
   * @param username The username of the new player
   */
  public Player(String username) {
    this.username = username;
    this.health = this.MAX_HEALTH;
    this.eventsPassed = 0;
    this.money = 0;
    this.weapon = null;
    this.playthroughs = 0;
    this.gamesWon = 0;
    this.unusedEvents = Events.ALL_EVENTS;
  }

  
  /**
   * Gets the username of a player.
   * @return The username of the player
   */
  public String getUsername() {
    return this.username;
  }
  
  /**
   * Gets the player's current health.
   * @return The player's current health
   */
  public int getHealth() {
    return this.health;
  }

  /**
   * Sets a new value for the player's health.
   * @param health the player's health to be set
   */
  public void setHealth(int health) {
    if (health > MAX_HEALTH){
      this.health = MAX_HEALTH;
    }
    this.health = health;
  }
  
  /**
   * Gets the number of events passed by the player.
   * @return The number of events the player passed
   */
  public int getEventsPassed() {
    return this.eventsPassed;
  }

  /**
   * Sets the number of events passed by the player.
   * @param eventsPassed The number of events the player passed to be set
   */
  public void setEventsPassed(int eventsPassed) {
    this.eventsPassed = eventsPassed;
  }
  
  /**
   * Gets the current weapon of the player.
   * @return The weapon the player possesses
   */
  public Weapon getWeapon() {
    return this.weapon;
  }

  /**
   * Sets the current weapon of player to a new weapon.
   * @param weapon The weapon to be set
   */
  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }
  
  /**
   * Gets the number of playthroughs by the player.
   * @return The number of playthroughs the player has done
   */
  public int getPlaythroughs() {
    return this.playthroughs;
  }

  /**
   * Sets the number of playthroughs by the player.
   * @param playthroughs The number of playthroughs of the player to be set
   */
  public void setPlaythroughs(int playthroughs) {
    this.playthroughs = playthroughs;
  }

  
  /**
   * Gets the amount of money the player has.
   * @return The amount of money the player has
   */
  public int getMoney() {
    return this.money;
  }

  /**
   * Sets the amount of money to the player
   * @param money The amount of money to be set to the player
   */
  public void setMoney(int money) {
    this.money = money;
  }

  
  /**
   * Gets the number of games won by the player
   * @return The number of games won by the player
   */
  public int getGamesWon() {
    return this.gamesWon;
  }

  /**
   * Sets the number of games won to the player
   * @param gamesWon The number of games won to be set to the player
   */
  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }

  /**
   * Gets a list of events already completed by the player
   * @return A list of events completed by the player
   */
  public ArrayList<String> getUnusedEvents() {
    return this.unusedEvents;
  }

  /**
   * Sets the list of events already completed by the player to a given list
   * @param usedEvents A list of events completed to be set to the player
   */
  public void setUnusedEvents(ArrayList<String> unusedEvents) {
    this.unusedEvents = unusedEvents;
  }

  /**
   * Compares the username of a player to another player
   * @param o A given player to be compared
   * @return Returns true if usernames match and false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return this.username.equals(((Player)o).getUsername());
  }


  /**
   * Compares number of games won of one player to another
   * @param o A given player to be compared
   * @return Returns an integer of difference of games won; if the player has more games won, returns a positive integer, if the player has less games won, returns a negative integer
   */
  @Override
  public int compareTo(Object o) {
    return this.gamesWon - ((Player)o).getGamesWon();
  }
}