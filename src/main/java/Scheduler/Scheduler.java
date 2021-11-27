package Scheduler;

import Booking.Booking;
import Booking.TimeSlot;
import Rooms.Room;
import Rooms.RoomsHandler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private RoomsHandler roomsHandler;
    private BufferTimeHandler bufferTimeHandler;

    public Scheduler(RoomsHandler roomsHandler, BufferTimeHandler bufferTimeHandler) {
        this.roomsHandler = roomsHandler;
        this.bufferTimeHandler = bufferTimeHandler;
        for(Room room : this.roomsHandler.getRooms()){
            for(BufferTime buffTime : this.bufferTimeHandler.getBufferTime()){
                room.bookRoom(buffTime.getSlot());
            }
        }
    }

    public List<Room> checkVacantRooms(TimeSlot timeSlot){
        List<Room> vacant = new ArrayList<>();
        for(Room room : this.roomsHandler.getRooms()){
            if(room.checkAvailability(timeSlot)) vacant.add(room);
        }
        return vacant;
    }

    public String bookRoom(Booking newBooking){
        String result = "NO_VACANT_ROOM";
        for(Room room : this.roomsHandler.getRooms()){
            if(newBooking.getMembers() > room.getRoom().getCapacity()) continue;
            if(!room.checkAvailability(newBooking.getTimeSlot())) continue;
            room.bookRoom(newBooking.getTimeSlot());
            return room.getRoom().getName();
        }
        return result;
    }

}
