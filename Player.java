//TODO change event names to numbers
/**
 * Creates an object Player containing data of a player.
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
import java.util.*;
class Player implements Comparable<Player> {
  protected String username;
  protected int health, eventsPassed, money, smallHeals, bigHeals, playthroughs, gamesWon;
  protected Weapon weapon;
  protected final int MAX_HEALTH = 100;
  protected final int TOTAL_EVENTS = 12;
  protected ArrayList<Integer> eventNumbers;
  
  /** 
   * Creates a player with the specified information if the player already exists
   * @param username The username of the player
   * @param health The health points of the player
   * @param eventsPassed The number of events the player has passed
   * @param money The amount of money the player has
   * @param smallHeals The number of small heals the player has
   * @param bigHeals The number of big heals the player has
   * @param weapon The weapon the player has
   * @param playthroughs The number of playthroughs the player has
   * @param gamesWon The number of games the player has won
   * @param eventNumbers An int array list of events that the player hasn't reached yet
   */
  public Player(String username, int health, int eventsPassed, int money, int smallHeals, int bigHeals, Weapon weapon, int playthroughs, int gamesWon, ArrayList<Integer> eventNumbers){
    this.username = username;
    this.health = health;
    this.eventsPassed = eventsPassed;
    this.money = money;
    this.smallHeals = smallHeals;
    this.bigHeals = bigHeals;
    this.weapon = weapon;
    this.playthroughs = playthroughs;
    this.gamesWon = gamesWon;
    this.eventNumbers = eventNumbers;
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
    this.weapon = new Sword();
    this.smallHeals = 0;
    this.bigHeals = 0;
    this.playthroughs = 0;
    this.gamesWon = 0;
    this.eventNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
  }

  /** 
   * Creates a new player with blank game stats, but with given overall stats
   * @param username The username of the new player
   * @param playthroughs The number of games the player has played
   * @param gamesWon The number of games the player has won
   */
  public Player(String username, int playthroughs, int gamesWon) {
    this.username = username;
    this.health = this.MAX_HEALTH;
    this.eventsPassed = 0;
    this.money = 0;
    this.weapon = new Sword();
    this.smallHeals = 0;
    this.bigHeals = 0;
    this.playthroughs = playthroughs;
    this.gamesWon = gamesWon;
    this.eventNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
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
    if (health > MAX_HEALTH) {
      health = MAX_HEALTH;
    }
    else if (health < 0) {
      health = 0;
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
    if(money < 0) {
      money = 0;
    }
    this.money = money;
  }

  /**
   * Gets the amount of small heals the player has.
   * @return The amount of small heals the player has
   */
  public int getSmallHeals() {
    return this.smallHeals;
  }

  /**
   * Sets the amount of small heals to the player
   * @param money The amount of small heals to be set to the player
   */
  public void setSmallHeals(int smallHeals) {
    this.smallHeals = smallHeals;
  }

  /**
   * Gets the amount of big heals the player has.
   * @return The amount of big heals the player has
   */
  public int getBigHeals() {
    return this.bigHeals;
  }

  /**
   * Sets the amount of big heals to the player
   * @param money The amount of big heals to be set to the player
   */
  public void setBigHeals(int bigHeals) {
    this.bigHeals = bigHeals;
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
   * Gets a list of events not yet completed by the player
   * @return A list of events not yet completed by the player
   */
  public ArrayList<Integer> getEventNumbers() {
    return this.eventNumbers;
  }

  /**
   * Sets the list of events not yet completed by the player to a given list
   * @param eventNumbers A list of events not completed to be set to the player
   */
  public void setEventNumbers(ArrayList<Integer> eventNumbers) {
    this.eventNumbers = eventNumbers;
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
  public int compareTo(Player player) {
    return this.getGamesWon() - player.getGamesWon();
  }
}