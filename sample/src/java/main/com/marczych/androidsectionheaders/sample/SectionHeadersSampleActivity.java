package com.marczych.androidsectionheaders.sample;

import java.util.ArrayList;

import com.marczych.androidsectionheaders.*;

import android.app.Activity;
import android.os.Bundle;

public class SectionHeadersSampleActivity extends Activity {
   private SectionListView mListView;
   private SectionHeadersAdapter mAdapter;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.section_headers);

      mListView = (SectionListView)findViewById(R.id.section_list);
      mAdapter = getSectionAdapter();
      mListView.setAdapter(mAdapter);
      mListView.getListView().setOnItemClickListener(mAdapter);
   }

   private SectionHeadersAdapter getSectionAdapter() {
      SectionHeadersAdapter adapter = new SectionHeadersAdapter();

      for (int i = 0; i < 10; i ++) {
         adapter.addSection(new SampleSectionAdapter(this, getSampleList(),
          "Header #" + i));
      }

      return adapter;
   }

   private ArrayList<String> getSampleList() {
      ArrayList<String> list = new ArrayList<String>();

      for (int i = 0; i < 10; i ++) {
         list.add("List item #" + i);
      }

      return list;
   }
}
