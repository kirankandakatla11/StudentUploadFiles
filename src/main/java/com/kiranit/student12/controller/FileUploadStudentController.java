package com.kiranit.student12.controller;

import com.kiranit.student12.domain.Student;
import com.kiranit.student12.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api")
public class FileUploadStudentController {

   @Autowired
   UploadService uploadService;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try{
            String fileName = uploadService.uploadFile(file);
        }catch (Exception e){
            return "Fail to upload, please try again";
        }
        return "Successfully uploaded";
    }
@PostMapping("/fileUpload")
    public String fileUpload(@RequestParam ("file") MultipartFile file) throws IOException
    {
        uploadService.fileUpload(file);
        return "successfully upload";
    }

    @GetMapping("/getAll")
    public List<Student> getStudents()
    {
        List<Student> studentList=uploadService.getStudents();
        return studentList;
    }

}
