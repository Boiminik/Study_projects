package util;
import java.util.*;

public class CourseECTSComparator implements Comparator<Course>{
    @Override
    public int compare(Course o1, Course o2) {
        return Double.compare(o1.getEcts(), o2.getEcts());
    }

    @Override
    public String toString() {
        return "CourseECTSComparator{}";
    }
}
