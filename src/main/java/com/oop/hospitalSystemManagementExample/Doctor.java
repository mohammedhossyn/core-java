package com.oop.hospitalSystemManagementExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// وراثت و چندریختی: کلاس پزشک که از HospitalStaff ارث می‌بره
class Doctor extends HospitalStaff {
    private final String specialty;
    private final List<Appointment> schedule;
    private final ReentrantLock lock = new ReentrantLock();

    public Doctor(String staffId, String name, String specialty) {
        super(staffId, name);
        this.specialty = specialty;
        this.schedule = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Doctor (" + specialty + ")";
    }

    public boolean addAppointment(Appointment appointment) {
        lock.lock();
        try {
            return schedule.add(appointment);
        } finally {
            lock.unlock();
        }
    }

    public boolean removeAppointment(Appointment appointment) {
        lock.lock();
        try {
            return schedule.remove(appointment);
        } finally {
            lock.unlock();
        }
    }

    public List<Appointment> getAppointments() {
        lock.lock();
        try {
            return new ArrayList<>(schedule); // کپی دفاعی برای حفظ کپسوله‌سازی
        } finally {
            lock.unlock();
        }
    }
}
