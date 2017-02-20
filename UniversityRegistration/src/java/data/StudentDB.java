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

import business.Student;
import java.util.List;

/**
 *
 * @author mukainong
 */
public class StudentDB {

    public static void insert(Student user) {
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

    public static void update(Student user) {
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

    public static void delete(Student user) {
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

    public static Student selectUser(String id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Student u " +
                "WHERE u.id = :id";
        TypedQuery<Student> q = em.createQuery(qString, Student.class);
        q.setParameter("id", id);
        try {
            Student user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        Student u = selectUser(email);   
        return u != null;
    }
    
    public static Student validateUser(String id, String pswd) {
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
    
    public static boolean emailPasswordExists(String id, String password) {
        Student u = validateUser(id,password);   
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
}
