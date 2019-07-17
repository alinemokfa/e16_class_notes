using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class MagicCarpetTest {
    MagicCarpet magicCarpet;

    [SetUp]
    public void Init() 
    {
      magicCarpet = new MagicCarpet("Yellow");
    }

    [Test]
    public void HasColour()
    {
      Assert.AreEqual("Yellow", magicCarpet.Colour);
    }

    [Test]
    public void CanFly()
    {
      Assert.AreEqual("Hovering up, straightening out, flying off!", magicCarpet.Fly());
    }
  }
}