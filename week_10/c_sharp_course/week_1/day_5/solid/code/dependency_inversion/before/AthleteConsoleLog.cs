using System;

public class AthleteConsoleLog {

  public void Distance(int lastRunDistance, int totalDistance) 
  {
    string thisRun = "This run was " + lastRunDistance + " meters";
    string totalRun = "I have ran " + totalDistance + " meters in total";
    Console.WriteLine(thisRun);
    Console.WriteLine(totalRun);
  }
}