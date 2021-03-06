package in.trentweet.myapplication.utilities;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Widget extends AppCompatActivity {

    private Context context;
    private AlertDialog alert;

    public Widget(Context context) {
        this.context = context;
    }

    public void hideKeyBoard(EditText input) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
    }

    public void showSnackBar(View view, String message, int length, int snackBarType) {
        Snackbar snackbar = Snackbar.make(view, message, length);

        TextView textView = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);

        if (snackBarType == 1)
            textView.setTextColor(Color.GREEN);
        else
            textView.setTextColor(Color.RED);

        snackbar.show();
    }

    public String getTextFromEditText(EditText text) {
        return text.getText().toString().trim();
    }

    public Boolean isLessThan(EditText text, int length) {
        if (getTextFromEditText(text).length() <= length)
            return true;
        else
            return false;
    }

    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public boolean isValidEmail(EditText et) {
        String email = getTextFromEditText(et);

        if ((!TextUtils.isEmpty(email)) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return true;
        else return false;

    }

}
