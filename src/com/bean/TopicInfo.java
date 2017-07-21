package com.bean;

/**
 * 帖子详情
 * @author i欢
 *
 */
public class TopicInfo {
	private int rid;
	private int tid;
	private int bid;
	private int uid;
	private String title;
	private String content;
	private String recTime;
	private int great;
	private String headimg;
	private String userName;
	private int rcount;
	private int flowCount;
	
	public TopicInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 构造一贴详情
	 * @param rid	回ID
	 * @param tid	帖子ID
	 * @param uid	用户ID
	 * @param title	帖子标题
	 * @param content	帖子类容
	 * @param recTime	回帖时间
	 * @param great	点赞
	 * @param heading 用户头像地址
	 * @param userName 用户名
	 * @param rcount 回复数
	 * @param flowCount	流量数
	 */
	public TopicInfo(int rid, int tid,int bid, int uid, String title, String content, String recTime, int great, String headimg,
			String userName, int rcount, int flowCount) {
		super();
		this.rid = rid;
		this.tid = tid;
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.recTime = recTime;
		this.great = great;
		this.headimg = headimg;
		this.userName = userName;
		this.rcount = rcount;
		this.flowCount = flowCount;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRecTime() {
		return recTime;
	}

	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}

	public int getGreat() {
		return great;
	}

	public void setGreat(int great) {
		this.great = great;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeading(String headimg) {
		this.headimg = headimg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public int getFlowCount() {
		return flowCount;
	}

	public void setFlowCount(int flowCount) {
		this.flowCount = flowCount;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	
	
	
}
