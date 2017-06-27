package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cong.helloworld.Controller.StudentScoreController;
import com.example.cong.helloworld.R;


public class StudentScoreStatisticFragment extends Fragment {


    public StudentScoreStatisticFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static StudentScoreStatisticFragment newInstance() {
        StudentScoreStatisticFragment fragment = new StudentScoreStatisticFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentScoreController controller=new StudentScoreController(this);
        controller.getStudentScore(12,227);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_score_statistic, container, false);
    }

}
