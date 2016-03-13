package securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rey.material.widget.EditText;

import javax.inject.Inject;

import butterknife.InjectView;
import securitywizards.herobo.com.androidtemplate.R;
import securitywizards.herobo.com.androidtemplate.other.helper.AndroidUtils;
import securitywizards.herobo.com.androidtemplate.viewcontroller.activity.MainActivity;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.BaseFragment;

/**
 * Fragment which houses the View pager.
 */
public class GradesFragment extends BaseFragment {

    @Inject
    AndroidUtils androidUtils;
    @InjectView(R.id.etGrade)
    EditText etGrade;
    @InjectView(R.id.tvResult)
    TextView tvResult;
    @InjectView(R.id.btnCompute)
    Button btnCompute;

    @Override
    public View onCreateView2(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grades, container, false);
    }

    @Override
    public void onActivityCreated2(Bundle savedInstanceState) {
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int grade=Integer.parseInt(etGrade.getText().toString());


                //                EditText etatten = (EditText) findViewById(R.id.editText);
//                EditText etquizrecass = (EditText) findViewById(R.id.editText3);
//                EditText etlab = (EditText) findViewById(R.id.editText8);
//                EditText etcasestudy = (EditText) findViewById(R.id.editText9);
//                EditText etexam = (EditText) findViewById(R.id.editText12);
//
//                Double num1, num2, num3, num4, num5,sum,ave;
//
//                num1 = Double.parseDouble(etatten .getText().toString());
//                num2 = Double.parseDouble(etquizrecass.getText().toString());
//                num3 = Double.parseDouble(etlab.getText().toString());
//                num4 = Double.parseDouble(etcasestudy.getText().toString());
//                num5 = Double.parseDouble(etexam.getText().toString());
//
//                sum = num1 + num2 + num3 + num4 + num5;
//                ave = sum / 5;
//
//                //if (num1 < 100) {
//                    String.valueOf("num1");
//
//                //} else if (num1 > 100); {
//
//                //}
//
//                displaygrade.setText(String.valueOf(ave));
                tvResult.setText("Result : "+grade);
            }
        });
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){

    }

    //Here you Save your data
    @Override
    public void onSaveInstanceState2(Bundle outState) {

    }


    public static Fragment newInstance(){
        GradesFragment loginFragment =new GradesFragment();
        loginFragment.setRetainInstance(true);
        return loginFragment;
    }
}