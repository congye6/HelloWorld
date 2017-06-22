package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapText;
import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Activity.listener.PracticeListener;
import com.example.cong.helloworld.Controller.PracticeController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.StatusTool;
import com.example.cong.helloworld.vo.Practice;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PracticeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PracticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PracticeFragment extends Fragment {



    public PracticeFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PracticeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PracticeFragment newInstance() {
        PracticeFragment fragment = new PracticeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PracticeController controller=new PracticeController(this);
        controller.getPractice();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice, container, false);
    }

    public void showPractice(List<Practice> practices){
        LinearLayout list=(LinearLayout)getActivity().findViewById(R.id.practice_list);
        LayoutInflater inflater=getActivity().getLayoutInflater();
        Context context= SampleApplication.getContext();
        BootstrapText.Builder builder;
        for(Practice practice:practices){
            View practiceInfo=inflater.inflate(R.layout.practice_info,null);

            AwesomeTextView title=(AwesomeTextView) practiceInfo.findViewById(R.id.title);
            builder=new BootstrapText.Builder(context);
            builder.addText(practice.title);
            title.setBootstrapText(builder.build());

            AwesomeTextView description=(AwesomeTextView)practiceInfo.findViewById(R.id.description);
            builder=new BootstrapText.Builder(context);
            if(practice.description.length()>=9)
                practice.description=practice.description.substring(0,8);
            builder.addText("描述:"+practice.description);
            description.setBootstrapText(builder.build());

            AwesomeTextView status=(AwesomeTextView)practiceInfo.findViewById(R.id.status);
            builder=new BootstrapText.Builder(context);
            builder.addText(StatusTool.getStatus(practice.getStatus()));
            status.setBootstrapText(builder.build());

            practiceInfo.setOnClickListener(new PracticeListener(practice,(MainActivity) getActivity()));

            list.addView(practiceInfo);
        }
    }

}
