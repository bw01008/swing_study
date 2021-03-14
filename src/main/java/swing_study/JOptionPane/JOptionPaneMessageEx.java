package swing_study.JOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JOptionPaneMessageEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn;

	public JOptionPaneMessageEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Message");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 132);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRes = new JLabel("메시지");
		contentPane.add(lblRes, BorderLayout.CENTER);
		
		btn = new JButton("클릭");
		btn.addActionListener(this);
		contentPane.add(btn, BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			actionPerformedBtn(e);
		}
	}
	protected void actionPerformedBtn(ActionEvent e) {
		String path = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(path + "icon03.png");
		
		JOptionPane.showMessageDialog(
				null, 
				"조심하세요!!", //출력되는 메시지
				"경고", //팝업창 타이틀(제목)
				JOptionPane.WARNING_MESSAGE, //메시지타입
				icon);	// 사용자 지정 이미지
	}
}
