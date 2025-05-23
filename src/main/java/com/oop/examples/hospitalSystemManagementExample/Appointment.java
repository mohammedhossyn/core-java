package com.oop.examples.hospitalSystemManagementExample;

// کپسوله‌سازی و انتزاع: کلاس نوبت
class Appointment {
    private final Patient patient;
    private final Doctor doctor;
    private final String timeSlot;

    public Appointment(Patient patient, Doctor doctor, String timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
}
