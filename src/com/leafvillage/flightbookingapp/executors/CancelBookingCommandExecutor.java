package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.model.CancellationInfo;
import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public class CancelBookingCommandExecutor extends CommandLineExecutor{
    public final static String CANCEL_BOOKING = "cancel_booking";

    public CancelBookingCommandExecutor(final FlightBookingService service) {
        super(service);
    }

    @Override
    protected boolean validate(final Command command) {
        return command.getCommand().equals(CANCEL_BOOKING) && command.getParams().size() == 1;
    }

    @Override
    protected void execute(final Command command) {
        CancellationInfo cancellationInfo = service.cancelBooking(command.getParams().get(0));
        System.out.println(cancellationInfo);
    }
}
