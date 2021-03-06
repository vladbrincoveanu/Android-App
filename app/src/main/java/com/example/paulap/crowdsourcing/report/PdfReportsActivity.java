package com.example.paulap.crowdsourcing.report;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.paulap.crowdsourcing.Models.Event;
import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.R;
import com.example.paulap.crowdsourcing.report.HeaderFooter;
import com.example.paulap.crowdsourcing.report.PDFCreatorForEvents;
import com.example.paulap.crowdsourcing.report.PDFCreatorForIssues;
import com.example.paulap.crowdsourcing.util.AppUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PdfReportsActivity extends AppCompatActivity {

    private static final String TITLE_ISSUE = "Issues";
    public static final String PDF_EXTENSION = ".pdf";
    private static final String TITLE_EVENTS = "Events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reports);

        TextView issueTextView = findViewById(R.id.reports_issues_description);
        Issue issue = AppUtil.issueList.get(AppUtil.issueList.size()-1);
        issueTextView.setText(issue.getDescription());

        TextView eventTextView = findViewById(R.id.reports_events_description);
        Event event = AppUtil.eventList.get(AppUtil.eventList.size()-1);
        eventTextView.setText(event.getTitle() + "\n" +event.getL() + "\n" + event.getData());
    }

    public void exportIssuesPdf(View view) {
        List<Issue> issues = new ArrayList<>();
        Document document = null;
        issues.add(new Issue("Groapa","Multe gropi pe strazi","Sa se asfalteze","Rutier",0,R.drawable.issue1));
        issues.add(new Issue("Mijloc de transport","Autobuzele intarzie foarte multe","Mai multe autobuze","Transport",0,R.drawable.issue2));
        issues.add(new Issue("Spatii verzi","Prea putine spatii verzi","Sa se faca mai multe parcuri","Agrement",0,R.drawable.mountain));
        try {
            //Document is not auto-closable hence need to close it separately

            String extStorageDirectory = Environment.getExternalStorageDirectory()
                    .toString();
            System.out.println("extStorageDirectory = " + extStorageDirectory + "\n");
            File folder = new File(this.getFilesDir(), "pdf");
            folder.mkdir();

            document = new Document(PageSize.A4);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    new File(folder, TITLE_ISSUE+PDF_EXTENSION)));
            HeaderFooter event = new HeaderFooter();
            event.setHeader("ISSUES");
            writer.setPageEvent(event);
            document.open();
            PDFCreatorForIssues.addMetaData(document, TITLE_ISSUE);
            PDFCreatorForIssues.addTitlePage(document, TITLE_ISSUE);
            PDFCreatorForIssues.addContent(document, issues);

        }catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        }finally{
            if(null != document){
                document.close();
            }
        }

        showIssuesPdf();
    }

    public void showIssuesPdf()
    {
        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        String yourFilePath = this.getFilesDir() + "/pdf/" + TITLE_ISSUE+PDF_EXTENSION;
        File file = new File( yourFilePath );
        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //Uri uri = Uri.fromFile(file);
        Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".com.example.paulap.crowdsourcing.provider", file);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(uri, "application/pdf");
        startActivity(intent);
    }

    public void exportEventsPdf(View view) {
        List<Event> events = new ArrayList<>();
        Document document = null;
        Location loc1 = new Location("");
        loc1.setLatitude(0.0d);
        loc1.setLongitude(0.0d);
        Location loc2 = new Location("");
        loc2.setLatitude(0.0d);
        loc2.setLongitude(0.0d);

        new Event("Strangere fonduri", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Se vor colecta fundri ptr copii nevoiasi", "Fonduri");
        new Event("Donatii oamenii strazi", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Scopul este de a ajuta oamenii strazii cum puteti. Cu haine, mancare, adapost etc. Orice este binevenit ", "Donati");
        new Event("Ajutor oameni cu dizabilitati", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Vrem sa ajutam oamenii cu dizabilitati de toate felurile. Acest voluntariat se intampla in fiecare zi, puteti participa venind la adresa mentionatat si vom discuta despre cum puteti ajuta si pe cine.", "Voluntariat");

        events.add(new Event("Strangere fonduri", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Se vor colecta fundri ptr copii nevoiasi", "Fonduri"));
        events.add(new Event("Donatii oamenii strazi", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Scopul este de a ajuta oamenii strazii cum puteti. Cu haine, mancare, adapost etc. Orice este binevenit ", "Donati"));
        events.add(new Event("Ajutor oameni cu dizabilitati", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Vrem sa ajutam oamenii cu dizabilitati de toate felurile. Acest voluntariat se intampla in fiecare zi, puteti participa venind la adresa mentionatat si vom discuta despre cum puteti ajuta si pe cine.", "Voluntariat"));

        try {
            File folder = new File(this.getFilesDir(), "pdf");
            folder.mkdir();
            document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    new File(folder, TITLE_EVENTS+PDF_EXTENSION)));
            HeaderFooter event = new HeaderFooter();
            event.setHeader("EVENTS");
            writer.setPageEvent(event);
            document.open();
            PDFCreatorForEvents.addMetaData(document, TITLE_EVENTS);
            PDFCreatorForEvents.addTitlePage(document, TITLE_EVENTS);
            PDFCreatorForEvents.addContent(document, events);

        }catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        }finally{
            if(null != document){
                document.close();
            }
        }

        showEventsPdf();
    }

    public void showEventsPdf()
    {
        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        String yourFilePath = this.getFilesDir() + "/pdf/" + TITLE_EVENTS+PDF_EXTENSION;
        File file = new File( yourFilePath );
        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //Uri uri = Uri.fromFile(file);
        Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".com.example.paulap.crowdsourcing.provider", file);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(uri, "application/pdf");
        startActivity(intent);
    }
}
