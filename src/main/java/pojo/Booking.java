package pojo;

import lombok.Data;

@Data
public class Booking {

    private String firstName;
    private String lastName;
    private double totalPrice;
    private boolean depositPaid;
    private BookingDates bookingDates;
}
