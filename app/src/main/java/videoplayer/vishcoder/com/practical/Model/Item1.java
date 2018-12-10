package videoplayer.vishcoder.com.practical.Model;

public class Item1 {

    private String title;
    private int check;

    public Item1(String title,int check)
    {

        this.title = title;
        this.check = check;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
