package items;

import entities.EntitiesClass;

public class PotionClass extends EntitiesClass implements Potion {

	public PotionClass() {
	}

	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return Potion.POTION;
	}

}
