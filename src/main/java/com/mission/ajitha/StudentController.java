package com.mission.ajitha;


import com.mission.ajitha.model.Course;
import com.mission.ajitha.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {
    @Autowired
    StudentService ss;
    List<Student> studentList=new ArrayList<>();
    @RequestMapping(value="stu-all")
    public List<Student> getStudentList()
    {
        // List<Student> studentList=prepareData();
        List<Student> studentList=ss.prepareData();

        return studentList;
    }
    @RequestMapping(value = "stu", method=RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody Student stu){
        Map<String, String> map = new HashMap<>();
        if(ss.addStudent(stu)) {

            map.put("message", "Student added succesfully");
            ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.CREATED);
            return responseEntity;
        }
        else
        {

            map.put("message", "Student already exist");
            ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.ALREADY_REPORTED);
            return responseEntity;

        }
    }

    @RequestMapping(value="stuedit",method =RequestMethod.PUT)
    public ResponseEntity updateStudentList(@RequestBody  Student stu)
    {
        Map<String,String> map=new HashMap<>();
        if (ss.updateStudent(stu))
        {
            map.put("message","Student updated");
            ResponseEntity rs=new ResponseEntity(map,HttpStatus.OK);
            return rs;
        }
        else
        {

            map.put("message","Student not found");
            ResponseEntity rs=new ResponseEntity(map,HttpStatus.NOT_FOUND);
            return rs;
        }

    }

    @RequestMapping(value="stu-{id}")
    public ResponseEntity getStudent(@PathVariable("id")Integer i)
    {



        List<Student> studentList=ss.prepareData();
        for (Student s:studentList)
            if(s.getId() == i) {
                ResponseEntity rs = new ResponseEntity(s, HttpStatus.OK);
                return rs;
            }
        Map<String,String> map=new HashMap<>();
        map.put("message","Student not found");
        ResponseEntity rs=new ResponseEntity(map,HttpStatus.NOT_FOUND);
        return rs;
    }
    private List<Student> prepareData()
    {
        if(studentList.isEmpty())
        {
            Student s1=new Student();
            s1.setId(1);
            s1.setName("Ajitha");
            Course c1=new Course();
            c1.setDepartment("ICT");
            c1.setYear(4);
            c1.setSemester(7);
            s1.setCourse(c1);

            Student s2=new Student();
            s2.setId(2);
            s2.setName("Abinaya");
            Course c2=new Course();
            c2.setDepartment("BCA");
            c2.setYear(1);
            c2.setSemester(2);
            s2.setCourse(c2);
            studentList.add(s1);
            studentList.add(s2);

        }
        return studentList;
    }

    private boolean addStudent (Student stu) {
        List<Student> studentList= prepareData();
        for (Student s:studentList) {
            if(s.getId()==stu.getId())
                return false;
        }

        studentList.add(stu);
        return true;
    }


    private boolean updateStudent (Student stu) {
        List<Student> studentList = prepareData();

        Iterator<Student> iterator =studentList.iterator();
        boolean removed = false;

        while(iterator.hasNext()) {
            Student s = iterator.next();
            if(s.getId() == stu.getId()) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if(removed) {
            studentList.add(stu);
        }
        return removed;
    }
}