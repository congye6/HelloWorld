package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cong.helloworld.Controller.StudentScoreController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.vo.QuestionInfo;
import com.example.cong.helloworld.vo.QuestionResult;
import com.example.cong.helloworld.vo.QuetionWrapper;
import com.example.cong.helloworld.vo.TestCase;
import com.example.cong.helloworld.vo.TestResult;

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

    public void showResult(QuetionWrapper[] questionInfos){
        LinearLayout layout=(LinearLayout)getActivity().findViewById(R.id.results);


        for(QuetionWrapper questionInfo:questionInfos){
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View view=inflater.inflate(R.layout.student_score_info,null);

            TextView title=(TextView)view.findViewById(R.id.title);
            title.setText(questionInfo.questionTitle);

            TextView score=(TextView)view.findViewById(R.id.score);
            score.setText("得分:"+questionInfo.scoreResult.getScore());

            TextView git=(TextView)view.findViewById(R.id.git);
            git.setText("题目git:"+questionInfo.scoreResult.getGit_url());

            TextView analysis=(TextView)view.findViewById(R.id.analysis);
            analysis.setText("总行数:"+questionInfo.metricData.total_line_count + " 注释行数:"+questionInfo.metricData.comment_line_count+
                    "  方法数:"+questionInfo.metricData.method_count+"\n属性数:"+questionInfo.metricData.field_count+"  max_coc:"+questionInfo.metricData.max_coc);

            TextView testcase=(TextView) view.findViewById(R.id.testcase);
            StringBuilder builder=new StringBuilder();
            builder.append("测试用例通过情况\n");
            if(questionInfo.testResult.testcases==null){
                testcase.setText("暂无测试用例");
            }else{
                for(TestCase test:questionInfo.testResult.testcases){
                    builder.append(test.name+":"+test.getPassed()+"\n");
                }
                testcase.setText(builder.toString());
            }


            layout.addView(view);
        }

    }

}
