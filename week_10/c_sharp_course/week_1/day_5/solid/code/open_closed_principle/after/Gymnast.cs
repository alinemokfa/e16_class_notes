using System;

public class Gymnast : Athlete{
  private int pointsForExecution;
  private int pointsForDifficulty;
  
  public Gymnast(int pointsForDifficulty, int pointsForExecution) 
  {
    this.pointsForExecution = pointsForExecution;
    this.pointsForDifficulty = pointsForDifficulty;
  }

  public override int CalculatePoints() 
  {
    this.points = this.pointsForDifficulty + this.pointsForExecution;
    Console.WriteLine("Gymnast gained: " + this.points + " points");
    return points;
  }
}