using System;

public class Athlete {
  private int totalDistance;

  public void Run(int distance)
  {
    totalDistance += distance;
    WriteDistanceLog(distance, totalDistance);
  }

  public void WriteDistanceLog(int distance, int totalDistance)
  {
    string thisRun = "This run was "+ distance + " meters";
    string totalRun = "I have ran "+ totalDistance + " meters in total";
    Console.WriteLine(thisRun);
    Console.WriteLine(totalRun);
  }
}