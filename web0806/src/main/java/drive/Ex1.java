package drive;

import java.util.List;

import dept.DeptDAO;
import dept.DeptDTO;

public class Ex1 {

	public static void main(String[] args) {
		DeptDAO dao2 = new DeptDAO();
		dao2.insertDept(50, "HELLO", "KOREA");
		
		DeptDAO dao = new DeptDAO();
		List<DeptDTO> list = dao.getDeptList();
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}

	}

}
