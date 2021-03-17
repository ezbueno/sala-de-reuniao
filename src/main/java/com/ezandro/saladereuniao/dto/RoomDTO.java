package com.ezandro.saladereuniao.dto;

import java.io.Serializable;

import com.ezandro.saladereuniao.model.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO implements Serializable {

	private Long id;
	private String name;
	private String date;
	private String startHour;
	private String endHour;
	
	public RoomDTO(Room entity) {
		id = entity.getId();
		name = entity.getName();
		date = entity.getDate();
		startHour = entity.getStartHour();
		endHour = entity.getEndHour();  
	}
	
}
