package map;

import characters.*;
import entities.Entities;
import items.*;

public class EmptySpaceClass extends LocationAbstractClass implements EmptySpace {
	
	private Gun gun;
	private Potion potion;
	private Rebel rebel;
	private StormtrooperBlack stormtrooperB;
	private StormtrooperWhite stormtrooperW;
	private StormtrooperOrange stormtrooperO;
	
	public EmptySpaceClass(int r, int c){
		super(r,c);
		gun = null;
		potion = null;
		stormtrooperB = null; 
		stormtrooperW = null;
		stormtrooperO = null;
		rebel = null;
		
		//emptySpace = ;
	}

	@Override
	public char symbol() {
		char c = interact();
		return c;
	}
	
	
	@SuppressWarnings("static-access")
	public char interact(){
		char c = ' ';
		if(rebel != null && stormtrooperB != null && gun != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperB);
				rebel.captureGun();
				removeGun();
				removeStormtrooper();
			}
			else{
				c = stormtrooperB.symbol();
				stormtrooperB.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperW != null && gun != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperW);
				rebel.captureGun();
				removeGun();
				removeStormtrooper();
			}
			else{
				c = stormtrooperW.symbol();
				stormtrooperW.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperO != null && gun != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperO);
				rebel.captureGun();
				removeGun();
				removeStormtrooper();
			}
			else{
				c = stormtrooperO.symbol();
				stormtrooperO.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperB != null && potion != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperB);
				removeStormtrooper();
			}
			else{
				c = stormtrooperB.symbol();
				stormtrooperB.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperO != null && potion != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperO);
				removeStormtrooper();
			}
			else{
				c = stormtrooperO.symbol();
				stormtrooperO.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperW != null && potion != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperW);
				removeStormtrooper();
			}
			else{
				c = stormtrooperW.symbol();
				stormtrooperW.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperB != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperB);
				removeStormtrooper();
			}
			else{
				c = stormtrooperB.symbol();
				stormtrooperB.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperW != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperW);
				removeStormtrooper();
			}
			else{
				c = stormtrooperW.symbol();
				stormtrooperW.captureRebel(rebel);
				removeRebel();
			}
		}
		else if(rebel != null && stormtrooperO != null){
			if(rebel.isSuperCharged()){
				c = rebel.SUPERCHARGED;
				rebel.captureStorm(stormtrooperO);
				removeStormtrooper();
			}
			else{
				c = stormtrooperO.symbol();
				stormtrooperO.captureRebel(rebel);
				removeRebel();
			}
		}
		
		else if(rebel != null && gun != null){
			if(rebel.isSuperCharged())
				c = rebel.SUPERCHARGED;
			else
				c = rebel.symbol();
			removeGun();
		}
		else if(rebel != null && potion != null){
			if(!rebel.isSuperCharged())
				rebel.drinkPotion();
			c = rebel.SUPERCHARGED;
			removePotion();
		}
		
		else if(stormtrooperB != null && gun != null){
			c = stormtrooperB.symbol();
		}
		else if(stormtrooperO != null && gun != null){
			c = stormtrooperO.symbol();
		}
		else if(stormtrooperW != null && gun != null){
			c = stormtrooperW.symbol();
		}
		else if(stormtrooperB != null){
			c = stormtrooperB.symbol();
		}
		else if(stormtrooperW != null){
			c = stormtrooperW.symbol();
		}
		else if(stormtrooperO != null){
			c= stormtrooperO.symbol();
		}
		else if(gun != null){ 
			c = gun.GUN;
		}
		else if(potion != null){
			c = potion.POTION;
		}
		else if(rebel != null){
			c = rebel.symbol();
		}
		
		else{
			gun = null;
			potion = null;
			stormtrooperB = null; 
			stormtrooperW = null;
			stormtrooperO = null;
			rebel = null;
			
		}
		return c;
	}
	
	

	@Override
	public boolean hasRebel(){
		return rebel != null ;
	}
	
	public boolean hasGun(){
		return gun != null;
	}
	
	public boolean hasStorm(){
		return ( stormtrooperB != null || stormtrooperW != null || stormtrooperO != null);
	}
	
	public void addStormB(StormtrooperBlack st){
		stormtrooperB = st;
	}
	
	public void addStormO(StormtrooperOrange st){
		stormtrooperO = st;
	}
	
	public void addStormW(StormtrooperWhite st){
		stormtrooperW = st;
	}
	
	public Stormtrooper returnStormtrooper(){
		if(stormtrooperB != null)
			return stormtrooperB;
		else if(stormtrooperW != null)
			return stormtrooperW;
		else if(stormtrooperO != null)
			return stormtrooperO;
		return null;
	}
	
	public void removeStorm(){
		stormtrooperB = null;
		stormtrooperW = null;
		stormtrooperO = null;
	}
	
	public void addRebel(Rebel r){
			rebel = r;
	}
	
	public void removeRebel(){
		rebel = null;
	}
	
	public void removeStormtrooper(){
		stormtrooperB = null;
		stormtrooperW = null;
		stormtrooperO = null;
	}
	
	public void addGun(){
		gun = new GunClass();
	}
	
	public void removeGun(){
		gun = null;
	}
	
	public void addPotion(){
		potion = new PotionClass(); 
	}
	
	public void removePotion(){
		potion = null;
	}
}
