package com.sms.secondhomework.dao;

import com.sms.secondhomework.model.Course;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernateImpl implements  CourseDAO<Course>{

    EntityManager entityManager;

    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.find(Course.class,id);

    }

    @Override
    @Transactional
    public Course save(Course object) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(object);
    }

    @Override
    @Transactional
    public Course update(Course object) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(object);
    }

    @Override
    @Transactional
    public void delete(Course object) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(object);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        Course course=findById(id);
        Session session = entityManager.unwrap(Session.class);
        session.remove(course);
    }
}
