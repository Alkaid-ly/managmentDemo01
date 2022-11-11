package com.example.managementdemo01.pojo;

public class Mission {
  private String mid;
  private String mtitle;
  private String context;
  private String fk_tid;
  private String fk_sid;
  private String m_date;
  private String status;

    @Override
    public String toString() {
        return "Mission{" +
                "mid='" + mid + '\'' +
                ", mtitle='" + mtitle + '\'' +
                ", context='" + context + '\'' +
                ", fk_tid='" + fk_tid + '\'' +
                ", fk_sid='" + fk_sid + '\'' +
                ", m_date='" + m_date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFk_tid() {
        return fk_tid;
    }

    public void setFk_tid(String fk_tid) {
        this.fk_tid = fk_tid;
    }

    public String getFk_sid() {
        return fk_sid;
    }

    public void setFk_sid(String fk_sid) {
        this.fk_sid = fk_sid;
    }

    public String getM_date() {
        return m_date;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
