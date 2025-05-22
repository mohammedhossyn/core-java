package com.oop.hospitalSystemManagementExample;

public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient("P001", "Ali");
        Doctor doctor1 = new Doctor("D001", "Dr. Reza", "Cardiology");

        HospitalAppointmentSystem system = new HospitalAppointmentSystem();

        // شبیه‌سازی چندنخی برای رزرو نوبت
        Runnable scheduler = () -> {
            boolean success = system.scheduleAppointment(patient1, doctor1);
            System.out.println(Thread.currentThread().getName() + ": Appointment " + (success ? "scheduled" : "failed"));
        };

        Thread t1 = new Thread(scheduler, "Scheduler-1");
        Thread t2 = new Thread(scheduler, "Scheduler-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Patient appointments: " + patient1.getAppointments().size());
            System.out.println("Doctor schedule: " + doctor1.getAppointments().size());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}