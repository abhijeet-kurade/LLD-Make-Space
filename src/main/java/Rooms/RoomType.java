package Rooms;

public enum RoomType {

    C_Cave("C-Cave", 3),
    D_Tower("D-Tower", 7),
    G_Mansion("G-Mansion", 20);

    private String name;
    private int capacity;

    RoomType(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
