import java.util.*;

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> prev = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> next = calendar.ceilingEntry(start);

        if (prev != null && prev.getValue() > start) {
            return false;
        }

        if (next != null && next.getKey() < end) {
            return false;
        }

        calendar.put(start, end);
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */