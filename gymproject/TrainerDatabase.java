package gymproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainerDatabase extends DataBases {

    public TrainerDatabase(String filename) {
        super(filename);
    }

    public Users createRecordFrom(String Line) {
        return new Trainer(Line.split(", "));
    }
}
