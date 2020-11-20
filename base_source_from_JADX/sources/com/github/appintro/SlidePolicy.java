package com.github.appintro;

public interface SlidePolicy {
    boolean isPolicyRespected();

    void onUserIllegallyRequestedNextPage();
}
