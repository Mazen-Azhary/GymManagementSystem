package gymproject;

import java.util.Scanner;

public class GymProject {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice;
        boolean exitSys = false;
        AdminRole admin = new AdminRole();
        TrainerRole trainer = new TrainerRole();
        while (!exitSys) {
            System.out.println("Welcome To Gym Sys, Please choose a role:");
            System.out.println("1-Admin Role");
            System.out.println("2-Trainer Role");
            System.out.println("3-Exit");
            System.out.print("Enter your choice:");
            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    boolean exitAdmin = false;
                    while (!exitAdmin) {
                        System.out.println("Admin Menu:");
                        System.out.println("1-View Reports");
                        System.out.println("2-Manage Users");
                        System.out.println("3-Logout to Main Menu");
                        System.out.print("Enter your choice:");
                        int adminChoice = s.nextInt();
                        s.nextLine();
                        switch (adminChoice) {
                            case 1:
                                
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                exitAdmin = true;
                                break;
                            default:
                                System.out.println("Invalid choice,Please try again.");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    boolean exitTrainer = false;
                    while (!exitTrainer) {
                        System.out.println("Trainer Menu:");
                        System.out.println("1-View Workout Plans");
                        System.out.println("2-Track Client Progress");
                        System.out.println("3-Logout to Main Menu");
                        System.out.print("Enter your choice:");
                        int trainerChoice = s.nextInt();
                        s.nextLine();

                        switch (trainerChoice) {
                            case 1:
                                
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                
                                exitTrainer = true;
                                break;
                            default:
                                System.out.println("Invalid choice,Please try again.");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Exiting");
                    exitSys = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        s.close();
    }
}
