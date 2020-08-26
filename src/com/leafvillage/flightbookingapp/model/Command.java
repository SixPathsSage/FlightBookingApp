package com.leafvillage.flightbookingapp.model;

import com.leafvillage.flightbookingapp.exceptions.InvalidCommandException;
import com.leafvillage.flightbookingapp.helper.ConversionHelper;

import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private String command;
    private List<Long> params;

    public Command(List<String> commandText) {
        if(commandText.size() < 1) {
            throw new InvalidCommandException("Empty Command");
        }
        this.command = commandText.get(0);
        commandText.remove(0);
        this.params = commandText.stream().map(ConversionHelper::toLong).collect(Collectors.toList());
    }

    public String getCommand() {
        return command;
    }

    public List<Long> getParams() {
        return params;
    }
}
