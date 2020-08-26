package com.leafvillage.flightbookingapp.mode;

import com.leafvillage.flightbookingapp.datastore.BookingStore;
import com.leafvillage.flightbookingapp.executors.CommandFactory;
import com.leafvillage.flightbookingapp.executors.CommandLineExecutor;
import com.leafvillage.flightbookingapp.model.Command;
import com.leafvillage.flightbookingapp.model.Flight;
import com.leafvillage.flightbookingapp.service.FlightBookingService;
import com.leafvillage.flightbookingapp.strategy.AllocationStrategy;
import com.leafvillage.flightbookingapp.strategy.NaturalOrderAllocationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InteractiveMode {
    private Scanner scanner;

    public InteractiveMode() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        AllocationStrategy strategy = new NaturalOrderAllocationStrategy();
        Flight flight = new Flight();
        BookingStore store = new BookingStore();
        FlightBookingService service = new FlightBookingService(strategy, flight, store);
        CommandFactory commandFactory = new CommandFactory(service);
        while(true) {
            try {
                String input = scanner.nextLine();
                List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
                Command command = new Command(inputList);
                CommandLineExecutor executor = commandFactory.getExecutors(command.getCommand());
                executor.executeCommand(command);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }
}
