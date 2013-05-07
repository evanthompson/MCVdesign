package mvcPack;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Controller implements ActionListener, KeyListener, MouseListener {

	private Model myModel;
	private View myView;
	
	private final static int start_value = 10;
	
	public Controller() {}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myModel.incNumber();
		System.out.println("Counter: " + myModel.getNumber());
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped: " + e.getKeyChar());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().getClass() == Button.class) {
			System.out.println("Entered: " + ((Button) e.getSource()).getLabel());
			e.getComponent().requestFocusInWindow();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().getClass() == Button.class) {
			System.out.println("Exited: " + ((Button) e.getSource()).getLabel());
			e.getComponent().transferFocusUpCycle();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	
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
		
		newView.addController(newController);
	}


	
	
}
