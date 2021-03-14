package swing_study.Listener;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MouseListenerEx extends JFrame {

	private JPanel contentPane;
	private JLabel lblHello;

	public MouseListenerEx() {
		initialize();
	}

	private void initialize() {
		setTitle("마우스 리스너");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(250, 250);
		setVisible(true);

		lblHello = new JLabel("Hello");
		lblHello.setBounds(176, 98, 57, 15);
		lblHello.setSize(50, 20);
		lblHello.setLocation(30, 30);
		contentPane.add(lblHello);
	}

	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// 마우스로 프레임 안을 눌렀을 때 누른 위치의 좌표를 가져와서 레이블의 세팅위치로 삼는다.
			int x = e.getX();
			int y = e.getY();
			lblHello.setLocation(x, y);

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		public void main(String[] args) {

		}
	}// end of class

}
