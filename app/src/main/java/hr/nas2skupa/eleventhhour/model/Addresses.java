package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Addresses {
    private String ownerId;
    private String address;
    private String objectId;
    private java.util.Date created;
    private java.util.Date updated;
    private Neighbourhoods neighbourhood;
    private Cities city;
    private Countries country;
    private GeoPoint location;

    public String getOwnerId() {
        return ownerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getObjectId() {
        return objectId;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public Neighbourhoods getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(Neighbourhoods neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }


    public Addresses save() {
        return Backendless.Data.of(Addresses.class).save(this);
    }

    public void saveAsync(AsyncCallback<Addresses> callback) {
        Backendless.Data.of(Addresses.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Addresses.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Addresses.class).remove(this, callback);
    }

    public static Addresses findById(String id) {
        return Backendless.Data.of(Addresses.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Addresses> callback) {
        Backendless.Data.of(Addresses.class).findById(id, callback);
    }

    public static Addresses findFirst() {
        return Backendless.Data.of(Addresses.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Addresses> callback) {
        Backendless.Data.of(Addresses.class).findFirst(callback);
    }

    public static Addresses findLast() {
        return Backendless.Data.of(Addresses.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Addresses> callback) {
        Backendless.Data.of(Addresses.class).findLast(callback);
    }

    public static BackendlessCollection<Addresses> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Addresses.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Addresses>> callback) {
        Backendless.Data.of(Addresses.class).find(query, callback);
    }
}