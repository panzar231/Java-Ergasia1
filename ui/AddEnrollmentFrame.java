package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Enrollment;
import services.EnrollmentService;

public class AddEnrollmentFrame extends ChildWindow implements ActionListener { // κανει extend το childwindow ωστε να
																				// μπορει να επιστρεφει στο προηγουμενο
																				// παραθυρο

	private EnrollmentService enrollmentService;

	private JTextField codeTextField1, textField3; // ολα τα textfield
	private JButton submitButton1, returnButton, button; // ολα τα κουμπια
	private JLabel wrongCode, messageCongratsLabel, costLabel; // ολα τα label
	private Enrollment enrollment;

	AddEnrollmentFrame(JFrame parentWindow, EnrollmentService enrollmentService) {
		super(parentWindow);

		this.enrollmentService = enrollmentService;

		button = new JButton("Πληρωμή");
		button.setBounds(700, 350, 200, 100);
		button.setFocusable(false);
		button.addActionListener(this);
		button.setVisible(false);

		codeTextField1 = new JTextField("Κωδικός αθλητή");
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

		wrongCode = new JLabel("Λάθος κωδικός");
		wrongCode.setVisible(false);
		wrongCode.setFont(new Font("Poppins", Font.BOLD, 40));
		wrongCode.setBounds(450, 400, 300, 60);
		wrongCode.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		wrongCode.setBackground(Color.white);
		wrongCode.setForeground(Color.black);
		wrongCode.setOpaque(true);

		costLabel = new JLabel("");
		costLabel.setVisible(false);
		costLabel.setFont(new Font("Poppins", Font.BOLD, 40));
		costLabel.setBounds(450, 400, 300, 60);
		costLabel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		costLabel.setBackground(Color.white);
		costLabel.setForeground(Color.black);
		costLabel.setOpaque(true);

		messageCongratsLabel = new JLabel("Η πληρωμή συνδρομής ήταν επιτυχής!");
		messageCongratsLabel.setVisible(false);
		messageCongratsLabel.setFont(new Font("Poppins", Font.BOLD, 35));
		messageCongratsLabel.setBounds(350, 500, 800, 500);

		this.setTitle("Πληρωμή εγγραφής"); // τα δεδομενα του frame
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
		this.add(wrongCode);
		this.add(costLabel);
		this.add(messageCongratsLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		button.setVisible(false);
		messageCongratsLabel.setVisible(false);
		costLabel.setVisible(true);
		button.setVisible(true);
		if (e.getSource() == returnButton) { // αν πατηθει το επιστροφη
			// γυρναει στο προηγουμενο window
			this.setVisible(false);
			resetValues(); // κανει reset ολες τισ πληροφοριες
			parentWindow.setVisible(true);
		} else if (e.getSource() == submitButton1) { // αν πατηθει το αναζητηση
			wrongCode.setVisible(false);
			button.setVisible(false);
			if (isInteger(codeTextField1.getText())) {
				int code = Integer.valueOf(codeTextField1.getText());
				enrollment = enrollmentService.createEnrollmentFor(code);
				if (enrollment == null) {
					wrongCode.setVisible(true);
					return;
				}
				costLabel.setText("Κόστος: " + enrollment.getCost());
			} else {
				wrongCode.setVisible(true);
			}
		} else if (e.getSource() == button) { // αν πατηθει το πληρωμη
			enrollmentService.paid(enrollment);
			button.setVisible(false);
			messageCongratsLabel.setVisible(true);
		}
	}

	private void resetValues() {
		codeTextField1.setText("Κωδικός του αθλητή");
		wrongCode.setVisible(false);
		messageCongratsLabel.setVisible(false);
		costLabel.setVisible(false);
		button.setVisible(false);
	}

	private boolean isInteger(String text) {
		try { // αυτος ο κωδικας κοιταζει αν μπορει το string να μεταφραστει σε αριθμο

			int code = Integer.valueOf(text);

			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
