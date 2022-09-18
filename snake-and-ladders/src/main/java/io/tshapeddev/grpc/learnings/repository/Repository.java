package io.tshapeddev.grpc.learnings.repository;

import lombok.NonNull;

public interface Repository<T> {

    T save(@NonNull T entity);
    T getById(int id);
    boolean isPresent(int id);
}
