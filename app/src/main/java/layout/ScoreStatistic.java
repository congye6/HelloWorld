package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cong.helloworld.Controller.ScoreController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.vo.AllScore;
import com.github.mikephil.charting.charts.LineChart;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScoreStatistic.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScoreStatistic#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreStatistic extends Fragment {


    public ScoreStatistic() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScoreStatistic.
     */
    // TODO: Rename and change types and number of parameters
    public static ScoreStatistic newInstance() {
        ScoreStatistic fragment = new ScoreStatistic();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScoreController controller=new ScoreController(this);
        controller.getScores(38);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score_statistic, container, false);
    }

    public void setData(AllScore[] scores){
        LinearLayout layout=(LinearLayout) getActivity().findViewById(R.id.score_list);

        if(scores.length==0){
            //显示无数据
        }
        for(AllScore score:scores){
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View view=inflater.inflate(R.layout.score_info,null);
            LineChart chart=(LineChart) view.findViewById(R.id.chart);




            layout.addView(view);
        }



    }

}
