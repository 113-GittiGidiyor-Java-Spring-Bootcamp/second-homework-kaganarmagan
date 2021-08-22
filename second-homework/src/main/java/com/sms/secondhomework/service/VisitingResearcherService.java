package com.sms.secondhomework.service;

import com.sms.secondhomework.dao.VisitingResearcherDAO;
import com.sms.secondhomework.model.VisitingResearcher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitingResearcherService implements BaseService<VisitingResearcher> {
    private VisitingResearcherDAO visitingResearcherDAO;

    public VisitingResearcherService(@Qualifier("visitingResearcherDAOHibernateImpl") VisitingResearcherDAO visitingResearcherDAO) {
        this.visitingResearcherDAO = visitingResearcherDAO;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return visitingResearcherDAO.findAll();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return (VisitingResearcher) visitingResearcherDAO.findById(id);
    }

    @Override
    public VisitingResearcher save(VisitingResearcher object) {
        return (VisitingResearcher) visitingResearcherDAO.save(object);
    }

    @Override
    public VisitingResearcher update(VisitingResearcher object) {
        return (VisitingResearcher) visitingResearcherDAO.update(object);
    }

    @Override
    public void delete(VisitingResearcher object) {
visitingResearcherDAO.delete(object);
    }

    @Override
    public void deletebyId(int id) {
visitingResearcherDAO.deletebyId(id);
    }
}
