package gymproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;

public class TrainerRole {
    private MemberDatabase memberdatabase;
    private ClassDatabase classdatabase;
    private MemberClassRegistrationDatabase memberClassRegistrationDatabase;

    public TrainerRole()
    {

    }
    public TrainerRole(MemberDatabase memberdatabase, ClassDatabase classdatabase, MemberClassRegistrationDatabase memberClassRegistrationDatabase) {
        this.memberdatabase = memberdatabase;
        this.classdatabase = classdatabase;
        this.memberClassRegistrationDatabase = memberClassRegistrationDatabase;
    }

    public void addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if(!memberdatabase.contains(memberID))
            memberdatabase.insertRecord(new Member(memberID,name,membershipType,email,phoneNumber,status));
        else 
            System.out.println("The Member is already registered!");
    }  

    public ArrayList<Member> getListOfMembers()
    {
        return memberdatabase.returnAllRecords();
    }

    public void addClass (String classID, String className, String trainerID, int duration, int 
    maxParticipants) {
        classdatabase.insertRecord(new Class(classID,className,trainerID,duration,maxParticipants));
    }

    public ArrayList<Class> getListOfClasses(){
    return this.classdatabase.returnAllRecords();
    }
    
    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate)
    {
        Class addedClass = (Class) classdatabase.getRecord(classID);
        if(addedClass == null)
            return false;
        if(addedClass.getAvailableSeats()>0)
        {
            memberClassRegistrationDatabase.insertRecord(new MemberClassRegistration(memberID,classID,"active"));
            addedClass.decrementSeats();
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
            issueRefund(memberID);
        }
        registration.setRegestrationStatus("cancelled");
        Class c_class = (Class) classdatabase.getRecord(classID);
        c_class.incrementSeats();
        memberClassRegistrationDatabase.deleteRecord(classID);
        return true;
    }

    void issueRefund(String MemberID)
    {
        System.out.println("Refund issued to member: "+MemberID);
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations()
    {
        return memberClassRegistrationDatabase.returnAllRecords();
    }

    void logout()
    {
        memberClassRegistrationDatabase.saveToFile();
        classdatabase.saveToFile();
        memberdatabase.saveToFile();
    }
}
