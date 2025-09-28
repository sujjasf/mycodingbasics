// Ticket Booking System
// Multiple users try to book seats at the same time.
// Prevent overbooking with synchronization.


class ticketProcessing {
    private final int[] seats = new int[11];
    // String[] cities = { "KTM", "PKH", "BRT"};

    public synchronized void bookTicket(int seat) {
        if(seat < 0 || seat >= seats.length) {
            System.out.println("Invalid seat number it should be between 0 and 10");
            return;
        }
        if ( seats[seat] == 0 ) {
            seats[seat] = 1;
            System.out.println(Thread.currentThread().getName() + " Succesfully booked seat at seat: "+ seat);
        }
        else {
            System.out.println(Thread.currentThread().getName() + ", sorry the seat " + seat + " is already booked sorry choose another one!!!");
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        
        ticketProcessing tickets = new ticketProcessing();
        
        Thread t1 = new Thread(() -> {
            tickets.bookTicket(3);
        }, "User1");
        Thread t2 = new Thread(() -> {
            tickets.bookTicket(3);
        }, "User2");
        Thread t3 = new Thread(() -> {
            tickets.bookTicket(4);
        }, "User3");

        t1.start();
        t2.start();
        t3.start();
    }
}
