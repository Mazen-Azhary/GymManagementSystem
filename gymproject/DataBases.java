package gymproject;
import java.util.*;

public interface DataBases {
    void readFromFile();
    Trainer createRecordFrom(String Line);
    ArrayList<Trainer> returnAllRecords();
    boolean contains(String key);
    Trainer getRecord(String key);
    void insertRecord(Trainer Record);
    void deleteRecord(String Key);
    void saveToFile();
}
