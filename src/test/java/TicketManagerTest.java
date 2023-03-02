import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void testSortTicket() {
        Ticket ticket = new Ticket(1, 1300, "DME", "US", 8);
        Ticket ticket2 = new Ticket(2, 1700, "DMV","BLR", 3);
        Ticket ticket3 = new Ticket(3, 2000, "ZKD", "LED", 1);
        Ticket ticket4 = new Ticket(4, 800, "KUF", "GOJ", 2);
        Ticket ticket5 = new Ticket(5, 500, "OGZ", "FRU", 4);
        Ticket ticket6 = new Ticket(6, 1300, "DME", "US", 7);
        Ticket ticket7 = new Ticket(7, 1700, "DME", "US", 6);

        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket, ticket6, ticket7};
        Ticket[] actual = manager.findAll("DME", "US");

        Assertions.assertArrayEquals(expected, actual);
    }

        @Test
        public void testShouldOneTicket() {
            Ticket ticket = new Ticket(1, 1300, "DME", "US", 8);

            manager.add(ticket);

            Ticket[] expected = {ticket};
            Ticket[] actual = manager.findAll("DME", "US");

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void testNullTicket() {

            Ticket[] expected = {};
            Ticket[] actual = manager.findAll("", "");

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void testShouldEqualTicket() {
            Ticket ticket = new Ticket(1, 1300, "DME", "US", 8);
            Ticket ticket2 = new Ticket(2, 1700, "DMV","BLR", 3);
            Ticket ticket3 = new Ticket(3, 2000, "ZKD", "LED", 1);
            Ticket ticket4 = new Ticket(4, 800, "KUF", "GOJ", 2);
            Ticket ticket5 = new Ticket(5, 500, "OGZ", "FRU", 4);
            Ticket ticket6 = new Ticket(6, 1300, "DME", "US", 7);
            Ticket ticket7 = new Ticket(7, 1700, "DME", "US", 6);

            manager.add(ticket);
            manager.add(ticket6);

            Ticket[] expected = {ticket, ticket6};
            Ticket[] actual = manager.findAll("DME", "US");

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void testMinPrice() {
            Ticket ticket = new Ticket(1, 1300, "DME", "US", 8);
            Ticket ticket2 = new Ticket(2, 1700, "DMV","BLR", 3);
            Ticket ticket3 = new Ticket(3, 2000, "ZKD", "LED", 1);
            Ticket ticket4 = new Ticket(4, 800, "KUF", "GOJ", 2);
            Ticket ticket5 = new Ticket(5, 500, "OGZ", "FRU", 4);
            Ticket ticket6 = new Ticket(6, 1300, "DME", "US", 7);
            Ticket ticket7 = new Ticket(7, 1700, "DME", "US", 6);

            manager.add(ticket7);
            manager.add(ticket);

            Ticket[] expected = {ticket, ticket7};
            Ticket[] actual = manager.findAll("DME", "US");

            Assertions.assertArrayEquals(expected, actual);
        }
}
