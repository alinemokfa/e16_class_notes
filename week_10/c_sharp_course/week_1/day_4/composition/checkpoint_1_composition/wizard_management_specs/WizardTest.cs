using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class WizardTest {
    Wizard wizard;
    Broomstick broomstick;

    [SetUp]
    public void Init() 
    {
      broomstick = new Broomstick("Nimbus", 10);
      wizard = new Wizard("Toby", broomstick);
    }

    [Test]
    public void HasName()
    {
      Assert.AreEqual("Toby", wizard.Name);
    }

    [Test]
    public void HasBroomstick()
    {
      Broomstick ride = (Broomstick) wizard.Ride;
      Assert.AreEqual("Nimbus", ride.Brand);
    }

    [Test]
    public void CanFly()
    {
      Assert.AreEqual("mounting broom, running, skipping, flying!", wizard.Fly());
    }

    [Test]
    public void CanFlyDragon(){
      Dragon dragon = new Dragon("Tilly");
      wizard = new Wizard("Toby", dragon);
      Assert.AreEqual("Standing up tall, beating wings, lift off!", wizard.Fly());
    }

    [Test]
    public void CanFlyMagicCarpet(){
      MagicCarpet carpet = new MagicCarpet("Purple");
      wizard = new Wizard("Toby", carpet);
      Assert.AreEqual("Hovering up, straightening out, flying off!", wizard.Fly());
    }

    [Test]
    public void CanSetRide(){
      Dragon dragon = new Dragon("Erik");
      wizard.Ride = dragon;
      Assert.AreEqual("Standing up tall, beating wings, lift off!",wizard.Fly());
    }
  }
}