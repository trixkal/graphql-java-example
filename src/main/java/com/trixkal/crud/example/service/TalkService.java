package com.trixkal.crud.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trixkal.crud.example.pojo.*;
import com.trixkal.crud.example.repository.AttendeeTalkRepository;
import com.trixkal.crud.example.repository.SpeakerTalkRepository;
import com.trixkal.crud.example.repository.TalkRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TalkService {

    @Autowired
    private TalkRepository talkRepository;

    @Autowired
    private SpeakerTalkRepository speakerTalkRepository;

    @Autowired
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<com.trixkal.crud.example.pojo.Talk> findAll() {
        return talkRepository.findAll();
    }

    public List<com.trixkal.crud.example.pojo.Talk> findAllTalksBySpeaker(com.trixkal.crud.example.pojo.Speaker speaker) {
        List<com.trixkal.crud.example.pojo.SpeakerTalk> st = speakerTalkRepository.findAllBySpeakerId(speaker.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<com.trixkal.crud.example.pojo.Talk> findAllTAlksByAttendee(com.trixkal.crud.example.pojo.Attendee attendee) {
        List<com.trixkal.crud.example.pojo.AttendeeTalk> st = attendeeTalkRepository.findAllByAttendeeId(attendee.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }
}
