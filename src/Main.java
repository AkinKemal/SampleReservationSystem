import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SeatingPlan seatingPlan = new SeatingPlan();
        TicketPrinting ticketPrinting = new TicketPrinting(seatingPlan.transfer());
        Reservation reservation = new Reservation();
        MakeAReservation makeAReservation = new MakeAReservation(reservation.getCounter(), seatingPlan.transfer());
        CancelAReservation cancelAReservation = new CancelAReservation(reservation.getCounter(), seatingPlan.transfer());

        System.out.println("Welcome To Reservation System For A Cinema");
        seatingPlan.design();

        //sinema salonunu oluşturma
        seatingPlan.createASeatingPlan();

        ticketPrinting.usersName();
        //kullanıcının seçimini alma
        String choice;
        do {

            System.out.println("Reservation System");
            System.out.println("1. Make reservation\n2. Cancel reservation\n3. Show seating plan\n4. Show ticket\n5. EXIT");
            choice = scanner.next();

            //kullanıcının seçimine uygun işlem yapma
            switch (choice) {
                case "1":
                    seatingPlan.design();
                    seatingPlan.writingASeatingPlan();
                    makeAReservation.makeReservation();
                    seatingPlan.writingASeatingPlan();
                    reservation.setCounter(makeAReservation.getCounter());
                    cancelAReservation.setCounter(makeAReservation.getCounter());
                    seatingPlan.design();
                    break;
                case "2":
                    seatingPlan.design();
                    seatingPlan.writingASeatingPlan();
                    cancelAReservation.cancelReservation();
                    seatingPlan.writingASeatingPlan();
                    reservation.setCounter(cancelAReservation.getCounter());
                    makeAReservation.setCounter(cancelAReservation.getCounter());
                    seatingPlan.design();
                    break;
                case "3":
                    seatingPlan.design();
                    seatingPlan.writingASeatingPlan();
                    seatingPlan.design();
                    break;
                case "4":
                    seatingPlan.design();
                    ticketPrinting.printing(reservation.getCounter());
                    seatingPlan.design();
                    break;
                case "5":
                    System.out.println("Thank you for choosing us.\nEnjoy the MOVIE");
                    break;
                default:
                    System.out.println("WARNING! You entered an in correct expression. Please try again:");
                    break;
            }
            //kullanıcının inputlarını kontrol etme
        } while (!choice.equals("5"));
    }
}