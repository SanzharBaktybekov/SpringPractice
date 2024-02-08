package example.proxy;

import example.models.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.UUID;

@Component
public class PaymentProxy {
    @Value("${name.service.url}")
    private String baseUrl;
    private final RestTemplate rest;
    public PaymentProxy(RestTemplate rest) {
        this.rest = rest;
    }

    public Payment createPayment(Payment payment) {
        String url = baseUrl + "/payment";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);
        ResponseEntity<Payment> response = rest.exchange(url, HttpMethod.POST, httpEntity, Payment.class);
        return response.getBody();
    }

}
