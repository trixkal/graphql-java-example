package com.trixkal.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trixkal.crud.example.pojo.AttendeeTalk;

import java.util.List;

@Repository
public interface AttendeeTalkRepository extends JpaRepository<AttendeeTalk, Long> {
    List<AttendeeTalk> findAllByAttendeeId(Long attendeeId);

    List<AttendeeTalk> findAllByTalkId(Long talkId);
}
