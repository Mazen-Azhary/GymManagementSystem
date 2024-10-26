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

public class TrainerDatabase extends DataBases{

    public TrainerDatabase(String filename) {
        this.filename = filename;
        this.readFromFile();
    }

    public Trainer createRecordFrom(String Line) {
        return new Trainer(Line.split(", "));
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
}
