package com.cssl.pojo;

import java.io.Serializable;

public class VoteOption implements Serializable {

    private int vo_id;//选项id
    private int vs_id;//选项所属主题id
    private String vo_option;//选项内容
    private int vo_order;//选项顺序

    private int voteNum;//投票数
    private double count;//投票比例

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public int getVo_id() {
        return vo_id;
    }

    public void setVo_id(int vo_id) {
        this.vo_id = vo_id;
    }

    public int getVs_id() {
        return vs_id;
    }

    public void setVs_id(int vs_id) {
        this.vs_id = vs_id;
    }

    public String getVo_option() {
        return vo_option;
    }

    public void setVo_option(String vo_option) {
        this.vo_option = vo_option;
    }

    public int getVo_order() {
        return vo_order;
    }

    public void setVo_order(int vo_order) {
        this.vo_order = vo_order;
    }

    public VoteOption() {
    }

    public VoteOption(int vo_id, int vs_id, String vo_option, int vo_order) {
        this.vo_id = vo_id;
        this.vs_id = vs_id;
        this.vo_option = vo_option;
        this.vo_order = vo_order;
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "vo_id=" + vo_id +
                ", vs_id=" + vs_id +
                ", vo_option='" + vo_option + '\'' +
                ", vo_order=" + vo_order +
                '}';
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        VoteOption vo=(VoteOption) obj;
        return this.vo_option.equals(vo.getVo_option());
    }
}
