package com.sms.secondhomework.controller;


import com.sms.secondhomework.model.VisitingResearcher;
import com.sms.secondhomework.model.PermanentInstructor;
import com.sms.secondhomework.service.PermanentInstructorService;
import com.sms.secondhomework.service.VisitingResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    PermanentInstructorService permanentInstructorService;
    VisitingResearcherService visitingResearcherService;
// coded individually for all types of instructors
    @Autowired
    public InstructorController(PermanentInstructorService permanentInstructorService, VisitingResearcherService visitingResearcherService) {
        this.permanentInstructorService = permanentInstructorService;
        this.visitingResearcherService = visitingResearcherService;
    }
//permenants  instructor methods
    @GetMapping("/permanent")
    public ResponseEntity<List<PermanentInstructor>> findPermanentInstructors(){
        return new ResponseEntity<>(permanentInstructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/permanent/{id}")
    public ResponseEntity<PermanentInstructor> findPermanentInstructorById(@PathVariable int id){
        return new ResponseEntity<>(permanentInstructorService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/permanent")
    public ResponseEntity<PermanentInstructor> savePermanentInstructor(@RequestBody PermanentInstructor permenantInstructor){
        return new ResponseEntity<>(permanentInstructorService.save(permenantInstructor),HttpStatus.CREATED);
    }

    @PutMapping("/permanent")
    public ResponseEntity<PermanentInstructor> updatePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        return new ResponseEntity<>(permanentInstructorService.update(permanentInstructor),HttpStatus.OK);
    }

    @DeleteMapping("/permanent/{id}")
    public ResponseEntity<String> deletePermanentInstructorById(@PathVariable int id){
        permanentInstructorService.deletebyId(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @DeleteMapping("/permanent")
    public ResponseEntity<String> deletePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        permanentInstructorService.delete(permanentInstructor);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
//# Permenant Instructor
    //visiting researcher methods
    @GetMapping("/visiting")
    public ResponseEntity<List<VisitingResearcher>> findVisitingResearchers(){
        return new ResponseEntity<>(visitingResearcherService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/visiting/{id}")
    public ResponseEntity<VisitingResearcher> findVisitingResearcherById(@PathVariable int id){
        return new ResponseEntity<>(visitingResearcherService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/visiting")
    public ResponseEntity<VisitingResearcher> saveVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        return new ResponseEntity<>(visitingResearcherService.save(visitingResearcher),HttpStatus.CREATED);
    }

    @PutMapping("/visiting")
    public ResponseEntity<VisitingResearcher> updateVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        return new ResponseEntity<>(visitingResearcherService.update(visitingResearcher),HttpStatus.OK);
    }

    @DeleteMapping("/visiting/{id}")
    public ResponseEntity<String> deleteVisitingResearcherById(@PathVariable int id){
        visitingResearcherService.deletebyId(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @DeleteMapping("/visiting")
    public ResponseEntity<String> deleteVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        visitingResearcherService.delete(visitingResearcher);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

}
