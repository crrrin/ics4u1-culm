/**
 * This class contains actions of a bow in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Bow implements Weapon {
  
  protected final int BASE_DAMAGE = 5;
  protected final double EVASION_ODDS = 0.2;

  /**
   * Uses the bow
   */
  @Override
  public int use() {

    int damage = BASE_DAMAGE + (int)(Math.round(Math.random() * 10));

    System.out.println("You draw your bow...");
    
    Sleep.wait(Sleep.GENERIC_TINY_DELAY_MS);
    System.out.println(".");
    Sleep.wait(Sleep.GENERIC_TINY_DELAY_MS);
    System.out.println("..");
    Sleep.wait(Sleep.GENERIC_SHORT_DELAY_MS);
    System.out.println("...");
    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);

    System.out.println("And release!");

    return damage;
  }

  /**
   * Contains the description about the dagger 
   */
  @Override
  public void description() {
    System.out.println("Commonly used by archers, the bow is a ranged weapon used to safely deal damage from a distance.\nDeals 5-15 damage to enemies, and enemy attacks have a 20% chance to miss."); // TODO ENEMY MISS BASED ON PLAYER WEAPON?
  }

  @Override
  public String toString() {
    return "Bow";
  }

  @Override
  public double getEvasionOdds(){
    return EVASION_ODDS;
  }

}