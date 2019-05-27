package com.chel.lab1.model;


import com.chel.lab1.dao.ParticipantDao;
import com.chel.lab1.dao.RaceDao;
import com.chel.lab1.entities.Participant;
import com.chel.lab1.entities.Race;

import java.util.ArrayList;


public class ParticipantModel {
    private static ParticipantDao participantDao = new ParticipantDao();

    public ArrayList<Participant> getAllParticipantsForRace(int id) {
        return participantDao.getAllForRace(id);
    }

    public ArrayList<Participant> getAllParticipants() {
        return participantDao.getAll();
    }

     public Participant getParticipantById(int id) {
        return participantDao.get(id);
     }

     public void deleteParticipantById(int id) {
         participantDao.delete(id);
     }

}
