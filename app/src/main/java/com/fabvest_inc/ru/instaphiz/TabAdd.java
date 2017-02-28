package com.fabvest_inc.ru.instaphiz;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.fabvest_inc.ru.instaphiz.DB.DBHelper;
import com.fabvest_inc.ru.instaphiz.DB.InstaPhizContract;
import com.fabvest_inc.ru.instaphiz.Data.User;


/**
 * Created by fab on 28.02.2017.
 */

public class TabAdd extends Fragment {

    DBHelper mDBHelper;
    SQLiteDatabase db;
    ContentValues values;
    User mUser;
    Button mButton;
    Button exitButton;
    Button clearButton;
    Button viewButton;
    EditText mName;
    EditText mLesson;
    EditText mMark;
    EditText mPrice;
    EditText mSemester;
    CheckBox isKafedra;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);


        return v;
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        mName = (EditText)v.findViewById(R.id.editTextName);
        mLesson = (EditText)v.findViewById(R.id.editTextLesson);
        mMark = (EditText)v.findViewById(R.id.editTextMark);
        mPrice = (EditText)v.findViewById(R.id.editTextPrice);
        mSemester = (EditText)v.findViewById(R.id.editTextSemester);
        isKafedra = (CheckBox)v.findViewById(R.id.checkBox);

        mDBHelper = new DBHelper(getActivity());


        values = new ContentValues();

        db = mDBHelper.getWritableDatabase();

        mButton = (Button)v.findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser = new User();
                putValues(db, mUser);
            }
        });

        exitButton = (Button)v.findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

    }

    private void putValues(SQLiteDatabase db, User user){
        values.put(InstaPhizContract.PhizCols.COLUMN_NAME_ID, mUser.getmId());
        values.put(InstaPhizContract.PhizCols.COLUMN_NAME_NAME, mName.getText().toString());
        values.put(InstaPhizContract.PhizCols.COLUMN_NAME_LESSON, mLesson.getText().toString());
        values.put(InstaPhizContract.PhizCols.COLUMN_MAME_MARK, mMark.getText().toString());
        values.put(InstaPhizContract.PhizCols.COLUMN_NAME_PRICE, mPrice.getText().toString());
        values.put(InstaPhizContract.PhizCols.COLUMN_NAME_SEMESTR, mSemester.getText().toString());
        values.put(InstaPhizContract.PhizCols.COLUMN_NAME_KAFEDRA, isKafedra.isChecked());

        try {
            long newRowId;
            newRowId = db.insert(InstaPhizContract.PhizCols.TABLE_NAME,
                    null,
                    values);
            Toast.makeText(getActivity(), "good", Toast.LENGTH_LONG).show();
            mName.getText().clear();
            mLesson.getText().clear();
            mMark.getText().clear();
            mPrice.getText().clear();
            mSemester.getText().clear();
            isKafedra.setChecked(false);
        }catch (Exception e){
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
        }
    }
}
