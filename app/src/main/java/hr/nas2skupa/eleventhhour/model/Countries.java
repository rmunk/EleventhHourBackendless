package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Countries {
    private java.util.Date updated;
    private String objectId;
    private String name;
    private String ownerId;
    private java.util.Date created;
    private java.util.List<Cities> cities;

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public java.util.List<Cities> getCities() {
        return cities;
    }

    public void setCities(java.util.List<Cities> cities) {
        this.cities = cities;
    }


    public Countries save() {
        return Backendless.Data.of(Countries.class).save(this);
    }

    public void saveAsync(AsyncCallback<Countries> callback) {
        Backendless.Data.of(Countries.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Countries.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Countries.class).remove(this, callback);
    }

    public static Countries findById(String id) {
        return Backendless.Data.of(Countries.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Countries> callback) {
        Backendless.Data.of(Countries.class).findById(id, callback);
    }

    public static Countries findFirst() {
        return Backendless.Data.of(Countries.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Countries> callback) {
        Backendless.Data.of(Countries.class).findFirst(callback);
    }

    public static Countries findLast() {
        return Backendless.Data.of(Countries.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Countries> callback) {
        Backendless.Data.of(Countries.class).findLast(callback);
    }

    public static BackendlessCollection<Countries> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Countries.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Countries>> callback) {
        Backendless.Data.of(Countries.class).find(query, callback);
    }
}