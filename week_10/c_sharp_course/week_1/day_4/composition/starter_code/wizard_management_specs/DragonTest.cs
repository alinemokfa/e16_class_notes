using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class DragonTest {
    Dragon dragon;

    [SetUp]
    public void Init() 
    {
      dragon = new Dragon("Bob");
    }

    [Test]
    public void HasName()
    {
      Assert.AreEqual("Bob", dragon.Name);
    }

    [Test]
    public void CanFly()
    {
      Assert.AreEqual("Standing up tall, beating wings, lift off!", dragon.Fly());
    }
  }
}