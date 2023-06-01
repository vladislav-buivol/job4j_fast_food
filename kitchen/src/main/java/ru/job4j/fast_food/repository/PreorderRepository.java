package ru.job4j.fast_food.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fast_food.domain.model.kitchen.Preorder;

@Repository
public interface PreorderRepository extends CrudRepository<Preorder, Integer> {
}
