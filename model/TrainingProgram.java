package model;

public class TrainingProgram {
    private int personalCode;
    private String sport;
    private String facility;
    private String coach;
    private int minimumLevelOfSkill;
    private boolean requiredBooking;
    private char genderPlayers;
    private int timeMinutes;
    private String dayOfWeek;

    public int getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(int personalCode) {
        this.personalCode = personalCode;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getMinimumLevelOfSkill() {
        return minimumLevelOfSkill;
    }

    public void setMinimumLevelOfSkill(int minimumLevelOfSkill) {
        this.minimumLevelOfSkill = minimumLevelOfSkill;
    }

    public boolean isRequiredBooking() {
        return requiredBooking;
    }

    public void setRequiredBooking(boolean requiredBooking) {
        this.requiredBooking = requiredBooking;
    }

    public char getGenderPlayers() {
        return genderPlayers;
    }

    public void setGenderPlayers(char genderPlayers) {
        this.genderPlayers = genderPlayers;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
