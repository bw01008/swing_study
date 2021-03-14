package swing_study.JOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JOptionPaneConfirmEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnConfirm;
	private JLabel lblComfirm;

	public JOptionPaneConfirmEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Confirm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblComfirm = new JLabel("JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType, icon)");
		contentPane.add(lblComfirm);
		
		btnConfirm = new JButton("\"누르시오\"");
		btnConfirm.addActionListener(this);
		contentPane.add(btnConfirm);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		/*
		 * public static int showConfirmDialog(Component parentComponent,
                                    Object message,
                                    String title,
                                    int optionType,
                                    int messageType,
                                    Icon icon)
                             throws HeadlessException
           
           optiontype = YES_NO_OPTION, YES_NO_CANCEL_OPTION,or OK_CANCEL_OPTION
           
		 */
		String path = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(path + "icon01.png");
		// int로 받는 이유는 예 선택시, 0 아니오 선택시, 1 취소 누르면 2, 닫기 누르면 -1이 반환된다.
		int res = JOptionPane.showConfirmDialog(
				null, 
				"계속할것입니까?", //출력되는 메시지
				"Confirm", //팝업창 타이틀(제목)
				JOptionPane.YES_NO_CANCEL_OPTION, //버튼 옵션
				JOptionPane.WARNING_MESSAGE, //메시지 타입
				icon); //사용자 지정 아이콘설정 
		
		if(res == JOptionPane.YES_OPTION) {
			lblComfirm.setText("Yes");
		}
		if(res == JOptionPane.NO_OPTION) {
			lblComfirm.setText("No");
		}
		if(res == JOptionPane.CANCEL_OPTION){
			lblComfirm.setText("Cancel");
		}
		if(res == -1) {
			lblComfirm.setText("선택하지 않음");
		}
	}
}
