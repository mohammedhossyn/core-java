package com.oop.examples.hospitalSystemManagementExample;

// انتزاع: رابط برای مدیریت نوبت‌ها
interface AppointmentManager {
    boolean scheduleAppointment(Patient patient, Doctor doctor);

    void cancelAppointment(Patient patient);
}
