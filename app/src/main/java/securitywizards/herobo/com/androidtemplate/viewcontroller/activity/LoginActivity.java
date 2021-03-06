package securitywizards.herobo.com.androidtemplate.viewcontroller.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.rey.material.widget.SnackBar;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.InjectView;
import securitywizards.herobo.com.androidtemplate.R;
import securitywizards.herobo.com.androidtemplate.other.helper.AndroidUtils;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.CarouselFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem.LoginFragment;


public class LoginActivity extends BaseActivity {

    @Inject
    AndroidUtils androidUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidUtils.loadFragment(this,R.id.container, LoginFragment.newInstance());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
