using System;

public class Gymnast {
  private int pointsForExecution;
  private int pointsForDifficulty;
  private int points;

  public Gymnast(int pointsForDifficulty, int pointsForExecution)
  {
    this.pointsForExecution = pointsForExecution;
    this.pointsForDifficulty = pointsForDifficulty;
  }

  public void Prepare()
  {
    Console.WriteLine("Warming up");
  }

  public void Compete()
  {
    Console.WriteLine("I am competing");
  }

  public int CalculatePoints()
  {
    this.points = this.pointsForDifficulty + this.pointsForExecution;
    Console.WriteLine("Gymnast gained: "+ points + " points");
    return points;
  }

  public void RecieveMedal()
  {
    string medal = "None";

    if(this.points >= 15) {
      medal = "Gold";
    }
    else if(points >= 10 && points <= 14) 
    {
      medal = "Silver";
    }
    else if(points >= 5 && points <= 9) 
    {
      medal = "Bronze";
    }

    Console.WriteLine("Medal gained: " + medal);
  }

  public void EnterEvent()
  {
    WarmUp();
    Compete();
    CalculatePoints();
    RecieveMedal();
  }
}