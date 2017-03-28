package com.fabvest_inc.ru.instaphiz;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fabvest_inc.ru.instaphiz.Data.User;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private List<User> rvUsers;

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
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(holder == null) Log.d("holder", "holder is null");
        holder.mNameText.setText(rvUsers.get(position).getmName());
        holder.mLessonText.setText(rvUsers.get(position).getLesson());
        holder.mMarkText.setText(String.valueOf(rvUsers.get(position).getMark()));
        holder.mPriceText.setText(String.valueOf(rvUsers.get(position).getPrice()));
        holder.mSemesterText.setText(String.valueOf(rvUsers.get(position).getSemester()));
        holder.isKafedraText.setChecked(rvUsers.get(position).isKafedra());
    }

    @Override
    public int getItemCount() {
        return rvUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mNameText;
        public TextView mLessonText;
        public TextView mMarkText;
        public TextView mPriceText;
        public TextView mSemesterText;
        public CheckBox isKafedraText;


        public ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView)itemView.findViewById(R.id.textViewName);
            mLessonText = (TextView) itemView.findViewById(R.id.textViewLesson);
            mMarkText = (TextView) itemView.findViewById(R.id.textViewMark);
            mPriceText = (TextView) itemView.findViewById(R.id.textViewPrice);
            mSemesterText =(TextView) itemView.findViewById(R.id.textViewSemester);
            isKafedraText = (CheckBox) itemView.findViewById(R.id.checkBox2);

        }
    }
}
