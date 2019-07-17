public class Athlete {
  private AthleteConsoleLog log;
  private int totalDistance;

  public Athlete()
  {
    this.log = new AthleteConsoleLog();
  }

  public void Run(int distance)
  {
    totalDistance += distance;
    this.log.Distance(distance, totalDistance);
  }
}