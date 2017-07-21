package com.bean;
/**
 * 查询所有帖子
 * @author i欢
 *
 */
public class Topic {
	private int tid;
	private int bid;
	private int uid;
	private String userName;
	private int level;
	private long mark;
	private String headimg;
	private String title;
	private String topTime;
	private int stat;
	private int rCount;
	private String newTime;
	private String block;
	private int care;
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param tid	帖子ID
	 * @param bid	板块ID
	 * @param uid	用户ID
	 * @param userName	用户名
	 * @param level	用户等级
	 * @param mark	用户积分
	 * @param headimg	用户头像地址
	 * @param title	帖子标题
	 * @param topTime	发帖时间
	 * @param stat	帖子状态
	 * @param rCount	回帖数
	 * @param newTime	最新回帖时间
	 * @param block	帖子板块
	 * @param care	关注
	 */
	public Topic(int tid, int bid, int uid, String userName, int level, long mark, String headimg, String title,
			String topTime, int stat, int rCount, String newTime,String block,int care) {
		super();
		this.tid = tid;
		this.bid = bid;
		this.uid = uid;
		this.userName = userName;
		this.level = level;
		this.mark = mark;
		this.headimg = headimg;
		this.title = title;
		this.topTime = topTime;
		this.stat = stat;
		this.rCount = rCount;
		this.newTime = newTime;
		this.block=block;
		this.care=care;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopTime() {
		return topTime;
	}

	public void setTopTime(String topTime) {
		this.topTime = topTime;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getrCount() {
		return rCount;
	}

	public void setrCount(int rCount) {
		this.rCount = rCount;
	}

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public int getCare() {
		return care;
	}

	public void setCare(int care) {
		this.care = care;
	}
	
	
}
