package videoplayer.vishcoder.com.practical.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private  static String CREATE_TABLE1;
    static String DATABASE_NAME = "Practical";
   static  String TABLE1_NAME = "Category";
    public static String ID = "id";

    public static String NAME = "name";
    public  static String DATE = "Date";
    ContentValues cValues;
    SQLiteDatabase database =null;
    Cursor cursor;
    public DbHelper(Context context)
    {
        super(context,context.getExternalFilesDir(null).getAbsolutePath()+"/"+ DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            CREATE_TABLE1 = " CREATE TABLE " + TABLE1_NAME + "(" + ID + " INTEGER PRIMARY KEY autoincrement, " + NAME + " TEXT, " + DATE + " DATE)";
            sqLiteDatabase.execSQL(CREATE_TABLE1);
            System.out.println("Table is Created....................");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public  void insertRecord_Category(String s,String date)
    {
        database = getWritableDatabase();
        cValues = new ContentValues();
        cValues.put(NAME,s);
        cValues.put(DATE,date);
        database.insert(TABLE1_NAME,"",cValues);
        database.close();

    }
    public Cursor selectRecord_category()
    {
        database = getWritableDatabase();
        cursor = database.rawQuery("select * from " + TABLE1_NAME,null);
        return cursor;
    }

}

