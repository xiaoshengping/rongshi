package com.example.administrator.iclub21.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public abstract class SDSQLiteOpenHelper {
	private static final String TAG = SDSQLiteOpenHelper.class.getSimpleName();
	private final Context mContext;
	private final String mName;
	private final CursorFactory mFactory;
	private final int mNewVersion;
	private final String mPath;
	private SQLiteDatabase mDatabase = null;
	private boolean mIsInitializing = false;

	public SDSQLiteOpenHelper(Context context, String path, String name, CursorFactory factory, int version) {
		if (version < 1)
			throw new IllegalArgumentException("Version must be >= 1, was " + version);

		mContext = context;
		mName = name;
		mFactory = factory;
		mNewVersion = version;
		mPath = path;

	}

	public synchronized SQLiteDatabase getWritableDatabase() {
		if (mDatabase != null && mDatabase.isOpen() && !mDatabase.isReadOnly()) {
			return mDatabase; // The database is already open for business

		}

		if (mIsInitializing) {
			throw new IllegalStateException("getWritableDatabase called recursively");
		}
		boolean success = false;
		SQLiteDatabase db = null;
		try {
			mIsInitializing = true;
			if (mName == null) {
				db = SQLiteDatabase.create(null);
			} else {
				String path = getDatabasePath(mName).getPath();
				db = SQLiteDatabase.openOrCreateDatabase(path, mFactory);
			}

			int version = db.getVersion();
			if (version != mNewVersion) {
				db.beginTransaction();
				try {
					if (version == 0) {
						onCreate(db);
					} else {
						onUpgrade(db, version, mNewVersion);
					}
					db.setVersion(mNewVersion);
					db.setTransactionSuccessful();
				} finally {
					db.endTransaction();
				}
			}

			onOpen(db);
			success = true;
			return db;
		} finally {
			mIsInitializing = false;
			if (success) {
				if (mDatabase != null) {
					try {
						mDatabase.close();
					} catch (Exception e) {
					}
				}
				mDatabase = db;
			} else {
				if (db != null)
					db.close();
			}
		}
	}

	public synchronized SQLiteDatabase getReadableDatabase() {
		if (mDatabase != null && mDatabase.isOpen()) {
			return mDatabase; // The database is already open for business

		}

		if (mIsInitializing) {
			throw new IllegalStateException("getReadableDatabase called recursively");
		}

		try {
			return getWritableDatabase();
		} catch (SQLiteException e) {
			if (mName == null)
				throw e;

			Log.e(TAG, "Couldn't open " + mName + " for writing (will try read-only):", e);
		}

		SQLiteDatabase db = null;
		try {
			mIsInitializing = true;
			String path = getDatabasePath(mName).getPath();
			db = SQLiteDatabase.openDatabase(path, mFactory, SQLiteDatabase.OPEN_READWRITE);
			if (db.getVersion() != mNewVersion) {
				throw new SQLiteException("Can't upgrade read-only database from version " + db.getVersion() + " to " + mNewVersion + ": " + path);
			}

			onOpen(db);
			Log.w(TAG, "Opened " + mName + " in read-only mode");
			mDatabase = db;
			return mDatabase;
		} finally {
			mIsInitializing = false;
			if (db != null && db != mDatabase)
				db.close();
		}
	}

	public synchronized void close() {
		if (mIsInitializing)
			throw new IllegalStateException("Closed during initialization");

		if (mDatabase != null && mDatabase.isOpen()) {
			mDatabase.close();
			mDatabase = null;
		}
	}

	public File getDatabasePath(String name) {
		String EXTERN_PATH = null;

		// 判断是否有SDcard
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) == true) {
			// 判断是否存在指定的文件夹，如果没有就创建它
			if (mPath != null && !"".equals(mPath)) {
				EXTERN_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + mPath;
				File f = new File(EXTERN_PATH);
				if (!f.exists()) {
					f.mkdirs();
				}
			}
		} else {
			EXTERN_PATH = mContext.getDatabasePath(mName).getPath();
		}
		return new File(EXTERN_PATH + name);
	}

	public abstract void onCreate(SQLiteDatabase db);

	public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

	public void onOpen(SQLiteDatabase db) {
	}
}