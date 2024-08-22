package du.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MemberDto {
	private int member_id;
	private String name;
	private String email;
	private String password;
	private String created_at;
	
}
