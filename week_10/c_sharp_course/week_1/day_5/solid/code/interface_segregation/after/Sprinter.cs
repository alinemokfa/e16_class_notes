public class Sprinter : IOlympicRunner {
  private int totalDistance;
  private int hydration;

  public void Sprint(int distance)
  {
    totalDistance += distance;
  }

  public void DrinkWater() 
  {
    hydration++;
  }

  public void JumpHurdle() 
  {
    hydration--;
  }
}