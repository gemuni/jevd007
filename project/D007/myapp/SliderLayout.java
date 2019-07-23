package myapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SliderLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JSlider slider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderLayout frame = new SliderLayout();
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
	public SliderLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Draw slider
		this.drawSlider();
		
		//Draw text box
		this.drawTextBox();
		
		SoundControl.setVolume(30);
		
	}
	
	/**
	 * Draw slider
	 */
	protected void drawSlider() {
		slider = new JSlider();
		slider.setValue(0);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int sliderVal = slider.getValue();
				textField.setText(String.valueOf(sliderVal));
			}
		});
		
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		
		slider.setPaintLabels(true);
		slider.setBounds(133, 170, 391, 42);
		slider.setLabelTable(slider.createStandardLabels(10));
		contentPane.add(slider);
	}
	
	/**
	 * Draw text box
	 */
	protected void drawTextBox() {
		textField = new JTextField();
		textField.setText("0");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = textField.getText();
				slider.setValue(Integer.valueOf(val));
			}
		});
		textField.setBounds(192, 127, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGiTr = new JLabel("Gi\u00E1 Tr\u1ECB");
		lblGiTr.setBounds(133, 130, 49, 14);
		contentPane.add(lblGiTr);
	}
}
