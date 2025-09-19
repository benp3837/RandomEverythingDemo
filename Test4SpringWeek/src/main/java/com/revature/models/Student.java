package com.revature.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String studentName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();

    //These methods will help keep Courses and Students synced up
    //TODO: enroll
//    public Enrollment enrollIn(Course course, Student student){
//        Enrollment e = new Enrollment(); //TODO------------
//
//        course.getEnrollments().add(e);
//    }

    //TODO: drop


    //boilerplate-------------
    public Student() {
    }

    public Student(int studentId, String name, Set<Enrollment> enrollments) {
        this.studentId = studentId;
        this.studentName = name;
        this.enrollments = enrollments;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
