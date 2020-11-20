package com.unboundid.ldap.sdk;

import com.unboundid.util.Validator;
import java.util.List;

public abstract class UpdatableLDAPRequest extends LDAPRequest {
    private static final long serialVersionUID = 2487230102594573848L;

    protected UpdatableLDAPRequest(Control[] controlArr) {
        super(controlArr);
    }

    public final void addControl(Control control) {
        Validator.ensureNotNull(control);
        Control[] controls = getControls();
        Control[] controlArr = new Control[(controls.length + 1)];
        System.arraycopy(controls, 0, controlArr, 0, controls.length);
        controlArr[controls.length] = control;
        setControlsInternal(controlArr);
    }

    public final void addControls(Control... controlArr) {
        if (controlArr != null && controlArr.length != 0) {
            Control[] controls = getControls();
            Control[] controlArr2 = new Control[(controls.length + controlArr.length)];
            System.arraycopy(controls, 0, controlArr2, 0, controls.length);
            System.arraycopy(controlArr, 0, controlArr2, controls.length, controlArr.length);
            setControlsInternal(controlArr2);
        }
    }

    public final void clearControls() {
        setControlsInternal(NO_CONTROLS);
    }

    public final Control removeControl(String str) {
        Control control;
        Validator.ensureNotNull(str);
        Control[] controls = getControls();
        int i = 0;
        while (true) {
            if (i >= controls.length) {
                i = -1;
                control = null;
                break;
            } else if (controls[i].getOID().equals(str)) {
                control = controls[i];
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return null;
        }
        if (controls.length == 1) {
            setControlsInternal(NO_CONTROLS);
        } else {
            Control[] controlArr = new Control[(controls.length - 1)];
            int i2 = 0;
            for (int i3 = 0; i3 < controls.length; i3++) {
                if (i3 != i) {
                    controlArr[i2] = controls[i3];
                    i2++;
                }
            }
            setControlsInternal(controlArr);
        }
        return control;
    }

    public final boolean removeControl(Control control) {
        Control[] controlArr;
        Validator.ensureNotNull(control);
        Control[] controls = getControls();
        int i = 0;
        while (true) {
            if (i >= controls.length) {
                i = -1;
                break;
            } else if (controls[i].equals(control)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return false;
        }
        if (controls.length == 1) {
            controlArr = NO_CONTROLS;
        } else {
            controlArr = new Control[(controls.length - 1)];
            int i2 = 0;
            for (int i3 = 0; i3 < controls.length; i3++) {
                if (i3 != i) {
                    controlArr[i2] = controls[i3];
                    i2++;
                }
            }
        }
        setControlsInternal(controlArr);
        return true;
    }

    public final Control replaceControl(Control control) {
        Validator.ensureNotNull(control);
        return replaceControl(control.getOID(), control);
    }

    public final Control replaceControl(String str, Control control) {
        Validator.ensureNotNull(str);
        if (control == null) {
            return removeControl(str);
        }
        Control[] controls = getControls();
        for (int i = 0; i < controls.length; i++) {
            if (controls[i].getOID().equals(str)) {
                Control control2 = controls[i];
                controls[i] = control;
                setControlsInternal(controls);
                return control2;
            }
        }
        Control[] controlArr = new Control[(controls.length + 1)];
        System.arraycopy(controls, 0, controlArr, 0, controls.length);
        controlArr[controls.length] = control;
        setControlsInternal(controlArr);
        return null;
    }

    public final void setControls(List<Control> list) {
        setControlsInternal((list == null || list.isEmpty()) ? NO_CONTROLS : (Control[]) list.toArray(new Control[list.size()]));
    }

    public final void setControls(Control... controlArr) {
        if (controlArr == null) {
            controlArr = NO_CONTROLS;
        }
        setControlsInternal(controlArr);
    }
}
