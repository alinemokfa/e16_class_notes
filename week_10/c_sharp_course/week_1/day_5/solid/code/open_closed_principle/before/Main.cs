class Runner {
  public static void Main()
  {
    Boxer boxer = new Boxer(20,10);
    boxer.EnterEvent();
    Gymnast gymnast = new Gymnast(8,9);
    gymnast.EnterEvent();
  }
}