package edu.mum.cs.cs525.labs.exercises.project.ui.bank;
/*
		A basic implementation of the JDialog class.
*/

import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.CardFrm;

import javax.swing.*;

public class JDialogReport extends JDialog
{
    String billstring;

	public JDialogReport(BankFrm parent)
	{
		super(parent);
		
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		//JScrollPane1.getViewport().add(JTextField1);
		//JTextField1.setBounds(0,0,355,237);

		JTextArea1.setText(parent.accountService.generateReport());
		JTextArea1.setEditable(false);
		JTextArea1.setLineWrap(true);
		JTextArea1.setWrapStyleWord(true);

		JScrollPane1.getViewport().add(JTextArea1);
		JTextArea1.setBounds(0, 0, 490, 237);


		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		// generate the string for the monthly bill

		//JTextField1.setText(parent.accountService.generateReport());
		//}}
	
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		//}}
	}



	//{{DECLARE_CONTROLS
	JScrollPane JScrollPane1 = new JScrollPane();
	JTextField JTextField1 = new JTextField();
	JButton JButton_OK = new JButton();
	javax.swing.JTextArea JTextArea1 = new javax.swing.JTextArea();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}