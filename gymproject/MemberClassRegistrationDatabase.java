package gymproject;

public class MemberClassRegistrationDatabase extends DataBases {
    public MemberClassRegistrationDatabase(String filename) {
        this.filename = filename;
        this.readFromFile();
    }

    public MemberClassRegistraton createRecordFrom(String Line) {
        return new MemberClassRegistraton(Line.split(", "));
    }

    public MemberClassRegistraton getRecord(String Key) {
        for (MemberClassRegistraton current : this.records) {
            if (current.getSearchKey() == Key) {
                return current;
            }
        }
        System.out.println("record with key not found");
        return null;
    }
}
