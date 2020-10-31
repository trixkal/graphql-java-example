package com.trixkal.crud.example.resolver;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import com.trixkal.crud.example.pojo.Attendee;
import com.trixkal.crud.example.pojo.Human;
import com.trixkal.crud.example.pojo.Speaker;
import com.trixkal.crud.example.pojo.Talk;
import com.trixkal.crud.example.service.AttendeeService;
import com.trixkal.crud.example.service.SpeakerService;
import com.trixkal.crud.example.service.TalkService;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AttendeeService attendeeService;
    private final SpeakerService speakerService;
    private final TalkService talkService;

    public List<Talk> allTalks() {
        return talkService.findAll();
    }

    public List<Speaker> allSpeakers() {
        return speakerService.findAll();
    }

    public List<Attendee> allAttendees() {
        return attendeeService.findAll();
    }


    public List<Object> allPeople() {
        List<Attendee> attendees = attendeeService.findAll();
        List people = speakerService.findAll();

        people.addAll(attendees);
        return people;
    }

    public List<Human> allHumans() {
        List<Attendee> attendees = attendeeService.findAll();
        List people = speakerService.findAll();

        people.addAll(attendees);
        return people;
    }

}
