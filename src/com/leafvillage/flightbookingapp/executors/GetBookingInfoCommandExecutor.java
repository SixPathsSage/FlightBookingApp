package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.model.Booking;
import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public class GetBookingInfoCommandExecutor extends CommandLineExecutor {
    public final static String GET_BOOKING_INFO = "get_booking_info";

    public GetBookingInfoCommandExecutor(final FlightBookingService service) {
        super(service);
    }

    @Override
    protected boolean validate(final Command command) {
        return command.getCommand().equals(GET_BOOKING_INFO) && command.getParams().size() == 1;
    }

    @Override
    protected void execute(final Command command) {
        Booking booking = service.getBookingInformation(command.getParams().get(0));
        System.out.println(booking);
    }
}
