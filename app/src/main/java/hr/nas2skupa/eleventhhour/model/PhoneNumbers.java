package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class PhoneNumbers {
    private java.util.Date updated;
    private String ownerId;
    private java.util.Date created;
    private String objectId;
    private String phoneNumber;

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public PhoneNumbers save() {
        return Backendless.Data.of(PhoneNumbers.class).save(this);
    }

    public void saveAsync(AsyncCallback<PhoneNumbers> callback) {
        Backendless.Data.of(PhoneNumbers.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(PhoneNumbers.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(PhoneNumbers.class).remove(this, callback);
    }

    public static PhoneNumbers findById(String id) {
        return Backendless.Data.of(PhoneNumbers.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<PhoneNumbers> callback) {
        Backendless.Data.of(PhoneNumbers.class).findById(id, callback);
    }

    public static PhoneNumbers findFirst() {
        return Backendless.Data.of(PhoneNumbers.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<PhoneNumbers> callback) {
        Backendless.Data.of(PhoneNumbers.class).findFirst(callback);
    }

    public static PhoneNumbers findLast() {
        return Backendless.Data.of(PhoneNumbers.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<PhoneNumbers> callback) {
        Backendless.Data.of(PhoneNumbers.class).findLast(callback);
    }

    public static BackendlessCollection<PhoneNumbers> find(BackendlessDataQuery query) {
        return Backendless.Data.of(PhoneNumbers.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<PhoneNumbers>> callback) {
        Backendless.Data.of(PhoneNumbers.class).find(query, callback);
    }
}