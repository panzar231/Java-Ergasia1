package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import services.AthleteService;
import services.SubscriptionService;

@SuppressWarnings("unused")
public class SubscriptionFrame extends ChildWindow implements ActionListener {

	// private First Operation of the susbscription service frame
	private JButton newSubscription, subscriptionPayment, showSubscriptionList, subscriptionCancel, returnButton;

	public SubscriptionFrame(JFrame parentWindow, SubscriptionService subscriptionService) {
		super(parentWindow);
		// this.addAthleteFrame = new AddAthleteFrame(this, athleteService);

		newSubscription = new JButton();
		newSubscription.setBounds(30, 40, 230, 50);
		newSubscription.setVisible(true);
		newSubscription.setText("Νέα συνδρωμή");
		newSubscription.setFocusable(false);
		newSubscription.addActionListener(this);

		subscriptionPayment = new JButton();
		subscriptionPayment.setBounds(30, 120, 230, 50);
		subscriptionPayment.setVisible(true);
		subscriptionPayment.setText("Πληρωμή συνδρωμής");
		subscriptionPayment.setFocusable(false);
		subscriptionPayment.addActionListener(this);

		showSubscriptionList = new JButton();
		showSubscriptionList.setBounds(30, 200, 230, 50);
		showSubscriptionList.setVisible(true);
		showSubscriptionList.setText("Εμφάνιση λίστας συνδρωμών");
		showSubscriptionList.setFocusable(false);
		showSubscriptionList.addActionListener(this);

		subscriptionCancel = new JButton();
		subscriptionCancel.setBounds(30, 280, 230, 50);
		subscriptionCancel.setVisible(true);
		subscriptionCancel.setText("Ακύρωση συνδρωμής");
		subscriptionCancel.setFocusable(false);
		subscriptionCancel.addActionListener(this);

		returnButton = new JButton();
		returnButton.setBounds(30, 360, 230, 50);
		returnButton.setVisible(true);
		returnButton.setText("Επιστροφή");
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);

		this.setTitle("Διαχείριση Συνδρωμών");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 480);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocation(800, 325);
		// this.setIconImage(athleteImage.getImage());
		this.add(newSubscription);
		this.add(subscriptionPayment);
		this.add(showSubscriptionList);
		this.add(subscriptionCancel);
		this.add(returnButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newSubscription) {
			this.setVisible(false);
			// addAthleteFrame.setVisible(true);
		} else if (e.getSource() == subscriptionPayment) {

		} else if (e.getSource() == showSubscriptionList) {

		} else if (e.getSource() == subscriptionCancel) {

		} else if (e.getSource() == returnButton) {
			this.setVisible(false);
			parentWindow.setVisible(true);
		}

	}

}
