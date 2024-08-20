package com.board.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
    private int    num     = 0;
    private String writer  = "";
    private String title   = "";
    private String content = "";
    private String regtime = "";
    private int    hits    = 0;
}
