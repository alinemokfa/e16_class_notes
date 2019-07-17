using Behaviours;

namespace WizardManagement {
  public class Dragon : MythicalBeast, IFly {
    public Dragon(string name) : base(name)
    {

    }

    public string Fly(){
      return "Standing up tall, beating wings, lift off!";
    }
  }
}