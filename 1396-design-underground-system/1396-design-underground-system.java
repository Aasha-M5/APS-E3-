import java.util.*;

class UndergroundSystem {

    // Store check-in details: id -> (station, time)
    private Map<Integer, Pair> checkInMap;

    // Store journey data: "start-end" -> (totalTime, count)
    private Map<String, int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        checkInMap.remove(id);

        String key = p.station + "-" + stationName;
        int travelTime = t - p.time;

        travelMap.putIfAbsent(key, new int[2]);
        travelMap.get(key)[0] += travelTime; // total time
        travelMap.get(key)[1] += 1;          // count
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] data = travelMap.get(key);
        return (double) data[0] / data[1];
    }

    // Helper class
    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}