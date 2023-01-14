package model.delivery;

import lombok.Data;
import model.client.Address;

import java.util.Date;

@Data
public class Payment {
    private int id;
    private Date date;
    private Address billingAddress;
    private Status status;
    private Type type;

    public enum Status {
        SUCCESSFUL,
        FAILED
    }

    public enum Type {
        CARD,
        CASH
    }

}
