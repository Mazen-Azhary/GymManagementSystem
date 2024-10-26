package gymproject;

public class MemberClassRegistrationDatabase extends DataBases {
    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }

    public Users createRecordFrom(String Line) {
        return new MemberClassRegistraton(Line.split(", "));
    }

}
