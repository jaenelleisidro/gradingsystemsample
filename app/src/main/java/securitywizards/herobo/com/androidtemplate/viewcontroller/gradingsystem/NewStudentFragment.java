package securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rey.material.widget.EditText;

import javax.inject.Inject;

import butterknife.InjectView;
import securitywizards.herobo.com.androidtemplate.R;
import securitywizards.herobo.com.androidtemplate.model.businesslayer.StudentRepository;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.Student;
import securitywizards.herobo.com.androidtemplate.other.helper.AndroidUtils;
import securitywizards.herobo.com.androidtemplate.viewcontroller.activity.MainActivity;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.BaseFragment;

/**
 * Fragment which houses the View pager.
 */
public class NewStudentFragment extends BaseFragment {

    @Inject
    AndroidUtils androidUtils;
    @Inject
    StudentRepository studentRepository;

    @InjectView(R.id.etFirstname)
    EditText etFirstname;
    @InjectView(R.id.etLastname)
    EditText etLastname;
    @InjectView(R.id.etSection)
    EditText etSection;
    @InjectView(R.id.etProgram)
    EditText etProgram;
    @InjectView(R.id.btnAddNewStudent)
    Button btnAddNewStudent;

    @Override
    public View onCreateView2(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_newstudent, container, false);
    }

    @Override
    public void onActivityCreated2(Bundle savedInstanceState) {

//        student.addStringProperty("firstname");
//        student.addStringProperty("lastname");
//        student.addStringProperty("section");
//        student.addStringProperty("program");

        btnAddNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname=etFirstname.getText().toString();
                String lastname=etLastname.getText().toString();
                String program=etProgram.getText().toString();
                String section=etSection.getText().toString();
                Student student =new Student();
                student.setFirstname(firstname);
                student.setLastname(lastname);
                student.setProgram(program);
                student.setSection(section);
                studentRepository.insertOrUpdate(getActivity(),student);
                etFirstname.setText("");
                etLastname.setText("");
                etProgram.setText("");
                etSection.setText("");
                androidUtils.alert("Successfully Added");
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
        NewStudentFragment loginFragment =new NewStudentFragment();
        loginFragment.setRetainInstance(true);
        return loginFragment;
    }
}