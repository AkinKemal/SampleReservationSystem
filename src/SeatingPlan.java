public class SeatingPlan {

    public int[][] seatingPlan = new int[8][12];

    public SeatingPlan() {

    }

    //oturma planını oluşturma ve temizleme
    public void createASeatingPlan() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 12; j++) {
                seatingPlan[i][j] = 0;
            }
        }
    }

    //oturma planını yazdırma
    public void writingASeatingPlan() {
        System.out.println("  |-------------------------------------------------------|");
        System.out.println("  |                         STAGE                         |");
        System.out.println("  |     ---------------------------------------------     |");

        int numberAscii = 65;
        for (int i = 0; i < 8; i++) {
            System.out.print(conversion(numberAscii) + " |");
            for (int j = 0; j < 12; j++) {
                //merdiven boşluklerını oluşturma
                if (j == 3 || j == 9) {
                    System.out.print("   ");
                }
                //koltukları yazdırma
                if (seatingPlan[i][j] == 0) {
                    System.out.print(" [ ]");
                } else if (seatingPlan[i][j] == 1) {
                    System.out.print(" [X]");
                } else {
                    System.out.println("A system error has occurred!");
                }
            }
            System.out.print(" |\n");
            numberAscii++;
        }
        System.out.println("  |-------------------------------------------------------|");
        System.out.println("     1   2   3      4   5   6   7   8   9      10  11  12  ");
    }

    //ascii tablosu kullanarak harfleri yazdırma
    public char conversion(int numberAscii) {
        return (char) numberAscii;
    }

    //dizayn
    public void design() {
        System.out.println("-----------------------------------------------------------------------");
    }

    public int[][] transfer() {
        return seatingPlan;
    }
}