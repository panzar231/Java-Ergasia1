package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import services.AthleteService;
import services.ReservationService;

public class ReservationFrame extends ChildWindow implements ActionListener {

    JButton newReservation, showReservationList, cancelReservation, returnButton;
    private AddReservationFrame addReservationFrame;

    public ReservationFrame(JFrame parentWindow, ReservationService reservationService, AthleteService athleteService) {
        super(parentWindow);

        this.addReservationFrame = new AddReservationFrame(this, reservationService, athleteService);

        newReservation = new JButton();
        newReservation.setBounds(30, 40, 230, 50);
        newReservation.setVisible(true);
        newReservation.setText("Νέα Κράτηση");
        newReservation.setFocusable(false);
        newReservation.addActionListener(this);

        showReservationList = new JButton();
        showReservationList.setBounds(30, 120, 230, 50);
        showReservationList.setVisible(true);
        showReservationList.setText("Εμφάνηση Λίστας Κρατήσεων");
        showReservationList.setFocusable(false);
        showReservationList.addActionListener(this);

        cancelReservation = new JButton();
        cancelReservation.setBounds(30, 200, 230, 50);
        cancelReservation.setVisible(true);
        cancelReservation.setText("Ακύρωση Κράτησης");
        cancelReservation.setFocusable(false);
        cancelReservation.addActionListener(this);

        returnButton = new JButton();
        returnButton.setBounds(30, 280, 230, 50);
        returnButton.setVisible(true);
        returnButton.setText("Επιστροφή");
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);

        this.setTitle("Διαχείριση Κρατήσεων");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLocation(800, 325);
        this.add(newReservation);
        this.add(showReservationList);
        this.add(cancelReservation);
        this.add(returnButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newReservation) {
            this.setVisible(false);
            addReservationFrame.setVisible(true);
        } else if (e.getSource() == showReservationList) {

        } else if (e.getSource() == cancelReservation) {

        } else if (e.getSource() == returnButton) {
            this.setVisible(false);
            parentWindow.setVisible(true);
        }
    }

}
