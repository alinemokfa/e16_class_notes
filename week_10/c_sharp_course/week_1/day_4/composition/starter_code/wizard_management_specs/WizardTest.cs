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
      Assert.AreEqual("Nimbus", wizard.Broomstick.Brand);
    }

    [Test]
    public void CanFly()
    {
      Assert.AreEqual("mounting broom, running, skipping, flying!", wizard.Fly());
    }
  }
}