
import services.AthleteService;
import services.ReservationService;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {

        AthleteService athleteService = new AthleteService();
        ReservationService reservationService = new ReservationService();

        MainWindow mainWindow = new MainWindow(athleteService, reservationService);
        mainWindow.setVisible(true);
    }
}