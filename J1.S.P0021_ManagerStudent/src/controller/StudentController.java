/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Student;
import model.StudentModel;
import view.StudentView;

/**
 *
 * @author win
 */
public class StudentController {

    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
        generateStudent();
    }

    public void run() {
        view.addItem("Create");
        view.addItem("Find and Sort");
        view.addItem("Update/Delete");
        view.addItem("Report");
        view.addItem("Exit");
        while (true) {
            view.showMenu();
            int choice = view.getChoice(5);
            switch (choice) {
                case 1:
                    handleAddStudent();
                    break;
                case 2:
                    handlefindAndSort();
                    break;
                case 3:
                    handleUpdateOrDelete();
                    break;
                case 4:
                    handleReport();
                    break;
                default:
                    System.exit(0); // thoát
            }
        }
    }

    public void handleAddStudent() {
        do {
            String ID = view.getId();
            ArrayList<Student> list = model.getListStudentById(ID);
            String name;

            if (list.isEmpty()) {
                name = view.getStudentName();
            } else {
                name = list.get(0).getStudentName();
                view.setMess("Name Student: " + name);
                view.displayMessages();
            }

            String semester = view.getSemester();
            Course course = view.getCourse();

            Student student = new Student(ID, name, semester, course);
            try {
                if (model.add(student)) {
                    view.setMess("Add success: " + student);
                    view.displayMessages();
                } else {
                    view.setError("Add Fail: Duplicate student record!");
                    view.displayErrorMessages();
                }
            } catch (Exception ex) {
                view.setError(ex.getMessage());
                view.displayErrorMessages();
            }

            if (model.getList().size() >= 10) {
                if (!view.getContinueChoice()) {
                    return;
                }
            }
        } while (true);
    }

    public void handlefindAndSort() {
        String name = view.getSearchName();
        ArrayList<Student> list = model.getListStudentByName(name);
        if (list.isEmpty()) {
            view.setError("Cannot find student!");
            view.displayErrorMessages();
        } else {
            StudentModel listSort = new StudentModel();
            listSort.setList(list);
            listSort.sortStudentsByName();
            view.displayStudents(list);
        }
    }

    public void handleUpdateOrDelete() {
        String id = view.getId();
        ArrayList<Student> list = model.getListStudentById(id);
        if (list.isEmpty()) {
            view.setError("Student not found!");
            view.displayErrorMessages();
        } else {
            view.displayStudents(list);
            view.setMess("Enter index of record (1-" + list.size() + "): ");
            view.displayMessages();
            int choice = view.getChoice(list.size());
            Student student = list.get(choice - 1);
            String choose = view.getUpdateOrDelete();

            if (choose.equalsIgnoreCase("u")) {
                String semester = view.getSemester();
                Course course = view.getCourse();
                try {
                    model.update(student, semester, course);
                    view.setMess("Update successful!");
                    view.displayMessages();
                } catch (Exception ex) {
                    view.setError(ex.getMessage());
                    view.displayErrorMessages();
                }
            } else {
                try {
                    model.delete(student);
                    view.setMess("Delete successful!");
                    view.displayMessages();
                } catch (Exception ex) {
                    view.setError(ex.getMessage());
                    view.displayErrorMessages();
                }
            }
        }
    }

    public void handleReport() {
        HashMap<String, Integer> result = model.generateReport();
        view.showReport(result);
    }

    public void generateStudent() {
        try {
            model.add(new Student("S1", "Tran Quoc Tuan", "Fall2022", Course.JAVA));
            model.add(new Student("S1", "Tran Quoc Tuan", "Summer2022", Course.DOT_NET));
            model.add(new Student("S1", "Tran Quoc Tuan", "Fall2022", Course.C_CPP));
            model.add(new Student("S2", "Doan Duy Huy", "Fall2021", Course.JAVA));
            model.add(new Student("S2", "Doan Duy Huy", "Spring2022", Course.JAVA));
            model.add(new Student("S3", "Le Thi Hoa", "Fall2022", Course.DOT_NET));
            model.add(new Student("S4", "Le Thi Quynh", "Fall2022", Course.JAVA));
            model.add(new Student("S5", "Le Trong Nhat", "Fall2022", Course.DOT_NET));
            model.add(new Student("S5", "Le Trong Nhat", "Summer2022", Course.JAVA));
            model.add(new Student("S6", "Le Van Quyen", "Fall2022", Course.JAVA));
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
