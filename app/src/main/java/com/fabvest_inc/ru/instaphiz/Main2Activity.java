package com.fabvest_inc.ru.instaphiz;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.fabvest_inc.ru.instaphiz.DB.DBHelper;
import com.fabvest_inc.ru.instaphiz.DB.InstaPhizContract;
import com.fabvest_inc.ru.instaphiz.Data.User;

public class Main2Activity extends FragmentActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mName = (EditText)findViewById(R.id.editTextName);
        mLesson = (EditText)findViewById(R.id.editTextLesson);
        mMark = (EditText)findViewById(R.id.editTextMark);
        mPrice = (EditText)findViewById(R.id.editTextPrice);
        mSemester = (EditText)findViewById(R.id.editTextSemester);
        isKafedra = (CheckBox)findViewById(R.id.checkBox);

        mDBHelper = new DBHelper(Main2Activity.this);


        values = new ContentValues();

        db = mDBHelper.getWritableDatabase();

        mButton = (Button)findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser = new User();
                putValues(db, mUser);
            }
        });

        exitButton = (Button)findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        clearButton = (Button)findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO clear all table
            }
        });

        viewButton = (Button)findViewById(R.id.buttonList);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO fragment with list
            }
        });
    }


    protected void onStop(){
        super.onStop();
        finish();
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
            mName.getText().clear();
            mLesson.getText().clear();
            mMark.getText().clear();
            mPrice.getText().clear();
            mSemester.getText().clear();
            isKafedra.setChecked(false);
        }catch (Exception e){
            Toast.makeText(Main2Activity.this, "Error", Toast.LENGTH_LONG).show();
        }
    }


}
