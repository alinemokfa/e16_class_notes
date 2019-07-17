package example.codeclan.com.godzilla;


public class Tank extends Vehicle implements Attack {


    public Tank(int healthValue, int attackValue){
        super(healthValue, attackValue);
    }

    public void attack(Kaiju kaiju){
        kaiju.subtractHealthValue(this.attackValue);
    }

    public void superAttack(Kaiju kaiju){
        kaiju.subtractHealthValue(this.attackValue * 2);
    }

}

