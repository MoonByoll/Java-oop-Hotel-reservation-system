package Place.Hotel.Rooms;

public class Room {
    // composition relation of bed type and room type for bed (a room has bed and
    // room type)
    private static BedType bedType;
    private static RoomType roomType;

    public Room(BedType bedType, RoomType roomType) {
    }

    // setter
    public static void setBedType(BedType bedType) {
        Room.bedType = bedType;
    }

    public static void setRoomType(RoomType roomType) {
        Room.roomType = roomType;
    }

    // getters
    public static BedType getBedType() {
        return bedType;
    }

    public static RoomType getRoomType() {
        return roomType;
    }
}
