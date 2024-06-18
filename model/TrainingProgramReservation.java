package model;

public class TrainingProgramReservation {
    private String reservationcode;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private String dateOfReservation;

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public String getReservationcode() {
        return reservationcode;
    }

    public void setReservationcode(String reservationcode) {
        this.reservationcode = reservationcode;
    }

    public String getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(String dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }
}
