using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class RugTest {
    Rug rug;

    [SetUp]
    public void Init() 
    {
      rug = new Rug("Yellow");
    }

    [Test]
    public void HasColour()
    {
      Assert.AreEqual("Yellow", rug.Colour);
    }
  }
}