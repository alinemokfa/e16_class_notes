class Runner {

  public static void Main(){
    Athlete athlete = new Athlete(new AthleteConsoleLog());
    athlete.Run(10);   
    Athlete athlete2 = new Athlete(new AthleteFileLog());
    athlete.Run(2);
  }
  
}