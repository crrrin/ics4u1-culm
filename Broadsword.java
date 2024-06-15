/**
 * Object containing actions of a broadsword in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Broadsword implements Weapon {

  protected static final int DAMAGE = 50;
  protected final double EVASION_ODDS = 0;
  protected static final double MISS_ODDS = 0.2;
    
  /**
   * Uses the broadsword
   * @return The damage dealt by the broadsword
   */
  @Override
  public int use() {
      
    GameIO.dialogueln("You swing your broadsword.");
  
    GameIO.wait(GameIO.LONG_DELAY);

    //if broadsword does not miss
    if (Math.random() > MISS_ODDS){
      return DAMAGE;
    }

    //broadsword misses
    GameIO.dialogueln("Your enemy dodged your attack, and you left yourself open to a deadly attack!");
    return 0;
      
  }
  
  /**
   * Contains a description of the broadsword
   * @return A string with a description of the broadsword
   */
  public static String description() {
    return 
      "Mastered by the monks, the broadsword is a powerful weapon that greatly rewards skill. It is a high risk but a high reward weapon.\n" + 
      "Deals a heavy " + DAMAGE + " damage, but improper usage leaves one vulnerable. There is a " + (int) (Math.round(100 * MISS_ODDS)) + "% chance to miss an attack, putting you into the Vulnerable state.\n" + 
      "When in the vulnerable state, take " + (int) (Math.round(100 * ENEMY_MULTIPLIER)) + "% damage from the enemy.";
  }
    
  /** 
   * Returns the name of the weapon
   * @return A string with the weapon name
   */
  @Override
  public String toString() {
    return "Broadsword";
  }
    
  /** 
   * Returns the odds of evasion
   * @return A double with the odds of evasion
   */
  @Override
  public double getEvasionOdds() {
    return this.EVASION_ODDS;
  }
}