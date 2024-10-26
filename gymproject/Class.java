package gymproject;

public class Class implements Users {

    private String classId;
    private String ClassName;
    private String trainerId;
    private int duration;
    private int availableSeats;

    public Class(String classId, String ClassName, String trainerId, int duration, int availableSeats) {
        this.classId = classId;
        this.ClassName = ClassName;
        this.trainerId = trainerId;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public Class(String[] SplittedData) {
        this.classId = SplittedData[0];
        this.ClassName = SplittedData[1];
        this.trainerId = SplittedData[2];
        this.duration = Integer.parseInt(SplittedData[3]);
        this.availableSeats = Integer.parseInt(SplittedData[4]);
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public void incrementSeats()
    {
        availableSeats++;
    }
    public void decrementSeats()
    {
        availableSeats--;
    }
    public String getSearchKey(){
        return this.classId;
    }

    public String toString() {
        return classId + ", " + ClassName + ", " + trainerId + ", " + duration + ", " + availableSeats ;
    }
    
    public String LineRepresentation(){
        return this.toString();
    }


}
