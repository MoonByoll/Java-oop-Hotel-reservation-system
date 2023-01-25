package Place.Hotel.Features;

public class Restaurant implements CanBeReserved {

    private String name;
    // each restaurant object may have its own max guests so its not static
    private final int MAX_GUESTS;
    // restaurant has a immutable and a must type
    private final RestaurantType RESTAURANT_TYPES;

    public Restaurant(String name, int numberOfGuests, RestaurantType restaurantTypes) {
        this.name = name;
        this.MAX_GUESTS = numberOfGuests;
        this.RESTAURANT_TYPES = restaurantTypes;
    }

    // getters
    public int getMAX_GUESTS() {
        return MAX_GUESTS;
    }

    public RestaurantType getRESTAURANT_TYPES() {
        return RESTAURANT_TYPES;
    }

    public void haveType(RestaurantType type, String restaurantName) {
        switch (type) {
            case KOREAN:
                System.out.println(restaurantName + ":  ** Is A Korean Restaurant **");
                break;
            case IRANIAN:
                System.out.println(restaurantName + ":  ** Is An Iranian Restaurant **");
                break;
            case EUROPEAN:
                System.out.println(restaurantName + ":  ** Is An Europin Restaurant **");
                break;
            case CHINEASE:
                System.out.println(restaurantName + ":  ** Is A chinease Restaurant **");
                break;
            case VEGAN:
                System.out.println(restaurantName + ":  ** Is A Vegan Restaurant **");
                break;
        }
    }

    @Override
    public String toString() {
        String s;
        s = ("Restaurant Name:  " + name + " People Capcity: " + MAX_GUESTS);
        return s;
    }

    @Override
    public void reserve() {
        System.out.println("You have to reserve Each Restaurant first in order to use the feature");
    }

}
