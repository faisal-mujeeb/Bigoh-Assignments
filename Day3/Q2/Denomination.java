public class Denomination {
    private int value;
    private int count;
    private boolean isValid;

    public Denomination(int value, int count) {
        this.value = value;
        this.count = count;
        this.isValid = true;
    }

    public int getValue() { return value; }
    public int getCount() { return count; }
    public boolean isValid() { return isValid; }
    public void addCount(int count) { this.count += count; }
    public void reduceCount(int count) { this.count -= count; }
    public void invalidate() { this.isValid = false; }
    public void validate() { this.isValid = true; }
}
