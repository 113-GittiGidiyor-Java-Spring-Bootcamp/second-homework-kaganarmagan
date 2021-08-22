package com.sms.secondhomework.service;

import com.sms.secondhomework.dao.CourseDAO;
import com.sms.secondhomework.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements BaseService<Course>{

    private CourseDAO courseDAO;

    public CourseService(@Qualifier("courseDAOHibernateImpl") CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    public Course save(Course object) {
        return (Course) courseDAO.save(object);
    }

    @Override
    public Course update(Course object) {
        return (Course) courseDAO.update(object);
    }

    @Override
    public void delete(Course object) {
        courseDAO.delete(object);
    }

    @Override
    public void deletebyId(int id) {
        courseDAO.deletebyId(id);
    }
}
