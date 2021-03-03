package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrameComponentEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn03;
	private JButton btn02;
	private JButton btn01;
	private JButton btn01_1;

	public FrameComponentEx() {
		initialize();
	}

	private void initialize() {
		setTitle("공통속성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		btn01 = createBtn();
		contentPane.add(btn01);

		btn02 = new JButton("Disabled Button");
		btn02.addActionListener(this);
		btn02.setEnabled(false);
		contentPane.add(btn02);

		btn03 = new JButton("getX(), getY()");
		btn03.addActionListener(this);
		contentPane.add(btn03);
	}

	public JButton createBtn() {
		JButton btn = btn01_1 = new JButton("Magenta /Yellow Button");
		btn01_1.addActionListener(this);
		btn01_1.setFont(new Font("Arial", Font.ITALIC, 20));
		btn01_1.setForeground(Color.MAGENTA);
		btn01_1.setBackground(Color.YELLOW);
		return btn;

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn01_1) {
			actionPerformedBtn01(arg0);
		}
		if (arg0.getSource() == btn02) {
			actionPerformedBtn02(arg0);
		}
		if (arg0.getSource() == btn03) {
			actionPerformedBtn03(arg0);
		}
	}

	protected void actionPerformedBtn03(ActionEvent arg0) {
		JButton btn = (JButton) arg0.getSource(); // 액션 이벤트가 발생한 버튼의 정보(?)를 가져온다.
		FrameComponentEx parent = (FrameComponentEx) btn.getTopLevelAncestor(); // 해당 버튼이 올라가있는 jframe(즉 최상위 부모 컨테이너 리턴)
		parent.setTitle(btn.getX() + ", " + btn.getY()); // 최상위 부모 컨테이너 타이틀에 버튼의 좌표가 뜨도록 설정

		if (btn02.isEnabled()) {
			btn02.setEnabled(false);
		} else {
			btn02.setEnabled(true);
		}
	}

	protected void actionPerformedBtn02(ActionEvent arg0) {
		if (btn01 != null) {
			contentPane.remove(btn01); // 버튼 삭제
			btn01 = null;
			revalidate(); // 삭제된 이후 변경된 내용으로 교체하는 메소드 (refresh)
		} else {
			JButton btn = createBtn(); // 버튼 추가
			contentPane.add(btn, 0);
			revalidate(); // 추가된 이후 변경된 내용으로 교체하는 메소드

		}

	}

	protected void actionPerformedBtn01(ActionEvent arg0) {
		if (btn03.isVisible()) {
			btn03.setVisible(false);
		} else {
			btn03.setVisible(true);
		}
	}
}
