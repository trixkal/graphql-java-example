package com.trixkal.crud.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trixkal.crud.example.pojo.Attendee;
import com.trixkal.crud.example.pojo.AttendeeTalk;
import com.trixkal.crud.example.pojo.Talk;
import com.trixkal.crud.example.repository.AttendeeRepository;
import com.trixkal.crud.example.repository.AttendeeTalkRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<Attendee> findAll() {
        return attendeeRepository.findAll();
    }

    public List<Attendee> findAllAttendiesForTalk(Talk talk) {
        List<AttendeeTalk> at = attendeeTalkRepository.findAllByTalkId(talk.getId());

        return at.stream()
                .map(e -> attendeeRepository.findById(e.getAttendeeId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Attendee save(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }
}
