/**
 * Creates an object Player containing data of a player.
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Player {
  protected String username;
  protected int eventsPassed, money, playthroughs, gamesWon;
  
  /** 
   * Creates a player with the specified information if the player already exists
   * @param username The username of the player
   * @param eventsPassed The number of events the player has passed
   * @param money The amount of money the player has
   * @param playthroughs The number of playthroughs the player has
   * @param gamesWon The number of games the player has won
   */
  public Player(String username, int eventsPassed, int money, int playthroughs, int gamesWon){
    this.username = username;
    this.eventsPassed = eventsPassed;
    this.money = money;
    this.playthroughs = playthroughs;
    this.gamesWon = gamesWon;
  }
  
  /** 
   * Creates a new player with blank stats
   * @param username The username of the new player
   */
  public Player(String username) {
    this.username = username;
    this.eventsPassed = 0;
    this.money = 0;
    this.playthroughs = 0;
    this.gamesWon = 0;
  }

  
  /**
   * Gets the username of a player.
   * @return The username of the player
   */
  public String getUsername() {
    return this.username;
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
   * Gets the number of games won by the player.
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
   * Compares the username of a player to another player
   * @param o The username to be compared to
   * @return Returns true if usernames match and false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return this.username.equals(((Player)o).getUsername());
  }
}