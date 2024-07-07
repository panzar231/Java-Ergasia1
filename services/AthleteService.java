package services;

import java.util.ArrayList;
import java.util.List;

import model.Athlete;

public class AthleteService {

	private List<Athlete> athleteList; // η λιστα με τους αθλητες

	public AthleteService() {
		this.athleteList = new ArrayList<>(); // στο constructor θα δημιουργει την λιστα
		addAthlete("geo", "zar", 'M', "", "null", true, 2);
	}

	public void addAthlete(String name, String surname, char gender, String dateOfBirth, String phoneNumber, // αυτη η
																												// μεθοδο
																												// προσθετη
																												// εναν
																												// αθλητη
																												// με τα
																												// αναλογα
																												// στοιχεια
																												// στην
																												// λιστα
			boolean proffesional, int skill) {
		Athlete athlete = new Athlete();
		athlete.setCode(nextCode()); // ο κωδικος φτιαχνεται μονος του απο την αναλογη μεθοδο
		athlete.setName(name);
		athlete.setSurname(surname);
		athlete.setGender(gender);
		athlete.setDateOfBirth(dateOfBirth);
		athlete.setPhoneNumber(phoneNumber);
		athlete.setProffesional(proffesional);
		athlete.setSkill(skill);
		athleteList.add(athlete);
	}

	public boolean ckeckAthleteDate(int dayOfBirthTemp, int monthOfBirthTemp, int yearOfBirthTemp) { // εξεταζει αν
																										// ειναι σωστη η
																										// ημερομινια
																										// γενισσης
		if (yearOfBirthTemp < 1000 || yearOfBirthTemp > 2024) { // μην ειναι μικροτερο απο 4 ψηφεια αλλα να μην ειναι
																// μεγαλυτερο απο φετος
			return true;
		} else {
			if (monthOfBirthTemp < 1 || monthOfBirthTemp > 12) { // να ειναι σωστος μηνας
				return true;
			} else {
				if (monthOfBirthTemp == 2 && yearOfBirthTemp % 4 == 0) { // για φεβρουαριο αν ο χρονος διαιρειται με το
																			// 4 τοτε να περιοριζεται μεχρι τις 29
					if (dayOfBirthTemp < 1 || dayOfBirthTemp > 29) {
						return true;
					} else {

						return false;
					}
				} else if (monthOfBirthTemp == 2 && yearOfBirthTemp % 4 != 0) { // για φεβρουαριο αν ο χρονος δεν
																				// διαιρειται με το 4 τοτε να
																				// περιοριζεται μεχρι τις 28
					if (dayOfBirthTemp < 1 || dayOfBirthTemp > 28) {
						return true;
					} else {

						return false;
					}
				} else if (monthOfBirthTemp < 8) { // αν μηνας πριν τον αυγουστο τοτε αν διαιρειται με το δυο
													// περιοριζεται στο 30
					if (monthOfBirthTemp % 2 == 0) {
						if (dayOfBirthTemp < 1 || dayOfBirthTemp > 30) {
							return true;
						} else {

							return false;
						}
					} else { // αν μηνας μετα τον αυγουστο τοτε αν διαιρειται με το δυο περιοριζεται στο 31
						if (dayOfBirthTemp < 1 || dayOfBirthTemp > 31) {
							return true;
						} else {

							return false;
						}
					}
				} else {
					if (monthOfBirthTemp % 2 == 0) {
						if (dayOfBirthTemp < 1 || dayOfBirthTemp > 31) {
							return true;
						} else {

							return false;
						}
					} else {
						if (dayOfBirthTemp < 1 || dayOfBirthTemp > 30) {
							return true;
						} else {

							return false;
						}
					}
				}
			}
		}

	}

	public boolean checkAthletePhone(long phone) { // πρεπει το τηλεφωνο να ειναι 10 ψηφεια μεγαλο
		if (phone < 1000000000l || phone > 9999999999l) {
			return true;
		} else {
			return false;
		}

	}

	private int nextCode() { // επιστρεφη ενα πανω απο το μεγεθος της λιστας
		return athleteList.size() + 1;
	}

	public int getAthleteListSize() { // επιστρεφει το μεγεθος της λιστας
		return athleteList.size();
	}

	public List<Athlete> getAthleteList() { // επιστρεφει την ιδια την λιστα
		return athleteList;
	}

	public int getAthleteCode(int x) { // επιστρεφει των κωδικο του ζητουμενου αθλητη
		return athleteList.get(x).getCode();
	}

}
