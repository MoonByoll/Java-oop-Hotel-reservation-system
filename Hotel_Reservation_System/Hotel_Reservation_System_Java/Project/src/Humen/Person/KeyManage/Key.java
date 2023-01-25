package Humen.Person.KeyManage;

public class Key {

    private final int KEY_ROOM_TAG;
    private final int TOTAL_KEYS = 20;
    private static KeyState KeyAvailability;

    public Key(int keyRoomTag, KeyState KeyAvailability) {
        this.KEY_ROOM_TAG = keyRoomTag;
        Key.KeyAvailability = KeyAvailability;
    }

    // getters
    public int getKEY_ROOM_TAG() {
        return KEY_ROOM_TAG;
    }

    public int getTOTAL_KEYS() {
        return TOTAL_KEYS;
    }

    public static KeyState getState() {
        return KeyAvailability;
    }

    public static KeyState statusToAvailabe() {
        return KeyState.AVAILABLE;
    }

    public static KeyState statusToUnAvailable() {
        return KeyState.NOT_AVAILABLE;
    }
}
