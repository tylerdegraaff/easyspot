package nl.hr.tylerdegraaff.easyspot;

/**
 * Created by Tylerjeremy on 21/06/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 11;
    // Database Name
    private static final String DATABASE_NAME = "easy_spot";
    // Contacts table name
    private static final String TABLE_CAMPINGS = "campings";
    private static final String TABLE_RESERVATIONS = "reservations";
    // Common Column names
    private static final String KEY_ID = "id";
    // Campings Table Columns names
    private static final String KEY_NAME = "name";
    private static final String KEY_RE_ADDR = "camping_adress";
    private static final String KEY_IMAGE_ADDR = "camping_image";
    private static final String KEY_PHONE = "camping_phone";
    private static final String KEY_PRICE = "camping_price";
    private static final String KEY_EMAIL = "camping_email";
    private static final String KEY_DESC= "camping_description";
    private static final String KEY_FAC = "camping_facilities";
    // Reservations Table Columns names
    private static final String KEY_CAMPING_ID = "camping_id";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CAMPING_TABLE = "CREATE TABLE " + TABLE_CAMPINGS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_RE_ADDR + " TEXT," + KEY_IMAGE_ADDR + " INTEGER," + KEY_PHONE + " INTEGER,"
                + KEY_PRICE + " INTEGER," + KEY_EMAIL + " TEXT," + KEY_DESC + " TEXT,"
                + KEY_FAC + " TEXT" + ")";
        db.execSQL(CREATE_CAMPING_TABLE);

        String CREATE_RESERVATIONS_TABLE = "CREATE TABLE " + TABLE_RESERVATIONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CAMPING_ID + " INTEGER" + ")";
        db.execSQL(CREATE_RESERVATIONS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAMPINGS);
        // Creating tables again
        onCreate(db);
    }
    // Adding new camping
    public void addCamping(Camping camping) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, camping.getName()); // Camping Name
        values.put(KEY_RE_ADDR, camping.getAddress()); // Camping Adress
        values.put(KEY_IMAGE_ADDR, camping.getImage()); // Camping Image Int
        values.put(KEY_PHONE, camping.getPhone()); // Camping Phone Int
        values.put(KEY_PRICE, camping.getPrice()); // Camping Price Int
        values.put(KEY_EMAIL, camping.getEmail()); // Camping Email
        values.put(KEY_DESC, camping.getDesc()); // Camping Description
        values.put(KEY_FAC, camping.getFac()); // Camping Facilities

        // Inserting Row
        db.insert(TABLE_CAMPINGS, null, values);
        db.close(); // Closing database connection
    }

    // Getting one camping
    public ArrayList<Camping> getCamping(int id) {
        ArrayList<Camping> campingList = new ArrayList<Camping>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CAMPINGS + " WHERE id =" + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Camping camping = new Camping();
                camping.setId(Integer.parseInt(cursor.getString(0)));
                camping.setName(cursor.getString(1));
                camping.setAddress(cursor.getString(2));
                camping.setImage(Integer.parseInt(cursor.getString(3)));
                camping.setPhone(Integer.parseInt(cursor.getString(4)));
                camping.setPrice(Integer.parseInt(cursor.getString(5)));
                camping.setEmail(cursor.getString(6));
                camping.setDesc(cursor.getString(7));
                camping.setFac(cursor.getString(8));
                // Adding contact to list
                campingList.add(camping);
            } while (cursor.moveToNext());
        }

        // return contact list
        return campingList;
    }
    // Getting All Campings
    public ArrayList<Camping> getAllCampings() {
        ArrayList<Camping> campingList = new ArrayList<Camping>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CAMPINGS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Camping camping = new Camping();
                camping.setId(Integer.parseInt(cursor.getString(0)));
                camping.setName(cursor.getString(1));
                camping.setAddress(cursor.getString(2));
                camping.setImage(Integer.parseInt(cursor.getString(3)));
                camping.setPhone(Integer.parseInt(cursor.getString(4)));
                camping.setPrice(Integer.parseInt(cursor.getString(5)));
                camping.setEmail(cursor.getString(6));
                camping.setDesc(cursor.getString(7));
                camping.setFac(cursor.getString(8));
                // Adding contact to list
                campingList.add(camping);
            } while (cursor.moveToNext());
        }

        // return contact list
        return campingList;
    }
    // Getting campings Count
    public int getCampingsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CAMPINGS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }
    // Updating a camping
    public int updateCamping(Camping camping) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, camping.getName());
        values.put(KEY_RE_ADDR, camping.getAddress());
        values.put(KEY_IMAGE_ADDR, camping.getImage());
        values.put(KEY_PHONE, camping.getPhone());
        values.put(KEY_PRICE, camping.getPrice());
        values.put(KEY_EMAIL, camping.getEmail());
        values.put(KEY_DESC, camping.getDesc());
        values.put(KEY_FAC, camping.getFac());

        // updating row
        return db.update(TABLE_CAMPINGS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(camping.getId())});
    }

    // Deleting a camping
    public void deleteCamping(Camping camping) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CAMPINGS, KEY_ID + " = ?",
                new String[] { String.valueOf(camping.getId()) });
        db.close();
    }

    // Add a reservations
    public void addReservation(Reservation reservation){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CAMPING_ID, reservation.getCampingId()); // Camping Id
        // Inserting Row
        db.insert(TABLE_RESERVATIONS, null, values);
        db.close(); // Closing database connection
    }

    // Get all reservations
    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_RESERVATIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Reservation reservation = new Reservation();
                reservation.setId(Integer.parseInt(cursor.getString(0)));
                reservation.setCampingId(Integer.parseInt(cursor.getString(1)));
                // Adding contact to list
                reservationList.add(reservation);
            } while (cursor.moveToNext());
        }
        // return contact list
        return reservationList;
    }
}


