package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapText;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Activity.listener.StudentScoreListener;
import com.example.cong.helloworld.Activity.listener.TeacherScoreListener;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.PropertyTool;
import com.example.cong.helloworld.Tool.StatusTool;
import com.example.cong.helloworld.vo.Practice;
import com.example.cong.helloworld.vo.Question;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PracticeDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PracticeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PracticeDetailFragment extends Fragment {

    private Practice practice;

    public PracticeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PracticeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PracticeDetailFragment newInstance(Practice practice) {
        PracticeDetailFragment fragment = new PracticeDetailFragment();
        fragment.practice=practice;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void showQuestions(View view) {

        LinearLayout questions=(LinearLayout)view.findViewById(R.id.questions);
        Context context= SampleApplication.getContext();
        for(Question question:practice.questions){
            View questionView= getActivity().getLayoutInflater().inflate(R.layout.question_info, null);

            TextView title=(TextView) questionView.findViewById(R.id.title);
            title.setText(question.title);



            TextView difficulty=(TextView)questionView.findViewById(R.id.difficulty);
            difficulty.setText("难度:"+question.difficulty);

            TextView creator=(TextView)questionView.findViewById(R.id.creator);
            creator.setText("发布人:"+question.creator.name);

            TextView description=(TextView)questionView.findViewById(R.id.description);
            description.setText("描述:"+question.description);

            TextView git=(TextView)questionView.findViewById(R.id.git);
            git.setText("git:"+question.gitUrl);

            TextView link=(TextView)questionView.findViewById(R.id.link);
            link.setText("链接:"+question.link);

            questions.addView(questionView);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main=inflater.inflate(R.layout.fragment_practice_detail, container, false);
        showQuestions(main);
        showDetail(main);
        return main;
    }

    private void showDetail(View main) {
        TextView title=(TextView)main.findViewById(R.id.title);
        title.setText(practice.title);

        TextView start=(TextView)main.findViewById(R.id.start);
        start.setText("开始时间:"+practice.startAt+"\n结束时间:"+practice.endAt);

        TextView description=(TextView)main.findViewById(R.id.description);
        description.setText("描述:"+practice.description);

        Context context=SampleApplication.getContext();
        BootstrapButton status=(BootstrapButton)main.findViewById(R.id.status);
        BootstrapText.Builder builder=new BootstrapText.Builder(context);
        builder.addText(StatusTool.getStatus(practice.status));
        status.setBootstrapText(builder.build());
        if(practice.status.equals("analyzingFinish")){
            status.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
            String type= PropertyTool.getInfo(context,"type");
            //go to analysis
            if("teacher".equals(type)){
                TeacherScoreListener listener=new TeacherScoreListener((MainActivity) getActivity(),38);
                status.setOnClickListener(listener);
            }else{
                StudentScoreListener listener=new StudentScoreListener((MainActivity)getActivity(),38,256);
                status.setOnClickListener(listener);
            }
        }
    }

}
