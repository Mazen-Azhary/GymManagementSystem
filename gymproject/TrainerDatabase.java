/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainerDatabase implements DataBases{

    private String filename;
    private ArrayList<Trainer> records = new ArrayList<>();

    public TrainerDatabase(String filename) {
        this.filename = filename;
        this.readFromFile();

    }

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
        return new Trainer(Line.split(", "));
    }

    public ArrayList<Trainer> returnAllRecords() {
        return this.records;
    }

    public boolean contains(String Key) {

        if (getRecord(Key) != null) {
            return true;
        }
        System.out.println("trainer with key not found");
        return false;
    }

    public Trainer getRecord(String Key) {

        for (Trainer current : this.records) {
            if (current.getSearchKey() == Key) {
                return current;
            }
        }
        System.out.println("record with key not found");
        return null;
    }

    public void insertRecord(Trainer Record) {
        if (this.records.contains(Record.getSearchKey())) {
            System.out.println("Trainer Already Exists");
            return;
        }
        this.records.add(Record);
    }

    public void deleteRecord(String Key) {
        if (this.contains(Key)) {
            this.records.remove(this.getRecord(Key));
            return;
        }
        System.out.println("Unable to delete Trainer,Key doesn't exist");
    }

    public void saveToFile() {

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
