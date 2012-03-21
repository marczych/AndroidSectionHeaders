package com.ifixit.android.sectionheaders;

import android.content.Context;

import android.util.AttributeSet;

import android.view.LayoutInflater;

import android.widget.ListView;
import android.widget.RelativeLayout;

public class SectionListView extends RelativeLayout {
   private ListView mListView;
   private RelativeLayout mRelativeLayout;
   private SectionHeadersAdapter mAdapter;

   public SectionListView(Context context) {
      super(context);
      init(context);
   }

   public SectionListView(Context context, AttributeSet attrs) {
      super(context, attrs);
      init(context);
   }

   public SectionListView(Context context, AttributeSet attrs, int def) {
      super(context, attrs, def);
      init(context);
   }

   private void init(Context context) {
      LayoutInflater inflater = (LayoutInflater)context.getSystemService(
       Context.LAYOUT_INFLATER_SERVICE);

      inflater.inflate(R.layout.section_list_view, this, true);

      mListView = (ListView)findViewById(R.id.list_view);
      mRelativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);
   }

   public ListView getListView() {
      return mListView;
   }

   public void setAdapter(SectionHeadersAdapter adapter) {
      mAdapter = adapter;
      mListView.setAdapter(mAdapter);
   }
}
