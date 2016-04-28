package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Cities {
    private String objectId;
    private String name;
    private java.util.Date updated;
    private String ownerId;
    private java.util.Date created;
    private java.util.List<Neighbourhoods> neighbourhoods;
    private GeoPoint location;

    public String getObjectId() {
        return objectId;
    }

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

    public java.util.List<Neighbourhoods> getNeighbourhoods() {
        return neighbourhoods;
    }

    public void setNeighbourhoods(java.util.List<Neighbourhoods> neighbourhoods) {
        this.neighbourhoods = neighbourhoods;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }


    public Cities save() {
        return Backendless.Data.of(Cities.class).save(this);
    }

    public void saveAsync(AsyncCallback<Cities> callback) {
        Backendless.Data.of(Cities.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Cities.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Cities.class).remove(this, callback);
    }

    public static Cities findById(String id) {
        return Backendless.Data.of(Cities.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Cities> callback) {
        Backendless.Data.of(Cities.class).findById(id, callback);
    }

    public static Cities findFirst() {
        return Backendless.Data.of(Cities.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Cities> callback) {
        Backendless.Data.of(Cities.class).findFirst(callback);
    }

    public static Cities findLast() {
        return Backendless.Data.of(Cities.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Cities> callback) {
        Backendless.Data.of(Cities.class).findLast(callback);
    }

    public static BackendlessCollection<Cities> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Cities.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Cities>> callback) {
        Backendless.Data.of(Cities.class).find(query, callback);
    }
}