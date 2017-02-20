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
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String CrsCode;
    private String DeptID;
    private String CrsName;
    private String InsNo;

    public Course() {
        CrsCode = "";
        DeptID = "";
        CrsName = "";
        InsNo = "";
    }

    public Course(String CrsCode, String DeptID, String CrsName, String InsNo) {
        this.CrsCode = CrsCode;
        this.DeptID = DeptID;
        this.CrsName = CrsName;
        this.InsNo = InsNo;
    }
    
    public String getCrsCode() {
        return CrsCode;
    }

    public void setCrsCode(String CrsCode) {
        this.CrsCode = CrsCode;
    }
    
    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String DeptID) {
        this.DeptID = DeptID;
    }
    
    public String getCrsName() {
        return CrsName;
    }

    public void setCrsName(String CrsName) {
        this.CrsName = CrsName;
    }
    
    public String getInsNo() {
        return InsNo;
    }

    public void setStatus(String InsNo) {
        this.InsNo = InsNo;
    }
}
