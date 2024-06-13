class Main {
  public static void main(String[] args) {
    mainMenu();
  }

  /**
   * Creates the main menu for the user to access.
   */
  public static void mainMenu() {
    boolean stay = true;

    System.out.println( "Welcome to" + "\n" +
      " ____             _      ____  _          _ _     " + "\n" +
      "|  _ \\  __ _ _ __| | __ / ___|| | ___   _| | |___ " + "\n" + 
      "| | | |/ _` | '__| |/ / \\___ \\| |/ / | | | | / __|" + "\n" + //immortal quest??????????
      "| |_| | (_| | |  |   <   ___) |   <| |_| | | \\__ \\" + "\n" +
      "|____/ \\__,_|_|  |_|\\_\\ |____/|_|\\_\\\\__,_|_|_|___/"
    );
    
    Input.lore("A text-based adventure game where you must survive a dangerous journey to retrieve an invaluable artifact.");
    
    Input.clearConsole();
    
    while (stay) {
      System.out.println("Select an option:\n1. Play game\n2. Leaderboard\n3. Personal Statistics\n4. Quit");
      int choice = Input.intCheck(1, 4);
      System.out.println();

      switch (choice) {
        case 1: 
          System.out.println("Please enter your username (case sensitive, any spaces will be removed)");
          String username = "";
          while (username.equals("")) {
            username = Input.strIn().replaceAll(" ", "");
          }
          System.out.println("\nChoose an option:\n1. New game\n2. Load game (must be an existing user)");
          int gameChoice = Input.intCheck(1, 2);
          Player player = null;
          if (gameChoice == 1) {
            player = new Player(username);

          Input.clearConsole(); 
            
            Game game = new Game(player);
            game.play();
          }
          else {
            Data.loadData();
            for (int i = 0; i < Data.players.size(); i++) {
              if (Data.players.get(i).getUsername().equals(username)) {
                player = Data.players.get(i);
                i = Data.players.size();
              }
            }
            if (player == null || player.getEventsPassed() == 0) {
              System.out.println("\nYou do not have an existing game. Returning to main menu.\n");
              
              Sleep.wait(Sleep.LONG_DELAY);
              Input.clearConsole();
            }
            else {
              Game game = new Game(player);
              game.gameLoop();
            }
          }
          break;

        case 2: 
          Data.leaderboard();
          break;

        case 3:
          Data.personalStats();
          break;
          
        case 4: //quit
          System.out.println("Thanks for playing!");
          stay = false;
          // TODO potentially make stay global?
          break;
      }
      System.out.println();
    }
  }
}
