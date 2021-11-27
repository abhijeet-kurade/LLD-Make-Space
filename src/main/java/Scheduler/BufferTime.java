package Scheduler;

import Booking.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public enum BufferTime {

    Buffer1("09:00", "09:15"),
    Buffer2("13:15", "13:45"),
    Buffer3("18:45", "19:00");


    private TimeSlot slot;
    BufferTime(String start, String end) {
        this.slot = new TimeSlot(start, end);
    }

    public TimeSlot getSlot() {
        return slot;
    }
}
