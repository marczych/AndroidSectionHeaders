package com.ifixit.android.sectionheaders.sample;

import java.util.ArrayList;

import com.ifixit.android.sectionheaders.SectionHeadersAdapter;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ListView;

public class SectionHeadersSampleActivity extends Activity {
   private ListView mListView;
   private SectionHeadersAdapter mAdapter;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.section_headers);

      mListView = (ListView)findViewById(R.id.section_list);
      mAdapter = getSectionAdapter();
      mListView.setAdapter(mAdapter);
   }

   private SectionHeadersAdapter getSectionAdapter() {
      SectionHeadersAdapter adapter = new SectionHeadersAdapter();
      SampleSectionAdapter sampleAdapter = new SampleSectionAdapter(this,
       getSampleList(), "First Header");
      
      adapter.addSection(sampleAdapter);

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
