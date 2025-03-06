class TicketBookingSystem {
    private static int availableSeats = 10;
    private static final Object lock = new Object();

    public static void bookTicket(String customerName, boolean isVIP) {
        synchronized (lock) {
            if (availableSeats > 0) {
                System.out.println(customerName + " is booking a seat...");
                availableSeats--;
                System.out.println("Seat booked for " + customerName + ". Remaining seats: " + availableSeats);
            } else {
                System.out.println("Sorry, no seats available for " + customerName);
            }
        }
    }

    public static void main(String[] args) {
        Thread vipBooking1 = new Thread(new BookingTask("VIP Customer 1", true));
        Thread regularBooking1 = new Thread(new BookingTask("Regular Customer 1", false));
        Thread vipBooking2 = new Thread(new BookingTask("VIP Customer 2", true));
        Thread regularBooking2 = new Thread(new BookingTask("Regular Customer 2", false));

        vipBooking1.setPriority(Thread.MAX_PRIORITY);
        regularBooking1.setPriority(Thread.NORM_PRIORITY);
        vipBooking2.setPriority(Thread.MAX_PRIORITY);
        regularBooking2.setPriority(Thread.NORM_PRIORITY);

        vipBooking1.start();
        regularBooking1.start();
        vipBooking2.start();
        regularBooking2.start();
    }
}

class BookingTask implements Runnable {
    private String customerName;
    private boolean isVIP;

    public BookingTask(String customerName, boolean isVIP) {
        this.customerName = customerName;
        this.isVIP = isVIP;
    }

    @Override
    public void run() {
        TicketBookingSystem.bookTicket(customerName, isVIP);
    }
}
