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

public class ChangeAthletesFrame extends ChildWindow implements ActionListener { // κανει extend το childwindow ωστε να
																					// μπορει να επιστρεφει στο
																					// προηγουμενο παραθυρο

	String genderOfAthlete; // απο χαρακτηρα σε string
	int code; // κανει το string σε int
	private AthleteService athleteService;
	JTextField codeTextField1, textField2, textField3, textField4, textField61, textField62, textField63, textField7; // ολα
																														// τα
																														// textfield
	JButton submitButton1, returnButton, button; // ολα τα κουμπια
	JRadioButton maleRadioButton, femaleRadioButton, proffesionalRadioButton, notProffesionalRadioButton, skill1,
			skill2, skill3, skill4, skill5;
	JLabel genderLabel, proffesionalLabel, skillLabel, dateLabel, messageCongratsLabel, messageWrongDateLabel,
			messageNoDateLabel,
			messageNoPhoneLabel, messageWrongPhoneLabel, messageNoGenderLabel, messageNoProffesionalLabel,
			messageNoSkillLabel, notAppropriateCode, wrongCode;
	Border border;
	ButtonGroup gender, proffesional, skill;
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

	public ChangeAthletesFrame(JFrame parentWindow, AthleteService athleteService) { // το parent window το καλει ωστε
																						// να μπορει να επιστρεψει πισω
		super(parentWindow); // το κληρωνομει
		this.athleteService = athleteService;

		button = new JButton("Αποθήκευση");
		button.setBounds(100, 350, 200, 100);
		button.setFocusable(false);
		button.addActionListener(this);
		button.setVisible(false);

		codeTextField1 = new JTextField("Κωδικός του αθλητή που θέλετε να τροποποιήσετε");
		codeTextField1.setBounds(400, 10, 450, 50);
		codeTextField1.setFont(new Font("Poppins", Font.PLAIN, 20));
		codeTextField1.setBackground(Color.white);
		codeTextField1.setSelectedTextColor(Color.black);

		submitButton1 = new JButton("Αναζήτηση");
		submitButton1.setBounds(230, 10, 150, 50);
		submitButton1.setFocusable(false);
		submitButton1.addActionListener(this);

		returnButton = new JButton("Επιστροφή");
		returnButton.setBounds(70, 10, 150, 50);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);

		showAthleteInfo(); // στην ουσια αυτο ειναι ολο το ιδιο με το addAthleteFrame

		this.setTitle("Αλλαγή στοιχείων αθλητή");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 920);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocation(325, 60);
		this.add(codeTextField1);
		this.add(submitButton1);
		this.add(returnButton);
		this.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent d) {
		if (d.getSource() == submitButton1) {
			if (isInteger(codeTextField1.getText())) { // αν το string που δωθηκε αντιστοιχει σε αριθμο
				if (isCode(code)) { // αν ο αριθμος αυτος αντιστοιχει σε κωδικο
					changeInfo(code); // αλλαζει ολα τα δεδομενα για τον αναλογο αθλητη
					setVisibility(true); // και τα κανει ορατα
					wrongCode.setVisible(false); // αορατο το να εχει γινει καποιο λαθος
					notAppropriateCode.setVisible(false);
				} else { // αν δεν αντιστοιχει σε κωιδκο
					setVisibility(false);
					wrongCode.setVisible(true); // του λεει οτι εχει λαθος κωδικο
					notAppropriateCode.setVisible(false);
				}
			} else { // αν δεν ειναι αριθμος
				setVisibility(false);
				wrongCode.setVisible(false); // του λεει οτι εχει λαθος text
				notAppropriateCode.setVisible(true);
			}

		} else if (d.getSource() == returnButton) { // επιστροφη στο προηγουμενο παραθυρο
			this.setVisible(false);
			resetValues(); // κανει reset ολες τισ πληροφοριες
			setVisibility(false);
			parentWindow.setVisible(true);
		}
		if (d.getSource() == button) { // το ιδιο με το addAthleteFrame
			if (maleRadioButton.isSelected()) {
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
		if (d.getSource() == button) { // το ιδιο με το addAthleteFrame ομως αντι για να προσθετη αθλητη απλα τον
										// επεξεργαζεται
			checkInfo();
			if (!wrongInformation) {
				messageNoDateLabel.setVisible(false);
				messageWrongDateLabel.setVisible(false);
				messageNoPhoneLabel.setVisible(false);
				messageWrongPhoneLabel.setVisible(false);
				messageNoGenderLabel.setVisible(false);
				messageNoProffesionalLabel.setVisible(false);
				messageNoSkillLabel.setVisible(false);
				messageCongratsLabel.setVisible(true);
				athleteService.getAthleteList().get(code - 1).setName(textField3.getText()); // ο κωδικος ειναι παντα -1
																								// επειδη για το πρβτο
																								// στοιχειο του πινακα
																								// πρεπει να παμε στην
																								// θεση 0
				athleteService.getAthleteList().get(code - 1).setSurname(textField4.getText());
				athleteService.getAthleteList().get(code - 1).setGender(athleteGender);
				athleteService.getAthleteList().get(code - 1).setDateOfBirth(
						textField61.getText() + "/" + textField62.getText() + "/" + textField63.getText());
				athleteService.getAthleteList().get(code - 1).setPhoneNumber(textField7.getText());
				athleteService.getAthleteList().get(code - 1).setProffesional(athleteProffesional);
				athleteService.getAthleteList().get(code - 1).setSkill(athleteSkill);
			}
		}
	}

	private void resetValues() { // τα κανει ολα αορατα και κανει reset το text
		codeTextField1.setText("Κωδικός του αθλητή που θέλετε να τροποποιήσετε");
		messageCongratsLabel.setVisible(false);
		messageNoDateLabel.setVisible(false);
		messageWrongDateLabel.setVisible(false);
		messageNoPhoneLabel.setVisible(false);
		messageWrongPhoneLabel.setVisible(false);
		messageNoGenderLabel.setVisible(false);
		messageNoProffesionalLabel.setVisible(false);
		messageNoSkillLabel.setVisible(false);
		notAppropriateCode.setVisible(false);
		wrongCode.setVisible(false);
	}

	private boolean isInteger(String text) {
		try { // αυτος ο κωδικας κοιταζει αν μπορει το string να μεταφραστει σε αριθμο

			code = Integer.valueOf(text);

			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isCode(int x) { // κοιταει ολη την λιστα να δει αν ο αριθμος που δωσθηκε αντιστοιχει σε κανενα
									// αθλητη
		for (int i = 0; i <= x; i++) {
			try {
				if (x == athleteService.getAthleteCode(i)) {
					return true;
				}
			} catch (IndexOutOfBoundsException e) {
				return false;
			}
		}
		return false;
	}

	private void showAthleteInfo() { // το ιδιο με το addAthleteFrame

		textField3 = new JTextField("Όνομα");
		textField3.setBounds(450, 100, 350, 40);
		textField3.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField3.setBackground(Color.white);
		textField3.setSelectedTextColor(Color.black);
		textField3.setVisible(false);

		textField4 = new JTextField("Επώνυμο");
		textField4.setBounds(450, 190, 350, 40);
		textField4.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField4.setBackground(Color.white);
		textField4.setSelectedTextColor(Color.black);
		textField4.setVisible(false);

		maleRadioButton = new JRadioButton("Άντρας");
		maleRadioButton.setBounds(540, 280, 100, 50);
		maleRadioButton.setBackground(Color.LIGHT_GRAY);
		maleRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		maleRadioButton.setFocusable(false);
		maleRadioButton.addActionListener(this);
		maleRadioButton.setVisible(false);

		femaleRadioButton = new JRadioButton("Γυναίκα");
		femaleRadioButton.setBounds(640, 280, 100, 50);
		femaleRadioButton.setBackground(Color.LIGHT_GRAY);
		femaleRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		femaleRadioButton.setFocusable(false);
		femaleRadioButton.addActionListener(this);
		femaleRadioButton.setVisible(false);

		border = BorderFactory.createLineBorder(Color.black, 3);

		genderLabel = new JLabel("Φύλο");
		genderLabel.setBounds(450, 280, 80, 50);
		genderLabel.setBorder(border);
		genderLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		genderLabel.setOpaque(true);
		genderLabel.setBackground(Color.white);
		genderLabel.setForeground(Color.black);
		genderLabel.setVisible(false);

		gender = new ButtonGroup();
		gender.add(femaleRadioButton);
		gender.add(maleRadioButton);

		dateLabel = new JLabel("Ημερομηνία γέννησης");
		dateLabel.setBounds(450, 370, 350, 40);
		dateLabel.setBorder(border);
		dateLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		dateLabel.setOpaque(true);
		dateLabel.setBackground(Color.white);
		dateLabel.setForeground(Color.black);
		dateLabel.setVisible(false);

		textField61 = new JTextField("DD");
		textField61.setBounds(810, 370, 70, 40);
		textField61.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField61.setBackground(Color.white);
		textField61.setSelectedTextColor(Color.black);
		textField61.setVisible(false);

		textField62 = new JTextField("MM");
		textField62.setBounds(890, 370, 70, 40);
		textField62.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField62.setBackground(Color.white);
		textField62.setSelectedTextColor(Color.black);
		textField62.setVisible(false);

		textField63 = new JTextField("YYYY");
		textField63.setBounds(970, 370, 100, 40);
		textField63.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField63.setBackground(Color.white);
		textField63.setSelectedTextColor(Color.black);
		textField63.setVisible(false);

		textField7 = new JTextField("Κινητό τηλέφωνο");
		textField7.setBounds(450, 460, 350, 40);
		textField7.setFont(new Font("Poppins", Font.PLAIN, 35));
		textField7.setBackground(Color.white);
		textField7.setSelectedTextColor(Color.black);
		textField7.setVisible(false);

		proffesionalRadioButton = new JRadioButton("Ναι");
		proffesionalRadioButton.setBounds(700, 550, 60, 50);
		proffesionalRadioButton.setBackground(Color.LIGHT_GRAY);
		proffesionalRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		proffesionalRadioButton.setFocusable(false);
		proffesionalRadioButton.addActionListener(this);
		proffesionalRadioButton.setVisible(false);

		notProffesionalRadioButton = new JRadioButton("Όχι");
		notProffesionalRadioButton.setBounds(760, 550, 70, 50);
		notProffesionalRadioButton.setBackground(Color.LIGHT_GRAY);
		notProffesionalRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		notProffesionalRadioButton.setFocusable(false);
		notProffesionalRadioButton.addActionListener(this);
		notProffesionalRadioButton.setVisible(false);

		proffesionalLabel = new JLabel("Επαγγελματίας?");
		proffesionalLabel.setBounds(450, 550, 240, 50);
		proffesionalLabel.setBorder(border);
		proffesionalLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		proffesionalLabel.setOpaque(true);
		proffesionalLabel.setBackground(Color.white);
		proffesionalLabel.setForeground(Color.black);
		proffesionalLabel.setVisible(false);

		proffesional = new ButtonGroup();
		proffesional.add(proffesionalRadioButton);
		proffesional.add(notProffesionalRadioButton);

		skillLabel = new JLabel("Επίπεδο Εμπειρίας");
		skillLabel.setBounds(450, 630, 280, 50);
		skillLabel.setBorder(border);
		skillLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
		skillLabel.setOpaque(true);
		skillLabel.setBackground(Color.white);
		skillLabel.setForeground(Color.black);
		skillLabel.setVisible(false);

		skill1 = new JRadioButton("1");
		skill1.setBounds(740, 630, 40, 50);
		skill1.setBackground(Color.LIGHT_GRAY);
		skill1.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill1.setFocusable(false);
		skill1.addActionListener(this);
		skill1.setVisible(false);

		skill2 = new JRadioButton("2");
		skill2.setBounds(780, 630, 40, 50);
		skill2.setBackground(Color.LIGHT_GRAY);
		skill2.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill2.setFocusable(false);
		skill2.addActionListener(this);
		skill2.setVisible(false);

		skill3 = new JRadioButton("3");
		skill3.setBounds(820, 630, 40, 50);
		skill3.setBackground(Color.LIGHT_GRAY);
		skill3.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill3.setFocusable(false);
		skill3.addActionListener(this);
		skill3.setVisible(false);

		skill4 = new JRadioButton("4");
		skill4.setBounds(860, 630, 40, 50);
		skill4.setBackground(Color.LIGHT_GRAY);
		skill4.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill4.setFocusable(false);
		skill4.addActionListener(this);
		skill4.setVisible(false);

		skill5 = new JRadioButton("5");
		skill5.setBounds(900, 630, 40, 50);
		skill5.setBackground(Color.LIGHT_GRAY);
		skill5.setFont(new Font("Poppins", Font.PLAIN, 20));
		skill5.setFocusable(false);
		skill5.addActionListener(this);
		skill5.setVisible(false);

		skill = new ButtonGroup();
		skill.add(skill1);
		skill.add(skill2);
		skill.add(skill3);
		skill.add(skill4);
		skill.add(skill5);

		messageCongratsLabel = new JLabel("Η τροποποίηση του αθλητή ήτανε επιτυχής!");
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

		notAppropriateCode = new JLabel("Μη επιτρεπτός κωδικός");
		notAppropriateCode.setVisible(false);
		notAppropriateCode.setFont(new Font("Poppins", Font.BOLD, 40));
		notAppropriateCode.setBounds(400, 400, 470, 60);
		notAppropriateCode.setBorder(border);
		notAppropriateCode.setBackground(Color.white);
		notAppropriateCode.setForeground(Color.black);
		notAppropriateCode.setOpaque(true);

		wrongCode = new JLabel("Λάθος κωδικός");
		wrongCode.setVisible(false);
		wrongCode.setFont(new Font("Poppins", Font.BOLD, 40));
		wrongCode.setBounds(450, 400, 300, 60);
		wrongCode.setBorder(border);
		wrongCode.setBackground(Color.white);
		wrongCode.setForeground(Color.black);
		wrongCode.setOpaque(true);

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
		this.add(messageCongratsLabel);
		this.add(messageWrongDateLabel);
		this.add(messageNoDateLabel);
		this.add(messageNoGenderLabel);
		this.add(messageNoPhoneLabel);
		this.add(messageNoProffesionalLabel);
		this.add(messageNoSkillLabel);
		this.add(messageWrongPhoneLabel);
		this.add(notAppropriateCode);
		this.add(wrongCode);
	}

	private void setVisibility(boolean x) { // κανει τα παντα ορατα η αορατα
		textField3.setVisible(x);
		textField4.setVisible(x);
		maleRadioButton.setVisible(x);
		femaleRadioButton.setVisible(x);
		genderLabel.setVisible(x);
		dateLabel.setVisible(x);
		textField61.setVisible(x);
		textField62.setVisible(x);
		textField63.setVisible(x);
		textField7.setVisible(x);
		proffesionalRadioButton.setVisible(x);
		notProffesionalRadioButton.setVisible(x);
		proffesionalLabel.setVisible(x);
		skillLabel.setVisible(x);
		skill1.setVisible(x);
		skill2.setVisible(x);
		skill3.setVisible(x);
		skill4.setVisible(x);
		skill5.setVisible(x);
		button.setVisible(x);
	}

	private void changeInfo(int code) { // ο κωδικας αυτος ειναι υπευθηνος για την επεξεργασια του αθλητη
		boolean seenBefore1 = false;
		boolean seenBefore2 = false;
		int lengthOfDate;
		char detector, dayChar, monthChar, yearChar;
		int numberOfSymbols = 0;
		String day = "";
		String month = "";
		String year = "";
		lengthOfDate = athleteService.getAthleteList().get(code - 1).getDateOfBirth().length(); // βρισκει ποσο μεγαλη
																								// ειναι η ημερομηνια
																								// καθως εχει πολλες
																								// μετατροπες αναλογα με
																								// το αν ο μηνας ειναι
																								// δυπλος αριθμος η
																								// ημερα και τα λοιπα
		textField3.setText(athleteService.getAthleteList().get(code - 1).getName()); // βαζει το ονομα του αθλητη σαν το
																						// textfield
		textField4.setText(athleteService.getAthleteList().get(code - 1).getSurname()); // βαζει το επωνυμο του αθλητη
																						// σαν το textfield
		genderOfAthlete = String.valueOf(athleteService.getAthleteList().get(code - 1).getGender()); // βαζει σε μια
																										// μεταβλητη την
																										// string μορφη
																										// του φυλου
		if (genderOfAthlete.equals("M")) { // κανει check το αναλογο radio button
			maleRadioButton.setSelected(true);
		} else {
			femaleRadioButton.setSelected(true);
		}
		for (int d = 0; d < lengthOfDate; d++) {
			detector = athleteService.getAthleteList().get(code - 1).getDateOfBirth().charAt(d); // το detector
																									// εντοπιζει τα '/'
																									// ωστε να ξερει
																									// ποτε ειμαστε
																									// ημερα μηνα η
																									// χρονο
			if (detector == '/') {
				numberOfSymbols++; // μας ενημερωνει ποσα '/' εχουμε δει
			}
			if (numberOfSymbols == 1 && seenBefore1 == false) { // αν ειμαστε ακομα στην ημερα
				for (int r = 0; r < d; r++) {
					dayChar = athleteService.getAthleteList().get(code - 1).getDateOfBirth().charAt(r); // περνει τον
																										// χαρακτηρα στο
																										// αναλογο
																										// σημειο της
																										// ημερομηνιας
					day = day + String.valueOf(dayChar); // αν ειναι δυπλη ημερα οπως το 12 τοτε κανει '1'="1"
															// day=""+"1" '2'="2" day= "1"+"2"="12"
				}
				seenBefore1 = true; // ωστε να μην το κανει πολλαπλες φορες
			} else if (numberOfSymbols == 2 && seenBefore2 == false) { // αν ειμαστε ακομα στον μηνα
				for (int r = day.length() + 1; r < d; r++) { // περνει τον χαρακτηρα στο αναλογο σημειο της ημερομηνιας
					monthChar = athleteService.getAthleteList().get(code - 1).getDateOfBirth().charAt(r);
					month = month + String.valueOf(monthChar); // οπως πριν
				}
				seenBefore2 = true; // ωστε να μην το κανει πολλαπλες φορες
			}

		}
		for (int r = day.length() + month.length() + 2; r < athleteService.getAthleteList().get(code - 1)
				.getDateOfBirth().length(); r++) { // για τον χρονο κανει αθρισμα το μακρος της μερας και του μηνα +2
													// επειδι εχουμε 2 '/'
			yearChar = athleteService.getAthleteList().get(code - 1).getDateOfBirth().charAt(r);
			year = year + String.valueOf(yearChar); // οπως πριν
		}
		textField61.setText(day); // αναθετει την ημερομινια
		textField62.setText(month);
		textField63.setText(year);
		textField7.setText(athleteService.getAthleteList().get(code - 1).getPhoneNumber());
		if (athleteService.getAthleteList().get(code - 1).isProffesional()) { // αν ειναι αθλητης η οχι
			proffesionalRadioButton.setSelected(true);
		} else {
			notProffesionalRadioButton.setSelected(true);
		}
		if (athleteService.getAthleteList().get(code - 1).getSkill() == 1) { // αναλογα με την εμπειρια
			skill1.setSelected(true);
		} else if (athleteService.getAthleteList().get(code - 1).getSkill() == 2) {
			skill2.setSelected(true);
		} else if (athleteService.getAthleteList().get(code - 1).getSkill() == 3) {
			skill3.setSelected(true);
		} else if (athleteService.getAthleteList().get(code - 1).getSkill() == 4) {
			skill4.setSelected(true);
		} else {
			skill5.setSelected(true);
		}
	}

	private void checkInfo() { // σαν το addAthleteFrame
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
				|| textField63.getText().equals("YYYY")) {
			messageNoDateLabel.setVisible(true);
			wrongInformation = true;
		} else {
			day = Integer.parseInt(textField61.getText());
			month = Integer.parseInt(textField62.getText());
			year = Integer.parseInt(textField63.getText());
			if (athleteService.ckeckAthleteDate(day, month, year)) {
				messageWrongDateLabel.setVisible(true);
				wrongInformation = true;
			}
		}
		if (textField7.getText().equals("Κινητό τηλέφωνο")) {
			messageNoPhoneLabel.setVisible(true);
			wrongInformation = true;
		} else {
			phone = Long.parseLong(textField7.getText());
			if (athleteService.checkAthletePhone(phone)) {
				messageWrongPhoneLabel.setVisible(true);
				wrongInformation = true;
			}
		}
	}
}
