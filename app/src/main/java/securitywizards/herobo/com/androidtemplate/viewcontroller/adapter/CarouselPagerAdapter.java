

package securitywizards.herobo.com.androidtemplate.viewcontroller.adapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import securitywizards.herobo.com.androidtemplate.R;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.DaimajaSliderFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.DatabaseListFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.ListViewParallaxFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.ParallaxFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.SimpleWebViewFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.SweetDialogFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.SwipeFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.ButtonFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.MoviesFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.ProgressFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.SimpleFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.SimpleListFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.DialogsFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.FabFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.SliderFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.SnackbarFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.SpinnersFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.SwitchesFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.fragment.samples.material.TextfieldFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem.GradesFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem.LogoutFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem.NewStudentFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem.StudentListFragment;
import securitywizards.herobo.com.androidtemplate.viewcontroller.gradingsystem.ViewFragment;


/**
 * Pager adapter
 */
public class CarouselPagerAdapter extends FragmentPagerAdapter {

    private final Resources resources;

    /**
     * Create pager adapter
     *
     * @param resources
     * @param fragmentManager
     */
    List<FragmentGenerate> list=new ArrayList<FragmentGenerate>();
    public CarouselPagerAdapter(final Resources resources, final FragmentManager fragmentManager) {
        super(fragmentManager);
        this.resources = resources;
        list.add(new FragmentGenerate() {
            @Override
            public Fragment newInstance() {
                return StudentListFragment.newInstance();
            }
            @Override
            public String instanceName() {
                return "Students";
            }
        });
        list.add(new FragmentGenerate() {
            @Override
            public Fragment newInstance() {
                return NewStudentFragment.newInstance();
            }
            @Override
            public String instanceName() {
                return "New Student";
            }
        });
        list.add(new FragmentGenerate() {
            @Override
            public Fragment newInstance() {
                return GradesFragment.newInstance();
            }
            @Override
            public String instanceName() {
                return "Grades";
            }
        });
        list.add(new FragmentGenerate() {
            @Override
            public Fragment newInstance() {
                return ViewFragment.newInstance();
            }
            @Override
            public String instanceName() {
                return "View";
            }
        });
        list.add(new FragmentGenerate() {
            @Override
            public Fragment newInstance() {
                return LogoutFragment.newInstance();
            }
            @Override
            public String instanceName() {
                return "Logout";
            }
        });

    }


    private interface FragmentGenerate{
        abstract public Fragment newInstance();
        abstract public String instanceName();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(final int position) {
        return list.get(position).newInstance();
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return list.get(position).instanceName();
    }
}
