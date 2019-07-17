using System;

namespace DivideByZeroException {
    class Program
    {
        static void Main()
        {
          try {
            int one = 1;
            int zero = 0;
            Console.WriteLine(one / zero);
          }
          catch (System.DivideByZeroException ex)
          {
            Console.WriteLine("ERROR!: " + ex.Message);
          }
        }
    }
}