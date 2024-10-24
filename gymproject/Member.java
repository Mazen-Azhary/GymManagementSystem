/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproject;


public class Member {
String memberId;
String name;
String membershipType;
String email;
String phoneNumber;
String Status;

    public Member(String memberId, String name, String membershipType, String email, String phoneNumber, String Status) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Status = Status;
    }
    
    public Member(String[] SplittedData){
        this.memberId = SplittedData[0];
        this.name = SplittedData[1];
        this.membershipType = SplittedData[2];
        this.email = SplittedData[3];
        this.phoneNumber = SplittedData[4];
        this.Status = SplittedData[5];      
    }
    
    public String getSearchKey(){
    return this.memberId;
    }

    public String toString() {
     return memberId + ", " + name + ", " + membershipType + ", " + email + ", " + phoneNumber +", "+Status;
}
    
    public String LineRepresentation(){
        return this.toString();
    }


    
}
