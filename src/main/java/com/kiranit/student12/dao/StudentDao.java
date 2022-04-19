package com.kiranit.student12.dao;

import com.kiranit.student12.domain.Student;
import com.kiranit.student12.entity.StudentEntity;
import com.kiranit.student12.entity.UploadEntity;
import com.kiranit.student12.repository.StudentRepository;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDao {
    @Autowired
    StudentRepository studentRepository;
    public String fileUpload(StudentEntity studentEntity)
    {
        studentRepository.save(studentEntity);
        return "successfull";
    }

    public List<StudentEntity> getStudents(){
        Iterable<StudentEntity> studentList=studentRepository.findAll();
        List<StudentEntity> studentEntities=new ArrayList<>();
        studentList.forEach(studentEntity -> studentEntities.add(studentEntity));
        return studentEntities;
    }
}

