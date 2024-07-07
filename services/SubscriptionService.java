package services;

import java.util.ArrayList;
import java.util.List;

import model.Athlete;
import model.Subscription;
import model.TrainingProgram;

public class SubscriptionService {

    private List<Subscription> subscriptionList;
    Subscription subscription;

    public SubscriptionService() {
        this.subscriptionList = new ArrayList<>();
    }

    public void newSubscription(Athlete athlete, TrainingProgram trainingProgram, int monthlyCost) {

        if (hasAthelteSubbscribedToThisTrainingProgram(athlete, trainingProgram)) {

            System.out.println("This training program is already assigned to this athelte");

        } else {
            subscription = new Subscription();

            subscription.setAthlete(athlete);
            subscription.setTrainingProgram(trainingProgram);
            subscription.setMonthlyCost(monthlyCost);

            subscriptionList.add(subscription);
        }

    }

    private boolean hasAthelteSubbscribedToThisTrainingProgram(Athlete athlete, TrainingProgram trainingProgram) {
        boolean athelteAndTrainingProgramCheck = false;

        for (Subscription subscription : subscriptionList) {
            if (subscription.getAthlete() == athlete && subscription.getProgram() == trainingProgram) {
                athelteAndTrainingProgramCheck = true;
            }

        }
        return athelteAndTrainingProgramCheck;
    }

    @SuppressWarnings("unused")
    private void payment() {

    }

}
