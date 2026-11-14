import java.util.HashMap;
import java.util.Map;

public static Map<String, String> buildLookup(String[][] records) {
    Map<String, String> lookup = new HashMap<>();

    for (String[] record : records) {
        lookup.put(record[0], record[1]);
    }
    return lookup;
}

public static String getDepartment(Map<String, String> lookup, String employeeId) {
    return lookup.getOrDefault(employeeId, "Unknown");
}
