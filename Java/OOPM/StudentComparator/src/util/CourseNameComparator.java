package util;

import java.util.Comparator;

public class CourseNameComparator implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
    }

    @Override
    public String toString() {
        return "CourseNameComparator{}";
    }
}
