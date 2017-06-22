package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapText;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.font.FontAwesome;
import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Activity.listener.StudentClassListener;
import com.example.cong.helloworld.Controller.StudentListController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.vo.StudentClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StudentListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentListFragment extends Fragment {




    public StudentListFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment StudentListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentListFragment newInstance() {
        StudentListFragment fragment = new StudentListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentListController controller=new StudentListController(this);
        controller.getStudentList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

    public void initClassList(StudentClass[] classes){
        if(classes==null||classes.length==0)
            return;
        LinearLayout studentList=(LinearLayout)getActivity().findViewById(R.id.class_list);
        for(int i=0;i<classes.length;i++){
            StudentClass studentClass=classes[i];
            BootstrapButton button=new BootstrapButton(SampleApplication.getContext());
            button.setText(studentClass.getName());
            button.setBootstrapSize(DefaultBootstrapSize.XL);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0,15,0,15);
            button.setLayoutParams(params);
            button.setRounded(true);
            BootstrapText.Builder builder=new BootstrapText.Builder(SampleApplication.getContext());
            builder.addFontAwesomeIcon("fa_users");
            builder.addText("   "+studentClass.getName());
            button.setBootstrapText(builder.build());
            button.setGravity(Gravity.LEFT);
            button.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);

            //设置监听
            StudentClassListener listener=new StudentClassListener(studentClass.getId(),(MainActivity) getActivity());
            button.setOnClickListener(listener);

            studentList.addView(button);
        }




    }

}
