import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 * Utility class to store data of all players
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Data {

  protected static ArrayList<Player> players = new ArrayList<Player>();
  public static final int LEADERBOARD_SIZE = 10;
  public static final String FILE_NAME = "Utility/Database.txt";
  
  /**
   * Saves data about all players to a text file.
   */
  public static void saveData() {
    PrintWriter databaseWriter = null;

    // try-catch block to catch any exceptions while writing to the file
    try {
      databaseWriter = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, false)));

      // write each player's data to the file, in the following format:
      // username health eventsPassed money basicPotions superPotions weapon playthroughs gamesWon
      // event numbers that haven't been played yet with spaces in between
      for (int i = 0; i < players.size(); i++) {
        
        //line 1
        databaseWriter.println(players.get(i).getUsername() + " " + players.get(i).getHealth() + " " + players.get(i).getEventsPassed() + " " + players.get(i).getMoney() + " " + players.get(i).getSmallHeals() + " " + players.get(i).getBigHeals() + " " + players.get(i).getWeapon().toString() + " " + players.get(i).getPlaythroughs() + " " + players.get(i).getGamesWon());

        //line 2
        for (int j = 0; j < players.get(i).getEventNumbers().size(); j++) {
          databaseWriter.print(players.get(i).getEventNumbers().get(j) + " ");
        }
        
        //prints new line if not on last player
        if (i != players.size() - 1)
        {
          databaseWriter.println();
        }
      }
    }
      
    catch (IOException e) {} 

    //closes print writer
    finally {
      if (databaseWriter != null) {
        databaseWriter.close();
      }
    }
  }
  
  /**
   * Loads data about all players from a text file
   */
  public static void loadData() {
    Scanner databaseReader = null;

    // try-catch block to catch any exceptions while reading from the file
    try {
      databaseReader = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));

      // reads each player from database file in the format:
        // username(String) health (int) eventsPassed(int) money(int) basicPotions(int) superPotions(int)  weapon(Weapon, stored in a String as weaponStr) playthroughs(int) gamesWon(int)
        // eventNumbers(ArrayList<Integer>, stored in a String[] as eventNames)
      while (databaseReader.hasNext()) {

        //line 1
        String username = databaseReader.next();
        int health = databaseReader.nextInt();
        int eventsPassed = databaseReader.nextInt();
        int money = databaseReader.nextInt();
        int smallHeals = databaseReader.nextInt();
        int bigHeals = databaseReader.nextInt();
        String weaponStr = databaseReader.next();
        int playthroughs = databaseReader.nextInt();
        int gamesWon = databaseReader.nextInt();
        databaseReader.nextLine();

        //line 2
        String[] eventNames = databaseReader.nextLine().split(" ");

        //converting weapon String to Weapon object
        Weapon weapon = null;
        switch (weaponStr) {
          case "Dagger":
            weapon = new Dagger();
            break;
          case "Bow":
            weapon = new Bow();
            break;
          case "Sword":
            weapon = new Sword();
            break;
          case "Fists":
            weapon = new Fists();
            break;
          case "Broadsword":
            weapon = new Broadsword();
            break;
        }

        //converting eventNames String[] to eventNumbers ArrayList<Integer>
        ArrayList<Integer> eventNumbers = new ArrayList<Integer>();
        for (int i = 0; i < eventNames.length; i++) {
          eventNumbers.add(Integer.parseInt(eventNames[i]));
        }
        
        Player fromFile = new Player(username, health, eventsPassed, money, smallHeals, bigHeals, weapon, playthroughs, gamesWon, eventNumbers); //creates new player from file data
        addPlayer(fromFile); //tries to add player to database
      }
    } 
      
    catch (IOException e) {}

    //closes scanner
    finally {
      if (databaseReader != null) {
        databaseReader.close();
      }
    }
  }

  /**
   * Adds a given player to the database; if the player already exists, it will update the stats of the player.
   * @param player The player to be added
   */
  public static void addPlayer(Player player) {
    boolean exists = false;

    //sequentially searches for player in database
    for (int i = 0; i < players.size(); i++) {

      //if player already exists, updates all information
      if (players.get(i).equals(player)) {
        players.get(i).setHealth(player.getHealth());
        players.get(i).setEventsPassed(player.getEventsPassed());
        players.get(i).setMoney(player.getMoney());
        players.get(i).setSmallHeals(player.getSmallHeals());
        players.get(i).setBigHeals(player.getBigHeals());
        players.get(i).setWeapon(player.getWeapon());
        players.get(i).setPlaythroughs(player.getPlaythroughs());
        players.get(i).setGamesWon(player.getGamesWon());
        players.get(i).setEventNumbers(player.getEventNumbers());
        
        exists = true;
        i = players.size(); //exits for loop
      }
    }

    //if player doesn't exist, adds player to database
    if (!exists) {
      players.add(player);
    }
  }

  /**
   * Displays the players with the most wins
   */
  public static void leaderboard() {

    int displayScore = 1; 
    
    loadData(); //loads current player data from file
    sortByWins(); //sorts database by most wins

    System.out.println(
      "LEADERBOARD\n" +                 
      "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
   
    //goes through array until it reaches the leaderboard size or the end of the databse
    for (int i = 0; i < players.size() && i < LEADERBOARD_SIZE; i++) {

      //first user will always simply be 1.
      if (i == 0) {
        System.out.println(displayScore + ". " + players.get(i).getUsername() + ": " + players.get(i).getGamesWon() + " wins");
      }
      
      // users after have the chance of tying in number of wins with previous user; if tied, doesn't increment their rank
      // only increments rank once there is a user who isn't tied with previous user(s)
      if (i > 0) {

        //if users are tied
        if (players.get(i).getGamesWon() == players.get(i - 1).getGamesWon()) { 
          System.out.println(displayScore + ". " + players.get(i).getUsername() + ": " + players.get(i).getGamesWon() + " wins");
        } 

        //if users are not died
        else {
          displayScore = i + 1;
          System.out.println(displayScore + ". " + players.get(i).getUsername() + ": " + players.get(i).getGamesWon() + " wins");
            }
        }

    }
    System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
  }
  
  /**
   * Displays the user's playthroughs and games won
   */
  public static void personalStats() {
    loadData(); //loads current player data from file
    
    System.out.println("Please enter the username you want to see the stats of.");
    String username = Input.strIn();
    boolean exists = false;

    //sequentially searches for player in database
    for (int i = 0; i < players.size(); i++) {

      //if player exists, prints out their stats
      if (players.get(i).getUsername().equals(username)) {
        System.out.println("Playthroughs: " + players.get(i).getPlaythroughs());
        System.out.println("Games won: " + players.get(i).getGamesWon());
        exists = true;
        i = players.size(); //exits for loop
      }
    }

    //if player doesn't exist, prints error message
    if(!exists) {
      System.out.println("Player not found. Returning to main menu.");
    }

    Sleep.wait(Sleep.LONG_DELAY);
  }
  
  /**
   * Sorts the database by number of wins from greatest to least
   */
  public static void sortByWins() {
    mergeSort(players);
  }

  /**
   * Sorts a player array list by most to least game wins
   * @param arr The array list to be sorted 
   */
  public static void mergeSort(ArrayList<Player> arr) {

    //base case
    if (arr.size() < 2) {
      return;
    }

    //recursive step - splitting array list into 2
    int mid = arr.size() / 2;

    ArrayList<Player> left = new ArrayList<Player>(mid);
    ArrayList<Player> right = new ArrayList<Player>(arr.size() - mid);

    //left array list
    for (int i = 0; i < mid; i++) {
      left.add(arr.get(i));
    }

    //right array list
    for (int i = 0; i < arr.size()-mid; i++) {
      right.add(arr.get(i + mid));
    }

    mergeSort(left); //sort left
    mergeSort(right); //sort right

    mergeHelper(left, right, arr); //merge the sorted halves

  }

  /**
   * The helper function for mergeSort, merges 2 given array lists back into original
   * @param left The first half of the array list
   * @param right The second half of the array list
   * @param og The original array list
   */
  public static void mergeHelper(ArrayList<Player> left, ArrayList<Player> right, ArrayList<Player> og) {

    int leftIndex = 0;
    int rightIndex = 0;
    int ogIndex = 0;

    //while there are still players in both halves
    while (leftIndex < left.size() && rightIndex < right.size()) {

      //if left player has more wins, adds left player to original array list
      if (left.get(leftIndex).getGamesWon() > right.get(rightIndex).getGamesWon()) {
        og.set(ogIndex, left.get(leftIndex++));
      }

      //if right player has more wins, adds right player to original array list
      else {
        og.set(ogIndex, right.get(rightIndex++));
      }
      
      ogIndex++;
    }

    //if there are still players in left half, adds them to original array list
    while (leftIndex < left.size()) {
      og.set(ogIndex++, left.get(leftIndex++));
    }

    //if there are still players in right half, adds them to original array list
    while (rightIndex < right.size()) {
      og.set(ogIndex++, right.get(rightIndex++));
    }	
  }
}