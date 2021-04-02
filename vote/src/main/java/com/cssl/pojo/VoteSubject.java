package com.cssl.pojo;

import java.io.Serializable;
import java.util.List;

public class VoteSubject implements Serializable {

    private int vs_id;//主题id
    private String vs_title;//主题内容
    private int vs_type;//主题类型 单选1 多选2

    private List<VoteOption> options;//选项
    private int calOption;//选项数
    private int calVote;//总投票数

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public int getCalOption() {
        return calOption;
    }

    public void setCalOption(int calOption) {
        this.calOption = calOption;
    }

    public int getCalVote() {
        return calVote;
    }

    public void setCalVote(int calVote) {
        this.calVote = calVote;
    }

    public int getVs_id() {
        return vs_id;
    }

    public void setVs_id(int vs_id) {
        this.vs_id = vs_id;
    }

    public String getVs_title() {
        return vs_title;
    }

    public void setVs_title(String vs_title) {
        this.vs_title = vs_title;
    }

    public int getVs_type() {
        return vs_type;
    }

    public void setVs_type(int vs_type) {
        this.vs_type = vs_type;
    }

    public VoteSubject() {
    }

    public VoteSubject(int vs_id, String vs_title, int vs_type) {
        this.vs_id = vs_id;
        this.vs_title = vs_title;
        this.vs_type = vs_type;
    }

    @Override
    public String toString() {
        return "Vote_Subject{" +
                "vs_id=" + vs_id +
                ", vs_title='" + vs_title + '\'' +
                ", vs_type=" + vs_type +
                '}';
    }
}
