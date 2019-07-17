using System;

public class AthleteConsoleLog {

  public void Distance(int lastRunDistance, int totalDistance)
  {
    String thisRun = "This run was "+lastRunDistance+" meters";
    String totalRun = "I have ran "+totalDistance+" meters in total";
    Console.WriteLine(thisRun);
    Console.WriteLine(totalRun);
  }
}