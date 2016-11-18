package array.view;

import java.awt.Color;
import javax.swing.*;
import array.controller.ArrayController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HipsterPanel extends JPanel
{
	private ArrayController baseController;
	private JButton myButton;
	private JComboBox dropDown;
	private JLabel wordsLabel;
	private SpringLayout baseLayout;
	
	public HipsterPanel(ArrayController baseController)
	{
		super();
		this.baseController = baseController;
		myButton = new JButton("Click here");
		wordsLabel = new JLabel("such words!");
		baseLayout = new SpringLayout();
		dropDown = new JComboBox(baseController.getHipsters());
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(myButton);
		this.add(wordsLabel);
		this.add(dropDown);
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		dropDown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String selectedText = baseController.getHipsters()[dropDown.getSelectedIndex()].toString();
				wordsLabel.setText(selectedText);
			}
		});
		
		myButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.impactHipsters();
				wordsLabel.setText(baseController.getHipsters()[dropDown.getSelectedIndex()].toString());
				repaint();
			}
		});
	}
	
}
