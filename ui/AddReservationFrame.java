package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

import services.AthleteService;
import services.ReservationService;

public class AddReservationFrame extends ChildWindow {

    public AddReservationFrame(JFrame parentWindow, ReservationService reservationService,
            AthleteService athleteService) {

        super(parentWindow);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

        JTextField dateTextField = new JTextField("DD");
        dateTextField.setBounds(4, 3, 5, 4);
        dateTextField.setFont(new Font("Poppins", Font.PLAIN, 35));
        dateTextField.setBackground(Color.white);
        dateTextField.setSelectedTextColor(Color.black);

        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(800, 325);
        this.setResizable(false);
        this.add(dateTextField);
    }

}