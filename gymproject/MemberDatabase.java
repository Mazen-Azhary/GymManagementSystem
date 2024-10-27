package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDatabase extends DataBases {

    public MemberDatabase() {
        super("C:\\Users\\Etijah\\Documents\\NetBeansProjects\\GymProject\\src\\gymproject\\Members.txt");
    }
    public Users createRecordFrom(String Line) {
        return new Member(Line.split(", "));
    }
}
