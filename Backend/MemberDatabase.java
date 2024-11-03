package Backend;
public class MemberDatabase extends DataBases {

    public MemberDatabase() {
        super("src/Backend/Members.txt");
    }
    public Users createRecordFrom(String Line) {
        return new Member(Line.split(", "));
    }
}
