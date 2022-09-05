public class Reservation {

    public int control = 0;
    public int counter = 0;
    public String s;

    public Reservation() {

    }

    //harfi ascii karakterine çevirme
    public int asciiNumber(String seatNumberSelection) {
        seatNumberSelection = seatNumberSelection.toUpperCase();
        return seatNumberSelection.charAt(0);
    }

    //yanlış girişi kontrol etme
    public boolean checkForWrongEntry(String seatNumberSelection) {
        if (seatNumberSelection.length() == 2) {
            String s = seatNumberSelection.substring(1);
            if (control == 1) control--;
            return (asciiNumber(seatNumberSelection) >= 65 && asciiNumber(seatNumberSelection) <= 72 &&
                    Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 9);
        } else if (seatNumberSelection.length() == 3) {
            String s = seatNumberSelection.substring(1, 3);
            if (control == 1) control--;
            return (asciiNumber(seatNumberSelection) >= 65 && asciiNumber(seatNumberSelection) <= 72 &&
                    Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 12);
        } else {
            System.out.println("Sorry, seat number not found.");
            if (control == 0) control++;
            return false;
        }
    }

    public boolean seatOccupancy(String seatNumberSelection) {
        return true;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}