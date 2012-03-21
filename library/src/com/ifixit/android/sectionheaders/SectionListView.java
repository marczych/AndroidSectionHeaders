package com.ifixit.android.sectionheaders;

import android.content.Context;

import android.util.AttributeSet;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class SectionListView extends RelativeLayout implements
 AbsListView.OnScrollListener {
   private ListView mListView;
   private SectionHeadersAdapter mAdapter;
   private View mPinnedHeader;
   private int mHeaderPosition = -1;

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
      mListView.setOnScrollListener(this);
   }

   public ListView getListView() {
      return mListView;
   }

   public void setAdapter(SectionHeadersAdapter adapter) {
      mAdapter = adapter;
      mListView.setAdapter(mAdapter);
   }

   public void onScroll(AbsListView view, int firstVisibleItem,
    int visibleItemCount, int totalItemCount) {
      int headerPos;

      if (mAdapter != null && (headerPos = mAdapter.getHeaderPosition(
       firstVisibleItem)) != mHeaderPosition) {
         mHeaderPosition = headerPos;
         mPinnedHeader = mAdapter.getView(mHeaderPosition, null, this);
         injectPinnedHeader(mPinnedHeader);
      }
   }

   public void onScrollStateChanged(AbsListView view, int scrollState) {
   }

   private void injectPinnedHeader(View header) {
      if (mPinnedHeader != null) {
         removeView(mPinnedHeader);
      }

      mPinnedHeader = header;
      RelativeLayout.LayoutParams layoutParams =
       new RelativeLayout.LayoutParams(
       RelativeLayout.LayoutParams.FILL_PARENT,
       RelativeLayout.LayoutParams.WRAP_CONTENT);

      addView(mPinnedHeader, layoutParams);
   }
}
