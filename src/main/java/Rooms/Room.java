package Rooms;

import Booking.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private RoomType room;
    private List<TimeSlot> slots;

    public Room(RoomType room) {
        this.room = room;
        this.slots = new ArrayList<>();
    }

    public boolean checkAvailability(TimeSlot slot){
        for(TimeSlot curr : this.slots){
            if(slot.getEnd() < curr.getStart()) return true;
            if(Math.max(slot.getStart(), curr.getStart()) < Math.min(slot.getEnd(), curr.getEnd()))
                return false;
        }
        return true;
    }

    public void bookRoom(TimeSlot slot){
        if(this.slots.size() == 0){
            this.slots.add(slot);
            return;
        }
        for(int i=0; i<this.slots.size(); i++){
            if(slot.getStart() < this.slots.get(i).getStart()){
                this.slots.add(i, slot);
                return;
            }
        }
        this.slots.add(slot);
    }

    public RoomType getRoom() {
        return room;
    }
}
