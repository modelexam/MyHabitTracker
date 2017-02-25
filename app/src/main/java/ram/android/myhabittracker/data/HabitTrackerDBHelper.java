package ram.android.myhabittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitTrackerDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habittracker.db";

    public HabitTrackerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITDB =
                "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" +
                        HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        HabitContract.HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL" + ", " +
                        HabitContract.HabitEntry.COLUMN_DURATION + " INTEGER NOT NULL DEFAULT 0" + " )";
        db.execSQL(SQL_CREATE_HABITDB);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);

    }

    //deletes database
    public void deleteDB(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }
}