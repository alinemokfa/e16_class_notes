using System;
using NUnit.Framework;

[TestFixture]
public class CarTest
{
  Car car;

  [SetUp]
  public void Init()
  {
      car = new Car();
  }

  [Test]
  public void TestCarCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm", car.StartEngine());
  }
}