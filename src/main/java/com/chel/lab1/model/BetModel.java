package com.chel.lab1.model;


import com.chel.lab1.dao.*;
import com.chel.lab1.entities.*;

import java.util.ArrayList;


public class BetModel {
    private static BetDao betDao = new BetDao();

    public ArrayList<Bet> getAllBets() {
        return betDao.getAll();
    }

    public ArrayList<Bet> getBetsForClient(String clientId) {
        return betDao.getAllForClient(Integer.parseInt(clientId));
     }



    public ArrayList<BetData> getBetsDataForClient(String id) {
        ArrayList<BetData> result = new ArrayList<>();
        ArrayList<Bet> bets = betDao.getAllForClient(Integer.parseInt(id));

        for(Bet bet : bets) {
            result.add(new BetData(bet.getSum(), bet.getState()));
            Participant participant = new ParticipantDao().get(bet.getParticipantId());
            result.get(result.size()-1).setCoeff(participant.getCoeff());
            Rider rider = new RiderDao().get(participant.getRiderId());
            result.get(result.size()-1).setRiderFullName(rider.getFullName());
            Race race = new RaceDao().get(participant.getRaceId());

            race.formatDate();
            System.out.println(race.getDateTime());
            result.get(result.size()-1).setRaceDateTime(race.getDateTime());
            result.get(result.size()-1).setRacePlace(race.getPlace());
        }

        return result;
    }

    public void addBet(Bet bet) {
        ClientModel clientModel = new ClientModel();
        clientModel.subtractFromClient(bet.getClientId(), bet.getSum());
        betDao.save(bet);
    }
}
