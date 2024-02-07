package example.services;

import example.NotEnoughMoneyException;
import example.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("Not enough money");
    }
}
