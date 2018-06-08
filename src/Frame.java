import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JLabel amountOfWords;
	private JLabel uniqueWords;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton analyzeButton = new JButton("ANALYZE");
		analyzeButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.add(analyzeButton);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		amountOfWords = new JLabel("Amount of words: ");
		amountOfWords.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(amountOfWords, BorderLayout.NORTH);
		
		uniqueWords = new JLabel("Number of unique words: ");
		uniqueWords.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(uniqueWords, BorderLayout.CENTER);
		
		
		analyzeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TextAnalyzer analyzer = new TextAnalyzer(textField.getText());
				amountOfWords.setText(amountOfWords.getText() + analyzer.countWords());
				uniqueWords.setText(uniqueWords.getText() + analyzer.countUniqueWords());
			}
		});
	}

}
