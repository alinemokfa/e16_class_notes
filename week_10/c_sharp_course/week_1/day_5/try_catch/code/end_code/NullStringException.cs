using System;

public class NullStringException : Exception
{
  public NullStringException(string message) : base(message)
  {
  }
}