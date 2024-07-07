package ui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import services.AthleteService;
import services.ReservationService;

public class AddReservationFrame extends ChildWindow {

    public AddReservationFrame(JFrame parentWindow, ReservationService reservationService,
            AthleteService athleteService) {

        super(parentWindow);

        JFrame addReservationFrame = new JFrame("Add Reservation");
        addReservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addReservationFrame.setSize(600, 400);

        JTextField dateTextField = new JTextField("DD");
        dateTextField.setBounds(320, 300, 80, 40);
        addReservationFrame.add(dateTextField);

        this.setLocation(800, 325);
        this.setResizable(false);
    }

}