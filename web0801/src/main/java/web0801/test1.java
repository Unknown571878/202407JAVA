package web0801;

public class test1 {
	public static void main(String[] args) {
		AccountDAO dao = new AccountDAO();
		AccountDTO dto = new AccountDTO("이순신", "001224", "010-0000-0101");
		dao.RegistAccount(dto);
	}
}
