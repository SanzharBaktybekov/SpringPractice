package example.controllers;

import example.NotEnoughMoneyException;
import example.models.PaymentDetails;
import example.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final Logger logger = Logger.getLogger(PaymentController.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody PaymentDetails paymentDetails) {
        logger.info(paymentDetails.getAmount() + "");
        System.out.println(PaymentController.class.getName());
        return ResponseEntity.status(HttpStatus.OK).body(paymentDetails);
    }
}
