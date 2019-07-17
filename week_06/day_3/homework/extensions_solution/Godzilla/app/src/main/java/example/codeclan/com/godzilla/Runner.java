package example.codeclan.com.godzilla;

class Runner{
    public static void main(String[] args){
        Godzilla godzilla = new Godzilla("Godzilla", 100, 70);
        MechaGodzilla mechaGodzilla = new MechaGodzilla("MechaGodzilla", 100, 80);
        Tank tank = new Tank(100, 40);
        JetFighter jetFighter = new JetFighter(50, 30);
        godzilla.attackVehicle(tank);


        System.out.println("MechaGodzilla appears. It's current health is;");
        System.out.println(mechaGodzilla.getHealthValue());

        jetFighter.attack(mechaGodzilla);
        System.out.println("MechaGodzilla is attacked by a jet. Its health is now;");
        System.out.println(mechaGodzilla.getHealthValue());

        tank.attack(mechaGodzilla);
        System.out.println("MechaGodzilla is attacked by a tank. Its health is now;");
        System.out.println(mechaGodzilla.getHealthValue());

        System.out.println("MechaGodzilla stomps on tank");
        mechaGodzilla.attackVehicle(tank);
        System.out.println("The tank's health is now;");
        System.out.println(tank.getHealthValue());

//

        System.out.println("Godzilla emerges from the smoke. It's current health is;");
        System.out.println(godzilla.getHealthValue());

        jetFighter.attack(godzilla);
        System.out.println("Godzilla is attacked by a jet. Its health is now;");
        System.out.println(godzilla.getHealthValue());

        tank.attack(godzilla);
        System.out.println("Godzilla is attacked by a tank. Its health is now;");
        System.out.println(godzilla.getHealthValue());

        System.out.println("Godzilla attacks tank with nuclear blast");
        godzilla.attackVehicle(tank);
        System.out.println("The tank's health is now;");
        System.out.println(tank.getHealthValue());
    }
}
