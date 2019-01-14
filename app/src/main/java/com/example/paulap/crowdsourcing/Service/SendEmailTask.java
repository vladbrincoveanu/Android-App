package com.example.paulap.crowdsourcing.Service;

import android.os.AsyncTask;

import java.net.URL;

public class SendEmailTask extends AsyncTask<URL, Integer, Long> {

    private GMailSender gMailSender;
    private String to;
    private String sunject;
    private String content;

public  SendEmailTask(String to,String subject,String content){

    this.to = to;
    this.sunject = subject;
    this.content = content;
    this.gMailSender = new GMailSender("sd.proiect.3.2@gmail.com","proiect_3");

}
    @Override
    protected Long doInBackground(URL... urls) {
        long totalSize = 0;
        try {
            this.gMailSender.sendMail(this.to,this.sunject,this.content);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return totalSize;
    }
    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(Long result) {
    }
}
