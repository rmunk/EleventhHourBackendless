package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Subcategories {
    private String ownerId;
    private java.util.Date created;
    private String objectId;
    private java.util.Date updated;
    private String name;
    private java.util.List<Providers> providers;

    public String getOwnerId() {
        return ownerId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.List<Providers> getProviders() {
        return providers;
    }

    public void setProviders(java.util.List<Providers> providers) {
        this.providers = providers;
    }


    public Subcategories save() {
        return Backendless.Data.of(Subcategories.class).save(this);
    }

    public void saveAsync(AsyncCallback<Subcategories> callback) {
        Backendless.Data.of(Subcategories.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Subcategories.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Subcategories.class).remove(this, callback);
    }

    public static Subcategories findById(String id) {
        return Backendless.Data.of(Subcategories.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Subcategories> callback) {
        Backendless.Data.of(Subcategories.class).findById(id, callback);
    }

    public static Subcategories findFirst() {
        return Backendless.Data.of(Subcategories.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Subcategories> callback) {
        Backendless.Data.of(Subcategories.class).findFirst(callback);
    }

    public static Subcategories findLast() {
        return Backendless.Data.of(Subcategories.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Subcategories> callback) {
        Backendless.Data.of(Subcategories.class).findLast(callback);
    }

    public static BackendlessCollection<Subcategories> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Subcategories.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Subcategories>> callback) {
        Backendless.Data.of(Subcategories.class).find(query, callback);
    }
}