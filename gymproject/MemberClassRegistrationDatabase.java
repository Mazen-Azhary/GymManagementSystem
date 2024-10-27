package gymproject;

public class MemberClassRegistrationDatabase extends DataBases {
    public MemberClassRegistrationDatabase() {
        super("C:\\Users\\Etijah\\Documents\\NetBeansProjects\\GymProject\\src\\gymproject\\Registration.txt");
    }

    public Users createRecordFrom(String Line) {
        return new MemberClassRegistration(Line.split(", "));
    }

}
