package id.ac.sgu.homecontroller;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserGUI {
	
	JPanel panel = new ViewerGUIPanel();
	ImageIcon iconWeather;
	
	public void frameInit() throws IOException {
		//create the frame
		JFrame frame = new JFrame("JABLAY HomeCare");
		//Optional what happen when the frame closed?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//addComponent to panel
		//create components and put them in the frame
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		//size the frame
		frame.setSize(1000, 500);
		//show 
		frame.setVisible(true);
	}
	
	public void displayImage() throws IOException {
		BufferedImage bImage = ImageIO.read(new File("./Image/Weather/QuestionMark.png"));
		iconWeather = new ImageIcon(bImage);
	}
	
	
}

