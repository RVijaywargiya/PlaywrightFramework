package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDates {

    private String checkInDate;
    private String checkOutDate;
}
