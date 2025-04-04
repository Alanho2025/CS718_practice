package PracticeTwo;

public class Lecturer {
    private String name;
    private int staffId;
    private String[] papers;
    private boolean onLeave;

    public Lecturer(String name, int staffId, String[] papers, boolean onLeave) {
        this.name = name;
        this.staffId = staffId;
        this.papers = papers;
        this.onLeave = onLeave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String[] getPapers() {
        return papers;
    }

    public void setPapers(String[] papers) {
        this.papers = papers;
    }

    public boolean isOnLeave() {
        return onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        this.onLeave = onLeave;
    }

    public boolean teachesMorePapersThan(Lecturer other) {
        return papers.length > other.papers.length;
    }

    @Override
    public String toString() {
        return "id:" + staffId + " " + name + " is teaching " + papers.length + " papers.";
    }

}
