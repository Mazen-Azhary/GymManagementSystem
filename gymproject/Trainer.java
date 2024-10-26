/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproject;


public class Trainer extends Users {
    private String TrainerId;
    private String Name;
    private String Speciality;
    private String Email;
    private String PhoneNumber;

    public Trainer(String TrainerId, String Name, String Speciality, String Email, String PhoneNumber) {
        this.TrainerId = TrainerId;
        this.Name = Name;
        this.Speciality = Speciality;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }
    
    public Trainer(String[] SplittedData){
    this.TrainerId=SplittedData[0];
    this.Name=SplittedData[1];
    this.Speciality=SplittedData[2];
    this.Email=SplittedData[3];
    this.PhoneNumber=SplittedData[4];
    
    }
    
    public String toString() {
     return TrainerId + ", " + Name + ", " + Speciality + ", " + Email + ", " + PhoneNumber;
}



    public String lineRepresentation() {
        return this.toString();
    }

    public String getSearchKey(){
    return this.TrainerId;
    }
    
}
