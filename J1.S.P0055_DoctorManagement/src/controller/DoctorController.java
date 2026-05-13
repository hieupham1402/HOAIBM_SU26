/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Doctor;
import java.util.HashMap;
import java.util.Map;
import view.DoctorView;

/**
 *
 * @author win
 */
public class DoctorController {

    private Map<String, Doctor> doctorMap;
    private DoctorView view;

    public DoctorController() {
        doctorMap = new HashMap<>();
        view = new DoctorView();
    }

    public void setDoctorMap(Map<String, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }

    public void run() {
        view.addItem("Add Doctor");
        view.addItem("Update Doctor");
        view.addItem("Delete Doctor");
        view.addItem("Search Doctor");
        view.addItem("Display All Doctors");
        view.addItem("Exit");
        int choice;
        do {
            view.showMenu();
            choice = view.getChoice();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    displayAllDoctors();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
            }
        } while (choice != 6);
    }

    public void addDoctor() {
        String code = view.getCode();
        String name = view.getName();
        String specialization = view.getSpecialization();
        int availability = view.getAvailability();
        Doctor doctor = new Doctor(code, name, specialization, availability);
        if (doctorMap.containsKey(doctor.getCode())) {
            view.setError("Doctor code [" + doctor.getCode() + "] is duplicate.");
            view.displayErrorMessages();
        } else {
            doctorMap.put(doctor.getCode(), doctor);
            view.setMess("Doctor added successfully: " + doctor);
            view.displayMessages();
        }
    }

    public void updateDoctor() {
        String code = view.getCode();
        if (!doctorMap.containsKey(code)) {
            view.setError("Doctor code doesn’t exist.");
            view.displayErrorMessages();
            return;
        }
        view.setMess("Before update: " + doctorMap.get(code));
        view.displayMessages();
        view.setMess("ENTER NEW INFO:");
        view.displayMessages();
        String name = view.getName();
        String specialization = view.getSpecialization();
        int availability = view.getAvailability();
        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        doctorMap.put(code, newDoctor);
        view.setMess("Doctor updated successfully: " + doctorMap.get(code));
        view.displayMessages();
    }

    public void deleteDoctor() {
        String code = view.getCode();
        if (!doctorMap.containsKey(code)) {
            view.setError("Doctor code doesn’t exist.");
            view.displayErrorMessages();
            return;
        }
        if (doctorMap.remove(code) != null) {
            view.setMess("Doctor deleted successfully!");
            view.displayMessages();
        } else {
            view.setError("Delete false");
            view.displayErrorMessages();
        }
    }

    public void searchDoctor() {
        String input = view.getKeySearch();
        Map<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getCode().toLowerCase().contains(input.toLowerCase())
                    || doctor.getName().toLowerCase().contains(input.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(input.toLowerCase())) {
                result.put(doctor.getCode(), doctor);
            }
        }
        if (result.isEmpty()) {
            view.setError("No matching doctors found.");
            view.displayErrorMessages();
        } else {
            DoctorController manager = new DoctorController();
            manager.setDoctorMap(result);
            manager.displayAllDoctors();
        }
    }

    public void displayAllDoctors() {
        if (doctorMap.isEmpty()) {
            view.setError("List is empty!");
            view.displayErrorMessages();
            return;
        }
        String strHeader = String.format("%-10s %-20s %-20s %-10s", "Code", "Name",
                "Specialization", "Availability");
        view.setHeader(strHeader);
        StringBuilder body = new StringBuilder();
        for (Doctor doctor : doctorMap.values()) {
            body.append(String.format("%-10s %-20s %-20s %-10s\n", doctor.getCode(),doctor.getName(),
                doctor.getSpecialization(), doctor.getAvailability()));
        }
        view.setBody(body.toString());
        view.displayDoctors();
    }
}
