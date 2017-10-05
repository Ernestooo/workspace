package iterator;

import characters.*;


public class CharactersIteratorClass  implements CharactersIterator{

	private int counter;
	private int currentChar;
	private Characters[] character;
	
	public CharactersIteratorClass(int counter, Characters[] character){
		this.counter = counter;
		this.character = character;
		currentChar = -1;
	}
	
	public void init(){
		currentChar = 0;
	}
	
	public boolean hasNext(){
		return (currentChar >= 0 && currentChar < counter);
	}
	
	public Characters next(){
		return character[currentChar++];
	}
	
	
	public Rebel nextRebel(){
		Rebel res = (Rebel) character[currentChar++];
		searchNextRebel();
		return res;
	}
	
	
	public void searchNextRebel() {
		while (currentChar < counter && !(character[currentChar] instanceof Rebel))
			currentChar++;
	}
	
	public Stormtrooper nextStormtrooper(){
		Stormtrooper res = (Stormtrooper) character[currentChar++];
		searchNextStormtrooper();
		return res;
	}
	
	public void searchNextStormtrooper(){
		while(currentChar < counter && !(character[currentChar] instanceof Stormtrooper))
			currentChar++;
	}

}
