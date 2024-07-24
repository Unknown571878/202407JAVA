package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	String path[];
	JLabel lb1;
	MyFrame() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Filed field = new Filed();
		Control control = new Control();
		this.add(field, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		this.setBounds(1200, 100, 500, 500);
		this.setVisible(true);
	}

	private class Filed extends JPanel implements Runnable{
		

		public Filed() {
			this.setLayout(new BorderLayout());
			lb1 = new JLabel();
			lb1.setIcon(new ImageIcon("./src/stand.gif"));
			this.add(lb1, BorderLayout.CENTER);
		}

		@Override
		public void run() {
			while(true) {
				String[] path = {"stand.gif"};
				for(int i = 0; i<path.length; i++) {
					lb1.setIcon(new ImageIcon("./src/"+path[i]));
//					System.out.println(i);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private class Control extends JPanel implements ActionListener {
		private JButton standingBtn, walkingBtn, runningBtn;

		public Control() {
			this.setLayout(new FlowLayout());

			standingBtn = new JButton("Standing");
			walkingBtn = new JButton("WalkingBtn");
			runningBtn = new JButton("RunningBtn");

			standingBtn.addActionListener(this);
			walkingBtn.addActionListener(this);
			runningBtn.addActionListener(this);
			this.add(runningBtn);
			this.add(standingBtn);
			this.add(walkingBtn);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == standingBtn) {
				path = new String[] {"stand.gif"};
//				Thread thread = new Thread(new Move());
//				thread.start();
			}else if(e.getSource() == walkingBtn) {
				path = new String[]{"walk1.gif", "walk2.gif"};
//				Thread thread = new Thread(new Move());
//				thread.start();
			}else if(e.getSource() == runningBtn) {
				path = new String[]{"run1.gif", "run2.gif", "run3.gif"};
//				Thread thread = new Thread(new Move());
//				thread.start();
			}
			Thread thread = new Thread(new Move());
			thread.start();

		}

	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
	class Move implements Runnable{

		@Override
		public void run() {
			while(true) {
				for(int i = 0; i<path.length; i++) {
					lb1.setIcon(new ImageIcon("./src/"+path[i]));
//					System.out.println(i);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
