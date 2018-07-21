import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dialogues");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(329, 11, 235, 343);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(329, 11, 44, 343);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Left");
		btnNewButton.setBounds(31, 115, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Right");
		btnNewButton_1.setBounds(207, 115, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(120, 81, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Down");
		btnNewButton_3.setBounds(120, 149, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Dummy Pos.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(182, 23, 98, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCurrentPosition = new JLabel("Current Position:");
		lblCurrentPosition.setForeground(new Color(220, 20, 60));
		lblCurrentPosition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPosition.setBounds(31, 23, 118, 14);
		frame.getContentPane().add(lblCurrentPosition);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(31, 201, 265, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setBounds(31, 214, 89, 23);
		frame.getContentPane().add(btnAttack);
		
		JButton btnUseHealthPot = new JButton("Use Health Pot");
		btnUseHealthPot.setForeground(new Color(255, 0, 0));
		btnUseHealthPot.setBounds(31, 319, 108, 23);
		frame.getContentPane().add(btnUseHealthPot);
		
		JButton btnUseManaPot = new JButton("Use Mana Pot");
		btnUseManaPot.setForeground(new Color(25, 25, 112));
		btnUseManaPot.setBounds(31, 274, 108, 23);
		frame.getContentPane().add(btnUseManaPot);
		
		JButton btnFlee = new JButton("Flee");
		btnFlee.setBounds(207, 214, 89, 23);
		frame.getContentPane().add(btnFlee);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(128, 128, 128));
		separator_2.setBounds(31, 248, 265, 2);
		frame.getContentPane().add(separator_2);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(207, 297, 89, 23);
		frame.getContentPane().add(btnInventory);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(128, 128, 128));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(171, 274, 2, 68);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(128, 128, 128));
		separator_4.setBounds(31, 56, 265, 2);
		frame.getContentPane().add(separator_4);
	}
}
