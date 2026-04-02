import java.util.HashMap;
import java.util.Map;

public class BookMyStay {

    private Map<String, Integer> roomAvailability;

    public BookMyStay() {
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