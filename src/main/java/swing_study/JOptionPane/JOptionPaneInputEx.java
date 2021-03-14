package swing_study.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JOptionPaneInputEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JLabel lblRes;
	private JButton btn2;
	private JLabel lblRes2;
	private JButton btn3;
	private JLabel lblRes3;
	private JButton btn4;
	private JLabel lblRes4;

	public JOptionPaneInputEx() {
		initialize();
	}

	private void initialize() {
		setTitle("입력");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1248, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		btn1 = new JButton("JOptionPane.showInputDialog(Object message);");
		btn1.addActionListener(this);
		contentPane.add(btn1);

		lblRes = new JLabel("");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes);

		btn2 = new JButton("JOptionPane.showInputDialog(message, initialSelectionValue);");
		btn2.addActionListener(this);
		contentPane.add(btn2);

		lblRes2 = new JLabel("");
		lblRes2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes2.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes2);

		btn3 = new JButton("JOptionPane.showInputDialog(parentComponent, message, title, messageType)");
		btn3.addActionListener(this);
		contentPane.add(btn3);

		lblRes3 = new JLabel("");
		lblRes3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes3.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes3);

		btn4 = new JButton("JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue)");
		btn4.addActionListener(this);
		contentPane.add(btn4);

		lblRes4 = new JLabel("");
		lblRes4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes4.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			actionPerformedBtn4(e);
		}
		if (e.getSource() == btn3) {
			actionPerformedBtn3(e);
		} // 입력값없이 취소했을때 널포인트 익셉션 예외처리해줘야한다.
		try {
			if (e.getSource() == btn2) {
				actionPerformedBtn2(e);
			}
			if (e.getSource() == btn1) {
				actionPerformedBtn1(e);
			}
		} catch (NullPointerException e1) {
//			e1.printStackTrace();
		}
	}

	// 취소하거나 입력없이 확인하면 null이 들어간다.
	protected void actionPerformedBtn1(ActionEvent e) {
		String res = JOptionPane.showInputDialog("이름을 입력");
		System.out.println(res);
		if (res.length() == 0) {
			lblRes.setText("입력값은 없습니다.");
		} else {
			lblRes.setText("내이름은 " + res);
		}

	}

	// input을 하고 미리 텍스트 설정해둠(기본값 들어가있음)
	protected void actionPerformedBtn2(ActionEvent e) {
		String res = JOptionPane.showInputDialog("이름을 입력", "유한솔");
		System.out.println(res);
		if (res != null) {
			lblRes2.setText("내이름은 " + res);
		}
	}

	// 메시지 아이콘 설정(6가지 중에 사용가능)
	protected void actionPerformedBtn3(ActionEvent e) {
		/*
		•ERROR_MESSAGE 
		•INFORMATION_MESSAGE 
		•WARNING_MESSAGE 
		•QUESTION_MESSAGE 
		•PLAIN_MESSAGE 
		*/
		
		String res = JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.PLAIN_MESSAGE);
		lblRes3.setText("입력값은 " + res);

	}
	//메시지 아이콘 사용자설정
	protected void actionPerformedBtn4(ActionEvent e) {
		/*public static Object showInputDialog(Component parentComponent,
        Object message,
        String title,
        int messageType,
        Icon icon,
        Object[] selectionValues,
        Object initialSelectionValue)
		 */
		String path = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(path + "icon01.png");
		
		String[] selectionValues = {"박유진", "유한솔", "송명훈", "이나연", "우정아"};	//선택옵션
		String initialSelectionValue = "박유진"; //기본값
		Object res = JOptionPane.showInputDialog(
				null, 
				"이름을 선택하세요.", 
				"이름선택", 
				JOptionPane.QUESTION_MESSAGE, 
				icon, 
				selectionValues, 
				initialSelectionValue);
		
		lblRes4.setText("선택한 이름은 " + res);
		
	}
}
