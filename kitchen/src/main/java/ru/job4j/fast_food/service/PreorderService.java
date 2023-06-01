package ru.job4j.fast_food.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food.domain.model.kitchen.Preorder;
import ru.job4j.fast_food.domain.model.order.JobStatus;
import ru.job4j.fast_food.repository.PreorderRepository;

import java.util.function.Consumer;

@Service
public class PreorderService {

    private final PreorderRepository preorderRepository;

    public PreorderService(PreorderRepository preorderRepository) {
        this.preorderRepository = preorderRepository;
    }

    public Preorder save(Preorder preorder) {
        return preorderRepository.save(preorder);
    }

    public boolean delete(int preorderId) {
        processPreorderOrThrowNotFoundException(preorderId,
                preorder -> preorderRepository.deleteById(preorderId));
        return true;
    }

    private void processPreorderOrThrowNotFoundException(Integer orderId,
                                                         Consumer<Preorder> orderConsumer) {
        preorderRepository.findById(orderId).ifPresentOrElse(orderConsumer, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Preorder with id %s not found", orderId));
        });
    }

    public JobStatus getJobStatus() {
        double random = Math.random();
        return (random < 0.5) ? JobStatus.READY : JobStatus.CANCELLED;
    }

    public void updatePreOrderDetails(Preorder preorder) {
        JobStatus newJobStatus = getJobStatus();
        preorder.getOrder()
                .setJobStatus(newJobStatus);
        preorder.setNewStatus(newJobStatus);
    }
}
