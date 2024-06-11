package services;

import java.util.ArrayList;
import java.util.List;

import model.Athlete;

public class AthleteService {

    private List<Athlete> athleteList;

    public AthleteService() {
        this.athleteList = new ArrayList<>();
    }

    public void addAthlete(String name, String surname, char gender, int dateOfBirth, int phoneNumber,
            boolean proffesional, int skill) {
        Athlete athlete = new Athlete();
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

    private int nextCode() {
        return athleteList.size() + 1;
    }
}
