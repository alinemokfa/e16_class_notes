using System;
using NUnit.Framework;

[TestFixture]
public class VehicleTest
{
  Vehicle vehicle;

  [SetUp]
  public void Init()
  {
      vehicle = new Vehicle(4);
  }

  [Test]
  public void TestVehicleCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm", vehicle.StartEngine());
  }

  [Test]
  public void TestVehicleHasNumberOfWheels()
  {
      Assert.AreEqual(4, vehicle.NumberOfWheels);
  }
}