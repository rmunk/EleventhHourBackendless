package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Neighbourhoods {
    private String name;
    private java.util.Date updated;
    private String ownerId;
    private java.util.Date created;
    private String objectId;
    private java.util.List<Providers> providers;
    private GeoPoint location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public java.util.List<Providers> getProviders() {
        return providers;
    }

    public void setProviders(java.util.List<Providers> providers) {
        this.providers = providers;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }


    public Neighbourhoods save() {
        return Backendless.Data.of(Neighbourhoods.class).save(this);
    }

    public void saveAsync(AsyncCallback<Neighbourhoods> callback) {
        Backendless.Data.of(Neighbourhoods.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Neighbourhoods.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Neighbourhoods.class).remove(this, callback);
    }

    public static Neighbourhoods findById(String id) {
        return Backendless.Data.of(Neighbourhoods.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Neighbourhoods> callback) {
        Backendless.Data.of(Neighbourhoods.class).findById(id, callback);
    }

    public static Neighbourhoods findFirst() {
        return Backendless.Data.of(Neighbourhoods.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Neighbourhoods> callback) {
        Backendless.Data.of(Neighbourhoods.class).findFirst(callback);
    }

    public static Neighbourhoods findLast() {
        return Backendless.Data.of(Neighbourhoods.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Neighbourhoods> callback) {
        Backendless.Data.of(Neighbourhoods.class).findLast(callback);
    }

    public static BackendlessCollection<Neighbourhoods> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Neighbourhoods.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Neighbourhoods>> callback) {
        Backendless.Data.of(Neighbourhoods.class).find(query, callback);
    }
}