package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cong.helloworld.Controller.StudentScoreController;
import com.example.cong.helloworld.R;

import java.util.zip.Inflater;


public class StudentScoreStatisticFragment extends Fragment {


    private int assignmentId;

    private int studentId;

    public StudentScoreStatisticFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static StudentScoreStatisticFragment newInstance(int assignmentId,int studentId) {
        StudentScoreStatisticFragment fragment = new StudentScoreStatisticFragment();
        fragment.assignmentId=assignmentId;
        fragment.studentId=studentId;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentScoreController controller=new StudentScoreController(this);
        controller.getStudentScore(assignmentId,studentId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_score_statistic, container, false);
    }

    public void showResult(){
        RelativeLayout layout=(RelativeLayout)getActivity().findViewById(R.id.results);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.student_score_info,null);
        layout.addView(view);
    }

}
