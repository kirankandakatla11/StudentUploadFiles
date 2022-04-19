package com.kiranit.student12.service;

import com.kiranit.student12.dao.StudentDao;
import com.kiranit.student12.domain.Student;
import com.kiranit.student12.entity.StudentEntity;
import com.kiranit.student12.entity.UploadEntity;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {
    @Autowired
    StudentDao studentDao;
    public String uploadFile(MultipartFile file)  {

        try {
            Path fileStorageLocation = Paths.get("tmp").toAbsolutePath().normalize();
            Files.createDirectories(fileStorageLocation);
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            if (fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;


        }catch (IOException e){

        }catch (Exception e){

        }



        return "";
    }

public String fileUpload(MultipartFile file)throws  IOException{
        InputStream inputStream=file.getInputStream();
        String output=Streams.asString(inputStream);
        String[] inputList=output.split(System.lineSeparator());
        for(String line:inputList){
            StudentEntity studentEntity=new StudentEntity();
            studentEntity.setId(line.substring(0,9).trim());
            studentEntity.setFirstName(line.substring(10,24).trim());
            studentEntity.setLastName(line.substring(25,34).trim());
            studentEntity.setBranch(line.substring(35,44).trim());
            studentEntity.setMarks(line.substring(45,48).trim());
            studentDao.fileUpload(studentEntity);

        }
        return "successfile";
}
public List<Student> getStudents()
{
List<Student> studentList=new ArrayList<>();
List<StudentEntity> studentEntities=studentDao.getStudents();
for(StudentEntity studentEntity:studentEntities)
{
    Student student=new Student();
    student.setId(studentEntity.getId());
    student.setFirstName(studentEntity.getFirstName());
    student.setLastName(studentEntity.getLastName());
    student.setBranch(studentEntity.getBranch());
    student.setMarks(studentEntity.getMarks());
    studentList.add(student);
}
return studentList;
}
}
