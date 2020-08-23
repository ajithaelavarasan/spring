package com.mission.ajitha;

import com.mission.ajitha.model.Course;
import com.mission.ajitha.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {


    List<Student> studentList = new ArrayList<>();

    public List<Student> prepareData() {

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

    public boolean addStudent(Student student) {List<Student> studentList= prepareData();
        for (Student s:studentList) {
            if(s.getId()== student.getId())
                return false;
        }

        studentList.add(student);
        return true;
    }

    public boolean updateStudent(Student tobeUpdatedStudent) {
        List<Student> studentList = prepareData();

        Iterator<Student> iterator = studentList.iterator();
        boolean removed = false;

        while(iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getId() == tobeUpdatedStudent.getId()) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if(removed) {
            studentList.add(tobeUpdatedStudent);
        }
        return removed;
    }
}

