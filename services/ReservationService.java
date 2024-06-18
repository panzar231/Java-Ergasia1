package services;

import java.util.ArrayList;
import java.util.List;

import model.Athlete;
import model.TrainingProgram;
import model.TrainingProgramReservation;

public class ReservationService {

    private List<TrainingProgramReservation> reservationList;
    TrainingProgramReservation reservation;

    public ReservationService() {

        this.reservationList = new ArrayList<>();
    }

    public void reservation(Athlete athlete, TrainingProgram trainingProgram, String dateOfReservation,
            int sizeOfAthleteList) {

        if (sizeOfAthleteList != 0) {

            reservation = new TrainingProgramReservation();

            reservation.setAthlete(athlete);
            reservation.setTrainingProgram(trainingProgram);
            reservation.setDateOfReservation(dateOfReservation);

            reservationList.add(reservation);
        } else {
            System.out.println("There are no athletes added.");
        }

    }
}
