using System;

public class Sprinter : IOlympian {
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

  public void Swim() 
  {
    throw new SystemException();
  }

  public void ComeUpForAir() 
  {
    throw new SystemException();
  }

  public void Pedal() 
  {
    // do nothing
  }

  public void Brake() 
  {
    // do nothing
  }
}