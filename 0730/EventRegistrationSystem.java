import java.util.*;

public class EventRegistrationSystem {
    private final int capacity;
    private List<Registration> registrations = new ArrayList<>();
    private Queue<Registration> waitlist = new LinkedList<>();
    private Stack<Registration> cancelHistory = new Stack<>();
    private Set<String> registeredIds = new HashSet<>();

    public EventRegistrationSystem(int capacity) {
        this.capacity = capacity;
    }

    public boolean register(Registration reg) {
        if (registeredIds.contains(reg.getId())) {
            return false;
        }

        if (registrations.size() < capacity) {
            registrations.add(reg);
            registeredIds.add(reg.getId());
        } else {
            waitlist.offer(reg);
            registeredIds.add(reg.getId());
        }
        return true;
    }

    public void cancel(String id) {
        Registration target = null;
        for (Registration r : registrations) {
            if (r.getId().equals(id)) {
                target = r;
                break;
            }
        }

        if (target == null) {
            return;
        }

        registrations.remove(target);
        registeredIds.remove(id);
        cancelHistory.push(target);

        if (!waitlist.isEmpty()) {
            Registration next = waitlist.poll();
            registrations.add(next);
        }
    }

    public static void main(String[] args) {
        EventRegistrationSystem sys = new EventRegistrationSystem(2);

        sys.register(new Registration("R01", "Alice"));
        sys.register(new Registration("R02", "Bob"));
        sys.register(new Registration("R03", "Charlie")); 
        sys.register(new Registration("R01", "Duplicate")); 

        sys.cancel("R99");
        sys.cancel("R01");

        RegistrationAlgorithms.mergeSortById(sys.registrations, 0, sys.registrations.size() - 1);
        RegistrationAlgorithms.binarySearchById(sys.registrations, "R02");
        RegistrationAlgorithms.sequentialSearchByName(sys.registrations, "Charlie");
    }
}