class BusStop {
  private String location;
  private Person[] people;

  public BusStop(String location) {
    this.location = location;
    people = new Person[20];
  }

  public String getLocation() {
    return this.location;
  }

  public int personCount() {
    int count = 0;
    for (Person person : people) {
      if (person != null) {
        count++;
      }
    }
    return count;
  }

  public void addPerson(Person person) {
    int personCount = this.personCount();
    this.people[personCount] = person;
  }

  public void stopBus(Bus bus) {
    for (int i = 0; i < this.people.length; i++) {
      if (this.people[i] != null) {
        bus.addPassenger(this.people[i]);
        this.people[i] = null;
      }
    }
  }
}
