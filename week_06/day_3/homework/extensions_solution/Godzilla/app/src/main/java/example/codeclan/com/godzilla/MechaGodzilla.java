package example.codeclan.com.godzilla;

public class MechaGodzilla extends Kaiju {

    private String name;
    private int healthValue;
    private int attackValue;

    public MechaGodzilla(String name, int healthValue, int attackValue){
        super(name, healthValue, attackValue);
    }

    public String roar(){
        return "Mecha.......Roooooaooooaaaaaaaaar!!!";
    }




}