package com.rcv.solarsportsavance.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rcv.solarsportsavance.R;
import com.rcv.solarsportsavance.Video;

import java.util.ArrayList;
import java.util.List;

public class Videos extends Fragment {

    private static final String ARG_VIDEOS = "videos";

    private List<Video> videoList;
    private int currentVideoIndex = 0;

    private WebView webView;
    private TextView descriptionText;
    private Button btnPrevious;
    private Button btnNext;

    public static Videos newInstance(List<Video> videos) {
        Videos fragment = new Videos();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_VIDEOS, new ArrayList<>(videos));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            videoList = getArguments().getParcelableArrayList(ARG_VIDEOS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.webview_video);
        descriptionText = view.findViewById(R.id.description_text);
        btnPrevious = view.findViewById(R.id.btn_previous);
        btnNext = view.findViewById(R.id.btn_next);

        // Configuración de WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        if (videoList != null && !videoList.isEmpty()) {
            displayVideo(videoList.get(currentVideoIndex));

            btnPrevious.setOnClickListener(v -> previousVideo());
            btnNext.setOnClickListener(v -> nextVideo());
        }
    }

    private void displayVideo(Video video) {
        if (video != null) {
            webView.loadUrl(video.getUrl());
            descriptionText.setText(video.getDescription());
        }
    }

    public void previousVideo() {
        if (currentVideoIndex > 0) {
            currentVideoIndex--;
            displayVideo(videoList.get(currentVideoIndex));
        }
    }

    public void nextVideo() {
        if (currentVideoIndex < videoList.size() - 1) {
            currentVideoIndex++;
            displayVideo(videoList.get(currentVideoIndex));
        }
    }
}

