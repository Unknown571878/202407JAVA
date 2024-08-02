package drive;

import board.BoardDAO;

public class Ex4 {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(31);

	}

}
