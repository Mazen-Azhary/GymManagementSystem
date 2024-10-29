package gymproject;

import java.time.LocalDate;

public class gymproject {

    public static void main(String[] args) {
        // These lines of code are just for testing.

        // Creating an Admin
        AdminRole admin = new AdminRole();
        // add a trainer
        admin.addTrainer("1234", "Omar", "oadel@gmail.com", "fitness", "0112");
        admin.addTrainer("9999", "Ali", "Ali@gmail.com", "fitness", "0122");
        // add the same trainer to test duplication
        admin.addTrainer("1234", "Omar", "oadel@gmail.com", "fitness", "0112");
        // remove trainer with a specific ID
        admin.removeTrainer("1234");
        admin.logout();

        // Creating a trainer
        TrainerRole trainer = new TrainerRole();
        // adding a member
        trainer.addMember("5678", "Mazen", "Monthly", "mazen@gmail.com", "0155", "Active");
        // adding the same member to test duplication
        trainer.addMember("5678", "Mazen", "Monthly", "mazen@gmail.com", "0155", "Active");
        // adding a class
        trainer.addClass("c1", "fitness", "1234", 20, 2);
        trainer.addClass("c3", "fitness", "1234", 30, 0);
        // register the member to the class
        trainer.registerMemberForClass("5678", "c1", LocalDate.now());
        // register the member to a class with no available seats
        trainer.registerMemberForClass("5678", "c3", LocalDate.now());
        // Cancelling an un-existed registration
        trainer.cancelRegistration("8888", "c1");
        // Cancelling an existed registration
        trainer.cancelRegistration("5678", "c1");
        trainer.logout();

    }
}
