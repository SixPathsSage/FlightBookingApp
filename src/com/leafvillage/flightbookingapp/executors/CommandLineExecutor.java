package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.exceptions.IncorrectParametersException;
import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

public abstract class CommandLineExecutor {
    protected FlightBookingService service;

    public CommandLineExecutor(final FlightBookingService service) {
        this.service = service;
    }

    protected abstract boolean validate(final Command command);

    protected abstract void execute(final Command command);

    public void executeCommand(final Command command) {
        if(validate(command)) {
            execute(command);
        }
        else {
            throw new IncorrectParametersException(command.getCommand());
        }
    }
}
