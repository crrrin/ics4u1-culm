import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 * The class to store data of the player
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Data {

  protected static ArrayList<Player> players = new ArrayList<Player>();
  public static final int LEADERBOARD_SIZE = 10;
  
  /**
   * Saves data to a text file.
   */
  public static void saveData() {
    PrintWriter databaseWriter = null; //initialize outside of try/catch
    try {
      databaseWriter = new PrintWriter(new BufferedWriter(new FileWriter("Database.txt", false)));
      for (int i = 0; i < players.size(); i++) {
        databaseWriter.println(players.get(i).getUsername() + " " + players.get(i).getHealth() + " " + players.get(i).getEventsPassed() + " " + players.get(i).getMoney() + " " + players.get(i).getSmallHeals() + " " + players.get(i).getBigHeals() + " " + players.get(i).getWeapon().toString() + " " + players.get(i).getPlaythroughs() + " " + players.get(i).getGamesWon());
        for (int j = 0; j < players.get(i).getEventNumbers().size(); j++) {
          databaseWriter.print(players.get(i).getEventNumbers().get(j) + " ");
        }
        if (i != players.size() - 1)
        {
          databaseWriter.println();
        }
      }
    }
    catch (IOException e) {} 
    finally {
      if (databaseWriter != null) {
        databaseWriter.close();
      }
    }
  }
  
  /**
   * Loads data from a text file.
   */
  public static void loadData() {
    Scanner databaseReader = null; //initialize outside try/catch
    try {
      databaseReader = new Scanner(new BufferedReader(new FileReader("Database.txt")));
      while (databaseReader.hasNext()) {
        // loads from database file in the format:
        // username(String) health (int) eventsPassed(int) money(int)  weapon(Weapon, stored as String) playthroughs(int) gamesWon(int)
        // unusedEvents(ArrayList<String>)
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
        String[] eventNames = databaseReader.nextLine().split(" ");

        Weapon weapon = null;
        switch(weaponStr){
          case "Dagger":
            weapon = new Dagger();
          case "Bow":
            weapon = new Bow();
          case "Sword":
            weapon = new Sword();
        } //TODO if more weapons added

        ArrayList<Integer> eventNumbers = new ArrayList<Integer>();
        for (int i = 0; i < eventNames.length; i++) {
          eventNumbers.add(Integer.parseInt(eventNames[i]));
        }
        
        Player fromFile = new Player(username, health, eventsPassed, money, smallHeals, bigHeals, weapon, playthroughs, gamesWon, eventNumbers);
        addPlayer(fromFile);
      }
    } 
    catch (IOException e) {
      System.out.println("Error reading file"); // TODO remove later
    } 
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
    for (int i = 0; i < players.size(); i++) {
      
      if (players.get(i).equals(player)) {
        players.get(i).setHealth(player.getHealth());
        players.get(i).setEventsPassed(player.getEventsPassed());
        players.get(i).setMoney(player.getMoney());
        players.get(i).setSmallHeals(player.getSmallHeals());
        players.get(i).setBigHeals(player.getBigHeals());
        players.get(i).setWeapon(player.getWeapon());
        players.get(i).setEventNumbers(player.getEventNumbers());
        exists = true;
        i = players.size();
      }
    }
    
    if (!exists) {
      players.add(player);
    }
  }

  public static void leaderboard() {
    loadData();
    sortByWins();
    System.out.println("Leaderboard:");
    for (int i = 0; i < players.size() && i < LEADERBOARD_SIZE - 1; i++) {
      System.out.println((i + 1) + ". " + players.get(i).getUsername() + " - " + players.get(i).getGamesWon() + " wins");
    }
  }
  /**
   * Sorts the databse by number of wins from greatest to least
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

    // recursive step

    //split the array into 2

    int mid = arr.size() / 2;

    ArrayList<Player> left = new ArrayList<Player>(mid);
    ArrayList<Player> right = new ArrayList<Player>(arr.size() - mid);

    //left array
    for (int i = 0; i < left.size(); i++) {
      left.set(i, arr.get(i));
    }

    //right array
    for (int i = 0; i < right.size(); i++) {
      right.set(i, arr.get(i + mid));
    }

    mergeSort(left); //sort left
    mergeSort(right); //sort right

    mergeHelper(left, right, arr); //merge the sorted halves

  }

  /**
   * The helper function for mergeSort
   * @param left The first half of the array list
   * @param right The second half of the array list
   * @param og The original array list
   */
  public static void mergeHelper(ArrayList<Player> left, ArrayList<Player> right, ArrayList<Player> og) {

    int leftIndex = 0;
    int rightIndex = 0;
    int ogIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (left.get(leftIndex).compareTo(right.get(rightIndex)) > 0) {
        og.set(ogIndex, left.get(leftIndex++));
      }
      else {
        og.set(ogIndex, right.get(rightIndex++));
      }
      ogIndex++;
    }

    while (leftIndex < left.size()) {
      og.set(ogIndex++, left.get(leftIndex++));
    }

    while (rightIndex < right.size()) {
      og.set(ogIndex++, right.get(rightIndex++));
    }	
  }
}