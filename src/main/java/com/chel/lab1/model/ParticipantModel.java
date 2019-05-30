package com.chel.lab1.model;


import com.chel.lab1.dao.ParticipantDao;
import com.chel.lab1.dao.RaceDao;
import com.chel.lab1.entities.Participant;
import com.chel.lab1.entities.Race;

import java.util.ArrayList;


public class ParticipantModel {
    private static ParticipantModel instance = ParticipantModel.getInstance();

    private ParticipantModel() { };

    public static ParticipantModel getInstance() {
        return instance;
    }


    private static ParticipantDao participantDao = ParticipantDao.getInstance();

    public Iterable<Participant> getAllParticipantsForRace(int id) {
        return participantDao.getAllForRace(id);
    }

    public Iterable<Participant> getAllParticipants() {
        return participantDao.getAll();
    }

    public Participant getParticipantById(int id) {
        return participantDao.get(id);
     }

    public void deleteParticipantById(int id) {
         participantDao.delete(id);
     }

}
