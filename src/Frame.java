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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JLabel amountOfWords;
	private JLabel uniqueWords;
	private JLabel palindromeWords;
	private JLabel avgWordLength;

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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{424, 0};
		gbl_panel.rowHeights = new int[] {14, 14, 14, 14};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		amountOfWords = new JLabel("Amount of words: ");
		amountOfWords.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_amountOfWords = new GridBagConstraints();
		gbc_amountOfWords.anchor = GridBagConstraints.NORTH;
		gbc_amountOfWords.fill = GridBagConstraints.HORIZONTAL;
		gbc_amountOfWords.insets = new Insets(0, 0, 5, 0);
		gbc_amountOfWords.gridx = 0;
		gbc_amountOfWords.gridy = 0;
		panel.add(amountOfWords, gbc_amountOfWords);
		
		uniqueWords = new JLabel("Number of unique words: ");
		uniqueWords.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_uniqueWords = new GridBagConstraints();
		gbc_uniqueWords.insets = new Insets(0, 0, 5, 0);
		gbc_uniqueWords.fill = GridBagConstraints.HORIZONTAL;
		gbc_uniqueWords.anchor = GridBagConstraints.NORTH;
		gbc_uniqueWords.gridx = 0;
		gbc_uniqueWords.gridy = 1;
		panel.add(uniqueWords, gbc_uniqueWords);
		
		palindromeWords = new JLabel("Number of Palindrome words: ");
		GridBagConstraints gbc_palindromeWords = new GridBagConstraints();
		gbc_palindromeWords.insets = new Insets(0, 0, 5, 0);
		gbc_palindromeWords.anchor = GridBagConstraints.NORTHWEST;
		gbc_palindromeWords.gridx = 0;
		gbc_palindromeWords.gridy = 3;
		panel.add(palindromeWords, gbc_palindromeWords);
		
		avgWordLength = new JLabel("Average word length: ");
		GridBagConstraints gbc_avgWordLength = new GridBagConstraints();
		gbc_avgWordLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_avgWordLength.insets = new Insets(0, 0, 5, 0);
		gbc_avgWordLength.anchor = GridBagConstraints.NORTH;
		gbc_avgWordLength.gridx = 0;
		gbc_avgWordLength.gridy = 4;
		panel.add(avgWordLength, gbc_avgWordLength);
		
		
		analyzeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TextAnalyzer analyzer = new TextAnalyzer(textField.getText());
				amountOfWords.setText(amountOfWords.getText() + analyzer.countWords());
				uniqueWords.setText(uniqueWords.getText() + analyzer.countUniqueWords());
				palindromeWords.setText(palindromeWords.getText() + analyzer.coundPalindromes());
				avgWordLength.setText(avgWordLength.getText() + analyzer.calculateAvgLength());
			}
		});
	}

}
