package com.glandroid.readcontacts;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import com.glandroid.readcontacts.domain.ContactInfo;
import com.glandroid.readcontacts.utils.ContactInfoUtils;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        performCodeWithPermission("读取联系人", new PermissionCallback() {
            @Override
            public void hasPermission() {
                List<ContactInfo> infos = ContactInfoUtils.getAllContactInfos(MainActivity.this);
                for (ContactInfo info : infos) {
                    System.out.println(info.toString());
                }
            }

            @Override
            public void noPermission() {

            }
        }, Manifest.permission.READ_CONTACTS);
    }
}
