package edu.unc.hanbit.healthbuddy;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by conrad on 12/4/17.
 */

public class EmailActivity  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }
}

//public class GMailSender {
//    private Session session;
//    private String token;
//
//
//    public String getToken() {
//        return token;
//    }
//
//    public GMailSender(Activity ctx) {
//        super();
//        initToken(ctx);
//    }
//
//    public void initToken(Activity ctx) {
//
//        AccountManager am = AccountManager.get(ctx);
//
//        Account[] accounts = am.getAccountsByType("com.google");
//        for (Account account : accounts) {
//            Log.d("getToken", "account="+account);
//        }
//
//        Account me = accounts[0]; //You need to get a google account on the device, it changes if you have more than one
//
//
//        am.getAuthToken(me, "oauth2:https://mail.google.com/", null, ctx, new AccountManagerCallback<Bundle>(){
//            @Override
//            public void run(AccountManagerFuture<Bundle> result){
//                try{
//                    Bundle bundle = result.getResult();
//                    token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
//                    Log.d("initToken callback", "token="+token);
//
//                } catch (Exception e){
//                    Log.d("test", e.getMessage());
//                }
//            }
//        }, null);
//
//        Log.d("getToken", "token="+token);
//    }
//
//
//
//    public SMTPTransport connectToSmtp(String host, int port, String userEmail,
//                                       String oauthToken, boolean debug) throws Exception {
//
//        Properties props = new Properties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.smtp.sasl.enable", "false");
//
//        session = Session.getInstance(props);
//        session.setDebug(debug);
//
//        final URLName unusedUrlName = null;
//        SMTPTransport transport = new SMTPTransport(session, unusedUrlName);
//        // If the password is non-null, SMTP tries to do AUTH LOGIN.
//        final String emptyPassword = null;
//
//        /* enable if you use this code on an Activity (just for test) or use the AsyncTask
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//         */
//
//        transport.connect(host, port, userEmail, emptyPassword);
//
//        byte[] response = String.format("user=%s\1auth=Bearer %s\1\1",
//                userEmail, oauthToken).getBytes();
//        response = BASE64EncoderStream.encode(response);
//
//        transport.issueCommand("AUTH XOAUTH2 " + new String(response), 235);
//
//        return transport;
//    }
//
//    public synchronized void sendMail(String subject, String body, String user,
//                                      String oauthToken, String recipients) {
//        try {
//
//            SMTPTransport smtpTransport = connectToSmtp("smtp.gmail.com", 587,
//                    user, oauthToken, true);
//
//            MimeMessage message = new MimeMessage(session);
//            DataHandler handler = new DataHandler(new ByteArrayDataSource(
//                    body.getBytes(), "text/plain"));
//            message.setSender(new InternetAddress(user));
//            message.setSubject(subject);
//            message.setDataHandler(handler);
//            if (recipients.indexOf(',') > 0)
//                message.setRecipients(Message.RecipientType.TO,
//                        InternetAddress.parse(recipients));
//            else
//                message.setRecipient(Message.RecipientType.TO,
//                        new InternetAddress(recipients));
//            smtpTransport.sendMessage(message, message.getAllRecipients());
//
//        } catch (Exception e) {
//            Log.d("test", e.getMessage(), e);
//        }
////    }
//
//}
