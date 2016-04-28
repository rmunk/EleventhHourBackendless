package hr.nas2skupa.eleventhhour.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Providers {
    private String description;
    private String name;
    private String hours;
    private java.util.Date updated;
    private java.util.Date created;
    private String ownerId;
    private Double rating;
    private String email;
    private String objectId;
    private String website;
    private Addresses address;
    private java.util.List<Services> services;
    private java.util.List<PaymentOptions> paymentOptions;
    private java.util.List<PhoneNumbers> phoneNumbers;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public java.util.List<Services> getServices() {
        return services;
    }

    public void setServices(java.util.List<Services> services) {
        this.services = services;
    }

    public java.util.List<PaymentOptions> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(java.util.List<PaymentOptions> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public java.util.List<PhoneNumbers> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(java.util.List<PhoneNumbers> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    public Providers save() {
        return Backendless.Data.of(Providers.class).save(this);
    }

    public void saveAsync(AsyncCallback<Providers> callback) {
        Backendless.Data.of(Providers.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Providers.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Providers.class).remove(this, callback);
    }

    public static Providers findById(String id) {
        return Backendless.Data.of(Providers.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Providers> callback) {
        Backendless.Data.of(Providers.class).findById(id, callback);
    }

    public static Providers findFirst() {
        return Backendless.Data.of(Providers.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Providers> callback) {
        Backendless.Data.of(Providers.class).findFirst(callback);
    }

    public static Providers findLast() {
        return Backendless.Data.of(Providers.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Providers> callback) {
        Backendless.Data.of(Providers.class).findLast(callback);
    }

    public static BackendlessCollection<Providers> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Providers.class).find(query);
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Providers>> callback) {
        Backendless.Data.of(Providers.class).find(query, callback);
    }
}