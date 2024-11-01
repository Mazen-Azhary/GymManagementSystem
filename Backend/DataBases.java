package Backend;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class DataBases {
    protected String filename;
    protected ArrayList<Users> records=new ArrayList<>();

    public DataBases(String filename)
    {
        this.filename = filename;        
        readFromFile();
    }
    public Users getRecord(String Key) {
        for (Users current : this.records) {
            if (Objects.equals(current.getSearchKey(), Key)) {
                return current;
            }
        }
        return null;
    }
    public abstract Users createRecordFrom(String Line);
    
    
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

    public ArrayList<Users> returnAllRecords(){
        return records;
    }

    public boolean contains(String Key){
        if (getRecord(Key) != null) {
            return true;
        }
        return false;
    }

    public boolean insertRecord(Users Record){
        if(this.contains(Record.getSearchKey()))
            return false;
        this.records.add(Record);
        return true;
    }

    public boolean deleteRecord(String Key){
        if (this.records.contains(this.getRecord(Key))) {
            this.records.remove(this.getRecord(Key));
            return true;
        }
        return false;
    }

    public void saveToFile(){
        try {
            FileWriter output = new FileWriter(this.filename);
            for(int i=0;i<this.records.size();i++)
            {
                output.write(this.records.get(i).lineRepresentation()+"\n");
            }
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
