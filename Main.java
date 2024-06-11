
import services.AthleteService;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {
        AthleteService athleteService = new AthleteService();
        MainWindow mainWindow = new MainWindow(athleteService);
        mainWindow.setVisible(true);
    }
}