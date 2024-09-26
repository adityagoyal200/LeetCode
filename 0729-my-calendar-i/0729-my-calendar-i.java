class MyCalendar {
    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] booking : calendar) {
            if (Math.max(booking[0], start) < Math.min(booking[1], end)) {
                return false;
            }
        }

        calendar.add(new int[]{start, end});
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */