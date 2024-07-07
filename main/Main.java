package main;

import services.AthleteService;
import services.ReservationService;
import services.SubscriptionService;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {

        AthleteService athleteService = new AthleteService();
        ReservationService reservationService = new ReservationService(athleteService);
        SubscriptionService subscriptionService = new SubscriptionService();

        MainWindow mainWindow = new MainWindow(athleteService, reservationService, subscriptionService);
        mainWindow.setVisible(true);
    }
}