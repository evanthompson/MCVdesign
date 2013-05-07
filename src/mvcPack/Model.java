/**
 * A basic model. Lets say it stores integers, and multiplies them.
 * 
 * 
 * @author Evan
 *
 */

package mvcPack;

import java.util.Observable;

public class Model extends Observable {

	private int myNumber;
	
	public Model() {
		myNumber = 0;
	}
	
	
	public void incNumber() {
		myNumber++;
		setChanged();				// Important that these
		notifyObservers(myNumber);	// two lines happen
	}
	
	public void setNumber(int num) {
		myNumber = num;
		setChanged();
		notifyObservers(myNumber);
	}
	public int getNumber() { return myNumber; }
}
