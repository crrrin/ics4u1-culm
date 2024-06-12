/**
 * This class contains actions of the player's fists in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Fists implements Weapon {

  protected final int BASE_DAMAGE = 5;
  protected final double EVASION_ODDS = 0.3;
  protected final double ENEMY_BONUS_ODDS = 0;

  /**
   * Uses fists
   */
  @Override
  public int use() {

    System.out.println("You swing your fist.");
    return this.BASE_DAMAGE;
  }

  /**
   * Contains the description about the dagger 
   */
  public static String description() {
    return "Deals 3 damage, but enemies have a 30% chance to miss their attacks on you.";
  }

  /** 
   * Returns the name of the weapon
   * @return A string with the weapon name
   */
  @Override
  public String toString() {
    return "Fists";
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