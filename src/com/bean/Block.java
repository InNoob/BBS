package com.bean;

public class Block {
	private int topCount;
	private String blockName;
	private int bid;
	
	public Block(){}

	public Block(int bid, String blockName, int topCount) {
		super();
		this.bid = bid;
		this.topCount = topCount;
		this.blockName = blockName;
	}

	public int getTopCount() {
		return topCount;
	}

	public void setTopCount(int topCount) {
		this.topCount = topCount;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}


	

}
