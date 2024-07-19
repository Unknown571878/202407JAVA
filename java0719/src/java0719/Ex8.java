package java0719;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex8 extends JFrame implements ActionListener{
	JTextField tf = new JTextField(30);
	JButton bt = new JButton("확인");
	JTextArea ta = new JTextArea(10,30);
	String URL = "jdbc:mysql://localhost:3306/spring5fs";
	Ex8() {
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
		jp1.add(ta);
		jp2.add(tf);
		jp3.add(bt);
		
		ta.setText("원하시는 테이블을 입력하세요");
		bt.addActionListener(this);
		this.setSize(400,500);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Ex8();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt) {
			if(tf.getText().equals("dept")) {
				String sql = "select * from dept";
				try {
					Connection con = null;
					Statement stmt = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(URL, "spring5", "spring5");
					System.out.println("Mysql 접속 성공!");
					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					String str = "deptno, dname, loc \n\n";
					while(rs.next()) {
						str += rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + "\n";
					}
					ta.setText(str);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}else if (tf.getText().equals("emp")) {
				String sql = "select * from emp";
				try {
					Connection con = null;
					Statement stmt = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(URL, "spring5", "spring5");
					System.out.println("Mysql 접속 성공!");
					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					String str = "empno, ename, job, mgr, hiredate, sal, comm, deptno \n\n";
					while(rs.next()) {
						str += rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3)
						+ ", " + rs.getString(4) + ", " + rs.getString(5)+ ", " + rs.getString(6)
						+ ", " + rs.getString(7) + ", " + rs.getString(8) + "\n";
					}
					ta.setText(str);
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				System.out.println("다시 입력해주세요.");
			}
		}
	}
}
