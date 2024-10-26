package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDatabase extends DataBases {

    public MemberDatabase(String filename) {
        this.filename = filename;
        this.readFromFile();
    }

    public Member createRecordFrom(String Line) {
        return new Member(Line.split(", "));
    }

    public Member getRecord(String Key) {
        for (Member current : this.records) {
            if (current.getSearchKey() == Key) {
                return current;
            }
        }
        System.out.println("record with key not found");
        return null;
    }
}
