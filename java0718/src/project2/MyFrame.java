package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JLabel la1 = new JLabel("아이디");
	JLabel la2 = new JLabel("SSN");
	JLabel la3 = new JLabel("전화번호");
	JTextField tf1 = new JTextField(5);
	JTextField tf2 = new JTextField(5);
	JTextField tf3 = new JTextField(10);
	JTextArea ta = new JTextArea(20, 40);
	JButton bt1 = new JButton("로그인");
	JButton bt2 = new JButton("회원가입");
	JButton bt3 = new JButton("예금");
	JButton bt4 = new JButton("출금");
	JButton bt5 = new JButton("잔고");
	List<Member> list;
	Member member; // 로그인 된 현재 사용자

	MyFrame() {
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2)); // 배열을 ArrayList로
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			System.out.println(member);
		}
		System.out.println("총회원수:" + list.size());

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		con.add(jp3, BorderLayout.SOUTH);
		jp1.setLayout(new FlowLayout());
		jp2.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		jp1.add(la1);
		jp1.add(tf1);
		jp1.add(la2);
		jp1.add(tf2);
		jp1.add(la3);
		jp1.add(tf3);
		jp2.add(ta);
		jp3.add(bt1);
		jp3.add(bt2);
		jp3.add(bt3);
		jp3.add(bt4);
		jp3.add(bt5);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		this.setBounds(1200, 200, 700, 500);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new JFrameWindowClosingEventHandler());
	}

	public static void main(String[] ar) {
		new MyFrame();
	}

	class JFrameWindowClosingEventHandler extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// 파일 저장 위치
			Member[] list2 = list.toArray(new Member[list.size()]); // ArrayList를 배열로
			try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
		             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				 oos.writeObject(list2);
		         System.out.println("객체를 파일에 저장했습니다.");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JFrame frame = (JFrame) e.getWindow();
			frame.dispose();
			System.out.println("windowClosing()");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt1) {
			String name = tf1.getText(); // name 변수의 값 입력
			String strPassword = tf2.getText();// 패스워드입력

			for (Member member2 : list) {
				if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
					member = member2;
					System.out.println("로그인 성공!!!");
					break;
				}
			}
			System.out.println(member);
		} else if (e.getSource() == bt2) {
			String name = tf1.getText();
			String ssn = tf2.getText();
			String tel = tf3.getText();
			System.out.println("[입력된 내용]");
			System.out.println("1. 이름: " + name);
			System.out.println("2. 주민번호 앞 6자리: " + ssn);
			System.out.println("3. 전화번호: " + tel);
			list.add(new Member(name, ssn, tel));
		} else if (e.getSource() == bt3) {
			System.out.print("예금액> ");
			System.err.println(ta.getText());
			member.deposit(Integer.parseInt(ta.getText()));
		} else if (e.getSource() == bt4) {
			System.out.print("출금액> ");
			System.err.println(ta.getText());
			member.withdraw(Integer.parseInt(ta.getText()));
		} else if (e.getSource() == bt5) {
			System.out.print("잔고> ");
			System.out.println(member.getBalance());
		}
	}

}