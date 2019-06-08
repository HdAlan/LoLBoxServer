package com.henuajy.Entity;

public class CommunicateItem {
    private int id;
    private String head_icoPath;
    private String userName;
    private int level;
    private String title;
    private String summary;
    private String articalImgPath;
    private String articalCate;
    private String articalTime;
    private int articalCommCounts;
    private int articalLikeCounts;
    private int def;
    private String userAccount;
    private int commentId;
    private String articalAccount;
    public CommunicateItem(int id,String head_ico, String userName, int level, String title, String summary, String articalImg,
                           String articalCate, String articalTime, int articalCommCounts, int articalLikeCounts,int def,String userAccount){
        this.id = id;
        this.head_icoPath = head_ico;
        this.userName = userName;
        this.level = level;
        this.title = title;
        this.summary = summary;
        this.articalImgPath = articalImg;
        this.articalCate = articalCate;
        this.articalTime = articalTime;
        this.articalCommCounts = articalCommCounts;
        this.articalLikeCounts = articalLikeCounts;
        this.def = def;
        this.userAccount = userAccount;
    }
    public CommunicateItem(String head_ico, String userName, int level, String title, String summary, String articalImg,
                           String articalCate, String articalTime, int articalCommCounts, int articalLikeCounts,int def,String userAccount){
        this.id = id;
        this.head_icoPath = head_ico;
        this.userName = userName;
        this.level = level;
        this.title = title;
        this.summary = summary;
        this.articalImgPath = articalImg;
        this.articalCate = articalCate;
        this.articalTime = articalTime;
        this.articalCommCounts = articalCommCounts;
        this.articalLikeCounts = articalLikeCounts;
        this.def = def;
        this.userAccount = userAccount;
    }
    public CommunicateItem(String head_icoPath,String userName,int level,int commentId,String userAccount,String articalAccount, String summary,int articalId){
        this.head_icoPath = head_icoPath;
        this.userName = userName;
        this.level = level;
        this.commentId = commentId;
        this.userAccount = userAccount;
        this.articalAccount = articalAccount;
        this.summary = summary;
        this.id = articalId;
    }

    public String getArticalAccount() {
        return articalAccount;
    }

    public void setArticalAccount(String articalAccount) {
        this.articalAccount = articalAccount;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead_icoPath() {
        return head_icoPath;
    }

    public void setHead_icoPath(String head_icoPath) {
        this.head_icoPath = head_icoPath;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getArticalImgPath() {
        return articalImgPath;
    }

    public void setArticalImgPath(String articalImgPath) {
        this.articalImgPath = articalImgPath;
    }

    public String getArticalCate() {
        return articalCate;
    }

    public void setArticalCate(String articalCate) {
        this.articalCate = articalCate;
    }

    public String getArticalTime() {
        return articalTime;
    }

    public void setArticalTime(String articalTime) {
        this.articalTime = articalTime;
    }

    public int getArticalCommCounts() {
        return articalCommCounts;
    }

    public void setArticalCommCounts(int articalCommCounts) {
        this.articalCommCounts = articalCommCounts;
    }

    public int getArticalLikeCounts() {
        return articalLikeCounts;
    }

    public void setArticalLikeCounts(int articalLikeCounts) {
        this.articalLikeCounts = articalLikeCounts;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
