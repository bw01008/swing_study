package swing_study.layout;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class PanelBorder extends JPanel {

	public PanelBorder() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel = new JLabel("North");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setOpaque(true);	//jlabel은 기본값이 투명 > 불투명으로 바꾸기
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Center");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("West");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.CYAN);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("East");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_3.setBackground(Color.MAGENTA);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_3, BorderLayout.EAST);
		
		JLabel lblNewLabel_4 = new JLabel("South");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.GREEN);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_4, BorderLayout.SOUTH);
	}

}
