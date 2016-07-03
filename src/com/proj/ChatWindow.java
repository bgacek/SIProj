package com.proj;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.JButton;

public class ChatWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblWriteYourQuestion;
	private JTextPane textPane;
	private JTextField textArea;
	private JButton btnNewButton;
	private String answer="";
	private String console="";

	public ChatWindow() {
		initialize();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initialize() {
		
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setBounds(100, 100, 900, 950);
		setLayout(null);
	
		lblNewLabel = new JLabel("ChatBox");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 65));
		lblNewLabel.setBounds(181, 11, 397, 67);
		getContentPane().add(lblNewLabel);
		
		textPane = new JTextPane();
		textPane.setBounds(33, 82, 704, 736);
		getContentPane().add(textPane);
		
		lblWriteYourQuestion = new JLabel("Write your question below:");
		lblWriteYourQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWriteYourQuestion.setBounds(33, 829, 345, 24);
		getContentPane().add(lblWriteYourQuestion);
		
		textArea = new JTextField();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setBounds(33, 864, 356, 36);
		getContentPane().add(textArea);
		
		btnNewButton = new JButton("Send message");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setBounds(414, 865, 164, 36);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
	}
	
	public void setConsole(String text)
	{
		console = console + text+"\n";
		textPane.setText(console);
	}

	public String getAnswer()
	{
		return answer;
	}
	
	public String setAnswer(String answer)
	{
		return this.answer =  answer;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnNewButton)
		{
			this.answer = textArea.getText();
		}
	}

	
}
