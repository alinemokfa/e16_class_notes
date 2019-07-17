using System;
using System.Linq;
using System.Collections.Generic;

namespace LambdaExample {
    class Program
    {
        static void Main()
        {
          List<int> numbers = new List<int>{5, 8, 11, 14, 18, 23, 29, 30, };
          List<int> oddNumbers = numbers.Where(n => n % 2 == 1).ToList();

          foreach (var num in oddNumbers)
          {
            Console.WriteLine(num);
          }
        }
    }
}
