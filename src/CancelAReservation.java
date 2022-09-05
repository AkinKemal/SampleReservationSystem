import java.util.Scanner;

public class CancelAReservation extends Reservation {

    Scanner scanner = new Scanner(System.in);

    public int[][] seatingPlan;
    public boolean trueFalse;

    public CancelAReservation(int counter, int[][] seatingPlan) {
        this.counter = counter;
        this.seatingPlan = seatingPlan;
    }

    public void cancelReservation() {

        String seatNumberSelections;
        do {
            System.out.print("Please enter the list of seats you want to cancel('ENTER' - to exit): ");
            seatNumberSelections = scanner.nextLine();

            //kontrol için gerekli metodlar cağırma
            String[] split = seatNumberSelections.split(" ");
            for (String s : split) {
                trueFalse = checkForWrongEntry(s);
                if (s.length() == 2) {
                    super.s = s.substring(1);
                } else if (s.length() == 3) {
                    super.s = s.substring(1, 3);
                }
                trueFalse = seatOccupancy(s);
            }

            if (!trueFalse && control == 0) {
                System.out.println("WARNING! You entered an in correct expression. Please try again: ");
            }

        } while (!trueFalse && control == 0);

        if (trueFalse) {
            System.out.println("Successful! Cancel Confirmed");
        }
    }

    //koltuk dolumu kontrol etme
    @Override
    public boolean seatOccupancy(String seatNumberSelection) {
        if (seatNumberSelection.length() == 2 && asciiNumber(seatNumberSelection) - 65 <= 7) {
            if (seatingPlan[asciiNumber(seatNumberSelection) - 65][Integer.parseInt(s) - 1] == 1) {
                seatingPlan[asciiNumber(seatNumberSelection) - 65][Integer.parseInt(s) - 1] = 0;
                counter--;
                return true;
            } else {
                System.out.println("Seat " + seatNumberSelection + " is not reserved already.");
                return false;
            }
        } else if (seatNumberSelection.length() == 3 && Integer.parseInt(s) <= 12) {

            if (seatingPlan[asciiNumber(seatNumberSelection) - 65][Integer.parseInt(s) - 1] == 1) {
                seatingPlan[asciiNumber(seatNumberSelection) - 65][Integer.parseInt(s) - 1] = 0;
                counter--;
                return true;
            } else {
                System.out.println("Seat " + seatNumberSelection + " is not reserved already.");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void setCounter(int counter) {
        this.counter = counter;
    }
}