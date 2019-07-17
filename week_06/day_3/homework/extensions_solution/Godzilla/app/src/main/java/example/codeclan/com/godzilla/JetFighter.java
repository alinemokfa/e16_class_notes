package example.codeclan.com.godzilla;


public class JetFighter extends Vehicle {

    private int healthValue;
    private int attackValue;


    public JetFighter(int healthValue, int attackValue){
        super(healthValue, attackValue);
    }

    public void attack(Kaiju kaiju){
        kaiju.subtractHealthValue(this.attackValue);
    }

    public void superAttack(Kaiju kaiju){
        kaiju.subtractHealthValue(this.attackValue * 3);
    }

}

