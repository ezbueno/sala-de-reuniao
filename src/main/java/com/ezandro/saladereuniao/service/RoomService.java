package com.ezandro.saladereuniao.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezandro.saladereuniao.dto.RoomDTO;
import com.ezandro.saladereuniao.exception.ResourceNotFoundException;
import com.ezandro.saladereuniao.model.Room;
import com.ezandro.saladereuniao.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public List<RoomDTO> findAllRooms() {
		return roomRepository.findAll().stream().map(room -> new RoomDTO(room)).collect(Collectors.toList());
	}

	public RoomDTO getRoomById(Long roomId) {
		Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
		return new RoomDTO(room);
	}
	
	public RoomDTO saveRoom(RoomDTO roomDTO) {
		Room room = new Room();
		room.setName(roomDTO.getName());
		room.setDate(roomDTO.getDate());
		room.setStartHour(roomDTO.getStartHour());
		room.setEndHour(roomDTO.getEndHour());
		
		room = roomRepository.save(room);
		
		return new RoomDTO(room);
	}
	
	public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
		Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
		
		room.setName(roomDTO.getName());
		room.setDate(roomDTO.getDate());
		room.setStartHour(roomDTO.getStartHour());
		room.setEndHour(roomDTO.getEndHour());
		
		room = roomRepository.save(room);
		
		return new RoomDTO(room);
	}
	
	public void deleteRoomById(Long id) {
		Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
		roomRepository.delete(room);
	}
}
