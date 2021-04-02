package com.cssl.pojo;

import java.io.Serializable;

public class VoteItem implements Serializable {

    private int vi_id;//自身id
    private int vu_user_id;//用户id
    private int vs_id;//主题id
    private int vo_id;//选项id

    public int getVi_id() {
        return vi_id;
    }

    public void setVi_id(int vi_id) {
        this.vi_id = vi_id;
    }

    public int getVu_user_id() {
        return vu_user_id;
    }

    public void setVu_user_id(int vu_user_id) {
        this.vu_user_id = vu_user_id;
    }

    public int getVs_id() {
        return vs_id;
    }

    public void setVs_id(int vs_id) {
        this.vs_id = vs_id;
    }

    public int getVo_id() {
        return vo_id;
    }

    public void setVo_id(int vo_id) {
        this.vo_id = vo_id;
    }

    public VoteItem() {
    }

    public VoteItem(int vi_id, int vu_user_id, int vs_id, int vo_id) {
        this.vi_id = vi_id;
        this.vu_user_id = vu_user_id;
        this.vs_id = vs_id;
        this.vo_id = vo_id;
    }

    @Override
    public String toString() {
        return "VoteItem{" +
                "vi_id=" + vi_id +
                ", vu_user_id=" + vu_user_id +
                ", vs_id=" + vs_id +
                ", vo_id=" + vo_id +
                '}';
    }
}
