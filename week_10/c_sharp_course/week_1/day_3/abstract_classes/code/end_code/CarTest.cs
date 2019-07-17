using System;
using NUnit.Framework;

[TestFixture]
public class CarTest
{
  Car car;

  [SetUp]
  public void Init()
  {
      car = new Car("Ferrari");
  }

  [Test]
  public void TestCarHasModel()
  {
    Assert.AreEqual("Ferrari", car.Model);
  }

  [Test]
  public void TestCarCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm", car.StartEngine());
  }

  [Test]
  public void TestCarHasNumberOfWheels()
  {
      Assert.AreEqual(4, car.NumberOfWheels);
  }

  [Test]
  public void TestCarCanDrive()
  {
      Assert.AreEqual("use steering wheel", car.Drive());
  }

}