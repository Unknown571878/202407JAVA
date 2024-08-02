package java0730;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("신용권", 85);
		map.put("신용권", 86);
		map.put("신용권", 87);
		map.put("홍길동", 88);
		System.out.println(map.size());
		System.out.println(map.get("신용권"));

		Set<String> kk = map.keySet();
		for (String aa : kk) {
			System.out.println(aa);
			System.out.println(map.get(kk));
		}

		Set<Map.Entry<String, Integer>> zz = map.entrySet();
		for (Map.Entry<String, Integer> kv : zz) {
			String k = kv.getKey();
			int v = kv.getValue();
			String msg = MessageFormat.format("{0}, {1}", k, v);
			System.out.println(msg); //포멧해서 호출
			System.out.println(k); //key만 호출
			System.out.println(v); //value만 호출
			System.out.println(kv);
		}
	}

}
