/**
 * Object containing actions of a bow in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Bow implements Weapon {
  
  protected static final int BASE_DAMAGE = 15;
  protected static final double EVASION_ODDS = 0.5;
  protected static final int MAX_DAMAGE = 25;
  protected final int CHARGE_LENGTH = 3;
  protected static final int PRICE = 220;

  /**
   * Uses the bow
   * @return The damage value after calculations
   */
  @Override
  public int use() {
    int damage = BASE_DAMAGE + (int)(Math.round(Math.random() * (MAX_DAMAGE - BASE_DAMAGE))); //makes damage a random number between base damage and max damage
    
    GameIO.dialogue("You draw your bow");

    //charging loop
    for (int i = 0; i < CHARGE_LENGTH; i++) {
      GameIO.wait(GameIO.SHORT_DELAY); 
      System.out.print(".");
    }

    GameIO.wait(GameIO.LONG_DELAY);
    GameIO.dialogue(" and release!");

    return damage;
  }

  /**
   * Contains a description of the bow 
   * @return A string with the description of the bow
   */
  public static String description() {
    return 
      "Commonly used by archers, the bow is a ranged weapon used to safely deal damage from a distance.\n" + 
      "Deals "+ BASE_DAMAGE + "-" + MAX_DAMAGE + " damage to enemies, and enemy attacks have a " + (int) (Math.round(100 * EVASION_ODDS)) + "% chance to miss.";
  }

  /** 
   * Returns the name of the weapon
   * @return A string with the weapon name
   */
  @Override
  public String toString() {
    return "Bow";
  }

  /** 
   * Returns the odds of evasion
   * @return A double with the odds of evasion
   */
  @Override
  public double getEvasionOdds() {
    return EVASION_ODDS;
  }

  /** 
   * Returns the price of the weapon
   * @return An int with the price of the weapon
   */
  public static int getPrice() {
    return PRICE;
  }
}