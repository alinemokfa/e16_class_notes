using System;

public class Boxer {
  private int hitsTaken;
  private int hitsGiven;
  private int points;

  public Boxer(int hitsGiven, int hitsTaken)
  {
    this.hitsTaken = hitsTaken;
    this.hitsGiven = hitsGiven;
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
    this.points = this.hitsGiven - this.hitsTaken;
    Console.WriteLine("Boxer gained: " + points + " points");
    return points;
  }

  public void RecieveMedal()
  {
    string medal = "None";

    if(this.points >= 15) 
    {
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

    Console.WriteLine("Medal gained: "+ medal);
  }

  public void EnterEvent(){
    WarmUp();
    Compete();
    CalculatePoints();
    RecieveMedal();
  }
}