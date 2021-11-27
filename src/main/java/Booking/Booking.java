package Booking;

public class Booking {
    private TimeSlot timeSlot;
    private int members;

    public Booking(TimeSlot timeSlot, int members){
        this.timeSlot = timeSlot;
        this.members = members;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public int getMembers() {
        return members;
    }
}
