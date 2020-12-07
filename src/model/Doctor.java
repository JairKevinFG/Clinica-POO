package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    private String speciality;
    //fechas disponibles
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String name , String email, String speciality){
        super(name,email);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // agregar una fecha disponible al array
    public void addAvailableAppointment(String date ,String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString(){
        return super.toString() +  "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital : Cruz Roja");
        System.out.println("Departamento : Oncologia");
    }


    // cita
    public static class AvailableAppointment {

        private int id ;
        private Date date ;
        private String time ;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date , String time) {
            try{
            //    Transformar fechas de formato String a Date:this.date = format.parse(dateAsString);
                this.date = format.parse(date);
            } catch (ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        // Transformar fechas de formato Date a String:this.date = format.format(dateAsDate);
        public String getDate(String DATE) {
            return format.format(date);
        }


        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
        @Override
        public String toString(){
            return  "Available Appointments \nDate: " +date+ "\nTime: " + time;
        }

    }
}



