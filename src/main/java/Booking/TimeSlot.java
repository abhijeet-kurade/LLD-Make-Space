package Booking;

public class TimeSlot {
    private String strStart;
    private String strEnd;

    private int start;
    private int end;

    public TimeSlot(String strStart, String strEnd) {
        this.strStart = strStart;
        this.strEnd = strEnd;
        this.start = stringToMinute(strStart);
        this.end = stringToMinute(strEnd) - 1;
    }

    public boolean isTimeSlotValid(){
        boolean dayCross = this.start < this.end;
        boolean start = ((this.start % 60) % 15) == 0;
        boolean end = (((this.end+1) % 60) % 15) == 0;
        return dayCross && start && end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    private int stringToMinute(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return hour * 60 + minute;
    }

    @Override
    public String toString() {
        return "[" + strStart + " " + strEnd + ']';
    }
}
