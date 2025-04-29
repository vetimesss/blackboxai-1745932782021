package com.example.stockmanagementapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "stock_management.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_PRODUCTS = "products";
    public static final String TABLE_SUPPLIERS = "suppliers";
    public static final String TABLE_STOCK_OPERATIONS = "stock_operations";

    // Products Table Columns
    public static final String COLUMN_PRODUCT_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "name";
    public static final String COLUMN_PRODUCT_REF = "reference";
    public static final String COLUMN_PRODUCT_UNIT = "unit";
    public static final String COLUMN_PRODUCT_PRICE_A = "price_a";
    public static final String COLUMN_PRODUCT_QTE = "quantity";
    public static final String COLUMN_PRODUCT_TTL = "total";
    public static final String COLUMN_PRODUCT_CATEGORY = "category";
    public static final String COLUMN_PRODUCT_ZONE = "zone";

    // Suppliers Table Columns
    public static final String COLUMN_SUPPLIER_ID = "id";
    public static final String COLUMN_SUPPLIER_NAME = "name";
    public static final String COLUMN_SUPPLIER_CONTACT = "contact";

    // Stock Operations Table Columns
    public static final String COLUMN_OPERATION_ID = "id";
    public static final String COLUMN_OPERATION_PRODUCT_ID = "product_id";
    public static final String COLUMN_OPERATION_TYPE = "operation_type"; // IN or OUT
    public static final String COLUMN_OPERATION_QUANTITY = "quantity";
    public static final String COLUMN_OPERATION_DATE = "operation_date";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PRODUCT_NAME + " TEXT,"
                + COLUMN_PRODUCT_REF + " TEXT,"
                + COLUMN_PRODUCT_UNIT + " TEXT,"
                + COLUMN_PRODUCT_PRICE_A + " REAL,"
                + COLUMN_PRODUCT_QTE + " INTEGER,"
                + COLUMN_PRODUCT_TTL + " REAL,"
                + COLUMN_PRODUCT_CATEGORY + " TEXT,"
                + COLUMN_PRODUCT_ZONE + " TEXT"
                + ")";

        String CREATE_SUPPLIERS_TABLE = "CREATE TABLE " + TABLE_SUPPLIERS + "("
                + COLUMN_SUPPLIER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SUPPLIER_NAME + " TEXT,"
                + COLUMN_SUPPLIER_CONTACT + " TEXT"
                + ")";

        String CREATE_STOCK_OPERATIONS_TABLE = "CREATE TABLE " + TABLE_STOCK_OPERATIONS + "("
                + COLUMN_OPERATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_OPERATION_PRODUCT_ID + " INTEGER,"
                + COLUMN_OPERATION_TYPE + " TEXT,"
                + COLUMN_OPERATION_QUANTITY + " INTEGER,"
                + COLUMN_OPERATION_DATE + " TEXT,"
                + "FOREIGN KEY(" + COLUMN_OPERATION_PRODUCT_ID + ") REFERENCES " + TABLE_PRODUCTS + "(" + COLUMN_PRODUCT_ID + ")"
                + ")";

        db.execSQL(CREATE_PRODUCTS_TABLE);
        db.execSQL(CREATE_SUPPLIERS_TABLE);
        db.execSQL(CREATE_STOCK_OPERATIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUPPLIERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STOCK_OPERATIONS);

        // Create tables again
        onCreate(db);
    }
}
