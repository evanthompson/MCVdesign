package mvcPack;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller implements ActionListener, KeyListener {

	private Model myModel;
	private View myView;
	
	private final static int start_value = 10;
	
	public Controller() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("e.class: " + e.getClass());
		System.out.println("Action: " + e.getActionCommand());
		System.out.println("Counter: " + myModel.getNumber());
		
		myModel.incNumber();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped : " + e.getKeyChar());
	}
	
	
	public void addModel(Model m) {
		myModel = m;
	}
	
	public void addView(View v) {
		myView = v;
	}
	
	public void initModel(int x) {
		myModel.setNumber(x);
	}
	
	public static void main(String[] args) {
		Model newModel = new Model();
		View newView = new View();		
		
		newModel.addObserver(newView);
		
		Controller newController = new Controller();
		newController.addModel(newModel);
		newController.addView(newView);
		newController.initModel(start_value);
		
		newView.addController(newController, newController);
	}
	
}
