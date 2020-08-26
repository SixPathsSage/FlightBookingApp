package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public class CreateFlightCommandExecutor extends CommandLineExecutor{
    public final static String CREATE_FLIGHT = "create_flight";

    public CreateFlightCommandExecutor(final FlightBookingService service) {
        super(service);
    }

    @Override
    protected boolean validate(final Command command) {
        return command.getCommand().equals(CREATE_FLIGHT) && command.getParams().size() == 2;
    }

    @Override
    protected void execute(final Command command) {
        service.createFlight(command.getParams().get(0).intValue(), command.getParams().get(1).intValue());
        System.out.println("Flight Created Successfully");
    }
}
