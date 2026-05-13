/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lớp View dùng để hiển thị giao diện console
 * và nhận dữ liệu nhập từ người dùng.
 * Không xử lý nghiệp vụ, không làm việc trực tiếp với Model.
 *
 * @author Tuan Tran
 */
public class DoctorView {

    // Header dùng để hiển thị tiêu đề bảng Doctor
    private String header;

    // Body dùng để hiển thị danh sách Doctor
    private String body;

    // Message dùng để hiển thị thông báo thành công
    private String mess;

    // Error dùng để hiển thị thông báo lỗi
    private String error;

    // Danh sách menu chức năng
    ArrayList<String> menu = new ArrayList<>();

    // Scanner chỉ được đặt trong View để nhập dữ liệu từ bàn phím
    private Scanner scanner = new Scanner(System.in);

    /**
     * Thêm một mục vào menu chức năng
     */
    public void addItem(String s) {
        menu.add(s);
    }

    /**
     * Hiển thị menu chức năng ra màn hình
     */
    public void showMenu() {
        System.out.println("========= Doctor Management Program =========");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    /**
     * Khởi tạo các chức năng trong menu
     * Menu chỉ chứa nội dung hiển thị, không xử lý logic
     */
    public void showMenuChoice() {
        menu.add("Add Doctor");
        menu.add("Update Doctor");
        menu.add("Delete Doctor");
        menu.add("Search Doctor");
        menu.add("Display All Doctors");
        menu.add("Exit");
    }

    /**
     * Nhận lựa chọn menu từ người dùng
     * Dữ liệu nhập vào được validate bằng Validator
     */
    public int getChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return Validator.validateInt(scanner.nextLine(), 1, menu.size());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Nhập Doctor Code từ người dùng
     * Doctor Code phải đúng định dạng (DOC + số)
     */
    public String getCode() {
        while (true) {
            try {
                System.out.print("Enter Code: ");
                /**
                 * DOC	Chuỗi cố định, bắt buộc phải có
                    \\s	1 khoảng trắng (space)
                    \\d+	1 hoặc nhiều chữ số
                 */
                return Validator.validateString(scanner.nextLine(), "DOC\\s\\d+");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Nhập tên Doctor
     * Không được để trống
     */
    public String getName() {
        while (true) {
            try {
                System.out.print("Enter Name: ");
                /**
                 * ^	Bắt đầu chuỗi
                        (?!\\s*$)	Không cho phép toàn bộ chuỗi chỉ là khoảng trắng
                        .+	Ít nhất 1 ký tự bất kỳ
                        $	Kết thúc chuỗi
                 */
                return Validator.validateString(scanner.nextLine(), "^(?!\\s*$).+");
            } catch (Exception e) {
                System.out.println("Error: Name cannot be empty");
            }
        }
    }

    /**
     * Nhập chuyên khoa của Doctor
     * Không được để trống
     */
    public String getSpecialization() {
        while (true) {
            try {
                System.out.print("Enter Specialization: ");
                return Validator.validateString(scanner.nextLine(), "^(?!\\s*$).+");
            } catch (Exception e) {
                System.out.println("Error: Specialization cannot be empty");
            }
        }
    }

    /**
     * Nhập số lượng/giờ làm việc còn trống
     * Giá trị phải là số không âm
     */
    public int getAvailability() {
        while (true) {
            try {
                System.out.print("Enter Availability: ");
                return Validator.validateInt(scanner.nextLine(), 0, Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println("Error: Availability must be a non-negative number!");
            }
        }
    }

    /**
     * Nhập từ khóa tìm kiếm Doctor
     */
    public String getKeySearch() {
        while (true) {
            try {
                System.out.print("Enter search term: ");
                return Validator.validateString(scanner.nextLine(), "^(?!\\s*$).+");
            } catch (Exception e) {
                System.out.println("Error: Search term cannot be empty");
            }
        }
    }

    /**
     * Gán tiêu đề bảng hiển thị Doctor
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Gán nội dung danh sách Doctor
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gán thông báo thành công
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Gán thông báo lỗi
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Gán danh sách menu
     */
    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }

    /**
     * Hiển thị thông báo thành công
     */
    public void displayMessages() {
        System.out.println(mess);
    }

    /**
     * Hiển thị thông báo lỗi
     */
    public void displayErrorMessages() {
        System.out.println(error);
    }

    /**
     * Hiển thị danh sách Doctor dưới dạng bảng
     */
    public void displayDoctors() {
        System.out.println(header);
        System.out.println(body);
    }
}
