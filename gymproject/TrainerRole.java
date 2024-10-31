package gymproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TrainerRole {
    private MemberDatabase memberdatabase = new MemberDatabase();
    private ClassDatabase classdatabase = new ClassDatabase();
    private MemberClassRegistrationDatabase memberClassRegistrationDatabase = new MemberClassRegistrationDatabase();

    public TrainerRole() {}

    public boolean addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if (!memberdatabase.contains(memberID)) {
            memberdatabase.insertRecord(new Member(memberID, name, membershipType, email, phoneNumber, status));
            return true;
        }
        return false;
    }

    public ArrayList<Users> getListOfMembers() {
        return memberdatabase.returnAllRecords();
    }

    public boolean addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        return classdatabase.insertRecord(new Class(classID, className, trainerID, duration, maxParticipants));
    }

    public ArrayList<Users> getListOfClasses() {
        return classdatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {

        Class addedClass = (Class) classdatabase.getRecord(classID);
        Member addedMember = (Member) memberdatabase.getRecord(memberID);
        if (addedClass == null || addedMember == null || addedClass.getAvailableSeats() == 0) {
            return false;
        }
        if (memberClassRegistrationDatabase.getRecord(memberID + classID) != null) {
            return false;
        }
        MemberClassRegistration newRegistration = new MemberClassRegistration(memberID,classID,"Active",registrationDate);
        if (memberClassRegistrationDatabase.insertRecord(newRegistration)) {
            addedClass.setAvailableSeats(addedClass.getAvailableSeats() - 1);
            return true;
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        MemberClassRegistration registration = (MemberClassRegistration) memberClassRegistrationDatabase.getRecord(memberID + classID);

        if (registration == null) {
            return false;
        }
        if(registration.getStatus().equalsIgnoreCase("cancelled")) {
            return false;
        }
        LocalDate cancelDate = LocalDate.now();
        LocalDate registrationDate = registration.getRegistrationDate();
        long daysBetween = ChronoUnit.DAYS.between(registrationDate, cancelDate);
        if (daysBetween <= 3) {
            Class registeredClass = (Class) classdatabase.getRecord(classID);
                registration.setRegistrationStatus("cancelled");
                registeredClass.setAvailableSeats(registeredClass.getAvailableSeats() + 1);
                return true;
        }
        return false;
    }

    public ArrayList<Users> getListOfRegistrations() {
        return memberClassRegistrationDatabase.returnAllRecords();
    }

    public void logout() {
        memberClassRegistrationDatabase.saveToFile();
        classdatabase.saveToFile();
        memberdatabase.saveToFile();
    }
}
