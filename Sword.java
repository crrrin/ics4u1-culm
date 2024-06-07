/**
 * This class contains actions of a sword in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Sword implements Weapon {

  protected final int DAMAGE = 7;
  protected final double CRIT_ODDS = 0.3;
  protected final double CRIT_DAMAGE_BONUS = 1.5;
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

      System.out.println("CRITICAL HIT!");

      return (int) Math.round(this.DAMAGE + this.DAMAGE * CRIT_DAMAGE_BONUS);
    } else {
      return this.DAMAGE;
    }
    
  }

  /**
   * Contains the description about the sword
   */
  @Override
  public void description() {
    System.out.println("Forged by skilled blacksmiths, the sword is a long and deadly weapon.\nDeals a not-too-special 7 damage, but has a 30% chance to deal a critial hit.\nCritical hits deal +150% damage.\nFavoured by renowned knights of the kingdom, it is the weapon that the king has graced you with as you set out on this journey.");
  }

  @Override
  public String toString() {
    return "Sword";
  }

  @Override
  public double getEvasionOdds(){
    return EVASION_ODDS;
  }
}