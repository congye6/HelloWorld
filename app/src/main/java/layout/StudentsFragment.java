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
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Controller.StudentsController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.vo.Student;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StudentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentsFragment extends Fragment {


    private String id;

    public StudentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentsFragment newInstance(String id) {
        StudentsFragment fragment = new StudentsFragment();
        fragment.id=id;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentsController controller=new StudentsController(this);
        controller.getStudents(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_students, container, false);
    }


    public void showStudents(Student[] students){
        LinearLayout layout=(LinearLayout) getActivity().findViewById(R.id.students);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        for(Student student:students){
            View info=inflater.inflate(R.layout.student_info,null);
            String name=student.name+"("+student.name+")";
            Context context=SampleApplication.getContext();

            //name
            BootstrapText.Builder builder=new BootstrapText.Builder(SampleApplication.getContext());
            builder.addText(name);
            AwesomeTextView nameView=(AwesomeTextView)info.findViewById(R.id.name);
            nameView.setText(builder.build());

            //gender
            builder=new BootstrapText.Builder(context);
            AwesomeTextView genderView=(AwesomeTextView)info.findViewById(R.id.gender);
            if(student.gender.equals("male")){
                builder.addText("");
                genderView.setBootstrapText(builder.build());
                genderView.setFontAwesomeIcon("fa_male");
                genderView.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
            }

            //email
            builder=new BootstrapText.Builder(context);
            AwesomeTextView emailView=(AwesomeTextView)info.findViewById(R.id.email);
            builder.addText("邮箱:"+student.email);
            emailView.setBootstrapText(builder.build());

            //git
            builder=new BootstrapText.Builder(context);
            AwesomeTextView gitView=(AwesomeTextView)info.findViewById(R.id.git);
            builder.addText("git:"+student.gitId);
            gitView.setBootstrapText(builder.build());

            layout.addView(info);
        }


        System.out.println("showing...");
    }
}
