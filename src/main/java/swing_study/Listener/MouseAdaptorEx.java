package swing_study.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MouseAdaptorEx extends JFrame {

	private JPanel contentPane;
	private JLabel la;


	public MouseAdaptorEx() {
		initialize();
	}
	private void initialize() {
		setTitle("마우스 어댑터");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		la = new JLabel("New label");
		la.setBounds(157, 114, 57, 15);
		contentPane.add(la);
		
		contentPane.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setLocation(x, y);
			}
		});
	}
}
