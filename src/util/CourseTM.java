package util;

public class CourseTM {
    private String id;
    private String title;
    private String type;
    private double duration;

    public CourseTM() {
    }

    public CourseTM(String id, String title, String type, double duration) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                '}';
    }
}
