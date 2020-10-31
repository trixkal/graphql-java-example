package com.trixkal.crud.example.repository;

import org.springframework.stereotype.Repository;
import com.trixkal.crud.example.pojo.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
