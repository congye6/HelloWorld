package layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.RegisterActivity;
import com.example.cong.helloworld.Controller.LoginController;
import com.example.cong.helloworld.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {


    private Activity activity;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

        return fragment;
    }

    public void showSuccess(){
        activity=this.getActivity();
        if(activity==null)
            return;
        BootstrapLabel label=(BootstrapLabel) activity.findViewById(R.id.successLabel);
        label.setVisibility(View.VISIBLE);
        BootstrapLabel fail=(BootstrapLabel) activity.findViewById(R.id.failLabel);
        fail.setVisibility(View.INVISIBLE);
    }

    public void showError(){
        activity=this.getActivity();
        if(activity==null)
            return;
        BootstrapLabel label=(BootstrapLabel) activity.findViewById(R.id.failLabel);
        label.setVisibility(View.VISIBLE);
        BootstrapLabel success=(BootstrapLabel) activity.findViewById(R.id.successLabel);
        success.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }








}
