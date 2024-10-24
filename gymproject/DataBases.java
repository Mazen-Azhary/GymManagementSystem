package gymproject;
import java.util.*;

public interface DataBases {
    String filename = "";
    ArrayList<Trainer> records = new ArrayList<>();
    void readFromFile();
    Trainer createRecordFrom(String Line);
    ArrayList<Trainer> returnAllRecords();
    boolean contains(String key);
    Trainer getRecord(String key);
    void insertRecord(Trainer Record);
    void deleteRecord(String Key);
    void saveToFile();
}
