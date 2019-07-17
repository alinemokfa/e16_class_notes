using System;
using System.IO;

public class AthleteFileLog : IAthleteLog {

  public void Distance(int lastRunDistance, int totalDistance)
  {
    string thisRun = "This run was "+ lastRunDistance + " meters";
    string totalRuns = "I have ran "+ totalDistance + " meters in total";
    try 
    {
      this.Log(thisRun, totalRuns);
    }
    catch(FileNotFoundException ex) 
    {
      Console.WriteLine("Failed to write file "+ ex.Message);
    }
  }

  private void Log(String lastRunDistance, String totalDistance)
  {
    StreamWriter writer = new StreamWriter("athleteLog.txt");
    writer.WriteLine(lastRunDistance);
    writer.WriteLine(totalDistance);
    writer.Close();
  }

}