/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproject;

import java.util.ArrayList;

/**
 *
 * @author Mazen
 */
public class ClassDatabase extends DataBases {

    public ClassDatabase(String filename) {
        this.filename = filename;
        this.readFromFile();
    }

    public Class createRecordFrom(String Line) {
        return new Class(Line.split(", "));
    }

    public Class getRecord(String Key) {
        for (Class current : this.records) {
            if (current.getSearchKey() == Key) {
                return current;
            }
        }
        System.out.println("record with key not found");
        return null;
    }
    
}
