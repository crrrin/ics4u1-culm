/**
 * Object containing actions of a broadsword in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

 class Broadsword implements Weapon {

  protected final int DAMAGE = 50;
  protected final double EVASION_ODDS = 0;
  protected final double MISS_ODDS = 0.1;
    
  /**
   * Uses the broadsword
   * @return The damage dealt by the broadsword
   */
  @Override
  public int use() {
      
    System.out.println("You swing your broadsword.");
  
    Sleep.wait(Sleep.LONG_DELAY);

    //if broadsword does not miss
    if (Math.random() > MISS_ODDS){
      return this.DAMAGE;
    }

    //broadsword misses
    System.out.println("Your enemy dodged your attack, and you left yourself open to a deadly attack!");
    return 0;
      
  }
  
  /**
   * Contains a description of the broadsword
   * @return A string with a description of the broadsword
   */
  public static String description() {
    return "Forged by skilled blacksmiths, the sword is a long and deadly weapon.\nDeals a humble 8 damage, but has a 30% chance to deal a critial hit.\nCritical hits deal +150-200% damage.\nFavoured by renowned knights of the kingdom, it is the weapon that the king has graced you with as you set out on this journey.";
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
    return EVASION_ODDS;
  }
}