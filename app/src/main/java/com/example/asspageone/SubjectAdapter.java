package com.example.asspageone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.CardViewHolder> {

    ArrayList<Subjects> subjects;
    ArrayList<Subjects> subjectInfo;
    public SubjectAdapter(ArrayList<Subjects> subjects) {
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public SubjectAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_cards,parent,false);
        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.CardViewHolder holder, int position) {
        Subjects currentCards = this.subjects.get(position);
        holder.subjectImage.setImageResource(currentCards.getSubjectImage());
        holder.subjectName.setText(currentCards.getSubjectName());
        holder.assignment.setText(currentCards.getAssignment());

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    //@Override
    public Filter getFilter() {
        return Filter;
    }

    private Filter Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Subjects> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(subjectInfo);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Subjects note:subjectInfo
                ) {
                    if (note.getSubjectName().toLowerCase().contains(filterPattern)){
                        filteredList.add(note);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            subjects.clear();
            subjects.addAll((List)results.values);
           notifyDataSetChanged();
        }
    };

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public  ImageView subjectImage;

        public  TextView subjectName;
        public TextView assignment;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectImage=itemView.findViewById(R.id.subject_imageView);
            subjectName=itemView.findViewById(R.id.subjectName_textView);
            assignment=itemView.findViewById(R.id.assignment_textView);



        }
    }
}
