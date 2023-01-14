package model.delivery;

import lombok.Data;
import model.client.Address;

@Data
public class DeliveryInfo {
    private Address address;
    private String phone;
    private String comments;
}
