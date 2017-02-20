/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mukainong
 */

@Entity
public class Transcript implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String StudId;
    private String CrsCode;
    private String Semester;
    private String Grade;

    public Transcript() {
        StudId = "";
        CrsCode = "";
        Semester = "";
        Grade = "";
    }

    public Transcript(String StudId, String CrsCode, String Semester, String Grade) {
        this.StudId = StudId;
        this.CrsCode = CrsCode;
        this.Semester = Semester;
        this.Grade = Grade;
    }
    
    public String getStudId() {
        return StudId;
    }

    public void setID(String StudId) {
        this.StudId = StudId;
    }
    
    public String getCrsCode() {
        return CrsCode;
    }

    public void setCrsCode(String CrsCode) {
        this.CrsCode = CrsCode;
    }
    
    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
    
    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
}
