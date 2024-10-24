/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproject;

import java.util.ArrayList;

/**
 *
 * @author Etijah
 */
public class AdminRole {

    private TrainerDatabase database;

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber){
    this.database.insertRecord(new Trainer(trainerId, name, specialty, email, phoneNumber));
    };
    
    public ArrayList<Trainer> getListOfTrainers(){
    return this.database.returnAllRecords();
    }
    
    public void removeTrainer(String Key){
    this.database.deleteRecord(Key);
    }
    public void logout(){
    this.database.saveToFile();
    }
    
}
