package gymproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;

public class TrainerRole {
    private MemberDatabase memberdatabase = new MemberDatabase();
    private ClassDatabase classdatabase = new ClassDatabase();
    private MemberClassRegistrationDatabase memberClassRegistrationDatabase = new MemberClassRegistrationDatabase();

    public TrainerRole() {
    }

    public boolean addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if(!memberdatabase.contains(memberID)){
            memberdatabase.insertRecord(new Member(memberID,name,membershipType,email,phoneNumber,status));
            return true;
        }
        return false;
    }  

    public ArrayList<Member> getListOfMembers()
    {
        ArrayList<Users> records = memberdatabase.returnAllRecords();
        ArrayList<Member> members = new ArrayList<>();

        for (Users record : records) {
            if (record instanceof Member) {
                members.add((Member) record);
            }
        }
        return members;

    }

    public void addClass (String classID, String className, String trainerID, int duration, int
    maxParticipants) {
        classdatabase.insertRecord(new Class(classID,className,trainerID,duration,maxParticipants));
    }

    public ArrayList<Class> getListOfClasses(){
        ArrayList<Users> records = classdatabase.returnAllRecords();
        ArrayList<Class> classes = new ArrayList<>();

        for (Users record : records) {
            if (record instanceof Class) {
                classes.add((Class) record);
            }
        }
        return classes;
    }

    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate)
    {
        Class addedClass = (Class) classdatabase.getRecord(classID);
        if(addedClass == null)
            return false;
        if(addedClass.getAvailableSeats()>0)
        {
            memberClassRegistrationDatabase.insertRecord(new MemberClassRegistration(memberID,classID,"active"));
            addedClass.setAvailableSeats(addedClass.getAvailableSeats()-1);
        }
            return true;
    }

    public boolean cancelRegistration (String memberID, String classID)
    {
        LocalDate cancelDate = LocalDate.now();
        MemberClassRegistration registration = (MemberClassRegistration) memberClassRegistrationDatabase.getRecord(classID);
        if(registration == null)
            return false;
        LocalDate registeredDate = registration.getRegistrationDate();
        long days = ChronoUnit.DAYS.between(registeredDate, cancelDate);
        if(days<=3)
        {
        registration.setRegistrationStatus("cancelled");
        Class c_class = (Class) classdatabase.getRecord(classID);
        c_class.setAvailableSeats(c_class.getAvailableSeats()+1);
        memberClassRegistrationDatabase.deleteRecord(classID);
        return true;
        }
        return false;
    }

    void issueRefund(String MemberID)
    {
        System.out.println("Refund issued to member: "+MemberID);
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        ArrayList<Users> records = memberClassRegistrationDatabase.returnAllRecords();
        ArrayList<MemberClassRegistration> registrations = new ArrayList<>();

        for (Users record : records) {
            if (record instanceof MemberClassRegistration) {
                registrations.add((MemberClassRegistration) record);
            }
        }
        return registrations;
    }



    void logout()
    {
        memberClassRegistrationDatabase.saveToFile();
        classdatabase.saveToFile();
        memberdatabase.saveToFile();
    }
}
