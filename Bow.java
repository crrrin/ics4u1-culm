/**
 * This class contains actions of a bow in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Bow implements Weapon {
  
  protected final int DAMAGE = 4;

  /**
   * Uses the bow
   */
  @Override
  public int use() {
    System.out.println("You use your bow");
    return this.DAMAGE;
  }

  /**
   * Contains the description about the dagger 
   */
  @Override
  public void description() {
    System.out.println("Widely used by archers, the bow is a long range weapon used to safely deal damage at a distance.\nDeals medium damage to enemies."); // TODO dedscription
  }

  @Override
  public String toString() {
    return "Bow";
  }
}