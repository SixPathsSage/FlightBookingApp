package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.model.Booking;
import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public class BookEconomyCommandExecutor extends CommandLineExecutor {
    public final static String BOOK_ECONOMY = "book_economy";

    public BookEconomyCommandExecutor(final FlightBookingService service) {
        super(service);
    }

    @Override
    protected boolean validate(final Command command) {
        return command.getCommand().equals(BOOK_ECONOMY) && command.getParams().size() == 1;
    }

    @Override
    protected void execute(final Command command) {
        Booking booking = service.bookEconomySeat(command.getParams().get(0).intValue());
        System.out.println(booking);
    }
}
