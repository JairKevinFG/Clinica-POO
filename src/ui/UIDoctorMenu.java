package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    //doctores que tienen cita
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0 ;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Bienvenido "+ UIMenu.doctorLogged.getName());
            System.out.println("1. Agregar cita");
            System.out.println("2. Citas programadas");
            System.out.println("0. Cerrar sesion");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());
            switch (response){
                case 1 :
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0 :
                    UIMenu.showMenu();
            }
        }while (response != 0);
    }



    private static void showAddAvailableAppointmentsMenu(){
        int response = 0 ;
        do {
            System.out.println();
            System.out.println(":: Agregar cita");
            System.out.println(":: Selecciona el mes");

            for ( int i = 0; i<3 ; i++ ){
                int j = i +1 ;
                System.out.println(j + "."+ UIMenu.MONTHS[i]);
            }
            System.out.println("0. Regresar");
            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());
            if ( response > 0 && response < 4){
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected-1] );
                System.out.println("Inserta la fecha :  [dd /mm / yyyy]");
                String date = sc.nextLine();
                System.out.println("La fecha es :" + date + "\n1 Correcto  \n2 Volver a insertar");
                int responseDate = Integer.parseInt(sc.nextLine());
                if(responseDate == 2) continue;
                int responseTime = 0;
                String time = "";
                do{
                    System.out.println("Inserta la hora : "+date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("La hora es : "+time+ "\n1 Confirmar  \n2. Volver a insertar");
                    responseTime = Integer.parseInt(sc.nextLine());
                }while(responseTime == 2);
                UIMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);
                System.out.println(doctorsAvailableAppointments);

            }else if ( response == 0) {
                showDoctorMenu();
            }
        }while( response != 0 ) ;
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointments().size() > 0
                && !doctorsAvailableAppointments.contains(doctor)){
            System.out.println("aa");
            doctorsAvailableAppointments.add(doctor);
        }
    }


}
