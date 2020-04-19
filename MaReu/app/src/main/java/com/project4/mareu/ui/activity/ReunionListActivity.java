package com.project4.mareu.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.project4.mareu.R;
import com.project4.mareu.service.DummyMeetingApiServices;
import com.project4.mareu.service.ReunionListService;
import com.project4.mareu.ui.fragments.CreationReunionFragment;
import com.project4.mareu.ui.fragments.ReunionFragment;

import java.util.List;

import com.project4.mareu.models.Reunion;

public class ReunionListActivity extends AppCompatActivity implements ReunionFragment.fabListener, CreationReunionFragment.CreateReunionListener {

    private ReunionFragment mReunionFragment;
    private CreationReunionFragment mCreationReunionFragment;
    public static ReunionListService mReunionListService;
    public static DummyMeetingApiServices mDummyMeetingApiServices;
    List<Reunion> mReunionList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //configuration de la flèche retour si celle ci est affichée
        toolbar.setNavigationOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout_container, mReunionFragment)
                    .commit();
            configToolbar("MaReu", false);
        });

        mDummyMeetingApiServices = new DummyMeetingApiServices();
        mReunionList = mDummyMeetingApiServices.getReunionList();
        this.configureFragment();
    }

    // CONFIGURATION ----------------------------------------------------------------------
    private void configureFragment() {
        mReunionFragment = (ReunionFragment) getSupportFragmentManager().findFragmentById(R.id.reunion_list);

        if (mReunionFragment == null) {
            mReunionFragment = new ReunionFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout_container, mReunionFragment)
                    .commit();
            mReunionFragment.mFabListener = this;

        }
        //Mode tablette
        if (mCreationReunionFragment == null && findViewById(R.id.frameLayout_container_create) != null) {
            mCreationReunionFragment = new CreationReunionFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout_container_create, mCreationReunionFragment)
                    .commit();
        }
        mReunionFragment.mFabListener = this;
    }

    private void configToolbar(String text, Boolean bool){
        toolbar.setTitle(text);
        getSupportActionBar().setDisplayShowHomeEnabled(bool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(bool);
    }

    //listener method ----------------------------------------------------------------------------
    @Override
    public void onFabClicked() {
            mCreationReunionFragment = new CreationReunionFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout_container, mCreationReunionFragment)
                    .commit();
            configToolbar("Création d'une réunion", true);
    }

    @Override
    public void onCreateReunion(Reunion reunion) {
        mDummyMeetingApiServices.addReunion(reunion);
        // mode landscape
        if (mReunionFragment != null && findViewById(R.id.frameLayout_container_create) != null){
            mReunionFragment = new ReunionFragment();
            mCreationReunionFragment = new CreationReunionFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout_container, mReunionFragment)
                    .replace(R.id.frameLayout_container_create, mCreationReunionFragment)
                    .commit();
        }else {
            //mode normal
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout_container, mReunionFragment)
                    .commit();
            configToolbar("MaReu", false);
        }
    }

}
