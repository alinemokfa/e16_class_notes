using NUnit.Framework;

namespace WizardManagement { 

  [TestFixture]
  public class BroomstickTest {
    Broomstick broom;

    [SetUp]
    public void Init() 
    {
      broom = new Broomstick("Nimbus",10);
    }

    [Test]
    public void HasBrand(){
      Assert.AreEqual("Nimbus", broom.Brand);
    }

    [Test]
    public void HasSpeed(){
      Assert.AreEqual(10, broom.Speed);
    }

    [Test]
    public void CanFly(){
      Assert.AreEqual("mounting broom, running, skipping, flying!", broom.Fly());
    }

  }
}