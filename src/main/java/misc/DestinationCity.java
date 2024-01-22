package misc;

import java.util.HashSet;
import java.util.List;

public class DestinationCity {



    public String destCity(List<List<String>> paths) {
        // Create a hash set to store the cities that have outgoing paths
        HashSet<String> outgoing = new HashSet<>();
        // Iterate over the paths and add the first city of each pair to the set
        for (List<String> path : paths) {
            outgoing.add(path.get(0));
        }
        // Iterate over the paths again and check the second city of each pair
        for (List<String> path : paths) {
            String destination = path.get(1);
            // If the second city is not in the set, it means it has no outgoing path
            // Therefore, it is the destination city and we return it
            if (!outgoing.contains(destination)) {
                return destination;
            }
        }
        // If we reach here, it means there is no destination city
        // This should not happen as the problem guarantees there is exactly one destination city
        // But we return an empty string for safety
        return "";
    }




}
