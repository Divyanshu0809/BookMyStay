import java.util.*;

abstract class Room {
    protected int beds;
    protected int size;
    protected double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price: " + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public void displayInventory() {
        System.out.println("Current Room Availability:");

        for (Map.Entry<String, Integer> entry : roomAvailability.entrySet()) {
            System.out.println(entry.getKey() + " Room: " + entry.getValue());
        }
    }

}
class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory) {
        System.out.println("Available Rooms:\n");

        Map<String, Integer> data = inventory.getRoomAvailability();

        for (String type : data.keySet()) {
            int count = data.get(type);

            if (count > 0) {
                System.out.println(type + " Room (Available: " + count + ")");

                Room room = createRoom(type);
                room.displayDetails();

                System.out.println("-------------------");
            }
        }
    }

    private Room createRoom(String type) {
        switch (type) {
            case "Single":
                return new SingleRoom();
            case "Double":
                return new DoubleRoom();
            case "Suite":
                return new SuiteRoom();
            default:
                return null;
        }
    }
}

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

class BookingRequestQueue {
    private Queue<Reservation> requestQueue = new LinkedList<>();

    void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    Reservation getNextRequest() {
        return requestQueue.poll();
    }

    boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

class Reservation1 {
    private String guestName;
    private String roomType;

    public Reservation1(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

class BookingRequestQueue1 {
    private Queue<Reservation> requestQueue = new LinkedList<>();

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

class RoomAllocationService {
    private Set<String> allocatedRoomIds = new HashSet<>();
    private Map<String, Set<String>> assignedRoomsByType = new HashMap<>();

    public void allocateRoom(Reservation reservation) {
        String roomType = reservation.getRoomType();
        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        assignedRoomsByType.get(roomType).add(roomId);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType + "-" + count;
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        while (bookingQueue.hasPendingRequests()) {
            Reservation request = bookingQueue.getNextRequest();
            allocationService.allocateRoom(request);
        }
    }
}