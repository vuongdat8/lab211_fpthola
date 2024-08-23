/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Report;
import Model.Students;
import Utity.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Anh Dat
 */
public class Manage {
    
    ArrayList<Students> studentList = new ArrayList<>();
    ArrayList<Report> reportList = new ArrayList<>();
    Utility util = new Utility();



    public void inputStudents() {
        if (studentList.size() >= 10) {
            if (!checkYesNo()) {
                return;
            }
        }

        String name;
        String id = getIdInput();

        Students studentInList = getStudentById(id);
        //if student == null => input name
        //else display name of that student
        if (studentInList == null) {
            name = getNameInput();
        } else {
            name = studentInList.getName();
            System.out.print("Enter name: " + studentInList.getName() + "\n");
        }

        int semester = getSemesterInput();
        int course = getCourseInput();

        //check duplicate
        if (checkDuplicate(id, name, semester, course)) {
            System.out.println("Duplicate student");

        } else {
            //create instance and add to list
            Students student = new Students(id, name, semester, course);
            studentList.add(student);
            System.out.println("Add successfull");
        }

    }

    public String getIdInput() {
        String id = util.getString("Enter Id: ", "Wrong", util.REGEX_CODE);
        return id;
    }

    public String getNameInput() {
        String name = util.getString("Enter Name: ", "Wrong", util.REGEX_NAME);
        return name;
    }

    public int getSemesterInput() {
        int semester = util.getInteger("Enter Semester: ", "Wrong", 1, Integer.MAX_VALUE);
        return semester;
    }

    public int getCourseInput() {
        int course = util.getInteger("Enter course:\n1. Java\n2. .Net\n3. C/C++\n ", "Wrong", 1, 3);
        return course;
    }

    private Students getStudentById(String id) {
        for (Students student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;

    }

    private boolean checkDuplicate(String id, String name, int semester, int course) {
        for (Students students : studentList) {
            if (students.getId().equalsIgnoreCase(id) && students.getName().equalsIgnoreCase(name)
                    && students.getSemester() == semester && students.getCourse() == course) {

                return true;
            }

        }
        return false;
    }

    private boolean checkYesNo() {
        String result = util.getString("Do you want to continue (Y/N): ", "Wrong", util.REGEX_YesNo);

        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

   public void findAndSort() {
        String name = getNameInput();

        ArrayList<Students> listFound = getStudentByName(name);

        //check listFound isEmpty hay k
        if (listFound.isEmpty()) {
            System.out.println("NOT FOUND");

        } else {
            Collections.sort(listFound, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                // So sánh dựa trên diện tích (area)
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

            System.out.printf("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Semester", "Course");
            for (Students students : listFound) {
                System.out.println(students);
            }
        }

    }

    private ArrayList<Students> getStudentByName(String name) {
        name = name.toUpperCase();
        ArrayList<Students> listFound = new ArrayList<>();
        for (Students students : studentList) {
            if (students.getName().toUpperCase().contains(name)) {
                listFound.add(students);
            }
        }
        return listFound;
    }

   public void updateDelete() {
        String id = getIdInput();
        ArrayList<Students> listFound = getStudentsById(id);
        if (listFound.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            if (checkUpdateOrDelete()) {
                update(listFound);

            } else {
                delete(listFound);
            }
        }

    }

    private ArrayList<Students> getStudentsById(String id) {
        ArrayList<Students> listFound = new ArrayList<>();
        for (Students students : studentList) {
            if (students.getId().equalsIgnoreCase(id)) {
                listFound.add(students);
            }
        }
        return listFound;
    }

    private boolean checkUpdateOrDelete() {
        String result = util.getString("Do you want to update or delete (U/D): ", "Wrong", util.REGEX_Update);

        if (result.equalsIgnoreCase("u")) {
            return true;
        } else {
            return false;
        }
    }

    private void update(ArrayList<Students> listFound) {
        displayListFoundById(listFound);
        int chocie = util.getInteger("Enter no: ", "Wrong", 1, listFound.size());

        Students studentChoice = listFound.get(chocie - 1);

        String idUpdate = studentChoice.getId();
        String nameUpdate = studentChoice.getName();
        int semesterUpdate = studentChoice.getSemester();
        int courseUpdate = studentChoice.getCourse();

        //update
        if (checkUpdate("Id")) {
            idUpdate = getIdInput();
        }

        if (checkUpdate("name")) {
            nameUpdate = getNameInput();
        }

        if (checkUpdate("semester")) {
            semesterUpdate = getSemesterInput();
        }

        if (checkUpdate("course")) {
            courseUpdate = getCourseInput();
        }

        //check not update
        if (checkNotUpdate(idUpdate, nameUpdate, semesterUpdate, courseUpdate, studentChoice)) {
            System.out.println("You not update");
        } else if (checkDuplicate(idUpdate, nameUpdate, semesterUpdate, courseUpdate)) {
            System.out.println("Duplicate");

        } else {
            studentChoice.setId(idUpdate);
            updateAllName(idUpdate, nameUpdate);
            studentChoice.setSemester(semesterUpdate);
            studentChoice.setCourse(courseUpdate);
            System.out.println("Update successfully");
        }
    }

    private void delete(ArrayList<Students> listFound) {
        displayListFoundById(listFound);
        int chocie = util.getInteger("Enter no: ", "Wrong", 1, listFound.size());

        Students studentChoice = listFound.get(chocie - 1);

        studentList.remove(studentChoice);
        System.out.println("Delete successfully");

    }

    private void displayListFoundById(ArrayList<Students> listFound) {
        System.out.printf("%-10s %-10s %-15s %-10s %-10s\n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listFound.size(); i++) {
            System.out.printf("%-10s %s", i + 1, listFound.get(i));
        }
    }

    private boolean checkUpdate(String message) {
        String result = util.getString("Do you want to update " + message + "? (Y/N): ", "Wrong", util.REGEX_YesNo);
        if (result.equalsIgnoreCase("y")) {
            return true;

        }
        return false;
    }

    private boolean checkNotUpdate(String idUpdate, String nameUpdate, int semesterUpdate, int courseUpdate, Students studentChoice) {
        if (idUpdate.equalsIgnoreCase(studentChoice.getId())
                && nameUpdate.equalsIgnoreCase(studentChoice.getName())
                && semesterUpdate == studentChoice.getSemester()
                && courseUpdate == studentChoice.getCourse()) {
            return true;
        }
        return false;
    }

    private void updateAllName(String idUpdate, String nameUpdate) {
        for (Students students : studentList) {
            if (students.getId().equalsIgnoreCase(idUpdate)) {
                students.setName(nameUpdate);
            }
        }
    }

   public void report() {
        reportList.clear();;
        for (Students first : studentList) {
            if (!checkExistReport(first)) {
                int totalCourse = 0;
                for (Students second : studentList) {
                    if (first.getId().equalsIgnoreCase(second.getId())
                            && first.getCourse() == second.getCourse()) {
                        totalCourse++;
                    }

                }

                Report report = new Report(first.getId(), first.getName(), first.getCourse(), totalCourse);
                reportList.add(report);
            }

        }
        System.out.printf("%-15s %-10s %-10s\n", "Name", "Course", "Total Course");
        for (Report report : reportList) {
            System.out.println(report);
        }

    }

    private boolean checkExistReport(Students first) {
        for (Report report : reportList) {
            if (report.getId().equalsIgnoreCase(first.getId())
                    && report.getCourse() == first.getCourse()) {
                return true;
            }
        }
        return false;
    }
    
        void mockData() {
        studentList.add(new Students("1", "Nguyen E", 1, 1));
        studentList.add(new Students("1", "Nguyen A", 2, 1));
        studentList.add(new Students("2", "Nguyen B", 1, 1));
        studentList.add(new Students("3", "Nguyen C", 1, 1));
        studentList.add(new Students("4", "Nguyen D", 1, 1));
    }
}
