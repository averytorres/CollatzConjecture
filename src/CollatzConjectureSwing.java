import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CollatzConjectureSwing extends JFrame {

	public static void main(String args[]) {
		new CollatzConjectureSwing();
	}

	CollatzConjectureSwing() {

		//setting frame settings and layout
		final JFrame frame = new JFrame("Collatz Conjecture");
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int)(dim.getHeight()/2),(int)(dim.getWidth()/4), 500, 100);
		frame.setLayout(new GridLayout(2,2));
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});  

		//setting button functionality
		final CollatzConjecture h = new CollatzConjecture(5);
		final JLabel textArea = new JLabel("Enter a number:");
		final JTextArea textArea2 = new JTextArea("");
		final JLabel result = new JLabel();
		final JScrollPane scroll = new JScrollPane(result);
		scroll.setSize(100, 100);

		JButton submit = new JButton("Submit");

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i;
				CollatzConjecture c;

				try{
						i =Integer.parseInt(textArea2.getText());
						c = new CollatzConjecture(i);
						while(c.getNum()!=1){
							c.HOTPO(c.getNum());
						}
						result.setText(c.getMessage());
						//frame.pack();
				}
				catch(Exception x){
					JOptionPane.showMessageDialog(frame, "Please enter an integer!");
					result.setText("");
					textArea2.setText("");
				}

			}          
		});


		textArea2.setPreferredSize(new Dimension(100, 20));

		//adding the text and button to frame
		frame.add(textArea);
		frame.add(textArea2);
		frame.add(submit);
		frame.add(scroll);

		frame.setVisible(true);

	}
}
