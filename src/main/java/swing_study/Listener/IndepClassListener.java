package swing_study.Listener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class IndepClassListener extends JFrame {

	private JPanel contentPane;

	public IndepClassListener() {

		initialize();
	}
	
	private void initialize() {
		setTitle("독립클래스");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btn = new JButton("Action");	//버튼 생성
		btn.addActionListener(new MyActionListner());
		contentPane.add(btn, BorderLayout.CENTER);	//컨텐트 페인에 버튼 추가(보더레이아웃 중앙에)
	}

}

class MyActionListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);	//ActionEvent가 발생한 버튼의 정보가 찍힌다.
		JButton btn = (JButton) e.getSource();
		if(e.getActionCommand().equals("Action")) {
			btn.setText("액션");
		}else {
			btn.setText("Action");
		}
	}
	
}
