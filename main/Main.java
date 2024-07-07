package main;

import services.AthleteService;
import services.EnrollmentService;
import services.PaymentService;
import services.ReservationService;
import services.SubscriptionService;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {

        AthleteService athleteService = new AthleteService();
        ReservationService reservationService = new ReservationService(athleteService);
        SubscriptionService subscriptionService = new SubscriptionService();
        PaymentService paymentService = new PaymentService();
        EnrollmentService enrollmentService = new EnrollmentService(athleteService, paymentService);

        MainWindow mainWindow = new MainWindow(athleteService, reservationService, subscriptionService,
                enrollmentService);
        mainWindow.setVisible(true);
    }
}