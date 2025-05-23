package com.oop.examples.hospitalSystemManagementExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// چندریختی و انتزاع: پیاده‌سازی AppointmentManager
class HospitalAppointmentSystem implements AppointmentManager {
    private final List<Appointment> appointments = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public boolean scheduleAppointment(Patient patient, Doctor doctor) {
        lock.lock();
        try {
            // بررسی در دسترس بودن پزشک
            for (Appointment appt : doctor.getAppointments()) {
                if (appt.getTimeSlot().equals("10:00")) { // فرضاً زمان درخواستی
                    return false; // زمان قبلاً رزرو شده
                }
            }
            Appointment appointment = new Appointment(patient, doctor, "10:00");
            patient.addAppointment(appointment);
            doctor.addAppointment(appointment);
            appointments.add(appointment);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void cancelAppointment(Patient patient) {
        lock.lock();
        try {
            appointments.removeIf(appt -> appt.getPatient().equals(patient));
            patient.getAppointments().clear();
            // به‌روزرسانی برنامه پزشک
            for (Appointment appt : appointments) {
                appt.getDoctor().removeAppointment(appt);
            }
        } finally {
            lock.unlock();
        }
    }
}
