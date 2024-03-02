package utils;

public class Environment {

    public static String httpToken;
    public static String httpCreateBooking;
    public static String httpGetBooking;

    public void selectUrl() {
        httpToken = "https://restful-booker.herokuapp.com/auth";
        httpCreateBooking = "https://restful-booker.herokuapp.com/booking";
        httpGetBooking = "https://restful-booker.herokuapp.com/booking/";
    }
}
