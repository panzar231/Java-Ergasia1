package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import services.AthleteService;

public class ShowAthletesFrame extends ChildWindow implements ActionListener { // κανει extend το childwindow ωστε να
																				// μπορει να επιστρεφει στο προηγουμενο
																				// παραθυρο

	private AthleteService athleteService;
	JButton showButton, returnButton; // το κουμπι για εμφανιση και το κουμπι επιστροφης
	JLabel[][] athletes; // αυτο το array με labels θα εχει ολη την λιστα των αθλητων και της πληροφοριες
							// του
	JLabel nameLabel, surnameLabel, genderLabel, dateLabel, phoneLabel, proffesionalLabel, experienceLabel,
			noAthleteLabel;
	Border border;
	String gender, proffesional, skill; // επειδη ολα αυτα αντιστοιχουσαν σε radio button επρεπε να φτιαχτουν μεταβλητες
										// για να τα αναπαριστουν

	public ShowAthletesFrame(JFrame parentWindow, AthleteService athleteService) { // το parent window το καλει ωστε να
																					// μπορει να επιστρεψει πισω
		super(parentWindow); // το κληρωνομει
		this.athleteService = athleteService;

		athletes = new JLabel[16][7]; // ειναι 16 γραμμων επειδη δεν χωραει αλλον αθλητη το ορισμενο παραθυρο και 7
										// στυλων επειδη εχει 7 πληροφοριες να εκτυπωσει

		border = BorderFactory.createLineBorder(Color.black, 3); // δημιουργει ενα border

		nameLabel = new JLabel(" Όνομα"); // θετει τις πληροφοριες του αναλογου label
		nameLabel.setBounds(260, 50, 80, 30);
		nameLabel.setBorder(border);
		nameLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		nameLabel.setOpaque(true);
		nameLabel.setBackground(Color.white);
		nameLabel.setForeground(Color.black);

		surnameLabel = new JLabel(" Επώνυμο"); // θετει τις πληροφοριες του αναλογου label
		surnameLabel.setBounds(360, 50, 100, 30);
		surnameLabel.setBorder(border);
		surnameLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		surnameLabel.setOpaque(true);
		surnameLabel.setBackground(Color.white);
		surnameLabel.setForeground(Color.black);

		genderLabel = new JLabel(" Φύλο"); // θετει τις πληροφοριες του αναλογου label
		genderLabel.setBounds(480, 50, 60, 30);
		genderLabel.setBorder(border);
		genderLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		genderLabel.setOpaque(true);
		genderLabel.setBackground(Color.white);
		genderLabel.setForeground(Color.black);

		dateLabel = new JLabel(" Ημερομηνία Γέννησης"); // θετει τις πληροφοριες του αναλογου label
		dateLabel.setBounds(560, 50, 200, 30);
		dateLabel.setBorder(border);
		dateLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		dateLabel.setOpaque(true);
		dateLabel.setBackground(Color.white);
		dateLabel.setForeground(Color.black);

		phoneLabel = new JLabel(" Κινητό Τηλέφωνο"); // θετει τις πληροφοριες του αναλογου label
		phoneLabel.setBounds(780, 50, 170, 30);
		phoneLabel.setBorder(border);
		phoneLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		phoneLabel.setOpaque(true);
		phoneLabel.setBackground(Color.white);
		phoneLabel.setForeground(Color.black);

		proffesionalLabel = new JLabel(" Επαγγελματίας?"); // θετει τις πληροφοριες του αναλογου label
		proffesionalLabel.setBounds(970, 50, 170, 30);
		proffesionalLabel.setBorder(border);
		proffesionalLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		proffesionalLabel.setOpaque(true);
		proffesionalLabel.setBackground(Color.white);
		proffesionalLabel.setForeground(Color.black);

		experienceLabel = new JLabel(" Εμπειρία"); // θετει τις πληροφοριες του αναλογου label
		experienceLabel.setBounds(1160, 50, 100, 30);
		experienceLabel.setBorder(border);
		experienceLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		experienceLabel.setOpaque(true);
		experienceLabel.setBackground(Color.white);
		experienceLabel.setForeground(Color.black);

		noAthleteLabel = new JLabel("Δεν υπάρχει διαθέσιμος αθλητής"); // θετει τις πληροφοριες του αναλογου label
		noAthleteLabel.setBounds(450, 400, 450, 60);
		noAthleteLabel.setBorder(border);
		noAthleteLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		noAthleteLabel.setOpaque(true);
		noAthleteLabel.setBackground(Color.white);
		noAthleteLabel.setForeground(Color.black);
		noAthleteLabel.setVisible(false);

		showButton = new JButton("Εμφάνιση"); // θετει τις πληροφοριες του αναλογου κουμπιου
		showButton.setBounds(10, 350, 200, 100);
		showButton.setFocusable(false);
		showButton.addActionListener(this);

		returnButton = new JButton("Επιστροφή"); // θετει τις πληροφοριες του αναλογου κουμπιου
		returnButton.setBounds(10, 500, 200, 100);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);

		this.setTitle("Εμφάνιση λίστας αθλητών"); // τα δεδομενα του frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 920);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocation(325, 60);
		this.add(returnButton);
		this.add(showButton);
		this.add(nameLabel);
		this.add(surnameLabel);
		this.add(genderLabel);
		this.add(dateLabel);
		this.add(phoneLabel);
		this.add(proffesionalLabel);
		this.add(experienceLabel);
		this.add(noAthleteLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == showButton) { // αν πατηθει να εμφανισει τοτε καλει την initializeAthleteLabels οπου θέτει
											// ολες τις πληροφοριες την λιστας των athlete στα αναλογα labels
			initializeAthleteLabels();
			if (athleteService.getAthleteListSize() == 0) { // αν δεν εχει μπει ουτε ενα ατομο στην λιστα
				noAthleteLabel.setVisible(true);
			} else {
				athletesVisibility(true); // αν εχει αθλητες τους κανει ολους εμφανιση
			}
		} else if (e.getSource() == returnButton) {
			this.setVisible(false); // αν πατηθει το επιστροφη γυρναει στο προηγουμενο window
			athletesVisibility(false);
			noAthleteLabel.setVisible(false);
			parentWindow.setVisible(true);

		}
	}

	private void initializeAthleteLabels() { // αυτο ειναι λιγο περιπλοκο οποτε λιγο μαζι μου (συγγωμη)
		for (int i = 0; i < athleteService.getAthleteListSize(); i++) { // αρχικα κανει ενα for με το μεγεθος της λιστας
																		// ωστε να
			// μην προκυψει καποιο θεμα με την εκτυπωση μεταβλητων
			// που δεν υπαρχουν
			athletes[i][0] = new JLabel(); // καθε αθλητης εχει σαν παραμετρο για τις γραμμες την μεταβλητη i καθως
											// αναφερομαστε στον ιδιο αθλητη
			athletes[i][0].setText(athleteService.getAthleteList().get(i).getName()); // το
																						// athleteService.getAthleteList()
																						// φερνει την λιστα ,στην
																						// συνεχεια με το .get(i) περνει
																						// το i ατομο της λιστας και
																						// μετα περνει το ονομα αυτου
																						// του ατομου
			athletes[i][0].setBounds(220, (i + 1) * 50 + 50, 90, 30); // αυτα με τις στηλες που ειναι το 0 ειναι για
																		// ονοματα
			athletes[i][0].setBorder(border); // καθε πληροφορια θελω να ειναι 50 pixels αποσταση οποτε το εχω κανει να
												// χρησιμοποιει το i αι για αποστασεις
			athletes[i][0].setFont(new Font("Poppins", Font.PLAIN, 20)); // τα υπολοιπα ειναι ιδια για καθε αθλητη
			athletes[i][0].setOpaque(true);
			athletes[i][0].setBackground(Color.white);
			athletes[i][0].setForeground(Color.black);
			athletes[i][0].setVisible(false);

			athletes[i][1] = new JLabel(); // αυτα με τις στηλες που ειναι το 1 ειναι για επωνυμα
			athletes[i][1].setText(athleteService.getAthleteList().get(i).getSurname());
			athletes[i][1].setBounds(320, (i + 1) * 50 + 50, 160, 30);
			athletes[i][1].setBorder(border);
			athletes[i][1].setFont(new Font("Poppins", Font.PLAIN, 20));
			athletes[i][1].setOpaque(true);
			athletes[i][1].setBackground(Color.white);
			athletes[i][1].setForeground(Color.black);
			athletes[i][1].setVisible(false);

			gender = String.valueOf(athleteService.getAthleteList().get(i).getGender()); // κανει τον char του φυλου σε
																							// string

			athletes[i][2] = new JLabel(); // αυτα με τις στηλες που ειναι το 2 ειναι για φυλο
			athletes[i][2].setText(gender);
			athletes[i][2].setBounds(500, (i + 1) * 50 + 50, 30, 30);
			athletes[i][2].setBorder(border);
			athletes[i][2].setFont(new Font("Poppins", Font.PLAIN, 20));
			athletes[i][2].setOpaque(true);
			athletes[i][2].setBackground(Color.white);
			athletes[i][2].setForeground(Color.black);
			athletes[i][2].setVisible(false);

			athletes[i][3] = new JLabel(); // αυτα με τις στηλες που ειναι το 3 ειναι για ημερομηνια γεννησης
			athletes[i][3].setText(athleteService.getAthleteList().get(i).getDateOfBirth());
			athletes[i][3].setBounds(600, (i + 1) * 50 + 50, 110, 30);
			athletes[i][3].setBorder(border);
			athletes[i][3].setFont(new Font("Poppins", Font.PLAIN, 20));
			athletes[i][3].setOpaque(true);
			athletes[i][3].setBackground(Color.white);
			athletes[i][3].setForeground(Color.black);
			athletes[i][3].setVisible(false);

			athletes[i][4] = new JLabel();
			athletes[i][4].setText(athleteService.getAthleteList().get(i).getPhoneNumber()); // αυτα με τις στηλες που
																								// ειναι το 4 ειναι για
																								// οκινητα
			athletes[i][4].setBounds(800, (i + 1) * 50 + 50, 130, 30);
			athletes[i][4].setBorder(border);
			athletes[i][4].setFont(new Font("Poppins", Font.PLAIN, 20));
			athletes[i][4].setOpaque(true);
			athletes[i][4].setBackground(Color.white);
			athletes[i][4].setForeground(Color.black);
			athletes[i][4].setVisible(false);

			if (athleteService.getAthleteList().get(i).isProffesional()) { // αν ειναι επαγγελματιας η οχι
				proffesional = "Ναι";
			} else {
				proffesional = "Όχι";
			}

			athletes[i][5] = new JLabel(); // αυτα με τις στηλες που ειναι το 5 ειναι για την επαγγελματικη του
											// κατασταση
			athletes[i][5].setText(proffesional);
			athletes[i][5].setBounds(1020, (i + 1) * 50 + 50, 50, 30);
			athletes[i][5].setBorder(border);
			athletes[i][5].setFont(new Font("Poppins", Font.PLAIN, 20));
			athletes[i][5].setOpaque(true);
			athletes[i][5].setBackground(Color.white);
			athletes[i][5].setForeground(Color.black);
			athletes[i][5].setVisible(false);

			skill = String.valueOf(athleteService.getAthleteList().get(i).getSkill()); // απο int το κανει string

			athletes[i][6] = new JLabel(); // αυτα με τις στηλες που ειναι το 6 ειναι για εμπειρια
			athletes[i][6].setText(skill);
			athletes[i][6].setBounds(1190, (i + 1) * 50 + 50, 30, 30);
			athletes[i][6].setBorder(border);
			athletes[i][6].setFont(new Font("Poppins", Font.PLAIN, 20));
			athletes[i][6].setOpaque(true);
			athletes[i][6].setBackground(Color.white);
			athletes[i][6].setForeground(Color.black);
			athletes[i][6].setVisible(false);

			this.add(athletes[i][0]);
			this.add(athletes[i][1]);
			this.add(athletes[i][2]);
			this.add(athletes[i][3]);
			this.add(athletes[i][4]);
			this.add(athletes[i][5]);
			this.add(athletes[i][6]);
		}
	}

	private void athletesVisibility(boolean x) { // τα κανει ορατα η αορατα
		for (int i = 0; i < athleteService.getAthleteListSize(); i++) {
			for (int j = 0; j < 7; j++) {
				athletes[i][j].setVisible(x);
			}
		}

	}

}