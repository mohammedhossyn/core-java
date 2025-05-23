package com.oop.examples.hospitalSystemManagementExample;

// وراثت: کلاس پایه برای پرسنل بیمارستان
abstract class HospitalStaff {
    protected String staffId;
    protected String name;

    public HospitalStaff(String staffId, String name) {
        this.staffId = staffId;
        this.name = name;
    }

    public abstract String getRole(); // متد انتزاعی
}
