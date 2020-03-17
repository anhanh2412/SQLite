package com.example.sqlite;

public class SinhVien {
    private String id;
    private String hoTen;
    private int gioiTinh;
    private String namSinh;
    private String soThich;

    private String school;

    public SinhVien(String id, String hoTen, String namSinh, String school, int gioiTinh, String soThich) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.school = school;
        this.gioiTinh = gioiTinh;
        this.soThich = soThich;
    }

    public SinhVien(String hoTen, int gioiTinh, String namSinh, String soThich, String school) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.soThich = soThich;
        this.school = school;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }
}
