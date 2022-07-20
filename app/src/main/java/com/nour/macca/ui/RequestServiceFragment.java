package com.nour.macca.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nour.macca.R;
import com.nour.macca.Utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RequestServiceFragment extends Fragment {


    public EditText etPhone, etName, etService;
    public Button sendBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_request_service, container, false);
        etPhone = (EditText)root.findViewById(R.id.phone);
        etName = (EditText)root.findViewById(R.id.name);
        etService = (EditText)root.findViewById(R.id.service);

        sendBtn = root.findViewById(R.id.send_button);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });

        return root;
    }

    private void check() {

        String phone = etPhone.getText().toString().trim();
        String name = etName.getText().toString();
        String service = etService.getText().toString();

        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(getActivity(),"قم بإدخال رقم الهاتف",Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(name))
        {
            Toast.makeText(getActivity(),"قم بإدخال الاسم",Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(service))
        {
            Toast.makeText(getActivity(),"قم بإدخال الخدمة المطلوبة",Toast.LENGTH_SHORT).show();

        }
        else {
            String message = name.concat("\nالخدمة المطلوبة :\n" + service).trim();

            Properties props = new Properties();


            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");


            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
                }
            });

            try {
                //Creating MimeMessage object
                Message mm = new MimeMessage(session);

                //Setting sender address
                mm.setFrom(new InternetAddress(Utils.EMAIL));
                //Adding receiver
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(Utils.EMAIL));
                //Adding subject
                mm.setSubject(phone);
                //Adding message
                mm.setText(message);
                //Sending email


                new SendEmail().execute(mm);


            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    }

    private class SendEmail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(),"يتم إرسال الطلب", "انتظر...",true,false);

        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
            if (s.equals("Success")){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                //builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setTitle("تم إرسال طلبك بنجاح!");
                builder.setMessage("شكراً لك,سيتم التواصل معك قريباً");
                builder.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        etPhone.setText("");
                        etName.setText("");
                        etService.setText("");
                    }
                });
                builder.show();

            }
            else {
                Toast.makeText(getActivity(),"حدث خطأ,حاول مرة أخرى!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}