package com.chel.lab1.controller.commands;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CommandFactory {

    private Map<UrlEntry, Command> commands = new HashMap<>();

    public CommandFactory()
    {
        commands.put(new UrlEntry("^/api/races$", "GET"), new GetRacesCommand());
        commands.put(new UrlEntry("^/api/races/(\\d+)$", "GET"), new GetRaceByIdCommand());
        commands.put(new UrlEntry("^/api/races/(\\d+)$", "DELETE"), new DeleteRaceByIdCommand());

        commands.put(new UrlEntry("^/api/participants/(\\d+)$", "GET"), new GetParticipantByIdCommand());
        commands.put(new UrlEntry("^/api/participantsForRace/(\\d+)$", "GET"), new GetParticipantsForRaceCommand());
        commands.put(new UrlEntry("^/api/participants/(\\d+)$", "DELETE"), new DeleteParticipantByIdCommand());

        commands.put(new UrlEntry("^/api/ridersForRace/(\\d+)$", "GET"), new GetRidersForRaceCommand());
        commands.put(new UrlEntry("^/api/riders/(\\d+)$", "GET"), new GetRiderByIdCommand());

        commands.put(new UrlEntry("^/api/bets$", "POST"), new CreateBetCommand());
        commands.put(new UrlEntry("^/api/betsDataForClient/(\\w+)$", "GET"), new GetBetsDataForClientCommand());



        commands.put(new UrlEntry("^/api/checkAuthorisation$", "POST"), new CheckAuthorisationCommand());

    }

    public Command getCommand(String uri, String method) {
        for(UrlEntry urlEntry : commands.keySet())
        {
            if(urlEntry.getMethod().equals(method) && Pattern.matches(urlEntry.getPattern(), uri)) {
                return commands.get(urlEntry);
            }
        }
        return null;
    }
}