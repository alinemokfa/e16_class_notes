public class Athlete {
  private AthleteLog log;
  private int totalDistance;

  public Athlete(AthleteLog log){
    this.log = log;
  }

  public void Run(int distance)
  {
    totalDistance += distance;
    this.log.Distance(distance, totalDistance);
  }

  public void SetLog(AthleteLog log)
  {
    this.log = log;
  }
}