class Bus {
  private int routeNumber;
  private String start;
  private String destination;
  private Person[] passengers;

  public Bus(int routeNumber, String start, String destination, int capacity) {
    this.routeNumber = routeNumber;
    this.start = start;
    this.destination = destination;
    this.passengers = new Person[capacity];
  }

  public int getRouteNumber() {
    return this.routeNumber;
  }

  public String getStart() {
    return this.start;
  }

  public String getDestination() {
    return this.destination;
  }

  public int passengerCount() {
    int count = 0;
    for (Person passenger : passengers) {
      if (passenger != null) {
        count++;
      }
    }
    return count;
  }

  public void addPassenger(Person passenger) {
    if (this.isFull()) {
      return;
    }
    int passengerCount = this.passengerCount();
    this.passengers[passengerCount] = passenger;
  }

  public int getCapacity() {
    return this.passengers.length;
  }

  public boolean isFull() {
    return this.passengerCount() >= this.passengers.length;
  }
}
