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
        //User user = rvUsers.get(position);
        if(holder == null) Log.d("holder", "holder is null");
        holder.mName.setText(rvUsers.get(position).getmName());
        holder.mLesson.setText(rvUsers.get(position).getLesson());
        holder.mMark.setText(rvUsers.get(position).getMark());
        holder.mPrice.setText(rvUsers.get(position).getPrice());
        holder.mSemester.setText(rvUsers.get(position).getSemester());
        holder.isKafedra.setChecked(rvUsers.get(position).isKafedra());
    }

    @Override
    public int getItemCount() {
        return rvUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mName;
        public TextView mLesson;
        public TextView mMark;
        public TextView mPrice;
        public TextView mSemester;
        public CheckBox isKafedra;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView)itemView.findViewById(R.id.editTextName);
            mLesson = (TextView) itemView.findViewById(R.id.editTextLesson);
            mMark = (TextView) itemView.findViewById(R.id.editTextMark);
            mPrice = (TextView) itemView.findViewById(R.id.editTextPrice);
            mSemester =(TextView) itemView.findViewById(R.id.editTextSemester);
            isKafedra = (CheckBox) itemView.findViewById(R.id.checkBox2);

        }
    }
}
