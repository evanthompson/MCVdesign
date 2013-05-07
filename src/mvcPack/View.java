package mvcPack;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

	private Frame frame;
	private Panel panel;
	private Button button;
	private Button button2;
	private TextField text;
	
	public View() {
		frame = new Frame("simple MVC");
		frame.add("North", new Label("counter"));
		
		panel = new Panel();
		panel.setBackground(Color.gray);
		text = new TextField("Default");
		panel.add(text);
		button = new Button("PressMe");
		panel.add(button);
		button2 = new Button("PressMeToo");
		panel.add(button2);
		frame.add("South", panel);

		frame.addWindowListener(new CloseListener());
		frame.setSize(400,200);
		frame.setLocation(100,100);
		frame.setVisible(true);
		frame.requestFocusInWindow();
	}
	
	@Override
	public void update(Observable obs, Object obj) {
		text.setText(obj.toString());
	}
	
	public void addController(EventListener controller) {
		frame.addKeyListener((KeyListener) controller);
		button.addMouseListener((MouseListener) controller);
		button2.addMouseListener((MouseListener) controller);
		button.addActionListener((ActionListener) controller);
		button2.addActionListener((ActionListener) controller);
	}
	
	
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
	
	public Frame getFrame() { return frame; }
	
}
