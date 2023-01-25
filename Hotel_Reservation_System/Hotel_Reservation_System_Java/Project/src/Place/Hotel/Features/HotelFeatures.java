package Place.Hotel.Features;

public class HotelFeatures {

    private String theFeatureName;

    private static final int MAX_CINEMAS = 3;
    private static final int MAX_POOLS = 2;
    private static final int MAX_RESTAURANT = 5;

    private Cinema[] cinema = new Cinema[MAX_CINEMAS];
    private Pool[] pool = new Pool[MAX_POOLS];
    private Restaurant[] restaurant = new Restaurant[MAX_RESTAURANT];

    private int cinemaCount = 0;
    private int poolCount = 0;
    private int restaurantCount = 0;

    public HotelFeatures(String featureName) {
        this.theFeatureName = featureName;
    }

    // getters
    public static int getMAX_CINEMAS() {
        return MAX_CINEMAS;
    }

    public static int getMAX_POOLS() {
        return MAX_POOLS;
    }


    public static int getMAX_RESTAURANT() {
        return MAX_RESTAURANT;
    }

    public Cinema[] getCinema() {
        return cinema;
    }

    public Pool[] getPool() {
        return pool;
    }

    public Restaurant[] getRestaurant() {
        return restaurant;
    }

    public void addCinema(Cinema c) {
        cinema[cinemaCount++] = c;
    }

    public void addPool(Pool p) {
        pool[poolCount++] = p;
    }

    public void addRestaurant(Restaurant r) {
        restaurant[restaurantCount++] = r;
    }

    @Override
    public String toString() {
        String s;
        s = ("Feature Name: " + theFeatureName);
        return s;
    }

}
