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
import securitywizards.herobo.com.androidtemplate.other.helper.AndroidUtils;
import securitywizards.herobo.com.androidtemplate.viewcontroller.activity.LoginActivity;
import securitywizards.herobo.com.androidtemplate.viewcontroller.activity.MainActivity;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.BaseFragment;

/**
 * Fragment which houses the View pager.
 */
public class LogoutFragment extends BaseFragment {

    @Inject
    AndroidUtils androidUtils;
    @InjectView(R.id.btnLogout)
    Button btnLogout;

    @Override
    public View onCreateView2(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }

    @Override
    public void onActivityCreated2(Bundle savedInstanceState) {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidUtils.loadActivity(LogoutFragment.this.getActivity(), LoginActivity.class);
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
        LogoutFragment loginFragment =new LogoutFragment();
        loginFragment.setRetainInstance(true);
        return loginFragment;
    }
}