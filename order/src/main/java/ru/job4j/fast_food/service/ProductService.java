package ru.job4j.fast_food.service;

import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.order.Product;

@Service
public interface ProductService {
    void save(Product product);

    void delete(Product product);

    void update(Product product);

    void findById(int id);
}
