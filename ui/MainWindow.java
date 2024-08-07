package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import services.AthleteService;
import services.EnrollmentService;
import services.ReservationService;
import services.SubscriptionService;

public class MainWindow extends JFrame implements ActionListener {

	private AthleteFrame athleteFrame;
	private ReservationFrame bookingFrame;
	private SubscriptionFrame subscriptionFrame;
	private JButton athleteManagement, subscriptionManagement, bookingManagement, exitButton;
	private ImageIcon image;

	public MainWindow(AthleteService athleteService, ReservationService reservationService,
			SubscriptionService subscriptionService, EnrollmentService enrollmentService) {

		this.athleteFrame = new AthleteFrame(this, athleteService, enrollmentService);
		this.bookingFrame = new ReservationFrame(this, reservationService, athleteService);
		this.subscriptionFrame = new SubscriptionFrame(this, subscriptionService);

		image = new ImageIcon("file.png");

		athleteManagement = new JButton();
		athleteManagement.setBounds(30, 120, 180, 50);
		athleteManagement.setVisible(true);
		athleteManagement.setText("Διαχείριση Αθλητών");
		athleteManagement.setFocusable(false);
		athleteManagement.addActionListener(this);

		subscriptionManagement = new JButton();
		subscriptionManagement.setBounds(250, 120, 180, 50);
		subscriptionManagement.setVisible(true);
		subscriptionManagement.setText("Διαχείριση Συνδρομών");
		subscriptionManagement.setFocusable(false);
		subscriptionManagement.addActionListener(this);

		bookingManagement = new JButton();
		bookingManagement.setBounds(470, 120, 180, 50);
		bookingManagement.setVisible(true);
		bookingManagement.setText("Διαχείριση Κρατήσεων");
		bookingManagement.setFocusable(false);
		bookingManagement.addActionListener(this);

		exitButton = new JButton();
		exitButton.setBounds(690, 120, 180, 50);
		exitButton.setVisible(true);
		exitButton.setText("Έξοδος");
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 350);
		this.setLayout(null);
		this.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.add(bookingManagement);
		this.add(athleteManagement);
		this.add(subscriptionManagement);
		this.add(exitButton);
		this.setLocation(500, 325);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == athleteManagement) {
			this.setVisible(false);
			athleteFrame.setVisible(true);
		} else if (e.getSource() == subscriptionManagement) {
			this.setVisible(false);
			subscriptionFrame.setVisible(true);
		} else if (e.getSource() == bookingManagement) {
			this.setVisible(false);
			bookingFrame.setVisible(true);
		} else if (e.getSource() == exitButton) {
			System.exit(0);
		}
	}

}
