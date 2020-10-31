package com.trixkal.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trixkal.crud.example.pojo.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
}
