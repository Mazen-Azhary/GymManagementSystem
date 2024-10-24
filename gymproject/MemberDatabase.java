package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDatabase implements DataBases {

    @Override
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

    @Override
    public Trainer createRecordFrom(String Line) {
        return null;
    }

    @Override
    public ArrayList<Trainer> returnAllRecords() {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Trainer getRecord(String key) {
        return null;
    }

    @Override
    public void insertRecord(Trainer Record) {

    }

    @Override
    public void deleteRecord(String Key) {

    }

    @Override
    public void saveToFile() {

    }
}
