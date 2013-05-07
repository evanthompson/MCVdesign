package mvcPack;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

	private Frame frame;
	private Button button;
	
	public View() {
		frame = new Frame("simple MVC");
		frame.add("North", new Label("counter"));


		//panel in constructor and not an attribute as doesn't need to be visible to whole class
		Panel panel = new Panel();
		button = new Button("PressMe");
		panel.add(button);
		frame.add("South", panel);

		frame.addWindowListener(new CloseListener());
		frame.setSize(200,100);
		frame.setLocation(100,100);
		frame.setVisible(true);
		
	}
	
	@Override
	public void update(Observable obs, Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void addController(ActionListener controller, KeyListener controller2) {
		button.addActionListener(controller);
		frame.addKeyListener(controller2);
	}

	
	
	/* Figure out the properties of WindowAdapter, and why this class is here */
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
	
	public Frame getFrame() { return frame; }
	
}
