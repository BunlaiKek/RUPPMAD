package kh.edu.rupp.fe.ruppmad.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kh.edu.rupp.fe.ruppmad.R;

/**
 * Created by Kek Bunlai on 08-May-17.
 */

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    private Assignment[] assignments;
    private RecyclerViewItemClickListener recyclerViewItemClickListener;
    public AssignmentAdapter(Assignment[] assignments) {
        this.assignments = assignments;
    }

    public void setAssignments(Assignment[] assignments) {
        this.assignments = assignments;
        notifyDataSetChanged();
    }

    public void setRecyclerViewItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_assignment,parent,false);
        AssignmentViewHolder viewHolder = new AssignmentViewHolder(holder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position) {
        Assignment assignment = assignments[position];

        holder.txtAssignmentTitle.setText(assignment.getTitle());
        holder.txtAssignmentDeadline.setText(assignment.getDeadLine());
    }


    @Override
    public int getItemCount() {
        return assignments.length;
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtAssignmentTitle;
        private TextView txtAssignmentDeadline;
        private ImageView imageView;
        public AssignmentViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.img_assigment_thumnail);
            txtAssignmentTitle = (TextView)itemView.findViewById(R.id.txt_assigment_title);
            txtAssignmentDeadline = (TextView)itemView.findViewById(R.id.txt_deadline);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(recyclerViewItemClickListener != null)
            {
                recyclerViewItemClickListener.onRecyclerViewItemClick(getAdapterPosition());
            }

        }
    }
}
