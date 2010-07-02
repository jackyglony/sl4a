package com.googlecode.pythonforandroid;

import java.io.File;

import android.content.Context;

import com.google.ase.AseLog;
import com.google.ase.AsyncTaskListener;
import com.google.ase.InterpreterInstaller;
import com.google.ase.exception.AseException;
import com.google.ase.interpreter.InterpreterConstants;
import com.google.ase.interpreter.InterpreterDescriptor;

public class PythonInstaller extends InterpreterInstaller {

  public PythonInstaller(InterpreterDescriptor descriptor, Context context,
      AsyncTaskListener<Boolean> listener) throws AseException {
    super(descriptor, context, listener);
  }

  @Override
  protected boolean setup() {
    File tmp =
        new File(InterpreterConstants.INTERPRETER_EXTRAS_ROOT, mDescriptor.getName() + "/tmp");
    if (!tmp.isDirectory()) {
      try {
        tmp.mkdir();
      } catch (SecurityException e) {
        AseLog.e(mContext, "Setup failed.", e);
        return false;
      }
    }
    return true;
  }
}