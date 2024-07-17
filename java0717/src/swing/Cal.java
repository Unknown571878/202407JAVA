package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal extends JFrame implements ActionListener{

	JLabel la1 = new JLabel("계산기");
	JLabel la2 = new JLabel("계산결과:");
	JTextField tf1 = new JTextField(5);
	JTextField tf2 = new JTextField(5);
	JButton jb1 = new JButton("+");
	JButton jb2 = new JButton("-");
	JButton jb3 = new JButton("*");
	JButton jb4 = new JButton("/");

	Cal() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());

		jp1.add(la1);
		jp2.add(la2);
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.SOUTH);
		jp3.add(tf1);
		jp3.add(tf2);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		con.add(jp3, BorderLayout.CENTER);
		jp3.setLayout(new GridLayout(3, 2, 20, 20));

		this.setTitle("계산기");
		this.setLocation(1000, 200);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new Cal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getSource());
		if(e.getSource() == jb1) {
			System.out.println("+");
		}else if(e.getSource() == jb2) {
			System.out.println("-");
		}else if(e.getSource() == jb3) {
			System.out.println("*");
		}else if(e.getSource() == jb4) {
			System.out.println("/");
		}
		
	}

}
