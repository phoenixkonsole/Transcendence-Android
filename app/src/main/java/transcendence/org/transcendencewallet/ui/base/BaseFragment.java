package transcendence.org.transcendencewallet.ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import transcendence.org.transcendencewallet.TranscendenceApplication;
import global.TranscendenceModule;

/**
 * Created by akshaynexus on 6/29/17.
 */

public class BaseFragment extends Fragment {

    protected TranscendenceApplication transcendenceApplication;
    protected TranscendenceModule transcendenceModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transcendenceApplication = TranscendenceApplication.getInstance();
        transcendenceModule = transcendenceApplication.getModule();
    }

    protected boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getActivity(),permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
