package com.sms.secondhomework.service;

import com.sms.secondhomework.dao.PermanentInstructorDAO;
import com.sms.secondhomework.model.PermanentInstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermanentInstructorService implements BaseService<PermanentInstructor>{
    private PermanentInstructorDAO permanentInstructorDAO;

    public PermanentInstructorService(@Qualifier("permanentInstructorDAOHibernateImpl") PermanentInstructorDAO permanentInstructorDAO) {
        this.permanentInstructorDAO = permanentInstructorDAO;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        return permanentInstructorDAO.findAll();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return (PermanentInstructor) permanentInstructorDAO.findById(id);
    }

    @Override
    public PermanentInstructor save(PermanentInstructor object) {
        return (PermanentInstructor) permanentInstructorDAO.save(object);
    }

    @Override
    public PermanentInstructor update(PermanentInstructor object) {
        return (PermanentInstructor) permanentInstructorDAO.update(object);
    }

    @Override
    public void delete(PermanentInstructor object) {
        permanentInstructorDAO.delete(object);
    }

    @Override
    public void deletebyId(int id) {
        permanentInstructorDAO.deletebyId(id);
    }
}
