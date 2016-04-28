package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Categories {
    private String ownerId;
    private java.util.Date created;
    private String name;
    private java.util.Date updated;
    private String objectId;
    private java.util.List<Subcategories> subcategories;

    public String getOwnerId() {
        return ownerId;
    }

    public java.util.Date getCreated() {
        return created;
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

    public String getObjectId() {
        return objectId;
    }

    public java.util.List<Subcategories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(java.util.List<Subcategories> subcategories) {
        this.subcategories = subcategories;
    }


    public Categories save() {
        return Backendless.Data.of(Categories.class).save(this);
    }

    public void saveAsync(AsyncCallback<Categories> callback) {
        Backendless.Data.of(Categories.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Categories.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Categories.class).remove(this, callback);
    }

    public static Categories findById(String id) {
        return Backendless.Data.of(Categories.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Categories> callback) {
        Backendless.Data.of(Categories.class).findById(id, callback);
    }

    public static Categories findFirst() {
        return Backendless.Data.of(Categories.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Categories> callback) {
        Backendless.Data.of(Categories.class).findFirst(callback);
    }

    public static Categories findLast() {
        return Backendless.Data.of(Categories.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Categories> callback) {
        Backendless.Data.of(Categories.class).findLast(callback);
    }

    public static BackendlessCollection<Categories> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Categories.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Categories>> callback) {
        Backendless.Data.of(Categories.class).find(query, callback);
    }
}