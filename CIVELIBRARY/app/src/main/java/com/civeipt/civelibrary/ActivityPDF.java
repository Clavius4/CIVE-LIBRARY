package com.civeipt.civelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

public class ActivityPDF extends AppCompatActivity implements OnPageErrorListener, OnLoadCompleteListener {
    ImageButton btnBack, btnReflesh;
    ProgressBar pdfViewProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        btnBack = findViewById(R.id._btnback);;
        //btnReflesh = findViewById(R.id._btnReflesh)

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityPDF.this, BooksActivity.class);
                startActivity(i );
            }
        });

        final PDFView pdfView = findViewById(R.id.pdfview);
        pdfViewProgressBar = findViewById(R.id.pdfViewProgressBar);

        pdfViewProgressBar.setVisibility(View.VISIBLE);

        Intent i = this.getIntent();
        final String path = i.getExtras().getString("PATH");

        FileLoader.with(this)
                .load(path, false)
                .fromDirectory("MY_PDFs", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        pdfViewProgressBar.setVisibility(View.GONE);
                        File pdfFile = response.getBody();

                        try {
                            pdfView.fromFile(pdfFile)
                                    .defaultPage(1)
                                    .enableAnnotationRendering(true)
                                    .onLoad(ActivityPDF.this)
                                    .scrollHandle(new DefaultScrollHandle(ActivityPDF.this))
                                    .spacing(10) // in dp
                                    .onPageError(ActivityPDF.this)
                                    .load();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        pdfViewProgressBar.setVisibility(View.GONE);
                        Toast.makeText(ActivityPDF.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void loadComplete(int nbPages) {
        pdfViewProgressBar.setVisibility(View.GONE);
        Toast.makeText(ActivityPDF.this, String.valueOf(nbPages), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageError(int page, Throwable t) {
        pdfViewProgressBar.setVisibility(View.GONE);
        Toast.makeText(ActivityPDF.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }


}

/*
*
*
*
*
*
*
* */