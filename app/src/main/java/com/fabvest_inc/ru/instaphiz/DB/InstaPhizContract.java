package com.fabvest_inc.ru.instaphiz.DB;

import android.provider.BaseColumns;

/**
 * Created by fab on 24.02.2017.
 */

public final class InstaPhizContract {
    public InstaPhizContract() {}

    public static abstract class PhizCols implements BaseColumns{
        public static final String TABLE_NAME = "list";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_LESSON = "lesson";
        public static final String COLUMN_MAME_MARK = "mark";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_KAFEDRA = "kafedra";
        public static final String COLUMN_NAME_SEMESTR = "semestr";
    }
}
