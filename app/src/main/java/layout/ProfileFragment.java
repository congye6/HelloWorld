package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.beardedhen.androidbootstrap.BootstrapThumbnail;
import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Activity.listener.LogoutListener;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.PropertyTool;

import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {




    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String type=PropertyTool.getInfo(SampleApplication.getContext(),"type");
        View view=null;
        if(type!=null&&type.equals("teacher"))
            view=inflater.inflate(R.layout.fragment_profile_teacher, container, false);
        else
            view=inflater.inflate(R.layout.fragment_profile, container, false);
        flate((RelativeLayout) view);
        return view;
    }

    private void flate(RelativeLayout view) {
        Context context= SampleApplication.getContext();

        //TODO
        BootstrapCircleThumbnail thumbnail = (BootstrapCircleThumbnail) view.findViewById(R.id.avatar);


        LogoutListener listener=new LogoutListener((MainActivity) getActivity());
        BootstrapButton button=(BootstrapButton) view.findViewById(R.id.login);
        button.setOnClickListener(listener);

        TextView name=(TextView)view.findViewById(R.id.name);
        name.setText(PropertyTool.getInfo(context,"name"));

        String type=PropertyTool.getInfo(context,"type");
        BootstrapLabel typeLabel=(BootstrapLabel)view.findViewById(R.id.type);

        TextView username=(TextView)view.findViewById(R.id.username);
        username.setText("用户名:"+PropertyTool.getInfo(context,context.getString(R.string.username)));

        TextView email=(TextView)view.findViewById(R.id.email);
        email.setText("email:"+PropertyTool.getInfo(context,"email"));

        if(type!=null&&type.equals("teacher")){
            typeLabel.setText("老师");
        }else{
            typeLabel.setText("学生");
            TextView number=(TextView)view.findViewById(R.id.number);
            number.setText("学号:"+PropertyTool.getInfo(context,"number"));
            TextView git=(TextView)view.findViewById(R.id.git);
            git.setText("git:"+PropertyTool.getInfo(context,"gitId"));
        }
    }


}
