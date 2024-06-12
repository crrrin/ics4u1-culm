class Main {
  public static void main(String[] args) {
    mainMenu();
  }

  /**
   * Creates the main menu for the user to access.
   */
  public static void mainMenu() {
    boolean stay = true;

    while (stay) {
      Input.lore("Welcome to Blackjack! A text-based adventure game where you must survive a dangerous journey to retrieve an invaluable artifact.");
      System.out.println("Select an option:\n1. Play game\n2. Leaderboard\n3. Quit");
      int choice = Input.intCheck(1, 3);
      System.out.println();

      switch (choice) {
        case 1: 
          System.out.println("Please enter your username (any spaces will be removed)");
          String username = "";
          while (username.equals("")) {
            username = Input.strIn().replaceAll(" ", "");
          }
          System.out.println("\nChoose an option:\n1. New game\n2. Load game (must be an existing user)");
          int gameChoice = Input.intCheck(1, 2);
          Player player = null;
          if (gameChoice == 1) {
            player = new Player(username);
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
            if (player == null) {
              System.out.println("\nYou do not have an existing game. Returning to main menu.\n");
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

        case 3: //quit
          System.out.println("Thanks for playing!");
          stay = false;
          // TODO potentially make stay global?
          break;
      }
      System.out.println();
    }
  }
}
