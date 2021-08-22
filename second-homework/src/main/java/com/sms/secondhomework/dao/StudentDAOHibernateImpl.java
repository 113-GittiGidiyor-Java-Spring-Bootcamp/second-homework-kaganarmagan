package com.sms.secondhomework.dao;

import com.sms.secondhomework.model.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO<Student>{
    private EntityManager entityManager;

    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.find(Student.class,id);
    }

    @Override
    @Transactional
    public Student save(Student object) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(object);

    }

    @Override
    @Transactional
    public Student update(Student object) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(object);
    }

    @Override
    @Transactional
    public void delete(Student object) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(object);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        Student student=findById(id);
        Session session = entityManager.unwrap(Session.class);
        session.remove(student);
    }
}
