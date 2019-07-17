using System;

public abstract class Athlete {

  protected int points;

  public void Prepare()
  {
    Console.WriteLine("Warming up");
  }

  public void Compete() 
  {
    Console.WriteLine("I am competing");
  }

  public abstract int CalculatePoints();

  public void RecieveMedal() 
  {
    string medal = "None";

    if (this.points >= 15) 
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
    Console.WriteLine("Medal gained: " + medal);
  }

  public void EnterEvent()
  {
    Prepare();
    Compete();
    CalculatePoints();
    RecieveMedal();
  }
}