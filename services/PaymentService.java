package services;

import java.util.ArrayList;
import java.util.List;

import model.Enrollment;
import model.Payment;

public class PaymentService {
    private List<Payment> payments;

    public PaymentService() {
        this.payments = new ArrayList<>();
    }

    public void addPayment(Enrollment enrollment) {
        Payment payment = new Payment(payments.size() + 1, true, enrollment.getCode(), enrollment.getCost());
        payments.add(payment);
    }

}
