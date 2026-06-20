package models;

public class BookingRequest {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    public BookingRequest() {
    }

    public BookingRequest(String firstname,
                          String lastname,
                          int totalprice,
                          boolean depositpaid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }
}