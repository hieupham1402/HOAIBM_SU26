package main;

import controller.StudentController;
import model.StudentModel;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.run();
    }
}