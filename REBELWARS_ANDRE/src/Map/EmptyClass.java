package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */


import Character.Rebel;
import Character.Stormtropper;
import Character.StormtropperB;
import Character.StormtropperBClass;
import Character.StormtropperO;
import Character.StormtropperOClass;
import Character.StormtropperW;
import Character.StormtropperWClass;
import Item.Gun;
import Item.GunClass;
import Item.Potion;
import Item.PotionClass;

public class EmptyClass extends CellAbstractClass implements Empty {
	private Rebel rebel;
	private Gun gun;
	private Potion potion;
	private StormtropperB stormB;
	private StormtropperW stormW;
	private StormtropperO stormO;

	
	
	public EmptyClass(int r, int c) {
		super(r,c);
		rebel = null;
		gun = null;
		potion = null;
		stormB = null;
		stormW = null;
		stormO = null;
		
	}

	@SuppressWarnings("static-access")
	@Override
	public char symbol() {
		if (rebel != null && rebel.getStatus().equals("SUPERCHARGED")) {
			return rebel.REBEL_SUPER;
		}
		else if(stormB != null) {
			return StormtropperB.STORM_B;
			
		} else if(stormW != null) {
			return StormtropperW.STORM_W;
			
		} else if(stormO != null) {
			return StormtropperO.STORM_O;
			
		
			
		} else if (rebel!=null){
			
				return rebel.REBEL;
		
		} else if (gun!=null){
			return Gun.GUN;
			
		} else if (potion!=null){
			return Potion.POTION;
			
		}
			else return Empty.EMPTY;
	}

	@Override
	public void arrive(Rebel rebel) {
		this.rebel=rebel;
		
	}


	@Override
	public void addGun() {
		gun=new GunClass();
	 
		
	}

	@Override
	public void addPotion() {
		potion=new PotionClass();
		
	}

	@Override
	public void interact() {
		if(rebel != null && stormB != null) {
			
			if(rebel.hasPotion()) {
				((Stormtropper) stormB).captured();
				stormB = null;
			} else {
				rebel.gotCaptured();
				((Stormtropper) stormB).addCapturedRebel(rebel);
				rebel = null;
			}

			
		} else if(rebel != null && stormW != null) {

			if(rebel.hasPotion()) {
				((Stormtropper) stormW).captured();
				stormW = null;
			} else {
				rebel.gotCaptured();
				((Stormtropper) stormW).addCapturedRebel(rebel);
				rebel = null;
			}
			
			
		} else if(rebel!= null && stormO != null) {
			if(rebel.hasPotion()) {
				((Stormtropper) stormO).captured();
				stormO = null;
			} else {
				rebel.gotCaptured();
				((Stormtropper) stormO).addCapturedRebel(rebel);
				rebel = null;
			}
			
			
		} else if(rebel != null && gun != null) {
			rebel.addPontuation();
			removeGun();
			
		} else if(rebel != null && potion != null) {
			
			rebel.gotPotion();
			removePotion();
			
		}
		
	}

	@Override
	public void addStormO(int r, int c, int tag) {
		stormO = new StormtropperOClass(r, c, tag);
		
		
	}

	@Override
	public void addStormW(int r,int c, int tag) {
		stormW = new StormtropperWClass(r, c, tag);
		
		
	}

	@Override
	public void addStormB(int r,int c, int tag) {
		stormB = new StormtropperBClass(r, c, tag);
		
		
	}
	
	@Override
	public boolean canMove() {
		if (rebel!=null)
			return false;
		return true;
	}

	@Override
	public void leave() {
		rebel = null;
		
	}
	
	@Override
	public void removeGun() {
		gun = null;
	}

	@Override
	public void removePotion() {
		potion = null;
		
	}

	@Override
	public Stormtropper returnStorm() {
		if (stormB!=null)
			return (Stormtropper) stormB;
		else if (stormO!=null)
			return (Stormtropper) stormO;
		else if(stormW!=null)
			return (Stormtropper) stormW;
		return null;
		
	}

	@Override
	public boolean canMoveStorm() {
		if (stormB!=null){
		return false;}
	else if (stormO!=null)
		return false;
	else if(stormW!=null)
		return false;
	else return true;
	}

	@Override
	public void leaveStorm() {
			stormB=null;
			stormO=null;
			stormW=null;
	}

	@Override
	public void arriveStorm(Stormtropper storm) {
		if (storm.getColour()=='B')
			stormB=(StormtropperB) storm;
		else if (storm.getColour()=='W')
			stormW=(StormtropperW) storm;
		else if(storm.getColour()=='O'){
			stormO=(StormtropperO) storm;
		}
		
		
	}

}