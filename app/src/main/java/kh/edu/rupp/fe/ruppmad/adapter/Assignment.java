package kh.edu.rupp.fe.ruppmad.adapter;

/**
 * Created by Kek Bunlai on 08-May-17.
 */

public class Assignment {
    private String title;
    private String thumnaiUrl;
    private String deadLine;

    public Assignment(String title, String thumnaiUrl, String deadLine) {
        this.title = title;
        this.thumnaiUrl = thumnaiUrl;
        this.deadLine = deadLine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumnaiUrl() {
        return thumnaiUrl;
    }

    public void setThumnaiUrl(String thumnaiUrl) {
        this.thumnaiUrl = thumnaiUrl;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
