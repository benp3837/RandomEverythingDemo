package com.revature.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments",
        uniqueConstraints = @UniqueConstraint(
            name = "unique_student_course",
            columnNames = {"student_id", "course_id"}))
public class Enrollment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "studentId", nullable = false,
                foreignKey = @ForeignKey(name = "student_id_fk"))
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "courseId", nullable = false,
                foreignKey = @ForeignKey(name = "course_id_fk"))
    private Course course;

    //This field just belongs to Enrollments
    private LocalDate enrolledAt = LocalDate.now();

    public Enrollment() {
    }

    public Enrollment(int enrollmentId, Student student, Course course, LocalDate enrolledAt) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrolledAt = enrolledAt;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDate enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}
