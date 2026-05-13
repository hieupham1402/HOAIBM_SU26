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
        view.showMenuChoice();
    }

    public void setDoctorMap(Map<String, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }

    public void run() {
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

    //Thêm mới doctor - trùng doctor code -> báo lỗi
    public void addDoctor() {
        String code = view.getCode();
        String name = view.getName();
        String specialization = view.getSpecialization();
        int availability = view.getAvailability();
        //khởi tạo đối tượng doctor có các trường thông tin dùng để lưu trữ khi thêm mới
        Doctor doctor = new Doctor(code, name, specialization, availability);
        //kiểm tra trùng lặp và khi dùng containsKey sẽ kiểm tra Doctor Code đã tồn tại trong Map hay chưa
        //doctor.getCode() đc lấy từ model nếu kiểm tra containsKey mà ok thì sẽ lấy đc doctor code và chạy xuống else nếu trùng thì chạy vào if
        // doctor.getCode() lấy Doctor Code từ đối tượng Doctor vừa khởi tạo
        if (doctorMap.containsKey(doctor.getCode())) {
            //Nếu Doctor Code đã tồn tại thì hiển thị lỗi
            view.setError("Doctor code [" + doctor.getCode() + "] is duplicate.");
            view.displayErrorMessages();
        } else {
            /**
             * Thêm Doctor mới vào hệ thống bằng put() doctor.getCode() là key
             * (Doctor Code) doctor là value (đối tượng Doctor) Do đã kiểm tra
             * trùng ở trên nên chỉ khi không trùng mới chạy đến đây
             */
            doctorMap.put(doctor.getCode(), doctor);
            view.setMess("Doctor added successfully: " + doctor);
            view.displayMessages();
        }
    }

    /**
     * Update thông tin Doctor dựa theo Doctor Code
     */
    public void updateDoctor() {
        // Nhập Doctor Code để tìm Doctor cần cập nhật trong doctorMap
        // Nếu không tồn tại thì hiển thị lỗi
        String code = view.getCode();

        /**
         * containsKey(code) dùng để kiểm tra Doctor Code (key) có tồn tại trong
         * hệ thống hay không Nếu không tồn tại thì báo lỗi và dừng hàm bằng
         * return
         */
        if (!doctorMap.containsKey(code)) {
            view.setError("Doctor code doesn’t exist.");
            view.displayErrorMessages();
            return;
        }

        /**
         * Nếu Doctor Code tồn tại thì hiển thị thông tin Doctor trước khi cập
         * nhật
         */
        view.setMess("Before update: " + doctorMap.get(code));
        view.displayMessages();

        // Nhập thông tin mới (không nhập lại Doctor Code)
        view.setMess("ENTER NEW INFO:");
        view.displayMessages();
        String name = view.getName();
        String specialization = view.getSpecialization();
        int availability = view.getAvailability();

        // Khởi tạo biến newDoctor chứa thông tin Doctor sau khi cập nhật
        // Doctor Code giữ nguyên vì là key
        Doctor newDoctor = new Doctor(code, name, specialization, availability);

        /**
         * put(code, newDoctor) dùng để cập nhật Doctor trong hệ thống code là
         * key không thay đổi newDoctor là value mới sẽ ghi đè value cũ put lúc
         * này không thêm mới mà chỉ ghi đè dữ liệu
         */
        doctorMap.put(code, newDoctor);

        // Hiển thị thông báo cập nhật thành công
        view.setMess("Doctor updated successfully: " + doctorMap.get(code));
        view.displayMessages();
    }

    /**
     * Xóa Doctor khỏi hệ thống dựa theo Doctor Code
     */
    public void deleteDoctor() {

        // Nhập Doctor Code cần xóa
        String code = view.getCode();

        /**
         * Kiểm tra Doctor Code (key) có tồn tại trong doctorMap hay không Nếu
         * không tồn tại thì không thể xóa → hiển thị lỗi và dừng hàm
         */
        if (!doctorMap.containsKey(code)) {
            view.setError("Doctor code doesn’t exist.");
            view.displayErrorMessages();
            return;
        }

        /**
         * remove(code) dùng để xóa Doctor khỏi Map theo key Nếu xóa thành công
         * thì remove trả về value (Doctor) khác null
         */
        if (doctorMap.remove(code) != null) {
            // Xóa thành công
            view.setMess("Doctor deleted successfully!");
            view.displayMessages();
        } else {
            // Trường hợp xóa không thành công (hiếm khi xảy ra)
            view.setError("Delete false");
            view.displayErrorMessages();
        }
    }

    /**
     * Tìm kiếm Doctor theo Doctor Code, Name hoặc Specialization
     */
    public void searchDoctor() {

        // Nhập từ khóa tìm kiếm từ người dùng
        String input = view.getKeySearch();

        /**
         * Tạo Map result để lưu kết quả tìm kiếm Không làm thay đổi danh sách doctorMap ban đầu
         */
        Map<String, Doctor> result = new HashMap<>();

        /**
         * Duyệt toàn bộ danh sách Doctor trong doctorMap values() dùng để lấy
         * tất cả Doctor (value)
         */
        for (Doctor doctor : doctorMap.values()) {
            // Kiểm tra từ khóa có xuất hiện trong code, name hoặc specialization hay không
            if (doctor.getCode().toLowerCase().contains(input.toLowerCase())
                    || doctor.getName().toLowerCase().contains(input.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(input.toLowerCase())) {

                // Nếu thỏa điều kiện thì thêm Doctor vào danh sách kết quả
                // key là Doctor Code, value là Doctor
                result.put(doctor.getCode(), doctor);
            }
        }

        /**
         * Nếu không có kết quả phù hợp thì hiển thị lỗi
         */
        if (result.isEmpty()) {
            view.setError("No matching doctors found.");
            view.displayErrorMessages();
        } else {
            /**
             * Tạo Controller tạm để hiển thị danh sách kết quả Nhằm tái sử dụng
             * hàm displayAllDoctors() và không ảnh hưởng đến danh sách gốc
             */
            DoctorController manager = new DoctorController();
            manager.setDoctorMap(result);
            manager.displayAllDoctors();
        }
    }

    /**
     * Hiển thị toàn bộ danh sách Doctor trong hệ thống
     */
    public void displayAllDoctors() {

        /**
         * Kiểm tra danh sách Doctor có rỗng hay không Nếu rỗng thì hiển thị lỗi
         */
        if (doctorMap.isEmpty()) {
            view.setError("List is empty!");
            view.displayErrorMessages();
            return;
        }

        // Tạo tiêu đề bảng hiển thị
        String strHeader = String.format(
                "%-10s %-20s %-20s %-10s",
                "Code", "Name", "Specialization", "Availability"
        );
        view.setHeader(strHeader);

        /**
         * Sử dụng StringBuilder để nối chuỗi hiệu quả Duyệt toàn bộ Doctor
         * trong Map và đưa vào body
         */
        StringBuilder body = new StringBuilder();
        for (Doctor doctor : doctorMap.values()) {
            body.append(String.format(
                    "%-10s %-20s %-20s %-10s\n",
                    doctor.getCode(),
                    doctor.getName(),
                    doctor.getSpecialization(),
                    doctor.getAvailability()
            ));
        }

        // Gửi dữ liệu sang View để hiển thị
        view.setBody(body.toString());
        view.displayDoctors();
    }

}
