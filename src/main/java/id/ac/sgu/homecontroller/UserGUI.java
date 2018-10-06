package id.ac.sgu.homecontroller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserGUI {
	
	JLabel label = new JLabel();
	
	public void frameInit() {
		//create the frame
		JFrame frame = new JFrame("JABLAY HomeCare");
		//Optional what happen when the frame closed?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create components and put them in the frame
		//create empty label
		frame.getContentPane().add(label, BorderLayout.CENTER);
		//size the frame
		frame.setSize(1000, 500);
		//show 
		frame.setVisible(true);
	}
	
	public void labelInit(){
		JLabel tempOutsideLabel = new JLabel("Temperature Outside = ");
		JLabel windPressureLabel = new JLabel("Wind Pressure = ");
		JLabel setTempLabel = new JLabel("Set Temp " );
		JLabel Blind = new JLabel("BLinds " );
		
		//label.add(JLabel);
	}
	
}
