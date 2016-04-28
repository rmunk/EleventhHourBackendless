package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Orders {
    private String objectId;
    private java.util.Date updated;
    private String ownerId;
    private java.util.Date appointment;
    private java.util.Date created;
    private String note;
    private Providers provider;
    private Services service;
    private BackendlessUser customer;

    public String getObjectId() {
        return objectId;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public java.util.Date getAppointment() {
        return appointment;
    }

    public void setAppointment(java.util.Date appointment) {
        this.appointment = appointment;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Providers getProvider() {
        return provider;
    }

    public void setProvider(Providers provider) {
        this.provider = provider;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public BackendlessUser getCustomer() {
        return customer;
    }

    public void setCustomer(BackendlessUser customer) {
        this.customer = customer;
    }


    public Orders save() {
        return Backendless.Data.of(Orders.class).save(this);
    }

    public void saveAsync(AsyncCallback<Orders> callback) {
        Backendless.Data.of(Orders.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Orders.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Orders.class).remove(this, callback);
    }

    public static Orders findById(String id) {
        return Backendless.Data.of(Orders.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Orders> callback) {
        Backendless.Data.of(Orders.class).findById(id, callback);
    }

    public static Orders findFirst() {
        return Backendless.Data.of(Orders.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Orders> callback) {
        Backendless.Data.of(Orders.class).findFirst(callback);
    }

    public static Orders findLast() {
        return Backendless.Data.of(Orders.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Orders> callback) {
        Backendless.Data.of(Orders.class).findLast(callback);
    }

    public static BackendlessCollection<Orders> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Orders.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Orders>> callback) {
        Backendless.Data.of(Orders.class).find(query, callback);
    }
}