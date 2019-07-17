using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class MopTest {
    Mop mop;

    [SetUp]
    public void Init() 
    {
      mop = new Mop("Hygenic");
    }

    [Test]
    public void HasBrand()
    {
      Assert.AreEqual("Hygenic", mop.Brand);
    }

  }
}