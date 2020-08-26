package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public class ExitCommandExecutor extends CommandLineExecutor {

    public final static String EXIT_COMMAND = "exit";

    public ExitCommandExecutor(FlightBookingService service) {
        super(service);
    }

    @Override
    public boolean validate(Command command) {
        return command.getCommand().equals(EXIT_COMMAND) && command.getParams().size() == 0;
    }

    @Override
    public void execute(Command command) {
        System.exit(0);
    }
}
