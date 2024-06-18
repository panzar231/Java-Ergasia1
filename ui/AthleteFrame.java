package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import services.AthleteService;

public class AthleteFrame extends ChildWindow implements ActionListener {

	private AddAthleteFrame addAthleteFrame;
	private JButton addAthlete, registrationPayment, showAthleteList, changeAthlete, returnButton;
	private ImageIcon athleteImage;

	public AthleteFrame(JFrame parentWindow, AthleteService athleteService) {
		super(parentWindow);
		this.addAthleteFrame = new AddAthleteFrame(this, athleteService);

		athleteImage = new ImageIcon("125241.png");

		addAthlete = new JButton();
		addAthlete.setBounds(30, 40, 230, 50);
		addAthlete.setVisible(true);
		addAthlete.setText("Καταχώρηση αθλητή στο σύστημα");
		addAthlete.setFocusable(false);
		addAthlete.addActionListener(this);

		registrationPayment = new JButton();
		registrationPayment.setBounds(30, 120, 230, 50);
		registrationPayment.setVisible(true);
		registrationPayment.setText("Πληρωμή εγγραφής");
		registrationPayment.setFocusable(false);
		registrationPayment.addActionListener(this);

		showAthleteList = new JButton();
		showAthleteList.setBounds(30, 200, 230, 50);
		showAthleteList.setVisible(true);
		showAthleteList.setText("Εμφάνιση λίστας αθλητών");
		showAthleteList.setFocusable(false);
		showAthleteList.addActionListener(this);

		changeAthlete = new JButton();
		changeAthlete.setBounds(30, 280, 230, 50);
		changeAthlete.setVisible(true);
		changeAthlete.setText("Αλλαγή στοιχείων αθλητή");
		changeAthlete.setFocusable(false);
		changeAthlete.addActionListener(this);

		returnButton = new JButton();
		returnButton.setBounds(30, 360, 230, 50);
		returnButton.setVisible(true);
		returnButton.setText("Επιστροφή");
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);

		this.setTitle("Διαχείριση Αθλητών");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 480);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocation(800, 325);
		this.setIconImage(athleteImage.getImage());
		this.add(addAthlete);
		this.add(registrationPayment);
		this.add(showAthleteList);
		this.add(changeAthlete);
		this.add(returnButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addAthlete) {
			this.setVisible(false);
			addAthleteFrame.setVisible(true);
		} else if (e.getSource() == registrationPayment) {

		} else if (e.getSource() == showAthleteList) {

		} else if (e.getSource() == changeAthlete) {

		} else if (e.getSource() == returnButton) {
			this.setVisible(false);
			parentWindow.setVisible(true);
		}

	}

}
