package com.civeipt.civelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {
    public static String _neg_no=null, reg_no_=null;
    ImageButton btnback, btnreflesh;
    TextView txtName, txtcategory, txtFileName, txtDate, txtId;
    public static URLs urLs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        btnback = findViewById(R.id.btnback);
        btnreflesh = findViewById(R.id.btnReflesh);
        urLs = new URLs();

        Intent i = getIntent();
        _neg_no=i.getStringExtra(reg_no_);

        final GridView myGridView = findViewById(R.id.mygridView);
        final ProgressBar myProgressBar = findViewById(R.id.myprogressBar);


        btnback.setOnClickListener(view1 -> {
            Intent intent = new Intent(BooksActivity.this, HomeActivity.class);
            intent.putExtra(HomeActivity.reg_no, String.valueOf(_neg_no));
            startActivity(intent);
        });

        btnreflesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(BooksActivity.this).retrieve(myGridView, myProgressBar);
            }
        });

    }

    public class PDFDoc {
        String BookName, id, category, pdfURL, fileName, dateUpploaded;

        public String getBookName() {
            return BookName;
        }

        public void setBookName(String bookName) {
            BookName = bookName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getDateUpploaded() {
            return dateUpploaded;
        }

        public void setDateUpploaded(String dateUpploaded) {
            this.dateUpploaded = dateUpploaded;
        }

        public String getPdfURL() {
            return pdfURL;
        }

        public void setPdfURL(String pdfURL) {
            this.pdfURL = pdfURL;
        }
    }

    public class GridViewAdapter extends BaseAdapter {
        Context context;
        ArrayList<PDFDoc> pdfDocuments;
        public GridViewAdapter (Context context, ArrayList<PDFDoc> pdfDocuments){
            this.context=context;
            this.pdfDocuments=pdfDocuments;
        }


        @Override
        public int getCount() {
            return pdfDocuments.size();
        }

        @Override
        public Object getItem(int position) {
            return pdfDocuments.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            if(view==null){
                view = LayoutInflater.from(context).inflate(R.layout.row_model, viewGroup, false);
            }

            txtName = view.findViewById(R.id.bookname);
            txtFileName = view.findViewById(R.id.file);
            txtcategory = view.findViewById(R.id.category);
            txtDate = view.findViewById(R.id.uploadedDate);
            txtId = view.findViewById(R.id.bookId);



            final PDFDoc pdf = (PDFDoc) this.getItem(position);

            txtId.setText(pdf.getId());
            txtName.setText(pdf.getBookName());
            txtFileName.setText(pdf.getFileName());
            txtcategory.setText(pdf.getCategory());
            txtDate.setText(pdf.getDateUpploaded());


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(BooksActivity.this, pdf.getBookName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BooksActivity.this, ActivityPDF.class);
                    intent.putExtra("PATH", pdf.getPdfURL());
                    context.startActivity(intent);
                }
            });
            return  view;
        }
    }

    public class JSONDownloader{
        private final String PDF_SITE_URL=urLs.URLLoadBooks();
        private final Context context;
        private GridViewAdapter adapter;

        public JSONDownloader(Context context){
            this.context=context;
        }

        public void retrieve(final GridView gridView, final ProgressBar myprogressBar){
            final ArrayList<PDFDoc> pdfDocuments = new ArrayList<>();

            myprogressBar.setIndeterminate(true);
            myprogressBar.setVisibility(View.VISIBLE);

            AndroidNetworking.get(PDF_SITE_URL)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jsonObject;
                            PDFDoc pdfDoc;

                            try {

                                for (int i=0; i<response.length(); i++){
                                    jsonObject = response.getJSONObject(i);

                                    int id = jsonObject.getInt("id");
                                    String bookname = jsonObject.getString("bookname");
                                    String filename = jsonObject.getString("file");
                                    String category = jsonObject.getString("category");
                                    String time = jsonObject.getString("uploaded_time");

                                    String myID = Integer.toString(id);

                                    pdfDoc = new PDFDoc();
                                    pdfDoc.setId(myID);
                                    pdfDoc.setBookName(bookname);
                                    pdfDoc.setFileName(filename);
                                    pdfDoc.setCategory(category);
                                    pdfDoc.setDateUpploaded(time);
                                    pdfDoc.setPdfURL(urLs.URLPdfs()+filename);

                                    pdfDocuments.add(pdfDoc);

                                }

                                adapter = new GridViewAdapter(context, pdfDocuments);
                                gridView.setAdapter(adapter);
                                myprogressBar.setVisibility(View.GONE);

                            } catch (JSONException e) {
                                myprogressBar.setVisibility(View.GONE);
                                Toast.makeText(BooksActivity.this, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIVED. "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            anError.printStackTrace();
                            myprogressBar.setVisibility(View.GONE);
                            Toast.makeText(BooksActivity.this, "Unsuccessfully reload due to technical error", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }

}