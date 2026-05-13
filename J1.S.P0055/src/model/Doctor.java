/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Lớp Model Doctor dùng để biểu diễn thông tin của một Doctor.
 * Chỉ dùng để lưu trữ dữ liệu, không xử lý nhập/xuất hay nghiệp vụ.
 *
 * @author win
 */
import java.io.Serializable;

public class Doctor implements Serializable {

    // Doctor Code - mã định danh duy nhất của Doctor
    private String code;

    // Tên Doctor
    private String name;

    // Chuyên khoa của Doctor
    private String specialization;

    // Số lượng/giờ làm việc còn trống
    private int availability;

    /**
     * Hàm khởi tạo Doctor
     * Dùng để tạo đối tượng Doctor với đầy đủ thông tin ban đầu
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Lấy Doctor Code
     * Doctor Code được dùng làm key trong doctorMap
     */
    public String getCode() {
        return code;
    }

    /**
     * Gán Doctor Code
     * Không khuyến khích thay đổi vì Doctor Code là key
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Lấy tên Doctor
     */
    public String getName() {
        return name;
    }

    /**
     * Gán tên Doctor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lấy chuyên khoa của Doctor
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Gán chuyên khoa cho Doctor
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Lấy số lượng/giờ làm việc còn trống
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Gán số lượng/giờ làm việc còn trống
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Trả về thông tin Doctor dưới dạng chuỗi
     * Dùng để hiển thị khi in ra màn hình
     */
    @Override
public String toString() {
    return "Code: " + code +
           ", Name: " + name +
           ", Specialization: " + specialization +
           ", Availability: " + availability;
}
}
