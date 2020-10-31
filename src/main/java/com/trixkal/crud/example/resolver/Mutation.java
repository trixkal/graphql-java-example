package com.trixkal.crud.example.resolver;

//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import com.trixkal.crud.example.pojo.Speaker;
import com.trixkal.crud.example.pojo.SpeakerInput;
import com.trixkal.crud.example.service.SpeakerService;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final SpeakerService speakerService;

    public Speaker addSpeaker(SpeakerInput si ) {
        Speaker speaker  = new Speaker();
        speaker.setName(si.getName());
        speaker.setTwitter(si.getTwitter());

        return speakerService.save(speaker);
    }

}
