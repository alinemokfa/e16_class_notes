public class Athlete {
  private int totalDistance;
  private AthleteConsoleLog log;

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