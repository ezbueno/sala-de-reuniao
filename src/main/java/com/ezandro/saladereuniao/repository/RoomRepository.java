package com.ezandro.saladereuniao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezandro.saladereuniao.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
