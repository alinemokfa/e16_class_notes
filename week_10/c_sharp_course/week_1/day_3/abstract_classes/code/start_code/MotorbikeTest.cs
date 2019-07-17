using System;
using NUnit.Framework;

[TestFixture]
public class MotorbikeTest
{
  Motorbike motorbike;

  [SetUp]
  public void Init()
  {
      motorbike = new Motorbike();
  }

  [Test]
  public void TestMotorbikeCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm (I'm a motorbike), HELL YEAH!", motorbike.StartEngine());
  }

  [Test]
  public void TestCarHasNumberOfWheels()
  {
      Assert.AreEqual(2, motorbike.NumberOfWheels);
  }
}