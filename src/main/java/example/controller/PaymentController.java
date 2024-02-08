package example.controller;

import example.client.PaymentClient;
import example.models.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentClient paymentClient;
    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        String id = UUID.randomUUID().toString();
        return paymentClient.createPayment(id, payment);
    }
}
