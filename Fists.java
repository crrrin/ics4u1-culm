/**
 * Object containing actions of fists in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Fists implements Weapon {

  protected final int BASE_DAMAGE = 10;
  protected final double EVASION_ODDS = 0.3;

  /**
   * Uses fists
   * @return The damage dealt by fists
   */
  @Override
  public int use() {

    Input.dialogueln("You swing your fist.");
    return this.BASE_DAMAGE;
  }

  /**
   * Contains a description of fists 
   * @return A string with the description of fists
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