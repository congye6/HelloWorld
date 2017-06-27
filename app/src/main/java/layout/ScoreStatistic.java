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
import android.widget.TextView;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Controller.ScoreController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.MyXFormatter;
import com.example.cong.helloworld.vo.AllScore;
import com.example.cong.helloworld.vo.StudentScore;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ScoreStatistic extends Fragment {


    public ScoreStatistic() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ScoreStatistic newInstance() {
        ScoreStatistic fragment = new ScoreStatistic();

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
        View view=inflater.inflate(R.layout.fragment_score_statistic, container, false);
        ScoreController controller=new ScoreController(this);
        controller.getScores(90);
        return view;
    }

    public void setData(AllScore[] scores){
        LinearLayout layout=(LinearLayout) getActivity().findViewById(R.id.score_list);
        Context context= SampleApplication.getContext();
        if(scores.length==0){
            //显示无数据
            TextView alert=new TextView(context);
            alert.setText("暂无数据");
            layout.addView(alert);
            return;
        }
        for(AllScore score:scores){
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View view=inflater.inflate(R.layout.score_info,null);

            TextView title=(TextView) view.findViewById(R.id.title);
            title.setText(score.getQuestionInfo().title);

            TextView description=(TextView)view.findViewById(R.id.description);
            description.setText(score.getQuestionInfo().description);

            BarChart chart=(BarChart) view.findViewById(R.id.first_chart);

            //x轴
            String[] scoreAreas={
              "60以下","60-69","70-79","80-89","90-100"
            };
            List<String> x=new ArrayList<>();
            for(String scoreArea:scoreAreas){
                x.add(scoreArea);
            }

            //
            int[] counts=new int[5];
            Arrays.fill(counts,0);
            for(StudentScore studentScore:score.students){
                if(!studentScore.getScored().equals("true"))
                    continue;
                double num=studentScore.getScore();
                if(num<60)
                    counts[0]++;
                if(num>=60&&num<70)
                    counts[1]++;
                if(num>=70&&num<80)
                    counts[2]++;
                if(num>=80&&num<90)
                    counts[3]++;
                if(num>=90&&num<=100)
                    counts[4]++;
            }
            List<BarEntry> y=new ArrayList<>();
            for(int i=0;i<5;i++){
                BarEntry entry=new BarEntry(i,counts[i]);
                y.add(entry);
            }

            IBarDataSet data=new BarDataSet(y,"分数");
            BarData barData=new BarData(data);

            chart.setData(barData);

            XAxis xAxis = chart.getXAxis();
            xAxis.setDrawAxisLine(false);
            xAxis.setDrawGridLines(false);
            MyXFormatter formatter=new MyXFormatter(scoreAreas);
            xAxis.setValueFormatter(formatter);
            chart.getAxisLeft().setDrawAxisLine(false);

            chart.getDescription().setEnabled(false);//设置描述
            chart.setPinchZoom(true);//设置按比例放缩柱状图
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴标签显示位置

            chart.setExtraBottomOffset(10);//距视图窗口底部的偏移，类似与paddingbottom
            chart.setExtraTopOffset(30);//距视图窗口顶部的偏移，类似与paddingtop
            chart.setFitBars(true);//使两侧的柱图完全显示
            chart.animateX(1500);//数据显示动画，从左往右依次显示

            layout.addView(view);
        }



    }

}
