package ru.job4j.fast_food.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.fast_food.domain.model.customer.ClientCard;
import ru.job4j.fast_food.domain.model.order.JobStatus;
import ru.job4j.fast_food.service.CustomerServiceFastFood;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceFastFood customerService;

    public CustomerController(CustomerServiceFastFood customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/buyCard")
    public ResponseEntity<ClientCard> buyCard(ClientCard clientCard) {
        return new ResponseEntity<>(customerService.buyCard(clientCard), HttpStatus.ACCEPTED);
    }

    @PostMapping("/checkStatus")
    public ResponseEntity<JobStatus> checkStatus(int orderId) {
        return new ResponseEntity<>(customerService.checkStatus(orderId), HttpStatus.ACCEPTED);
    }
}
