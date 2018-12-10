package videoplayer.vishcoder.com.practical.Model;

public class save {
    String Id;
    String Name;
    String Date;

    public save(String Id,String Name,String Date)
    {
        this.Id = Id;
        this.Name = Name;
        this.Date = Date;

    }
    public String getId()
    {
        return Id;
    }
    public void setId()
    {
        this.Id = Id;
    }
    public String getName()
    {
        return Name;
    }
    public void setName()
    {
        this.Name = Name;
    }
    public String getDate()
    {
        return Date;
    }
    public void setDate()
    {
        this.Date = Date;
    }
}
