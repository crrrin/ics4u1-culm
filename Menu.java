/**
* Creates a 
* @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
* @version 17.0.5
* @since 2024/06/12
*/




class Menu {
  
  protected String username;

  /**
   * Sets the username of the user to the given username
   * @param username String containing the user's given username
   */
  public Menu(String username) {
    this.username = username;
    
  }

  /**
   * Creates the main menu for the user to access.
   */
  public void mainMenu() {
    boolean stay = true;
    
    while (stay) {
      System.out.println(/*main menu stuffs*/);
      System.out.println("Select an option: 1. Play game\n2. Player Statistics\n3. Quit");
      int choice = -1;
      while(choice >= 3 || choice <= 1) {
        choice = Input.intIn();
      }
      
      switch (choice) {
        case 1: 
          // Game.playGame();
          break;
  
        case 2: 
          // stats();
          break;
  
        case 3: //quit
          System.out.println("Thanks for playing!");
          stay = false;
          // TODO potentially make stay global?
          break;
      }
    }
  }
}