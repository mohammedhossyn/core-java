package com.oop.examples.hospitalSystemManagementExample;

import java.util.ArrayList;
import java.util.List;

// کپسوله‌سازی: کلاس بیمار با داده‌های خصوصی
class Patient {
    private final String id;
    private String name;
    private final List<Appointment> appointments;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.appointments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments); // کپی برای جلوگیری از تغییر مستقیم
    }
}
