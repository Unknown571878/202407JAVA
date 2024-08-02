package sec01.exam07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadEx {

	public static void main(String[] args) throws IOException {
//		Reader reader = new FileReader("C:/Temp/test7.txt");
		String line = "";
		List<BoardDTO> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/board1.csv"));
		while ((line = br.readLine()) != null) {
			String[] data = line.split(", ");
			list.add(new BoardDTO(0, data[0], data[1], data[2], "", 0));
			System.out.println();
		}
		for(BoardDTO str : list) {
			System.out.println(str);
		}
		br.close();

	}

}
