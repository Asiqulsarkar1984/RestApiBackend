package springBoot.Crud.Operstions.restApi.entity;

import jakarta.persistence.*;
import lombok.Generated;

@Entity
@Table(name = "student")

public class Student {

    private int student_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollN0;




    @Column(name = "student_name")
    private String name;
    @Column(name = "student_percentage")
    private float percentage;
    @Column(name = "student_branch")
    private String branch;

public Student(){

}

    public Student(float percentage, String name, String branch) {
        this.percentage = percentage;

        this.name = name;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "student{" +
                "student_id=" + student_id +
                ", rollN0=" + rollN0 +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                ", branch='" + branch + '\'' +
                '}';
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getRollN0() {
        return rollN0;
    }

    public void setRollN0(int rollN0) {
        this.rollN0 = rollN0;
    }
}


