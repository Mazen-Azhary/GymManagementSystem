/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproject;

import java.time.LocalDate;

public class MemberClassRegistration implements Users {
    String memberId;
    String classId;
    String status;
    LocalDate registrationDate;

    void setRegistrationStatus(String status) {
        this.status = status;
    }

    public MemberClassRegistration(String memberId, String classId, String status,LocalDate registrationDate) {
        this.memberId = memberId;
        this.classId = classId;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public MemberClassRegistration(String[] SplittedData) {
        this.memberId = SplittedData[0];
        this.classId = SplittedData[1];
        this.registrationDate = LocalDate.parse(SplittedData[2]);
        this.status = SplittedData[3];
    }

    public String getStatus() {
        return status;
    }
    
    public String getMemberId() {
        return memberId;
    }

    public String getClassId() {
        return classId;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public String lineRepresentation() {
        return this.toString();
    }

    public String getSearchKey() {
        return this.memberId + this.classId;
    }

    public String toString() {
        return memberId + ", " + classId + ", " + registrationDate.toString() + ", " + status;
    }

}
