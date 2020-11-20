package com.github.appintro;

public interface AppIntroViewPagerListener {
    boolean onCanRequestNextPage();

    void onIllegallyRequestedNextPage();

    void onUserRequestedPermissionsDialog();
}
