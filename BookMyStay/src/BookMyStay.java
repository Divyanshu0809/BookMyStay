abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;
    protected int available;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight, int available) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available: " + available);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0, 5);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0, 3);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0, 2);
    }
}

public class BookMyStay {   // ✅ matches file name
    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization\n");

        System.out.println("Single Room:");
        new SingleRoom().displayRoomDetails();

        System.out.println("\nDouble Room:");
        new DoubleRoom().displayRoomDetails();

        System.out.println("\nSuite Room:");
        new SuiteRoom().displayRoomDetails();
    }
}