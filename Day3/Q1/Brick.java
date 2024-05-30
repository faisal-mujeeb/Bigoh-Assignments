import java.util.ArrayList;
import java.util.List;

public class Brick {
    private String message;
    private User owner;
    private String dedicateTo;
    private boolean isVisible = true;
    private int flagCount = 0;
    private List<String> comments = new ArrayList<>();

    public Brick(String message, User owner, String dedicateTo) {
        this.message = message;
        this.owner = owner;
        this.dedicateTo = dedicateTo;
    }

    public String getMessage() {
        return message;
    }

    public User getOwner() {
        return owner;
    }

    public String getDedicateTo() {
        return dedicateTo;
    }

    public void flag() {
        flagCount++;
        if (flagCount > 10) {
            isVisible = false;
        }
    }

    public boolean isVisible() {
        return isVisible;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public List<String> getComments() {
        return comments;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDedicateTo(String dedicateTo) {
        this.dedicateTo = dedicateTo;
    }
}

