/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author mukainong
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import business.Professor;
import business.Student;
import business.Course;
import data.ProfessorDB;
import data.StudentDB;
import java.util.List;

@WebServlet(urlPatterns={"/emailList"}) 
public class RegistrationServlet extends HttpServlet
{    
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        String url = "/index.jsp";
        
        String action = request.getParameter("action");
        String act = request.getParameter("act");
        
//        if (action == null) {
//            action = "join";
//        }
//        
//        if (action.equals("add")) {      
            if(act.equals("Register")) {
                url = "/registrationChoice.jsp";
            }
            
            if(act.equals("Next")) {
                String type = request.getParameter("type");
                if(type.equals("student")) {
                    url = "/registrationStudent.jsp";
                }

                if(type.equals("professor")) {
                    url = "/registrationProfessor.jsp";
                }
            }
            
            if(act.equals("FinishStudent")) {
                // get parameters from the request
                String id = request.getParameter("id");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String status = request.getParameter("status");

                // use regular Java classes
                Student user = new Student(id,password, name, status);

                // validate the parameters
                String message;
                if (StudentDB.emailExists(user.getID())) {
                    message = "This email address already exists.<br>" +
                              "Please enter another email address.";
                    url = "/index.jsp";
                }
                else {
                    message = "";
                    url = "/thanks.jsp";
                    StudentDB.insert(user);
                }

                // store the User object in request and set URL
                request.setAttribute("user", user);
                request.setAttribute("message", message);
            }
            
            if(act.equals("FinishProfessor")) {
                // get parameters from the request
                String id = request.getParameter("id");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String status = request.getParameter("status");

                // use regular Java classes
                Professor user = new Professor(id,password, name, status);

                // validate the parameters
                String message;
                if (ProfessorDB.emailExists(user.getID())) {
                    message = "This email address already exists.<br>" +
                              "Please enter another email address.";
                    url = "/index.jsp";
                }
                else {
                    message = "";
                    url = "/thanks.jsp";
                    ProfessorDB.insert(user);
                }

                // store the User object in request and set URL
                request.setAttribute("user", user);
                request.setAttribute("message", message);
            }
            
            if(act.equals("Login")) {
                // get parameters from the request
                String id = request.getParameter("id");
                String password = request.getParameter("password");

                // use regular Java classes
                Professor professor = new Professor(id,password, "na", "na");
                List<Course> courseList = null;
                
                List<Object> objectList = null;
                
                // validate the parameters
                String message;
                if (ProfessorDB.emailPasswordExists(professor.getID(), professor.getPassword())) {
                    courseList = ProfessorDB.getCourseList(professor.getID());
                    message = "";
                    url = "/professorInformation.jsp";
                }
                else if(ProfessorDB.emailPasswordExists2(id, password)) {
                    objectList = ProfessorDB.getStudentCourses(id);
                    message = "";
                    url = "/studentInformation.jsp";
                }
                else {
                    message = "Invalid login input";
                    url = "/index.jsp";
                }

                // store the User object in request and set URL
                request.setAttribute("professor", professor);
                request.setAttribute("courseList", courseList);
                request.setAttribute("objectList", objectList);
                request.setAttribute("message", message);
            }
            
            if(act.equals("View and Set Transcript")) {
                // get parameters from the request
                String crscode = request.getParameter("crscode");

                // use regular Java classes
                List<Object> objectList= ProfessorDB.getCourseTranscript(crscode);
                
                url = "/professorCourseDetails.jsp";

                // store the User object in request and set URL
                request.setAttribute("objectList", objectList);
            }
            
            if(act.equals("Search Course")) {
                url = "/searchCourses.jsp";
            }
            
            if(act.equals("submit")) {
                // get parameters from the request
                String crsCode = request.getParameter("crsCode");

                // use regular Java classes
                List<Course> courseList= ProfessorDB.searchCourse(crsCode);
                
                url = "/searchResults.jsp";

                // store the User object in request and set URL
                request.setAttribute("courseList", courseList);
            }
            
            if(act.equals("Logout")) {
                url = "/index.jsp";
            }
//        }
//        else if (action.equals("join")) {
//            // set URL to index page
//            url = "/index.jsp";            
//        }
        
        // forward request and response objects
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }    
}
