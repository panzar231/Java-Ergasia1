package ui;

import javax.swing.*;

import model.Athlete;
import services.AthleteService;
import services.ReservationService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class AddReservationFrame extends ChildWindow {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public AddReservationFrame(JFrame parentWindow, ReservationService reservationService,
            AthleteService athleteService) {

        super(parentWindow);

        JFrame frame = new JFrame("Add Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Fill the layout with placeholders
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 15; col++) {
                constraints.gridx = col;
                constraints.gridy = row;
                constraints.weightx = 1.0;
                constraints.weighty = 1.0;
                constraints.fill = GridBagConstraints.BOTH;

                Component filler = Box.createRigidArea(new Dimension(0, 0));
                panel.add(filler, constraints);
            }
        }

        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        final DefaultListModel model = new DefaultListModel<>();
        for (Athlete athlete : athleteService.getAthleteList()) {
            model.addElement(athlete);
        }

        JList<Athlete> athlete_list = new JList<>(model);
        // you can assign the elements to the list by changing above line to
        // JList<String> athlete_list = new JList<>(yourStringArray);
        constraints.gridx = -6;
        constraints.gridy = 5;
        panel.add(athlete_list, constraints);

        JLabel reservation_label = new JLabel("Date Of Reservation");
        constraints.gridx = -1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        panel.add(reservation_label, constraints);

        JTextField day_textfiled = new JTextField(2);
        day_textfiled.setPreferredSize(new Dimension(136, 23));
        day_textfiled.setText("DD");
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        panel.add(day_textfiled, constraints);

        JTextField month_textfield = new JTextField(2);
        month_textfield.setPreferredSize(new Dimension(136, 23));
        month_textfield.setText("MM");
        constraints.gridx = 4;
        constraints.gridy = 6;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        panel.add(month_textfield, constraints);

        JTextField year_textfield = new JTextField(4);
        year_textfield.setPreferredSize(new Dimension(136, 23));
        year_textfield.setText("yyyy");
        constraints.gridx = 6;
        constraints.gridy = 6;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        panel.add(year_textfield, constraints);

        frame.add(panel);
        frame.setVisible(true);
    }

}