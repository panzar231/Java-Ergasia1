package services;

import java.util.ArrayList;
import java.util.List;

import model.Athlete;

public class AthleteService {

	private List<Athlete> athleteList;
	Athlete athlete;

	public AthleteService() {
		this.athleteList = new ArrayList<>();
	}

	public void addAthlete(String name, String surname, char gender, String dateOfBirth, String phoneNumber,
			boolean proffesional, int skill) {
		athlete = new Athlete();
		athlete.setCode(nextCode());
		athlete.setName(name);
		athlete.setSurname(surname);
		athlete.setGender(gender);
		athlete.setDateOfBirth(dateOfBirth);
		athlete.setPhoneNumber(phoneNumber);
		athlete.setProffesional(proffesional);
		athlete.setSkill(skill);
		athleteList.add(athlete);
	}

	public void printAthlete() {
		System.out.println(athlete.getName());
		System.out.println(athlete.getSurname());
		System.out.println(athlete.getGender());
		System.out.println(athlete.getDateOfBirth());
		System.out.println(athlete.getPhoneNumber());
		System.out.println(athlete.isProffesional());
		System.out.println(athlete.getSkill());
	}

	public boolean ckeckAthleteDate(int dayOfBirthTemp, int monthOfBirthTemp, int yearOfBirthTemp) {
		if (yearOfBirthTemp < 1000 || yearOfBirthTemp > 2024) {
			return true;
		} else {
			if (monthOfBirthTemp < 1 || monthOfBirthTemp > 12) {
				return true;
			} else {
				if (monthOfBirthTemp == 2 && yearOfBirthTemp % 4 == 0) {
					if (dayOfBirthTemp < 1 || dayOfBirthTemp > 29) {
						return true;
					} else {

						return false;
					}
				} else if (monthOfBirthTemp == 2 && yearOfBirthTemp % 4 != 0) {
					if (dayOfBirthTemp < 1 || dayOfBirthTemp > 28) {
						return true;
					} else {

						return false;
					}
				} else if (monthOfBirthTemp < 8) {
					if (monthOfBirthTemp % 2 == 0) {
						if (dayOfBirthTemp < 1 || dayOfBirthTemp > 30) {
							return true;
						} else {

							return false;
						}
					} else {
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

	public boolean checkAthletePhone(long phone) {
		if (phone < 1000000000l || phone > 9999999999l) {
			return true;
		} else {
			return false;
		}

	}

	private int nextCode() {
		return athleteList.size() + 1;
	}

	public List<Athlete> getAthleteList() {
		return this.athleteList;
	}

	public int getSizeOfAthleteList() {
		return athleteList.size();
	}
}
