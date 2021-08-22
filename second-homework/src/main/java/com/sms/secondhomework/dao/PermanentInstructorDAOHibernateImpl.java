package com.sms.secondhomework.dao;

import com.sms.secondhomework.model.Course;
import com.sms.secondhomework.model.PermanentInstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PermanentInstructorDAOHibernateImpl implements PermanentInstructorDAO<PermanentInstructor>{
    private EntityManager entityManager;

    public PermanentInstructorDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from PermanentInstructor", PermanentInstructor.class).getResultList();

    }

    @Override
    public PermanentInstructor findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.find(PermanentInstructor.class,id);

    }

    @Override
    @Transactional
    public PermanentInstructor save(PermanentInstructor object) {
        Session session = entityManager.unwrap(Session.class);
        return (PermanentInstructor) session.merge(object);
    }

    @Override
    @Transactional
    public PermanentInstructor update(PermanentInstructor object) {
        Session session = entityManager.unwrap(Session.class);
        return (PermanentInstructor) session.merge(object);
    }

    @Override
    @Transactional
    public void delete(PermanentInstructor object) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(object);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        PermanentInstructor permanentInstructor=findById(id);
        Session session = entityManager.unwrap(Session.class);
        session.remove(permanentInstructor);
    }
}
