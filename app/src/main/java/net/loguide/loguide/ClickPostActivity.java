package net.loguide.loguide;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class ClickPostActivity extends AppCompatActivity {

    private ImageView postImagePackage;
    private TextView titlePackage, timePackage, contentPackage, nameGuidePackage;
    private String PostKey;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_post);

        PostKey = getIntent().getExtras().get("PostKey").toString();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("uploads").child(PostKey);

        postImagePackage = findViewById(R.id.imagePackage);
        titlePackage = findViewById(R.id.titlePackage);
        timePackage = findViewById(R.id.timePackage);
        contentPackage = findViewById(R.id.contentPackage);
        nameGuidePackage = findViewById(R.id.guidePackage);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = dataSnapshot.child("name").getValue().toString();
                String postImage = dataSnapshot.child("imageUrl").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                String content = dataSnapshot.child("content").getValue().toString();

                titlePackage.setText(title);
                timePackage.setText(time);
                contentPackage.setText(content);
                Picasso.get().load(postImage).into(postImagePackage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
