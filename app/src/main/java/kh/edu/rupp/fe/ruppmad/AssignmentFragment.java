package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.rupp.fe.ruppmad.DB.DBManager;
import kh.edu.rupp.fe.ruppmad.adapter.Assignment;
import kh.edu.rupp.fe.ruppmad.adapter.AssignmentAdapter;
import kh.edu.rupp.fe.ruppmad.adapter.RecyclerViewItemClickListener;

/**
 * Created by Kek Bunlai on 08-May-17.
 */

public class AssignmentFragment extends Fragment implements RecyclerViewItemClickListener {
    private RecyclerView rclAssignment;
    private AssignmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragementView = inflater.inflate(R.layout.fragment_assignments,container,false);

        rclAssignment = (RecyclerView)fragementView.findViewById(R.id.rcl_assignments);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rclAssignment.setLayoutManager(layoutManager);
        adapter = new AssignmentAdapter(loadAllAssignments());
        Log.d("Bunlai","apdater");
        rclAssignment.setAdapter(adapter);

        return fragementView;
    }

    @Override
    public void onRecyclerViewItemClick(int position) {

    }
    private Assignment[] loadAllAssignments()
    {
        DBManager dbManager = new DBManager(getActivity());
        Log.d("Bunlai","DB is created");
        Log.d("Bunlai","Length"+String.valueOf(dbManager.getAllAssignments().length));
        return dbManager.getAllAssignments();
    }
}
