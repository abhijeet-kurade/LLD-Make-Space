package CommandExecutor;

import Booking.Booking;
import Booking.Constants;
import Booking.TimeSlot;
import Rooms.Room;
import Rooms.RoomsHandler;
import Scheduler.*;

import java.util.List;

public class CommandExecutor {
    private Scheduler scheduler;
    private RoomsHandler roomsHandler;
    private TimeSlot timeSlot;
    private BufferTimeHandler bufferTimeHandler;

    public CommandExecutor() {
        this.roomsHandler = new RoomsHandler();
        this.bufferTimeHandler = new BufferTimeHandler();
        this.scheduler = new Scheduler(this.roomsHandler, this.bufferTimeHandler);
        this.timeSlot = null;
    }

    public void runCommand(String command){
        if(command.startsWith(VacancyCommand.COMMAND)){
            VacancyCommand cmd = new VacancyCommand(command);
            String[] params = cmd.getParams();
            this.timeSlot = new TimeSlot(params[1], params[2]);
            if(!this.timeSlot.isTimeSlotValid()){
                System.out.println("INCORRECT_INPUT");
                return;
            }
            List<Room> vacantRoom = this.scheduler.checkVacantRooms(this.timeSlot);
            if(vacantRoom.size() != 0){
                String rooms = "";
                for(Room room : vacantRoom) rooms += room.getRoom().getName() +" ";
                System.out.println(rooms);
            }
            else{
                System.out.println("NO_VACANT_ROOM");
            }
        }
        else if(command.startsWith(BookCommand.COMMAND)){
            VacancyCommand cmd = new VacancyCommand(command);
            String[] params = cmd.getParams();
            this.timeSlot = new TimeSlot(params[1], params[2]);
            if(!this.timeSlot.isTimeSlotValid()){
                System.out.println("INCORRECT_INPUT");
                return;
            }
            int members = Integer.parseInt(params[3]);
            if(members < Constants.MIN_MEMBERS || Constants.MAX_MEMBERS < members){
                System.out.println("NO_VACANT_ROOM");
                return;
            }
            Booking newBooking = new Booking(this.timeSlot, members);
            String booked = this.scheduler.bookRoom(newBooking);
            System.out.println(booked);
            return;
        }
    }

}
