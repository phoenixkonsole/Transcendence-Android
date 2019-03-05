package transcendence.org.transcendencewallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import transcendence.org.transcendencewallet.TranscendenceApplication;
import transcendence.org.transcendencewallet.ui.splash_activity.SplashActivity;
import transcendence.org.transcendencewallet.ui.wallet_activity.WalletActivity;
import transcendence.org.transcendencewallet.utils.AppConf;

/**
 * Created by akshaynexus on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TranscendenceApplication transcendenceApplication = TranscendenceApplication.getInstance();
        AppConf appConf = transcendenceApplication.getAppConf();
        // show report dialog if something happen with the previous process
        Intent intent;
        if (!appConf.isAppInit() || appConf.isSplashSoundEnabled()){
            intent = new Intent(this, SplashActivity.class);
        }else {
            intent = new Intent(this, WalletActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
