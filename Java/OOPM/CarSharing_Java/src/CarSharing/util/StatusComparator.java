package CarSharing.util;


import CarSharing.entities.Trip;
import java.util.Comparator;

public class StatusComparator extends Object implements Comparator<Trip> {

    public StatusComparator(){

    }

    @Override
    public int compare(Trip o1, Trip o2) {
        return (int) o1.getStatus().compareTo(o2.getStatus());
    }
}
