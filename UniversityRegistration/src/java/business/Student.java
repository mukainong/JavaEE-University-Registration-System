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
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String pswd;
    private String name;
    private String status;

    public Student() {
        id = "";
        pswd = "";
        name = "";
        status = "";
    }

    public Student(String id, String password, String name, String status) {
        this.id = id;
        this.pswd = password;
        this.name = name;
        this.status = status;
    }
    
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return pswd;
    }

    public void setPassword(String password) {
        this.pswd = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}