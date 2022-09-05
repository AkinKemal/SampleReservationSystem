import java.util.Scanner;

public class TicketPrinting {

    Scanner scanner = new Scanner(System.in);

    public int[][] seatingPlan;
    public String name;

    public TicketPrinting(int[][] seatingPlan) {
        this.seatingPlan = seatingPlan;
    }

    public void usersName() {
        System.out.println("What is your name?");
        name = scanner.nextLine();
    }

    //bilet yazdırma
    public void printing(int counter) {
        System.out.println("|---------------------------------------------------------|");
        int a;
        for (int j = 0; j < 5; j++) {
            for (int i = 1; i <= 59; i++) {
                if (59 % i == 0) {
                    System.out.print("|");
                } else if (j == 0 && i == 22) {
                    String s = "DOFTDARE CINEMA";
                    System.out.print(s);
                    a = s.length() - 1;
                    i += a;
                } else if (j == 2 && i == 4) {
                    System.out.print(name.toUpperCase());
                    a = name.length() - 1;
                    i += a;
                } else if (j == 3 && i == 28) {
                    String s = "Your reservation seat numbers: ";
                    System.out.print(s);
                    a = s.length() - 1;
                    i += a;
                } else if (j == 4 && i == 28 && counter != 0) {
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 12; l++) {
                            if (seatingPlan[k][l] == 1) {
                                System.out.print((char) (k + 65));
                                System.out.print((l + 1) + " ");
                                if (l <= 9) {
                                    i += 3;
                                } else {
                                    i += 4;
                                }
                            }
                        }
                    }
                    i--;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("|---------------------------------------------------------|");
    }
}