package com.ezandro.saladereuniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ezandro.saladereuniao.dto.RoomDTO;
import com.ezandro.saladereuniao.service.RoomService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping(value = "/rooms")
	public List<RoomDTO> getAllRooms() {
		return roomService.findAllRooms();
	}
	
	@GetMapping(value = "/rooms/{roomId}")
	public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long roomId) {
		RoomDTO room = roomService.getRoomById(roomId);
		return ResponseEntity.ok().body(room);
	}
	
	@PostMapping(value = "/rooms")
	@ResponseStatus(HttpStatus.CREATED)
	public RoomDTO createRoom(@Valid @RequestBody RoomDTO roomDTO) {
		RoomDTO room = roomService.saveRoom(roomDTO);
		return room;
	}
	
	@PutMapping(value = "/rooms/{roomId}")
	public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long roomId, @Valid @RequestBody RoomDTO roomDTO) {
		RoomDTO room = roomService.updateRoom(roomId, roomDTO);
		return ResponseEntity.ok().body(room);
	}
	
	@DeleteMapping(value = "/rooms/{roomId}")
	public Map<String, Boolean> deleteRoom(@PathVariable Long roomId) {
		roomService.deleteRoomById(roomId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}
