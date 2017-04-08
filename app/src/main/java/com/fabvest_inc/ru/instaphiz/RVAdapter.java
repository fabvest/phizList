package com.fabvest_inc.ru.instaphiz;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.fabvest_inc.ru.instaphiz.Data.User;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private List<User> rvUsers;
    AlertDialog.Builder alertDialog;
    private String title = "Подтвердите действие";
    private String message = "Удалить запись о ";
    private String button1 = "Да";
    private String button2 = "Нет";
    private String message2;
    Context context;
    boolean flag;


    public RVAdapter(List<User> user){
        this.rvUsers = user;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        context = holder.itemView.getContext();
        if(holder == null) Log.d("holder", "holder is null");
        holder.mNameText.setText(rvUsers.get(position).getmName());
        holder.mLessonText.setText(rvUsers.get(position).getLesson());
        holder.mMarkText.setText(String.valueOf(rvUsers.get(position).getMark()));
        holder.mPriceText.setText(String.valueOf(rvUsers.get(position).getPrice()));
        holder.mSemesterText.setText(String.valueOf(rvUsers.get(position).getSemester()));
        holder.isKafedraText.setChecked(rvUsers.get(position).isKafedra());
        alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(button1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                flag = true;
            }
        });
        alertDialog.setNegativeButton(button2, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                flag = false;
            }
        });
        alertDialog.setCancelable(true);
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                flag = false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertDialog.show();
                Context context = v.getContext();
                //// TODO: 08.04.2017 написать обработчик нажатия на удаление элемента БД 
            }
        });

    }

    @Override
    public int getItemCount() {
        return rvUsers.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameText;
        public TextView mLessonText;
        public TextView mMarkText;
        public TextView mPriceText;
        public TextView mSemesterText;
        public CheckBox isKafedraText;



        public ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView) itemView.findViewById(R.id.textViewName);
            mLessonText = (TextView) itemView.findViewById(R.id.textViewLesson);
            mMarkText = (TextView) itemView.findViewById(R.id.textViewMark);
            mPriceText = (TextView) itemView.findViewById(R.id.textViewPrice);
            mSemesterText = (TextView) itemView.findViewById(R.id.textViewSemester);
            isKafedraText = (CheckBox) itemView.findViewById(R.id.checkBox2);
        }

    }
}
