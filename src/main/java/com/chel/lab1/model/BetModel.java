package com.chel.lab1.model;


import com.chel.lab1.dao.*;
import com.chel.lab1.entities.*;

import java.util.ArrayList;


public class BetModel {

    private static BetModel instance = new BetModel();

    private BetModel() { };

    public static BetModel getInstance() {
        return instance;
    }

    private static BetDao betDao = BetDao.getInstance();

    public Iterable<Bet> getAllBets() {
        return betDao.getAll();
    }

    public Iterable<Bet> getBetsForClient(String clientId) {
        return betDao.getAllForClient(Integer.parseInt(clientId));
    }

    public Iterable<BetData> getBetsDataForClient(String id) {
        ArrayList<BetData> result = new ArrayList<>();
        Iterable<Bet> bets = betDao.getAllForClient(Integer.parseInt(id));

        for(Bet bet : bets) {
            result.add(new BetData(bet.getSum(), bet.getState()));
            Participant participant = ParticipantDao.getInstance().get(bet.getParticipantId());
            result.get(result.size()-1).setCoeff(participant.getCoeff());
            Rider rider = RiderDao.getInstance().get(participant.getRiderId());
            result.get(result.size()-1).setRiderFullName(rider.getFullName());
            Race race = RaceDao.getInstance().get(participant.getRaceId());
            race.formatDate();
            System.out.println(race.getDateTime());
            result.get(result.size()-1).setRaceDateTime(race.getDateTime());
            result.get(result.size()-1).setRacePlace(race.getPlace());
        }
        return result;
    }

    public void addBet(Bet bet) {
        ClientModel.getInstance().subtractFromClient(bet.getClientId(), bet.getSum());
        betDao.save(bet);
    }
}
