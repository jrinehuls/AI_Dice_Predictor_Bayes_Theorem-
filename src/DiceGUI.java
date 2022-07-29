import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class DiceGUI extends JFrame implements ActionListener {
	
	Calculations calc  = new Calculations();
	int roll;
	int four = (int)(100*calc.prob_four);
	int six = (int)(100*calc.prob_six);
	int eight = (int)(100*calc.prob_eight);
	int twelve = (int)(100*calc.prob_twelve);
	int twenty = (int)(100*calc.prob_twenty);
	int certainty = 85;
	
	JPanel panel;
	JLabel label_four;
	JLabel label_six;
	JLabel label_eight;
	JLabel label_twelve;
	JLabel label_twenty;
	JLabel rollLabel;
	JLabel invalid;
	
	JProgressBar pb_four;
	JProgressBar pb_six;
	JProgressBar pb_eight;
	JProgressBar pb_twelve;
	JProgressBar pb_twenty;
	
	JTextField textField;
	
	JButton button;
	
	DiceGUI(){
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(500,500));
		//this.add(panel);
		
		label_four = new JLabel("Probability of 4-sided die:");
		label_four.setBounds(50, 50, 150, 25);
		this.add(label_four);
		pb_four = new JProgressBar();
		pb_four.setBounds(225, 50, 200, 25);
		this.add(pb_four);
		pb_four.setValue(four);
		pb_four.setStringPainted(true);
		
		label_six = new JLabel("Probability of 6-sided die:");
		label_six.setBounds(50, 100, 150, 25);
		this.add(label_six);
		pb_six = new JProgressBar();
		pb_six.setBounds(225, 100, 200, 25);
		this.add(pb_six);
		pb_six.setValue(six);
		pb_six.setStringPainted(true);
		
		label_eight = new JLabel("Probability of 8-sided die:");
		label_eight.setBounds(50, 150, 150, 25);
		this.add(label_eight);
		pb_eight = new JProgressBar();
		pb_eight.setBounds(225, 150, 200, 25);
		this.add(pb_eight);
		pb_eight.setValue(eight);
		pb_eight.setStringPainted(true);
		
		label_twelve = new JLabel("Probability of 12-sided die:");
		label_twelve.setBounds(50, 200, 150, 25);
		this.add(label_twelve);
		pb_twelve = new JProgressBar();
		pb_twelve.setBounds(225, 200, 200, 25);
		this.add(pb_twelve);
		pb_twelve.setValue(twelve);
		pb_twelve.setStringPainted(true);
		
		label_twenty = new JLabel("Probability of 20-sided die:");
		label_twenty.setBounds(50, 250, 150, 25);
		this.add(label_twenty);
		pb_twenty = new JProgressBar();
		pb_twenty.setBounds(225, 250, 200, 25);
		this.add(pb_twenty);
		pb_twenty.setValue(twenty);
		pb_twenty.setStringPainted(true);	
		
		rollLabel = new JLabel("Enter the roll result here:");
		rollLabel.setBounds(50, 300, 150, 25);
		this.add(rollLabel);
		textField = new JTextField();
		textField.setBounds(225, 300, 200, 25);
		this.add(textField);
		
		button = new JButton("Submit");
		button.setBounds(200, 350,100, 25);
		button.setFocusable(false);
		button.addActionListener(this);
		
		invalid = new JLabel("ERROR: Enter a number between 1 and 20");
		invalid.setForeground(Color.RED);
		invalid.setBounds(125, 400, 250, 25);
		this.add(invalid);
		invalid.setVisible(false);
		
		this.add(button);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setLayout(null); // Doesn't seem to do anything.
		this.setVisible(true);
	}
	
	public void redo() {
		four = (int)(100*calc.prob_four);
		pb_four.setValue(four);
		six = (int)(100*calc.prob_six);
		pb_six.setValue(six);
		eight = (int)(100*calc.prob_eight);
		pb_eight.setValue(eight);
		twelve = (int)(100*calc.prob_twelve);
		pb_twelve.setValue(twelve);
		twenty = (int)(100*calc.prob_twenty);
		pb_twenty.setValue(twenty);
		invalid.setVisible(false);
	}
	
	public void finish() {
		if(four >= certainty) {
			invalid.setText("You're using a four sided die");
		}
		if(six >= certainty) {
			invalid.setText("You're using a six sided die");
		}
		if(eight >= certainty) {
			invalid.setText("You're using a eight sided die");
		}
		if(twelve >= certainty) {
			invalid.setText("You're using a twelve sided die");
		}
		if(twenty >= certainty) {
			invalid.setText("You're using a twenty sided die");
		}
		if(four >= certainty || six >= certainty || eight >= certainty || twelve >= certainty || twenty >= certainty) {
			invalid.setForeground(Color.BLACK);
			invalid.setBounds(175, 400, 250, 25);
			invalid.setVisible(true);
			textField.setEnabled(false);
			button.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			try{
				roll = Integer.parseInt(textField.getText());
			} catch (NumberFormatException n) {
				invalid.setVisible(true);
				roll = 0;
			}
				if(roll >= 1 && roll <= 20) {
					calc.calculateProbability(roll);
					redo();
					finish();
				}
				else {
					invalid.setVisible(true);
				}
			textField.setText(null);
		}
	}
}