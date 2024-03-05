package misc;



import java.util.*;
import java.util.stream.*;

class VisitCounter {
    public Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null) {
            return Collections.emptyMap();
        }

        return Arrays.stream(visits)
                .filter(Objects::nonNull) // Filter out null maps
                .flatMap(map -> map.entrySet().stream()) // Stream of map entries
                .filter(entry -> entry.getKey() != null && entry.getValue() != null && entry.getValue().getVisitCount().isPresent()) // Filter valid entries
                .filter(entry -> {
                    try {
                        Long.parseLong(entry.getKey()); // Check if key is parseable to Long
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .collect(Collectors.groupingBy(
                        entry -> Long.parseLong(entry.getKey()), // Key by user ID as Long
                        Collectors.summingLong(entry -> entry.getValue().getVisitCount().get()) // Sum visit counts
                ));
    }
}

class UserStats {
    private Optional<Long> visitCount;

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}

