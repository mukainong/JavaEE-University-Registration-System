/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import business.Professor;
import business.Course;
import business.Student;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mukainong
 */
public class ProfessorDB {

    public static void insert(Professor user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        //try {
            em.persist(user);
            trans.commit();
        //} catch (Exception e) {
        //    System.out.println(e);
        //    trans.rollback();
        //} finally {
            em.close();
        //}
    }

    public static void update(Professor user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Professor user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static Professor selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.email = :email";
        TypedQuery<Professor> q = em.createQuery(qString, Professor.class);
        q.setParameter("email", email);
        try {
            Professor user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        Professor u = selectUser(email);   
        return u != null;
    }
    
    public static Professor validateUser(String id, String pswd) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Professor u " +
                "WHERE u.id = :id and u.pswd = :pswd";
        TypedQuery<Professor> q = em.createQuery(qString, Professor.class);
        q.setParameter("id", id);
        q.setParameter("pswd", pswd);
        try {
            Professor user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static boolean emailPasswordExists(String id, String password) {
        Professor u = validateUser(id,password);   
        return u != null;
    }
    
    public static List<Course> getCourseList(String id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Course c "+
                "WHERE c.InsNo = :id";
        TypedQuery<Course> q = em.createQuery(qString, Course.class);
        q.setParameter("id", id);
        try {
//            return q.getSingleResult();
            List<Course> list = q.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<Object> getCourseTranscript(String crscode) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select c.CrsCode As aa, c.CrsName As bb, s.id As cc, s.name As dd, t.Grade As ee from Course c,Student s,Transcript t "+
                "where c.CrsCode = t.CrsCode and s.id = t.StudId and t.CrsCode = :crscode";
        TypedQuery<Object> q = em.createQuery(qString, Object.class);
        q.setParameter("crscode", crscode);
        try {
//            Query query = em.createNativeQuery("select Course.CrsCode As a, Course.CrsName As b, Student.Id As c, Student.Name As d, Transcript.Grade As e from Course,Student,Transcript where Course.CrsCode=Transcript.CrsCode and Student.Id = Transcript.StudId and Transcript.CrsCode='"+crscode+"'");
//            return query.getResultList();
//            return query.getSingleResult();
            List<Object> list = q.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<Course> searchCourse(String crscode, String crsname, String deptId, String name) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "";
        
        if(!crscode.equals(""))
        {
            if(!crsname.equals(""))
            {
                if(!deptId.equals(""))
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                    "WHERE c.CrsCode = '" + crscode + "' " +
                                    "AND c.DeptID = '" + deptId + "' " +
                                    "AND c.CrsName = '" + crsname + "' " +
                                    "AND c.InsNo = '" + name + "' ");
                    }
                    else
                    {
                        qString = ("select c from Course c " +
                                    "WHERE c.CrsCode = '" + crscode + "' " +
                                    "AND c.DeptID = '" + deptId + "' " +
                                    "AND c.CrsName = '" + crsname + "' ");
                    }
                }
                else
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                    "WHERE c.CrsCode = '" + crscode + "' " +
                                    "AND c.CrsName = '" + crsname + "' " +
                                    "AND c.InsNo = '" + name + "' ");
                    }
                    else 
                    {
                        qString = ("select c from Course c " +
                                    "WHERE c.CrsCode = '" + crscode + "' " +
                                    "AND c.CrsName = '" + crsname + "' ");
                    }
                }
            }
            else // CrsName is null
            {
                if(!deptId.equals(""))
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.CrsCode = '" + crscode + "' " +
                                        "AND c.DeptID = '" + deptId + "' " +
                                        "AND c.InsNo = '" + name + "' ");
                    }
                    else 
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.CrsCode = '" + crscode + "' " +
                                        "AND c.DeptID = '" + deptId + "' ");
                    }
                }
                else
                {   
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.CrsCode =  '" + crscode + "' " +
                                        "AND c.InsNo = '" + name + "' ");
                    }
                    else
                    {
                     qString = ("select c from Course c " +
                                        "WHERE c.CrsCode =  '" + crscode + "' ");   
                    }
                }
            }
        }
        else  // CrsCode is null
        {
            if(!crsname.equals(""))
            {
                if(!deptId.equals(""))
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.DeptID = '" + deptId + "' " +
                                        "AND c.CrsName = '" + crsname + "' " +
                                        "AND c.InsNo = '" + name + "' ");
                    }
                    else
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.DeptID = '" + deptId + "' " +
                                        "AND c.CrsName = '" + crsname + "' ");
                    }
                }
                else
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.CrsName = '" + crsname + "' " +
                                        "AND c.InsNo = '" + name + "' ");
                    }
                    else
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.CrsName = '" + crsname + "' ");
                    }
                }
            }
            else // CrsName is null
            {
                if(!deptId.equals(""))
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.DeptID = '" + deptId + "' " +
                                        "AND c.InsNo = '" + name + "' ");
                    }
                    else
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.DeptID = '" + deptId + "' ");
                    }
                }
                else
                {
                    if(!name.equals(""))
                    {
                        qString = ("select c from Course c " +
                                        "WHERE c.InsNo = '" + name + "' ");
                    }
                    else
                    {
                        qString = ("select c from Course c ");
                    }
                }
            }
        }
        
        TypedQuery<Course> q = em.createQuery(qString, Course.class);
        try {
            List<Course> list = q.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    /*
    THE FOLLOWING CODE IS BORROWED FROM StudentDB.java
    */
    public static Student validateUser2(String id, String pswd) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Student u " +
                "WHERE u.id = :id and u.pswd = :pswd";
        TypedQuery<Student> q = em.createQuery(qString, Student.class);
        q.setParameter("id", id);
        q.setParameter("pswd", pswd);
        try {
            Student user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static boolean emailPasswordExists2(String id, String password) {
        Student u = validateUser2(id,password);   
        return u != null;
    }
    
    public static List<Object> getStudentCourses(String stuId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "select c.CrsCode As aa, c.CrsName As bb, s.id As cc, s.name As dd, t.Grade As ee from Course c,Student s,Transcript t "+
//                "where c.CrsCode = t.CrsCode and s.id = t.StudId and t.CrsCode = :crscode";
        String qString = "select c.CrsCode, c.CrsName, c.DeptID, p.name, t.Grade from Course c, Professor p, Transcript t " +
                "where c.CrsCode = t.CrsCode and p.id = c.InsNo and t.StudId = :stuId";
        TypedQuery<Object> q = em.createQuery(qString, Object.class);
        q.setParameter("stuId", stuId);
        try {
            List<Object> list = q.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static void updateGrade(String score, String crscode, String stu) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        Transcript t= (Transcript)em.find(Transcript.class , 1);
//
//        String qString = "update Transcript t set t.Grade='"+score.trim()+"' where t.CrsCode='"+crscode.trim()+"' and t.StudId='"+stu.trim()+"'";
//        String qString = "update Transcript set Grade = 'B' where CrsCode = 101 and StudId = 'stud1'";
//        em.createNativeQuery(qString).executeUpdate();
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNativeQuery("update Transcript t set t.Grade='"+score.trim()+"' where t.CrsCode='"+crscode.trim()+"' and t.StudId='"+stu.trim()+"'").executeUpdate();
        et.commit();
        try {
            
        } catch (NoResultException e) {
            
        } finally {
            em.close();
        }
    }
    
    public static void selectCourse(String crscode, String id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNativeQuery("Insert into Transcript VALUES ('" + id + "','" + crscode + "','FALL2016','')").executeUpdate();
        et.commit();
        try {
            
        } catch (NoResultException e) {
            
        } finally {
            em.close();
        }
    }
    
    public static void deleteCourse(String crscode, String id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNativeQuery("delete from Transcript where CrsCode='"+crscode+"' and StudId='"+id+"'").executeUpdate();
        et.commit();
        try {
            
        } catch (NoResultException e) {
            
        } finally {
            em.close();
        }
    }
}