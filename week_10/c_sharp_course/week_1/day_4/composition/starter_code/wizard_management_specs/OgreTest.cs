using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class OgreTest {
    Ogre ogre;

    [SetUp]
    public void Init() 
    {
      ogre = new Ogre("Freddie");
    }

    [Test]
    public void HasName()
    {
      Assert.AreEqual("Freddie", ogre.Name);
    }
  }
}