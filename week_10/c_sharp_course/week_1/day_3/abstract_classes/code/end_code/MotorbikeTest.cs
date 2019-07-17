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
  public void TestMotorbikeHasNumberOfWheels()
  {
      Assert.AreEqual(2, motorbike.NumberOfWheels);
  }

  [Test]
  public void TestMotorbikeCanDrive()
  {
      Assert.AreEqual("use handlebars", motorbike.Drive());
  }
}