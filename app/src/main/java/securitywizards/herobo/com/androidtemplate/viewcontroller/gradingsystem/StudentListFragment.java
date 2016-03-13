package securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import securitywizards.herobo.com.androidtemplate.R;
import securitywizards.herobo.com.androidtemplate.model.businesslayer.BoxRepository;
import securitywizards.herobo.com.androidtemplate.model.businesslayer.StudentRepository;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.Box;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.Student;
import securitywizards.herobo.com.androidtemplate.other.helper.AndroidUtils;
import securitywizards.herobo.com.androidtemplate.viewcontroller.adapter.DbItemsAdapter;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.BaseFragment;

/**
 * Fragment which houses the View pager.
 */
public class StudentListFragment extends BaseFragment {

    @Inject AndroidUtils androidUtils;
    @Inject
    StudentRepository studentRepository;


    @InjectView(R.id.lvListHolder)
    ListView lvListHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView2(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simplelist, container, false);
    }
    volatile StudentListAdapter adapter;
    @Override
    public void onActivityCreated2(Bundle savedInstanceState) {
        adapter=new StudentListAdapter(getActivity());
        lvListHolder.setAdapter(adapter);
        lvListHolder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                androidUtils.alert("Click ListItem Number " + position);
            }
        });
        List<Student> students=studentRepository.getAllStudents(getActivity());
//        if(students.size()==0){
//            for(int ctr=1;ctr<=100;ctr++) {
//                Student student=new Student()
//                student.setFirstname(ctr+"firstname");
//                studentRepository.insertOrUpdate(getActivity(), student);
//            }
//            students=studentRepository.getAllStudents(getActivity());
//        }

        adapter.updateData(students);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){}
    @Override
    public void onSaveInstanceState2(Bundle outState) {
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null){
            List<Student> students=studentRepository.getAllStudents(getActivity());
            adapter.notifyDataSetChanged();
        }
    }
    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            if(adapter!=null){
                List<Student> students=studentRepository.getAllStudents(getActivity());
                adapter.notifyDataSetChanged();
            }
        }
    }
    public static Fragment newInstance(){
        StudentListFragment simpleFragment =new StudentListFragment();
        return simpleFragment;
    }
    boolean isDestroyed=false;
    @Override
    public void onDestroy() {
        super.onDestroy();
        isDestroyed=true;
    }
}