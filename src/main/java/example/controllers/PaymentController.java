package example.controllers;

import example.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestBody Payment payment,
            @RequestHeader String id
    ) {
        logger.info("Request id:" + id + " and amount of payment:" + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.OK).header("requestId", id).body(payment);
    }
}
