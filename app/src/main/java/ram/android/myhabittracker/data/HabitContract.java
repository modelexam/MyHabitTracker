package ram.android.myhabittracker.data;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract(){}

    public static final class HabitEntry implements BaseColumns{
        public static final String TABLE_NAME = "habit_tracker";
        public final static String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "habit_name";
        public static final String COLUMN_DURATION = "duration";
    }
}
