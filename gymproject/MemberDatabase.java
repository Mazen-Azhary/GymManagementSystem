package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDatabase {

    
    public void readFromFile() {
        File myFile = new File(this.filename);

        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                this.records.add(createRecordFrom(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public Trainer createRecordFrom(String Line) {
        return null;
    }

    public ArrayList<Trainer> returnAllRecords() {
        return null;
    }

    public boolean contains(String key) {
        return false;
    }

    public Trainer getRecord(String key) {
        return null;
    }

    public void insertRecord(Trainer Record) {

    }

    public void deleteRecord(String Key) {

    }

    public void saveToFile() {

    }
}
