package gymproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TrainerRole {
    private MemberDatabase memberdatabase;
    private ClassDatabase classdatabase;
    private MemberClassRegistrationDatabase memberClassRegistrationDatabase;
    
    public void addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if(!memberdatabase.contains(memberID))
            memberdatabase.insertRecord(new Member(memberID,name,membershipType,email,phoneNumber,status));
        else 
            System.out.println("The Member is already registered!");
    }  

    public ArrayList<Member> getListOfMembers()
    {
        memberdatabase.returnAllRecords();
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
        if(classdatabase.getRecord(classID).getAvailableSeats>0)
        {
            memberClassRegistrationDatabase.insertRecord(new MemberClassRegistraton(memberID,classID,"active",LocalDate.now()));
            classdatabase.getRecord(classID).getAvailableSeats--;
            return true;
        }
        return false;
    }

    public boolean cancelRegistration (String memberID, String classID)
    {
        MemberClassRegistraton registraton = memberClassRegistrationDatabase.getRecord(memberID);
        if(registraton== null)
            return false;
        LocalDate registrationDate = registraton.getRegistrationDate();
        LocalDate current = LocalDate.now();

        long days = ChronoUnit.DAYS.between(registrationDate, current);
        if(days<3)
        {
            issueRefund(memberID);
        }
        registration.setRegestrationStatus("canceled");
        Class canceledClass = classdatabase.getRecord(classID);
        canceledClass.incrementSeats();
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
