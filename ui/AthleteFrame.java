package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import services.AthleteService;

public class AthleteFrame extends ChildWindow implements ActionListener { // κανει extend το childwindow ωστε να μπορει
																			// να επιστρεφει στο προηγουμενο παραθυρο

	private AddAthleteFrame addAthleteFrame; // τα μετεπομενα παραθυρα που θα χρειαστουν
	private ShowAthletesFrame showAthletesFrame;
	private ChangeAthletesFrame changeAthletesFrame;
	private JButton addAthlete, registrationPayment, showAthleteList, changeAthlete, returnButton; // τα αναλογα κουμπια

	public AthleteFrame(JFrame parentWindow, AthleteService athleteService) { // το parent window το καλει ωστε να
																				// μπορει να επιστρεψει πισω
		super(parentWindow); // το κληρωνομει
		this.addAthleteFrame = new AddAthleteFrame(this, athleteService); // φτιαχνει τα αναλογα αντικειμενα των
																			// υπολοιπων frames
		this.showAthletesFrame = new ShowAthletesFrame(this, athleteService);
		this.changeAthletesFrame = new ChangeAthletesFrame(this, athleteService);

		addAthlete = new JButton(); // θετει τις πληροφοριες του αναλογου κουμπιου
		addAthlete.setBounds(30, 40, 230, 50);
		addAthlete.setVisible(true);
		addAthlete.setText("Καταχώρηση αθλητή στο σύστημα");
		addAthlete.setFocusable(false);
		addAthlete.addActionListener(this);

		registrationPayment = new JButton(); // θετει τις πληροφοριες του αναλογου κουμπιου
		registrationPayment.setBounds(30, 120, 230, 50);
		registrationPayment.setVisible(true);
		registrationPayment.setText("Πληρωμή εγγραφής");
		registrationPayment.setFocusable(false);
		registrationPayment.addActionListener(this);

		showAthleteList = new JButton(); // θετει τις πληροφοριες του αναλογου κουμπιου
		showAthleteList.setBounds(30, 200, 230, 50);
		showAthleteList.setVisible(true);
		showAthleteList.setText("Εμφάνιση λίστας αθλητών");
		showAthleteList.setFocusable(false);
		showAthleteList.addActionListener(this);

		changeAthlete = new JButton(); // θετει τις πληροφοριες του αναλογου κουμπιου
		changeAthlete.setBounds(30, 280, 230, 50);
		changeAthlete.setVisible(true);
		changeAthlete.setText("Αλλαγή στοιχείων αθλητή");
		changeAthlete.setFocusable(false);
		changeAthlete.addActionListener(this);

		returnButton = new JButton(); // θετει τις πληροφοριες του αναλογου κουμπιου
		returnButton.setBounds(30, 360, 230, 50);
		returnButton.setVisible(true);
		returnButton.setText("Επιστροφή");
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);

		this.setTitle("Διαχείριση Αθλητών"); // τα δεδομενα του frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 480);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocation(800, 325);
		this.add(addAthlete);
		this.add(registrationPayment);
		this.add(showAthleteList);
		this.add(changeAthlete);
		this.add(returnButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addAthlete) { // αν πατηθει το αναλογο κουμπι να κανει ωρατη την καταχορηση αθλητη
			this.setVisible(false);
			addAthleteFrame.setVisible(true);
		} else if (e.getSource() == registrationPayment) { // αν πατηθει το αναλογο κουμπι να κανει ωρατη την πληρωμη
															// εγραφης

		} else if (e.getSource() == showAthleteList) { // αν πατηθει το αναλογο κουμπι να κανει ωρατη εμφανιση αθλητη
			this.setVisible(false);
			showAthletesFrame.setVisible(true);
		} else if (e.getSource() == changeAthlete) { // αν πατηθει το αναλογο κουμπι να κανει ωρατη την αλλαγη αθλητη
			this.setVisible(false);
			changeAthletesFrame.setVisible(true);

		} else if (e.getSource() == returnButton) { // //αν πατηθει το αναλογο κουμπι να γυρισει στο parent window
			this.setVisible(false);
			parentWindow.setVisible(true);
		}

	}

}
