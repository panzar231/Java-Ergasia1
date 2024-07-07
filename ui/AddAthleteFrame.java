package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import services.AthleteService;

public class AddAthleteFrame extends ChildWindow implements ActionListener { // κανει extend το childwindow ωστε να
																				// μπορει να επιστρεφει στο προηγουμενο
																				// παραθυρο

	private AthleteService athleteService;

	char athleteGender; // χρησιμοποειται για την μετατροπη radiobutton σε char
	boolean athleteProffesional; // χρησιμοποειται για την μετατροπη radiobutton σε boolean
	boolean wrongInformation = false; // προσεχει αν υπαρχει καποιο λαθος με τα δεδομενα που εισηλθαν
	int athleteSkill; // χρησιμοποειται για την μετατροπη radiobutton σε int
	boolean genderCheck = false; // προσεχει το αναλογο radioButton
	boolean proffesionalCheck = false; // προσεχει το αναλογο radioButton
	boolean skillCheck = false; // προσεχει το αναλογο radioButton
	int day; // χρησιμοποειται για την μετατροπη string σε int ωστε να γινουν πραξεις με την
				// ημερομηνια
	int month; // χρησιμοποειται για την μετατροπη string σε int ωστε να γινουν πραξεις με την
				// ημερομηνια
	int year; // χρησιμοποειται για την μετατροπη string σε int ωστε να γινουν πραξεις με την
				// ημερομηνια
	Long phone; // χρησιμοποειται για την μετατροπη string σε long ωστε να γινουν πραξεις με το
				// τηλεφωνο

	JTextField textField3; // το ονομα
	JTextField textField4; // το επωνυμο
	JTextField textField61, textField62, textField63; // ημερομινια και τα τρια
	JTextField textField7; // κινητο
	JButton button, returnButton; // το κουμπι για αποθηκευση και το κουμπι επιστροφης
	JRadioButton maleRadioButton, femaleRadioButton; // τα radio buttons για το gender
	JRadioButton proffesionalRadioButton, notProffesionalRadioButton; // τα radio buttons για το αν ειναι proffesional
	JRadioButton skill1, skill2, skill3, skill4, skill5; // τα radio buttons για το skill
	ButtonGroup gender; // button group για gender
	ButtonGroup proffesional; // button group για proffesional
	ButtonGroup skill; // button group για skill
	JLabel genderLabel, proffesionalLabel, skillLabel, dateLabel, messageCongratsLabel, messageWrongDateLabel,
			messageNoDateLabel,
			messageNoPhoneLabel, messageWrongPhoneLabel, messageNoGenderLabel, messageNoProffesionalLabel,
			messageNoSkillLabel;
	Border border;

	AddAthleteFrame(JFrame parentWindow, AthleteService athleteService) {
		super(parentWindow);

		this.athleteService = athleteService;

		button = new JButton("Αποθήκευση"); // θετει τις πληροφοριες του αναλογου κουμπιου
		button.setBounds(100, 350, 200, 100);
		button.setFocusable(false);
		button.addActionListener(this);

		returnButton = new JButton("Επιστροφή"); // θετει τις πληροφοριες του αναλογου κουμπιου
		returnButton.setBounds(100, 500, 200, 100);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);

		textField3 = new JTextField("Όνομα"); // θετει τις πληροφοριες του αναλογου textfield
		textField3.setBounds(450, 100, 350, 40);
		textField3.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField3.setBackground(Color.white);
		textField3.setSelectedTextColor(Color.black);

		textField4 = new JTextField("Επώνυμο"); // θετει τις πληροφοριες του αναλογου textfield
		textField4.setBounds(450, 190, 350, 40);
		textField4.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField4.setBackground(Color.white);
		textField4.setSelectedTextColor(Color.black);

		maleRadioButton = new JRadioButton("Άντρας"); // θετει τις πληροφοριες του αναλογου radiobutton
		maleRadioButton.setBounds(540, 280, 100, 50);
		maleRadioButton.setBackground(Color.LIGHT_GRAY);
		maleRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		maleRadioButton.setFocusable(false);
		maleRadioButton.addActionListener(this);

		femaleRadioButton = new JRadioButton("Γυναίκα"); // θετει τις πληροφοριες του αναλογου radiobutton
		femaleRadioButton.setBounds(640, 280, 100, 50);
		femaleRadioButton.setBackground(Color.LIGHT_GRAY);
		femaleRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		femaleRadioButton.setFocusable(false);
		femaleRadioButton.addActionListener(this);

		border = BorderFactory.createLineBorder(Color.black, 3); // δημιουργει ενα border

		genderLabel = new JLabel("Φύλο"); // θετει τις πληροφοριες του αναλογου label
		genderLabel.setBounds(450, 280, 80, 50);
		genderLabel.setBorder(border);
		genderLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		genderLabel.setOpaque(true);
		genderLabel.setBackground(Color.white);
		genderLabel.setForeground(Color.black);

		gender = new ButtonGroup(); // βαζει τα αναλογα radiobutton σε group
		gender.add(femaleRadioButton);
		gender.add(maleRadioButton);

		dateLabel = new JLabel("Ημερομηνία γέννησης"); // θετει τις πληροφοριες του αναλογου label
		dateLabel.setBounds(450, 370, 350, 40);
		dateLabel.setBorder(border);
		dateLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		dateLabel.setOpaque(true);
		dateLabel.setBackground(Color.white);
		dateLabel.setForeground(Color.black);

		textField61 = new JTextField("DD"); // θετει τις πληροφοριες του αναλογου textfield
		textField61.setBounds(810, 370, 70, 40);
		textField61.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField61.setBackground(Color.white);
		textField61.setSelectedTextColor(Color.black);

		textField62 = new JTextField("MM"); // θετει τις πληροφοριες του αναλογου textfield
		textField62.setBounds(890, 370, 70, 40);
		textField62.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField62.setBackground(Color.white);
		textField62.setSelectedTextColor(Color.black);

		textField63 = new JTextField("YYYY"); // θετει τις πληροφοριες του αναλογου textfield
		textField63.setBounds(970, 370, 100, 40);
		textField63.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField63.setBackground(Color.white);
		textField63.setSelectedTextColor(Color.black);

		textField7 = new JTextField("Κινητό τηλέφωνο"); // θετει τις πληροφοριες του αναλογου textfield
		textField7.setBounds(450, 460, 350, 40);
		textField7.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField7.setBackground(Color.white);
		textField7.setSelectedTextColor(Color.black);

		proffesionalRadioButton = new JRadioButton("Ναι"); // θετει τις πληροφοριες του αναλογου radiobutton
		proffesionalRadioButton.setBounds(700, 550, 60, 50);
		proffesionalRadioButton.setBackground(Color.LIGHT_GRAY);
		proffesionalRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		proffesionalRadioButton.setFocusable(false);
		proffesionalRadioButton.addActionListener(this);

		notProffesionalRadioButton = new JRadioButton("Όχι"); // θετει τις πληροφοριες του αναλογου radiobutton
		notProffesionalRadioButton.setBounds(760, 550, 70, 50);
		notProffesionalRadioButton.setBackground(Color.LIGHT_GRAY);
		notProffesionalRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		notProffesionalRadioButton.setFocusable(false);
		notProffesionalRadioButton.addActionListener(this);

		proffesionalLabel = new JLabel("Επαγγελματίας?"); // θετει τις πληροφοριες του αναλογου label
		proffesionalLabel.setBounds(450, 550, 240, 50);
		proffesionalLabel.setBorder(border);
		proffesionalLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		proffesionalLabel.setOpaque(true);
		proffesionalLabel.setBackground(Color.white);
		proffesionalLabel.setForeground(Color.black);

		proffesional = new ButtonGroup(); // βαζει τα αναλογα radiobutton σε group
		proffesional.add(proffesionalRadioButton);
		proffesional.add(notProffesionalRadioButton);

		skillLabel = new JLabel("Επίπεδο Εμπειρίας"); // θετει τις πληροφοριες του αναλογου label
		skillLabel.setBounds(450, 630, 280, 50);
		skillLabel.setBorder(border);
		skillLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		skillLabel.setOpaque(true);
		skillLabel.setBackground(Color.white);
		skillLabel.setForeground(Color.black);

		skill1 = new JRadioButton("1"); // θετει τις πληροφοριες του αναλογου radiobutton
		skill1.setBounds(740, 630, 40, 50);
		skill1.setBackground(Color.LIGHT_GRAY);
		skill1.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill1.setFocusable(false);
		skill1.addActionListener(this);

		skill2 = new JRadioButton("2"); // θετει τις πληροφοριες του αναλογου radiobutton
		skill2.setBounds(780, 630, 40, 50);
		skill2.setBackground(Color.LIGHT_GRAY);
		skill2.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill2.setFocusable(false);
		skill2.addActionListener(this);

		skill3 = new JRadioButton("3"); // θετει τις πληροφοριες του αναλογου radiobutton
		skill3.setBounds(820, 630, 40, 50);
		skill3.setBackground(Color.LIGHT_GRAY);
		skill3.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill3.setFocusable(false);
		skill3.addActionListener(this);

		skill4 = new JRadioButton("4"); // θετει τις πληροφοριες του αναλογου radiobutton
		skill4.setBounds(860, 630, 40, 50);
		skill4.setBackground(Color.LIGHT_GRAY);
		skill4.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill4.setFocusable(false);
		skill4.addActionListener(this);

		skill5 = new JRadioButton("5"); // θετει τις πληροφοριες του αναλογου radiobutton
		skill5.setBounds(900, 630, 40, 50);
		skill5.setBackground(Color.LIGHT_GRAY);
		skill5.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill5.setFocusable(false);
		skill5.addActionListener(this);

		skill = new ButtonGroup(); // βαζει τα αναλογα radiobutton σε group
		skill.add(skill1);
		skill.add(skill2);
		skill.add(skill3);
		skill.add(skill4);
		skill.add(skill5);

		messageCongratsLabel = new JLabel("Η προσθήκη του αθλητή ήτανε επιτυχής!"); // ολα αυτα ειναι label για αν εχει
																					// δωθει λαθος πληροφορια
		messageCongratsLabel.setVisible(false);
		messageCongratsLabel.setFont(new Font("Poppins", Font.BOLD, 35));
		messageCongratsLabel.setBounds(350, 500, 800, 500);

		messageWrongDateLabel = new JLabel("Λάθος ημερομηνία");
		messageWrongDateLabel.setVisible(false);
		messageWrongDateLabel.setFont(new Font("Poppins", Font.BOLD, 15));
		messageWrongDateLabel.setBounds(1080, 340, 150, 100);

		messageNoDateLabel = new JLabel("Καθόλου ημερομηνία");
		messageNoDateLabel.setVisible(false);
		messageNoDateLabel.setFont(new Font("Poppins", Font.BOLD, 15));
		messageNoDateLabel.setBounds(1080, 340, 150, 100);

		messageNoPhoneLabel = new JLabel("Καθόλου κινητό");
		messageNoPhoneLabel.setVisible(false);
		messageNoPhoneLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		messageNoPhoneLabel.setBounds(810, 430, 260, 100);

		messageWrongPhoneLabel = new JLabel("Λάθος κινητό");
		messageWrongPhoneLabel.setVisible(false);
		messageWrongPhoneLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		messageWrongPhoneLabel.setBounds(810, 430, 300, 100);

		messageNoGenderLabel = new JLabel("Καθόλου φύλο");
		messageNoGenderLabel.setVisible(false);
		messageNoGenderLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		messageNoGenderLabel.setBounds(760, 255, 300, 100);

		messageNoProffesionalLabel = new JLabel("Καθόλου επαγγελματική κατάσταση");
		messageNoProffesionalLabel.setVisible(false);
		messageNoProffesionalLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		messageNoProffesionalLabel.setBounds(840, 525, 450, 100);

		messageNoSkillLabel = new JLabel("Καθόλου επίπεδο ικανότητας");
		messageNoSkillLabel.setVisible(false);
		messageNoSkillLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		messageNoSkillLabel.setBounds(950, 605, 450, 100);

		this.setTitle("Καταχώρηση αθλητή στο σύστημα"); // τα δεδομενα του frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 920);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocation(325, 60);
		this.add(textField3);
		this.add(textField4);
		this.add(femaleRadioButton);
		this.add(maleRadioButton);
		this.add(genderLabel);
		this.add(textField61);
		this.add(textField62);
		this.add(textField63);
		this.add(textField7);
		this.add(proffesionalRadioButton);
		this.add(notProffesionalRadioButton);
		this.add(proffesionalLabel);
		this.add(skillLabel);
		this.add(dateLabel);
		this.add(skill1);
		this.add(skill2);
		this.add(skill3);
		this.add(skill4);
		this.add(skill5);
		this.add(button);
		this.add(returnButton);
		this.add(messageCongratsLabel);
		this.add(messageWrongDateLabel);
		this.add(messageNoDateLabel);
		this.add(messageNoGenderLabel);
		this.add(messageNoPhoneLabel);
		this.add(messageNoProffesionalLabel);
		this.add(messageNoSkillLabel);
		this.add(messageWrongPhoneLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			if (maleRadioButton.isSelected()) { // αν πατηθει το κουμπι της αποθηκευσης φτιαχνει της μεταβλητες που
												// χρειαζονται για να εξετασουμε αν ειναι σωστες οι πληροφοριες
				athleteGender = 'M';
			} else if (femaleRadioButton.isSelected()) {
				athleteGender = 'F';
			}
			if (proffesionalRadioButton.isSelected()) {
				athleteProffesional = true;
			} else if (notProffesionalRadioButton.isSelected()) {
				athleteProffesional = false;
			}
			if (skill1.isSelected()) {
				athleteSkill = 1;
			} else if (skill2.isSelected()) {
				athleteSkill = 2;
			} else if (skill3.isSelected()) {
				athleteSkill = 3;
			} else if (skill4.isSelected()) {
				athleteSkill = 4;
			} else if (skill5.isSelected()) {
				athleteSkill = 5;
			}
		}
		if (e.getSource() == button) { // στην συνεχεια κανει ολα αυτα τα label αορατα γτ αλλιως αν εχει εμφανιστει
										// αλλο θεμα πριν δεν θα φυγει το μυνημα απο πριν
			messageCongratsLabel.setVisible(false);
			messageNoDateLabel.setVisible(false);
			messageWrongDateLabel.setVisible(false);
			messageNoPhoneLabel.setVisible(false);
			messageWrongPhoneLabel.setVisible(false);
			messageNoGenderLabel.setVisible(false);
			messageNoProffesionalLabel.setVisible(false);
			messageNoSkillLabel.setVisible(false);
			wrongInformation = false;
			if (textField61.getText().equals("DD") || textField62.getText().equals("MM")
					|| textField63.getText().equals("YYYY")) { // αν δεν εχει δωθει ημερομηνια
				messageNoDateLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα οτι
														// υπαρχει λαθος πληροφορια
				wrongInformation = true;
			} else {
				day = Integer.parseInt(textField61.getText()); // χωριζει της ημερομινιες σε τρια κομματια
				month = Integer.parseInt(textField62.getText());
				year = Integer.parseInt(textField63.getText());
				if (athleteService.ckeckAthleteDate(day, month, year)) { // και τσεκαρει αν ειναι επιτρεπτες
					messageWrongDateLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα
															// οτι υπαρχει λαθος πληροφορια
					wrongInformation = true;
				}
			}
			if (textField7.getText().equals("Κινητό τηλέφωνο")) { // αν εχει δωθει τηλεωονο
				messageNoPhoneLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα οτι
														// υπαρχει λαθος πληροφορια
				wrongInformation = true;
			} else {
				phone = Long.parseLong(textField7.getText());
				if (athleteService.checkAthletePhone(phone)) { // αν το τηλεφονο ειναι 10 ψηφιων
					messageWrongPhoneLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα
																// οτι υπαρχει λαθος πληροφορια
					wrongInformation = true;
				}
			}
			if (gender.getSelection() == null) { // αν στο group δεν εχει επιλεχθει κατι
				messageNoGenderLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα οτι
														// υπαρχει λαθος πληροφορια
				wrongInformation = true;
			}
			if (proffesional.getSelection() == null) { // αν στο group δεν εχει επιλεχθει κατι
				messageNoProffesionalLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα
																// οτι υπαρχει λαθος πληροφορια
				wrongInformation = true;
			}
			if (skill.getSelection() == null) { // αν στο group δεν εχει επιλεχθει κατι
				messageNoSkillLabel.setVisible(true); // το αναλογο label γινεται ορατο και ενημερωνει το συστημα οτι
														// υπαρχει λαθος πληροφορια
				wrongInformation = true;
			}
			if (!wrongInformation) { // αν δεν υπαρχει θεμα
				messageNoDateLabel.setVisible(false);
				messageWrongDateLabel.setVisible(false);
				messageNoPhoneLabel.setVisible(false);
				messageWrongPhoneLabel.setVisible(false);
				messageNoGenderLabel.setVisible(false);
				messageNoProffesionalLabel.setVisible(false);
				messageNoSkillLabel.setVisible(false);
				messageCongratsLabel.setVisible(true);
				athleteService.addAthlete(textField3.getText(), textField4.getText(), athleteGender, // προσθετη αθλητη
						textField61.getText() + "/" + textField62.getText() + "/" + textField63.getText(),
						textField7.getText(),
						athleteProffesional, athleteSkill);
			}

		} else if (e.getSource() == returnButton) { // αν πατηθει το επιστροφη γυρναει στο προηγουμενο window
			this.setVisible(false);
			resetValues();
			parentWindow.setVisible(true);
		}

	}

	private void resetValues() { // καθε φορα που πατιεται η επιστροφη ξανα φτιαχνει τα σωστα δεδομενα
		textField3.setText("Όνομα");
		gender.clearSelection();
		proffesional.clearSelection();
		skill.clearSelection();
		textField4.setText("Επώνυμο");
		textField7.setText("Κινητό τηλέφωνο");
		textField61.setText("DD");
		textField62.setText("MM");
		textField63.setText("YYYY");
		messageCongratsLabel.setVisible(false);
		messageNoDateLabel.setVisible(false);
		messageWrongDateLabel.setVisible(false);
		messageNoPhoneLabel.setVisible(false);
		messageWrongPhoneLabel.setVisible(false);
		messageNoGenderLabel.setVisible(false);
		messageNoProffesionalLabel.setVisible(false);
		messageNoSkillLabel.setVisible(false);
	}

}
