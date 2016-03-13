package securitywizards.herobo.com.androidtemplate.model.businesslayer;

import android.content.Context;

import java.util.List;

import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.Box;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.BoxDao;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.DaoSession;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.Student;
import securitywizards.herobo.com.androidtemplate.model.dataaccesslayer.greendao.StudentDao;


/**
 * Created by surecase on 19/03/14.
 */
public class StudentRepository {
    DaoSession daoSession;
    public StudentRepository(DaoSession daoSession){
        this.daoSession=daoSession;
    }
    public void insertOrUpdate(Context context, Student student) {
        getStudentDao(context).insertOrReplace(student);
    }

    public void clearBoxes(Context context) {
        getStudentDao(context).deleteAll();
    }

    public void deleteBoxWithId(Context context, long id) {
        getStudentDao(context).delete(getStudentForId(context, id));
    }

    public Student getStudentForId(Context context, long id) {
        return getStudentDao(context).load(id);
    }

    public List<Student> getAllStudents(Context context) {
        return getStudentDao(context).loadAll();
    }

    public StudentDao getStudentDao(Context c) {
        return daoSession.getStudentDao();
    }
}
