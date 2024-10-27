package gymproject;

public class MemberDatabase extends DataBases {

    public MemberDatabase() {
        super("src/gymproject/Members.txt");
    }
    public Users createRecordFrom(String Line) {
        return new Member(Line.split(", "));
    }
}
