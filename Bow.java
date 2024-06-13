/**
 * This class contains actions of a bow in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Bow implements Weapon {
  
  protected final int BASE_DAMAGE = 5;
  protected final double EVASION_ODDS = 0.5;
  protected final double ENEMY_BONUS_ODDS = 0;
  protected final int MAX_DAMAGE = 15;
  protected final int CHARGE_LENGTH = 3;

  /**
   * Uses the bow
   * @return The damage dealt by the bow
   */
  @Override
  public int use() {

    int damage = BASE_DAMAGE + (int)(Math.round(Math.random() * (MAX_DAMAGE - BASE_DAMAGE))); //makes damage a random number between base damage and max damage
    
    System.out.print("You draw your bow");

    //charging loop
    for (int i = 0; i < CHARGE_LENGTH; i++) {
      Sleep.wait(Sleep.SHORT_DELAY); 
      System.out.print(".");
    }

    Sleep.wait(Sleep.LONG_DELAY);
    System.out.println(" and release!");

    return damage;
  }

  /**
   * Contains a description of the bow 
   * @return A string with the description of the bow
   */
  public static String description() {
    return "Commonly used by archers, the bow is a ranged weapon used to safely deal damage from a distance.\nDeals 5-15 damage to enemies, and enemy attacks have a 50% chance to miss.";
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
  public double getEvasionOdds(){
    return EVASION_ODDS;
  }

}