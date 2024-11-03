package Backend;
import java.util.Objects;

public class MemberClassRegistrationDatabase extends DataBases {
    public MemberClassRegistrationDatabase() {
        super("src/Backend/Registration.txt");
    }

    public Users createRecordFrom(String Line) {
        return new MemberClassRegistration(Line.split(", "));
    }

}
