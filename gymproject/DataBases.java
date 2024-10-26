package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBases<T extends Users> {
    protected String filename;
    protected ArrayList<T> records;

    public  void readFromFile(){
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

    public ArrayList<T> returnAllRecords(){
        return this.records;
    }

    public boolean contains(String Key){
        if (getRecord(Key) != null) {
            return true;
        }
        System.out.println("Not Found!");
        return false;
    }

    public void insertRecord(T Record){
        if (this.records.contains(Record.getSearchKey())) {
            System.out.println("Already Exists");
            return;
        }
        this.records.add(Record);
    }

    public void deleteRecord(String Key){
        if (this.contains(Key)) {
            this.records.remove(this.getRecord(Key));
            return;
        }
        System.out.println("Unable to delete, Key doesn't exist");
    }

    public void saveToFile(){
        try {
            FileWriter output = new FileWriter(this.filename);
            int i = 0;
            while (this.records.get(i) != null) {
                output.write(this.records.get(i).toString());
                i++;
            }
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
