package edu.ycp.cs320.magicprogram.shared;
//superclass
public class Tower {
	// Physical attributes
	private double range;
	private int damage;
	private int attackSpeed;
	// 
	private Rectangle towerBlock;
	
	public Tower() {
		
	}

	
	public Rectangle getBlock() {
		return this.towerBlock;
	}
	
}
