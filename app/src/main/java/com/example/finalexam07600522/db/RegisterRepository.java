package com.example.finalexam07600522.db;

import android.content.Context;
import android.os.AsyncTask;

import com.example.finalexam07600522.model.registerItem;

import java.util.List;

public class RegisterRepository {

    private Context mContext;

    public RegisterRepository(Context context) {
        this.mContext = context;
    }

    public void getRegister(Callback callback) {
        GetTask getTask = new GetTask(mContext,callback);
        getTask.execute();
    }

    public void insertRegister(registerItem item, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<registerItem>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<registerItem> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<registerItem> itemList = db.registerdao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<registerItem> itemList) {
            super.onPostExecute(itemList);
            mCallback.onGetRegister(itemList);
        }
    }

    public interface Callback {
        void onGetRegister(List<registerItem> itemList);
    }

    private static class InsertTask extends AsyncTask<registerItem, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(registerItem... registerItems) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.registerdao().insert(registerItems[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    }

    public interface InsertCallback {
        void onInsertSuccess();
    }
}
