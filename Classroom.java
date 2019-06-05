import java.util.*;

public class Classroom {

    public static void main(String[] args) {

        User bernard = new User("Bernard");
        User laverne = new User("Laverne");
        User hoagie = new User("Hoagie");
        User surfer = new User("Jeff Woodie");
        Computer sx386 = new Computer("386SX-25");
        Computer dx486 = new Computer("486DX2-66");
        Computer c64 = new Computer("Commodore 64");

        Map<User, Computer> classroom = new HashMap<>();
        classroom.put(bernard, dx486);
        classroom.put(laverne, sx386);
        classroom.put(hoagie, sx386);
        classroom.put(surfer, c64);

        Computer removed = classroom.remove(surfer);
        System.out.println("removed: " + removed.getModel()); // Commodore 64

        System.out.println("\nkeys:");
        for (User user : classroom.keySet()) {
            System.out.println("key: " + user.getName());
        }

        System.out.println("\nvalues:");
        for (Computer computer : classroom.values()) {
            System.out.println("value: " + computer.getModel());
        }

        System.out.println("\nkeys and values :");
        for (Map.Entry<User, Computer> entry : classroom.entrySet()) {
            User user = entry.getKey();
            Computer computer = entry.getValue();
            System.out.println(user.getName() + ": " + computer.getModel());
        }

        System.out.println("\nclassroom contains key `bernard`: " + classroom.containsKey(bernard));
        System.out.println("classroom contains value `c64`: " + classroom.containsValue(c64));

        Map<User, Computer> linkedClassroom = new LinkedHashMap<>();
        linkedClassroom.put(bernard, dx486);
        linkedClassroom.put(laverne, sx386);
        linkedClassroom.put(hoagie, sx386);
        linkedClassroom.put(surfer, c64);

        System.out.println("\nLinkedHashMap sorted by insertion:");
        for (User user : linkedClassroom.keySet()) {
            Computer computer = linkedClassroom.get(user);
            System.out.println(user.getName() + ": " + computer.getModel());
        }

        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User orig, User compare) {
                return orig.getName().compareTo(compare.getName());
            }
        };
        Map<User, Computer> treeClassroom = new TreeMap<>(comparator);
        treeClassroom.put(bernard, dx486);
        treeClassroom.put(laverne, sx386);
        treeClassroom.put(hoagie, sx386);
        treeClassroom.put(surfer, c64);
        System.out.println("\nTreeMap sorted by key:");
        for (User user : treeClassroom.keySet()) {
            Computer computer = treeClassroom.get(user);
            System.out.println(user.getName() + ": " + computer.getModel());
        }
    }
}
