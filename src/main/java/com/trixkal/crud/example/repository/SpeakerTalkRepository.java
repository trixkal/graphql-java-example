package com.trixkal.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trixkal.crud.example.pojo.SpeakerTalk;

import java.util.List;

@Repository
public interface SpeakerTalkRepository extends JpaRepository<SpeakerTalk,Long> {
    List<SpeakerTalk> findAllBySpeakerId(Long speakerId);
    List<SpeakerTalk> findAllByTalkId(Long talkId);
}
