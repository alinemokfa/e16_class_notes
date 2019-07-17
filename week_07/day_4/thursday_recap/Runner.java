public class Runner {
  public static void main(String[] args) {
    System.out.println("Hello world");

    //this is like in ruby saying
    //value1 = args[0].to_i
    int value1 = Integer.parseInt(args[0]);

    //value2 = args[1].to_i
    int value2 = Integer.parseInt(args[1]);

    System.out.println(value1 + value2);
  }
}

//Runner runner = new Runner();
//runner.main();

//Runner.main();
