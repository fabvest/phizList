package com.fabvest_inc.ru.instaphiz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fabvest_inc.ru.instaphiz.DB.DBHelper;
import com.fabvest_inc.ru.instaphiz.DB.InstaPhizContract;
import com.fabvest_inc.ru.instaphiz.Data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.provider.BaseColumns._COUNT;
import static com.fabvest_inc.ru.instaphiz.DB.InstaPhizContract.PhizCols.TABLE_NAME;


public class TabList extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DBHelper mDBHelper;
    private SQLiteDatabase db;
    private List<User> users;
    private boolean temp;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        users = new ArrayList<>();

        mDBHelper = new DBHelper(getActivity());

        db = mDBHelper.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            int nameColumn = cursor.getColumnIndex("name");
            int lessonColumn = cursor.getColumnIndex("lesson");
            int markColumr = cursor.getColumnIndex("mark");
            int priceColumn = cursor.getColumnIndex("price");
            int semesterColumn = cursor.getColumnIndex("semestr");
            int kafedraColumn = cursor.getColumnIndex("kafedra");
            do{
                String s = cursor.getString(kafedraColumn);

                temp = Objects.equals(cursor.getString(kafedraColumn), "1");
                users.add(new User(cursor.getString(nameColumn),
                        cursor.getString(lessonColumn),
                        cursor.getInt(markColumr),
                        cursor.getInt(priceColumn),
                        temp,
                        cursor.getInt(semesterColumn)));
            }while (cursor.moveToNext());
        }else
            Toast.makeText(getActivity(), "Нет записей", Toast.LENGTH_SHORT)
            .show();
        cursor.close();
        db.close();

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RVAdapter(users);
        recyclerView.setAdapter(adapter);

    }
}
