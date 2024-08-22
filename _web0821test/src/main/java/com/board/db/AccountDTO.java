package com.board.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AccountDTO {
	private int usernum = 0;
	private String id = "";
	private String pw = "";
	private String name = "";
	private String nickname = "";
	private String adr = "";
	public AccountDTO() {
		super();
	}
	
	
}
