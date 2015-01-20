package acc.resto;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by MITHUN on 1/11/2015.
 */
public class RestoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(getApplicationContext());
        Parse.initialize(getApplicationContext(), "G9RoZuVR9RNmNcw5Mppcnao6TrvF5QaAVUqrf5OI", "WYjiqHNRZtSo7xifBr0HmljpWJdytXePCsfCfTBM");

    }
}
