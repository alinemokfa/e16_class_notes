using System;

public class Boxer : Athlete {
  private int hitsTaken;
  private int hitsGiven;

  public Boxer(int hitsGiven, int hitsTaken) 
  {
    this.hitsTaken = hitsTaken;
    this.hitsGiven = hitsGiven;
  }

  public override int CalculatePoints() 
  {
    this.points = this.hitsGiven - this.hitsTaken;
    Console.WriteLine("Boxer gained: "+ this.points + " points");
    return points;
  }
}