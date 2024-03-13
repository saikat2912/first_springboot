package com.example.setupproj.services;

import com.example.setupproj.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TaskService {

    private ArrayList<TaskEntity> tasks= new ArrayList<>();

    void addTask(String title,String description,String deadline){
        
    }

}
