package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class PaymentOptions {
    private String icon;
    private java.util.Date created;
    private java.util.Date updated;
    private String ownerId;
    private String name;
    private String objectId;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }


    public PaymentOptions save() {
        return Backendless.Data.of(PaymentOptions.class).save(this);
    }

    public void saveAsync(AsyncCallback<PaymentOptions> callback) {
        Backendless.Data.of(PaymentOptions.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(PaymentOptions.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(PaymentOptions.class).remove(this, callback);
    }

    public static PaymentOptions findById(String id) {
        return Backendless.Data.of(PaymentOptions.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<PaymentOptions> callback) {
        Backendless.Data.of(PaymentOptions.class).findById(id, callback);
    }

    public static PaymentOptions findFirst() {
        return Backendless.Data.of(PaymentOptions.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<PaymentOptions> callback) {
        Backendless.Data.of(PaymentOptions.class).findFirst(callback);
    }

    public static PaymentOptions findLast() {
        return Backendless.Data.of(PaymentOptions.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<PaymentOptions> callback) {
        Backendless.Data.of(PaymentOptions.class).findLast(callback);
    }

    public static BackendlessCollection<PaymentOptions> find(BackendlessDataQuery query) {
        return Backendless.Data.of(PaymentOptions.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<PaymentOptions>> callback) {
        Backendless.Data.of(PaymentOptions.class).find(query, callback);
    }
}