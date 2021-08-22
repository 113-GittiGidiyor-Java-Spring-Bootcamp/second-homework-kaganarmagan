package com.sms.secondhomework.service;

import com.sms.secondhomework.dao.StudentDAO;
import com.sms.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements BaseService<Student>{
    private StudentDAO studentDAO;

    public StudentService(@Qualifier("studentDAOHibernateImpl") StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return (Student) studentDAO.findById(id);
    }

    @Override
    public Student save(Student object) {
        return (Student) studentDAO.save(object);
    }

    @Override
    public Student update(Student object) {
        return (Student) studentDAO.update(object);
    }

    @Override
    public void delete(Student object) {
        studentDAO.delete(object);
    }

    @Override
    public void deletebyId(int id) {
        studentDAO.deletebyId(id);
    }
}
