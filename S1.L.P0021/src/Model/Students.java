/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anh Dat
 */
public class Students {

    private String id, name;
    private int semester, course;

    public Students(String id, String name, int semeser, int course) {
        this.id = id;
        this.name = name;
        this.semester = semeser;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semeser) {
        this.semester = semeser;
    }

    public int getCourse() {
        return course;
    }

    public String getCourseString() {
        String result = null;
        switch (course) {
            case 1:
                result = "Java";
                break;
            case 2:
                result = ".Net";
                break;
            case 3:
                result = "C/C++";
                break;

        }
        return result;

    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10s\n", id, name, semester, getCourseString());
    }

}
