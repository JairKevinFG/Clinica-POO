package ui;

import java.util.Scanner;

public class UIPatientMenu {
    public static void main(String[] args) {
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
        }while(response !=0);
    }
}
