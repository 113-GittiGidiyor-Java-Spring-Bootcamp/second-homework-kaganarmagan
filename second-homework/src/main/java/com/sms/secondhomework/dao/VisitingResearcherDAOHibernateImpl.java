package com.sms.secondhomework.dao;

import com.sms.secondhomework.model.PermanentInstructor;
import com.sms.secondhomework.model.VisitingResearcher;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VisitingResearcherDAOHibernateImpl implements VisitingResearcherDAO<VisitingResearcher> {
    private EntityManager entityManager;

    public VisitingResearcherDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from VisitingResearcher", VisitingResearcher.class).getResultList();

    }

    @Override
    public VisitingResearcher findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.find(VisitingResearcher.class,id);
    }

    @Override
    @Transactional
    public VisitingResearcher save(VisitingResearcher object) {
        Session session = entityManager.unwrap(Session.class);
        return (VisitingResearcher) session.merge(object);
    }

    @Override
    @Transactional
    public VisitingResearcher update(VisitingResearcher object) {
        Session session = entityManager.unwrap(Session.class);
        return (VisitingResearcher) session.merge(object);
    }

    @Override
    @Transactional
    public void delete(VisitingResearcher object) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(object);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        VisitingResearcher visitingResearcher=findById(id);
        Session session = entityManager.unwrap(Session.class);
        session.remove(visitingResearcher);
    }
}
