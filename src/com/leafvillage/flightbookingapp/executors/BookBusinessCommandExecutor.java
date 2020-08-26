package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.model.Booking;
import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public class BookBusinessCommandExecutor extends CommandLineExecutor {
    public final static String BOOK_BUSINESS = "book_business";

    public BookBusinessCommandExecutor(final FlightBookingService service) {
        super(service);
    }

    @Override
    protected boolean validate(final Command command) {
        return command.getCommand().equals(BOOK_BUSINESS) && command.getParams().size() == 1;
    }

    @Override
    protected void execute(final Command command) {
        Booking booking = service.bookBusinessSeat(command.getParams().get(0).intValue());
        System.out.println(booking);
    }
}
