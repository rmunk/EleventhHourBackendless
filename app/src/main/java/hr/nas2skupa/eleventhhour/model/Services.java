package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Services {
    private String ownerId;
    private Boolean onSale;
    private Double priceOnSale;
    private java.util.Date created;
    private java.util.Date updated;
    private Double price;
    private String objectId;
    private String name;
    private java.util.Date duration;

    public String getOwnerId() {
        return ownerId;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Double getPriceOnSale() {
        return priceOnSale;
    }

    public void setPriceOnSale(Double priceOnSale) {
        this.priceOnSale = priceOnSale;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public java.util.Date getDuration() {
        return duration;
    }

    public void setDuration(java.util.Date duration) {
        this.duration = duration;
    }


    public Services save() {
        return Backendless.Data.of(Services.class).save(this);
    }

    public void saveAsync(AsyncCallback<Services> callback) {
        Backendless.Data.of(Services.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Services.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Services.class).remove(this, callback);
    }

    public static Services findById(String id) {
        return Backendless.Data.of(Services.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Services> callback) {
        Backendless.Data.of(Services.class).findById(id, callback);
    }

    public static Services findFirst() {
        return Backendless.Data.of(Services.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Services> callback) {
        Backendless.Data.of(Services.class).findFirst(callback);
    }

    public static Services findLast() {
        return Backendless.Data.of(Services.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Services> callback) {
        Backendless.Data.of(Services.class).findLast(callback);
    }

    public static BackendlessCollection<Services> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Services.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Services>> callback) {
        Backendless.Data.of(Services.class).find(query, callback);
    }
}