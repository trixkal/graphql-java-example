package com.trixkal.crud.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trixkal.crud.example.pojo.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
