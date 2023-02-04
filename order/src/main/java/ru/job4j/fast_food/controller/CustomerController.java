package ru.job4j.fast_food.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.fast_food.domain.model.customer.ClientCard;
import ru.job4j.fast_food.domain.model.order.OrderStatus;
import ru.job4j.fast_food.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/buyCard")
    public ResponseEntity<ClientCard> buyCard(ClientCard clientCard) {
        return new ResponseEntity<>(customerService.buyCard(clientCard), HttpStatus.ACCEPTED);
    }

    @PostMapping("/checkStatus")
    public ResponseEntity<OrderStatus> checkStatus(int orderId) {
        return new ResponseEntity<>(customerService.checkStatus(orderId), HttpStatus.ACCEPTED);
    }
}
