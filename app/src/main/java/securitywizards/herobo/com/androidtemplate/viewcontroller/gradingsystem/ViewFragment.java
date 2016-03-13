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
import securitywizards.herobo.com.androidtemplate.viewcontroller.activity.MainActivity;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.BaseFragment;

/**
 * Fragment which houses the View pager.
 */
public class ViewFragment extends BaseFragment {

    @Inject
    AndroidUtils androidUtils;
    @InjectView(R.id.etUsername)
    EditText etUsername;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    @InjectView(R.id.btnLogin)
    Button btnLogin;

    @Override
    public View onCreateView2(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    @Override
    public void onActivityCreated2(Bundle savedInstanceState) {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("secret123")){
                    androidUtils.loadActivity(ViewFragment.this.getActivity(), MainActivity.class);
                }else{
                    etUsername.setText("");
                    etPassword.setText("");
                    androidUtils.alert("Failed Login");
                }
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
        ViewFragment loginFragment =new ViewFragment();
        loginFragment.setRetainInstance(true);
        return loginFragment;
    }
}