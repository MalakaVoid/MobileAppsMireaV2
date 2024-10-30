package ru.mirea.azbukindu.domain;

public interface ApiRequestCallback<T> {

    public void onSuccess(T result);
    public void onFailure(Exception e);
}
