package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Genders {
    private String gender;
    private java.util.Date created;
    private String objectId;
    private java.util.Date updated;
    private String ownerId;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getObjectId() {
        return objectId;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getOwnerId() {
        return ownerId;
    }


    public Genders save() {
        return Backendless.Data.of(Genders.class).save(this);
    }

    public void saveAsync(AsyncCallback<Genders> callback) {
        Backendless.Data.of(Genders.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Genders.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Genders.class).remove(this, callback);
    }

    public static Genders findById(String id) {
        return Backendless.Data.of(Genders.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Genders> callback) {
        Backendless.Data.of(Genders.class).findById(id, callback);
    }

    public static Genders findFirst() {
        return Backendless.Data.of(Genders.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Genders> callback) {
        Backendless.Data.of(Genders.class).findFirst(callback);
    }

    public static Genders findLast() {
        return Backendless.Data.of(Genders.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Genders> callback) {
        Backendless.Data.of(Genders.class).findLast(callback);
    }

    public static BackendlessCollection<Genders> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Genders.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Genders>> callback) {
        Backendless.Data.of(Genders.class).find(query, callback);
    }
}