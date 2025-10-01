import java.util.HashMap;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> employees = new HashMap<>();

        employees.put(101, "Vaibhav");
        employees.put(102, "Gaggu");
        employees.put(103, "Munna");

        try {
            int searchId = 102;
            if (!employees.containsKey(searchId)) {
                throw new EmployeeNotFoundException("ID " + searchId + " not found.");
            }
            System.out.println("Employee with ID " + searchId + ": " + employees.get(searchId));
            searchId = 200;
            if (!employees.containsKey(searchId)) {
                throw new EmployeeNotFoundException("ID " + searchId + " not found.");
            }
            System.out.println("Employee with ID " + searchId + ": " + employees.get(searchId));

        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}