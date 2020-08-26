package com.leafvillage.flightbookingapp.executors;

import com.leafvillage.flightbookingapp.exceptions.InvalidCommandException;
import com.leafvillage.flightbookingapp.service.FlightBookingService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, CommandLineExecutor> executors;
    public CommandFactory(FlightBookingService service) {
        executors = new HashMap<>();
        executors.put(CreateFlightCommandExecutor.CREATE_FLIGHT, new CreateFlightCommandExecutor(service));
        executors.put(BookEconomyCommandExecutor.BOOK_ECONOMY, new BookEconomyCommandExecutor(service));
        executors.put(BookBusinessCommandExecutor.BOOK_BUSINESS, new BookBusinessCommandExecutor(service));
        executors.put(GetBookingInfoCommandExecutor.GET_BOOKING_INFO, new GetBookingInfoCommandExecutor(service));
        executors.put(CancelBookingCommandExecutor.CANCEL_BOOKING, new CancelBookingCommandExecutor(service));
        executors.put(ExitCommandExecutor.EXIT_COMMAND, new ExitCommandExecutor(service));
    }

    public CommandLineExecutor getExecutors(String command) {
        if(!executors.containsKey(command)) {
            throw new InvalidCommandException(command);
        }
        return executors.get(command);
    }
}
