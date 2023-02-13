/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbclasstimelesson;
import com.example.DemoProjectSem04.interfaces.tbClassTimeLessonInterface;
import com.example.DemoProjectSem04.repositories.tbClassTimeLessonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbClassTimeLessonService implements tbClassTimeLessonInterface {

    @Autowired
    tbClassTimeLessonRepository repository;

    @Override
    public List<Tbclasstimelesson> getListClassTimeLesson() {
        return repository.getListClassTimeLessonIsLock();
    }

    @Override
    public Tbclasstimelesson getClassTimeLessonByCode(String id) {
        return repository.getClassTimeLessonById(id);
    }

}
