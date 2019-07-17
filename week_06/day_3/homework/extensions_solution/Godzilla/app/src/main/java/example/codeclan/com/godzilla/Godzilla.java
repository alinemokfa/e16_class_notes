package example.codeclan.com.godzilla;

public class Godzilla extends Kaiju {

    private String name;


    public Godzilla(String name, int healthValue, int attackValue){
        super(name, healthValue, attackValue);
    }

    public String roar(){
        return "Roooooaooooaaaaaaaaar!!!";
    }


}
