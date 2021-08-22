package com.sms.secondhomework.dao;

import com.sms.secondhomework.model.Instructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOHibernateImpl implements BaseDAO<Instructor> {

    private EntityManager entityManager;

    public InstructorDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor object) {
        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(object);
    }

    @Override
    @Transactional
    public Instructor update(Instructor object) {
        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(object);
    }

    @Override
    @Transactional
    public void delete(Instructor object) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(object);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        Instructor instructor=findById(id);
        Session session = entityManager.unwrap(Session.class);
        session.remove(instructor);
    }
}
