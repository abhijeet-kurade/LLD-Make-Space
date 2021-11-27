package Rooms;

import java.util.ArrayList;
import java.util.List;

public class RoomsHandler {
    private List<Room> rooms;

    public RoomsHandler() {
        this.rooms = new ArrayList<>();
        for(RoomType room : RoomType.values()){
            Room newRoom = new Room(room);
            this.rooms.add(newRoom);
        }
    }

    public List<Room> getRooms() {
        return this.rooms;
    }
}
