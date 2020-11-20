package com.wang.avi.indicators;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.wang.avi.Indicator;

public class BallTrianglePathIndicator extends Indicator {
    float[] translateX = new float[3];
    float[] translateY = new float[3];

    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate(this.translateX[i], this.translateY[i]);
            canvas.drawCircle(0.0f, 0.0f, (float) (getWidth() / 10), paint);
            canvas.restore();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<android.animation.ValueAnimator> onCreateAnimators() {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r12.getWidth()
            int r1 = r1 / 5
            float r1 = (float) r1
            int r2 = r12.getWidth()
            int r2 = r2 / 5
            float r2 = (float) r2
            r3 = 0
            r4 = 0
        L_0x0015:
            r5 = 3
            if (r4 >= r5) goto L_0x010c
            r6 = 4
            float[] r7 = new float[r6]
            int r8 = r12.getWidth()
            r9 = 2
            int r8 = r8 / r9
            float r8 = (float) r8
            r7[r3] = r8
            int r8 = r12.getWidth()
            float r8 = (float) r8
            float r8 = r8 - r1
            r10 = 1
            r7[r10] = r8
            r7[r9] = r1
            int r8 = r12.getWidth()
            int r8 = r8 / r9
            float r8 = (float) r8
            r7[r5] = r8
            android.animation.ValueAnimator r7 = android.animation.ValueAnimator.ofFloat(r7)
            if (r4 != r10) goto L_0x005e
            float[] r7 = new float[r6]
            int r8 = r12.getWidth()
            float r8 = (float) r8
            float r8 = r8 - r1
            r7[r3] = r8
            r7[r10] = r1
            int r8 = r12.getWidth()
            int r8 = r8 / r9
            float r8 = (float) r8
            r7[r9] = r8
            int r8 = r12.getWidth()
            float r8 = (float) r8
            float r8 = r8 - r1
            r7[r5] = r8
        L_0x0059:
            android.animation.ValueAnimator r7 = android.animation.ValueAnimator.ofFloat(r7)
            goto L_0x0077
        L_0x005e:
            if (r4 != r9) goto L_0x0077
            float[] r7 = new float[r6]
            r7[r3] = r1
            int r8 = r12.getWidth()
            int r8 = r8 / r9
            float r8 = (float) r8
            r7[r10] = r8
            int r8 = r12.getWidth()
            float r8 = (float) r8
            float r8 = r8 - r1
            r7[r9] = r8
            r7[r5] = r1
            goto L_0x0059
        L_0x0077:
            float[] r8 = new float[r6]
            r8[r3] = r2
            int r11 = r12.getHeight()
            float r11 = (float) r11
            float r11 = r11 - r2
            r8[r10] = r11
            int r11 = r12.getHeight()
            float r11 = (float) r11
            float r11 = r11 - r2
            r8[r9] = r11
            r8[r5] = r2
            android.animation.ValueAnimator r8 = android.animation.ValueAnimator.ofFloat(r8)
            if (r4 != r10) goto L_0x00b4
            float[] r6 = new float[r6]
            int r8 = r12.getHeight()
            float r8 = (float) r8
            float r8 = r8 - r2
            r6[r3] = r8
            int r8 = r12.getHeight()
            float r8 = (float) r8
            float r8 = r8 - r2
            r6[r10] = r8
            r6[r9] = r2
            int r8 = r12.getHeight()
            float r8 = (float) r8
            float r8 = r8 - r2
            r6[r5] = r8
        L_0x00af:
            android.animation.ValueAnimator r8 = android.animation.ValueAnimator.ofFloat(r6)
            goto L_0x00d3
        L_0x00b4:
            if (r4 != r9) goto L_0x00d3
            float[] r6 = new float[r6]
            int r8 = r12.getHeight()
            float r8 = (float) r8
            float r8 = r8 - r2
            r6[r3] = r8
            r6[r10] = r2
            int r8 = r12.getHeight()
            float r8 = (float) r8
            float r8 = r8 - r2
            r6[r9] = r8
            int r8 = r12.getHeight()
            float r8 = (float) r8
            float r8 = r8 - r2
            r6[r5] = r8
            goto L_0x00af
        L_0x00d3:
            r5 = 2000(0x7d0, double:9.88E-321)
            r7.setDuration(r5)
            android.view.animation.LinearInterpolator r9 = new android.view.animation.LinearInterpolator
            r9.<init>()
            r7.setInterpolator(r9)
            r9 = -1
            r7.setRepeatCount(r9)
            com.wang.avi.indicators.BallTrianglePathIndicator$1 r10 = new com.wang.avi.indicators.BallTrianglePathIndicator$1
            r10.<init>(r4)
            r12.addUpdateListener(r7, r10)
            r8.setDuration(r5)
            android.view.animation.LinearInterpolator r5 = new android.view.animation.LinearInterpolator
            r5.<init>()
            r8.setInterpolator(r5)
            r8.setRepeatCount(r9)
            com.wang.avi.indicators.BallTrianglePathIndicator$2 r5 = new com.wang.avi.indicators.BallTrianglePathIndicator$2
            r5.<init>(r4)
            r12.addUpdateListener(r8, r5)
            r0.add(r7)
            r0.add(r8)
            int r4 = r4 + 1
            goto L_0x0015
        L_0x010c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wang.avi.indicators.BallTrianglePathIndicator.onCreateAnimators():java.util.ArrayList");
    }
}
