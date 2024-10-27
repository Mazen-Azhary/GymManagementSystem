package gymproject;

import java.util.ArrayList;

public class AdminRole {

    private TrainerDatabase trainerDatabase = new TrainerDatabase();

    public AdminRole() {}

    public boolean addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        if (!trainerDatabase.contains(trainerId)) {
            trainerDatabase.insertRecord(new Trainer(trainerId, name, specialty, email, phoneNumber));
            return true;
        }
        return false;
    }

    public ArrayList<Users> getListOfTrainers() {
        return trainerDatabase.returnAllRecords();
    }

    public boolean removeTrainer(String key) {
        if (trainerDatabase.getRecord(key)!=null) {
            trainerDatabase.deleteRecord(key);
            return true;
        }
        return false;
    }

    public void logout() {
        trainerDatabase.saveToFile();
    }
}
