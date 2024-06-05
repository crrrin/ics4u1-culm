class Player{
  protected String username;
  protected int eventsPassed, playThroughs, money, gamesWon;
  
  //for existing player
  public Player(String username, int eventsPassed, int playThroughs, int money, int gamesWon){
    this.username = username;
    this.eventsPassed = eventsPassed;
    this.playThroughs = playThroughs;
    this.money = money;
    this.gamesWon = gamesWon;
  }
  
  //for new player
  public Player(String username){
    this.username = username;
    this.eventsPassed = 0;
    this.playThroughs = 0;
    this.money = 0;
    this.gamesWon = 0;
  }

  //getters and setters
  /**
  * Gets the eventsPassed of the item
  * @return The product name of the item
  */
  public int getEventsPassed() {
    return this.eventsPassed;
  }
 
  public void setEventsPassed(int eventsPassed) {
    this.eventsPassed = eventsPassed;
  }


  
  public int getPlayThroughs() {
    return this.playThroughs;
  }
  
  public void setPlayThroughs(int playThroughs) {
    this.playThroughs = playThroughs;
  }

  
  
  public int getMoney() {
    return this.money;
  }
  
  public void setMoney(int money) {
    this.money = money;
  }

  

  public int getGamesWon() {
    return this.gamesWon;
  }

  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }
}