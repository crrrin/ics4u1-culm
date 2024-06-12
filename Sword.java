/**
 * This class contains actions of a sword in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Sword implements Weapon {

  protected final int DAMAGE = 8;
  protected final double CRIT_ODDS = 0.3;
  protected int critDamage;
  protected final double EVASION_ODDS = 0;
  
  
  
  /**
   * Uses the sword
   */
  @Override
  public int use() {
    boolean crit = Math.random() < CRIT_ODDS;
    
    System.out.println("You swing your sword.");

    Sleep.wait(Sleep.GENERIC_LONG_DELAY_MS);
    
    if (crit) {
// TODO make the crit bonus slightly random
      this.critDamage = (int) Math.round(this.DAMAGE * (Math.random() * 0.5 + 1.5));
      System.out.println("CRITICAL HIT!"); 

      return this.critDamage;
    } else {
      return this.DAMAGE;
    }
    
  }

  /**
   * Contains the description about the sword
   */
  public static void description() {
    System.out.println("Forged by skilled blacksmiths, the sword is a long and deadly weapon.\nDeals a humble 8 damage, but has a 30% chance to deal a critial hit.\nCritical hits deal +150-200% damage.\nFavoured by renowned knights of the kingdom, it is the weapon that the king has graced you with as you set out on this journey.");
  }

  /** 
   * Returns the name of the weapon
   * @return A string with the weapon name
   */
  @Override
  public String toString() {
    return "Sword";
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