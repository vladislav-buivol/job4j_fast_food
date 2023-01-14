package model.client;

import lombok.Data;

@Data
public class Address {
    private int id;
    private String city;
    private String Street;
    private String houseNr;
    private String apartments;
    private int postCode;
}
