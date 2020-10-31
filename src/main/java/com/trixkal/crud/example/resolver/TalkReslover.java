package com.trixkal.crud.example.resolver;

//import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import com.trixkal.crud.example.pojo.Speaker;
import com.trixkal.crud.example.pojo.Talk;
import com.trixkal.crud.example.service.SpeakerService;

import java.util.List;

@RequiredArgsConstructor
public class TalkReslover implements GraphQLResolver<Talk> {

    private final SpeakerService speakerService;

    public List<Speaker> speakers(Talk talk) {
        return speakerService.findAllSpeakersForTalk(talk);
    }

}
