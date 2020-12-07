package ui;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

     public static void showMenu(){

         System.out.println("Bienvenido al sistema de citas ");
         System.out.println("Selecciona la opción deseada");
         int response = 0;

         do {
             System.out.println("1. Doctor");
             System.out.println("2. Paciente");
             System.out.println("0. Salir");


             Scanner sc = new Scanner(System.in);
             response = Integer.parseInt(sc.nextLine());


             switch (response){
                 case 1:
                     System.out.println("Doctor");
                     authUser(1);

                     response = 0;
                     break;
                 case 2:
                     response = 0;
                     authUser(2);
                     break;
                 case 0:
                     System.out.println("Gracias por su visita");
                     break;
                 default:
                     System.out.println("Selecciona una opcion correcta");
             }

         }while(response!= 0);


     }

    public static void authUser(int userType){
        ArrayList<Doctor> doctors = new ArrayList<>();
        Doctor doctor = new Doctor("Jair ", "jkevinfg@gmail.com","Cirujano" );
        doctor.setAddress("El agustino");
        doctors.add(doctor);

        doctors.add(new Doctor("Kevin ", "fg@gmail.com" , "pediatra"));
        doctors.add(new Doctor("Jr ", "j@gmail.com", "oftalmologo" ));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Diana", "diana@gmail.com"));
        patients.add(new Patient("Thais", "thais@gmail.com"));
        patients.add(new Patient("catalina", "catalina@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Ingrese su email  : [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if( userType == 1){
                for (Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logeado
                        doctorLogged = d;
                        System.out.println(d);
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2){
                for (Patient p:patients){
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logeado
                        patientLogged = p;

                    }
                }
            }
        }while (!emailCorrect);


    }



}
