/**
 * This class contains actions of a bow in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Bow implements Weapon {
  
  protected final int BASE_DAMAGE = 5;
  protected final double EVASION_ODDS = 0.6;
  protected final double ENEMY_BONUS_ODDS = 0;

  /**
   * Uses the bow
   */
  @Override
  public int use() {

    int damage = BASE_DAMAGE + (int)(Math.round(Math.random() * 10));

    System.out.println("You draw your bow...");
    
    Sleep.waitShort();
    System.out.println(".");
    Sleep.waitShort();
    System.out.println("..");
    Sleep.waitShort();
    System.out.println("...");
    Sleep.waitLong();

    System.out.println("And release!");

    return damage;
  }

  /**
   * Contains the description about the dagger 
   */
  public static String description() {
    return "Commonly used by archers, the bow is a ranged weapon used to safely deal damage from a distance.\nDeals 5-15 damage to enemies, and enemy attacks have a 60% chance to miss.";
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