package services;

import java.util.ArrayList;
import java.util.List;

import model.Athlete;
import model.Enrollment;

public class EnrollmentService {
    private List<Enrollment> enrollments;
    private AthleteService athleteService;
    private PaymentService paymentService;

    public EnrollmentService(AthleteService athleteService, PaymentService paymentService) {
        this.athleteService = athleteService;
        this.paymentService = paymentService;
        this.enrollments = new ArrayList<>();
    }

    public Enrollment createEnrollmentFor(int code) {
        for (Enrollment e : enrollments) { // αν εχει γινει ηδη πληρωμη
            if (e.getCode() == code) {
                return null;
            }
        }
        Athlete athlete = null;
        for (Athlete a : athleteService.getAthleteList()) { // βρες αθλητη
            if (a.getCode() == code) {
                athlete = a;
                break;
            }
        }

        if (athlete == null) {
            return null;
        }

        double cost = athlete.isProffesional() ? 20 : 50;

        return new Enrollment(code, code, cost);
    }

    public void paid(Enrollment enrollment) {
        this.enrollments.add(enrollment);
        this.paymentService.addPayment(enrollment);
    }

}
