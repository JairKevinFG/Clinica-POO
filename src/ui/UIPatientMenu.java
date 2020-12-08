package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response  = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Paciente");
            System.out.println("Bienvenido "+ UIMenu.patientLogged.getName());
            System.out.println("1. Reservar cita");
            System.out.println("2. Mis citas ");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1 :
                    showBookAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0 :
                    UIMenu.showMenu();
                    break;
            }

        }while (response != 0);
    }
    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println(":: Reservar cita");
            System.out.println("::Selecciona la fecha: ");

            // Clave valor
            //       Clave
            // 1 -> doctor
            //            -> 1 fecha 1
            //            -> 2 fecha 2

            Map <Integer , Map<Integer , Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i< UIDoctorMenu.doctoresFechasDisponibles.size() ; i++ ){
                ArrayList<Doctor.AvailableAppointment> fechasDisponibles = UIDoctorMenu.doctoresFechasDisponibles.get(i).getAvailableAppointments();
                System.out.println(fechasDisponibles);
                Map<Integer , Doctor > doctorCitas = new TreeMap<>();
                for ( int j = 0 ; j<  fechasDisponibles.size(); j ++){
                    k++;
                    System.out.println(k+ ". " +fechasDisponibles.get(j).getDate());
                    doctorCitas.put(Integer.valueOf(j), UIDoctorMenu.doctoresFechasDisponibles.get(i));
                    doctors.put(Integer.valueOf(k), doctorCitas );
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected  = Integer.parseInt(sc.nextLine());
            Map<Integer , Doctor > doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0 ;
            Doctor doctorSelected = new Doctor("","");
            for(Map.Entry< Integer , Doctor> doc  :doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName()
                    + "Date: "+doctorSelected.getAvailableAppointments().get(indexDate).getDate()
                    + "Time: "+doctorSelected.getAvailableAppointments().get(indexDate).getTime()  );
            System.out.println("Confirma tu cita:  \n1. Sí \n2. Cambiar");
            response = Integer.valueOf(sc.nextLine());
            if(response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }

        }while(response !=0);
    }
}
