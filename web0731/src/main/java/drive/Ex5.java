package drive;

import board.BoardDAO;
import board.BoardDTO;

public class Ex5 {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(32, "강하늘", "강하늘", "강하늘", "", 0);
		dao.updateBoard(dto);

	}

}
