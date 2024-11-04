package controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime from;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime to;
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		this.from = from;
	}
	public LocalDateTime getTo() {
		return to;
	}
	public void setTo(LocalDateTime to) {
		this.to = to;
	}
	
	
}
