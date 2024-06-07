0/**
 * This class contains menus that a user will interact with
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Menu {
  
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
          System.out.print("Please enter your username (any spaces will be removed): ");
          String username = Input.strIn().replaceAll(" ", "");
          System.out.println("\nChoose an option: 1. New game\n2. Load game (must be an existing user)");
          int gameChoice = -1;
          while(gameChoice != 1 && gameChoice != 2) {
            gameChoice = Input.intIn();
          }
          Player player = null;
          if (gameChoice == 1) {
            Player player = new Player(username);
            Game game = new Game(player);
            game.play();
          }
          else {
            Data.loadData();
            for(int i = 0; i < Data.players.size(); i++) {
              if (Data.players.get(i).getUsername().equals(username)) {
                player = Data.players.get(i);
                i = Data.players.size();
              }
            }
            if(player == null) {
              System.out.println("You do not have an existing game. Returning to main menu.");
            }
            else {
              Game game = new Game(player);
              game.gameLoop();
            }
          }
          break;
  
        case 2: 
          // Data.stats();
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