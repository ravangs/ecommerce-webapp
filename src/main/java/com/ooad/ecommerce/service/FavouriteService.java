package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.FavouriteDto;
import com.ooad.ecommerce.model.Favourite;
import com.ooad.ecommerce.model.FavouriteId;
import com.ooad.ecommerce.repository.FavouriteRepository;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

@Service
public class FavouriteService implements FavouriteRepository {

  @Autowired private UserRepository userRepository;
  @Autowired private UserInfoRepository userInfoRepository;

  private List<FavouriteDto> getFavouriteDetails() {
    return null;
  }

  private void updateFavouriteDetails() {}

  @Override
  public List<Favourite> findAll() {
    return null;
  }

  @Override
  public List<Favourite> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Favourite> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public List<Favourite> findAllById(Iterable<FavouriteId> favouriteIds) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(FavouriteId favouriteId) {

  }

  @Override
  public void delete(Favourite entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends FavouriteId> favouriteIds) {

  }

  @Override
  public void deleteAll(Iterable<? extends Favourite> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public <S extends Favourite> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Favourite> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Favourite> findById(FavouriteId favouriteId) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(FavouriteId favouriteId) {
    return false;
  }

  @Override
  public void flush() {

  }

  @Override
  public <S extends Favourite> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Favourite> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteAllInBatch(Iterable<Favourite> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<FavouriteId> favouriteIds) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Favourite getOne(FavouriteId favouriteId) {
    return null;
  }

  @Override
  public Favourite getById(FavouriteId favouriteId) {
    return null;
  }

  @Override
  public Favourite getReferenceById(FavouriteId favouriteId) {
    return null;
  }

  @Override
  public <S extends Favourite> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Favourite> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends Favourite> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends Favourite> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Favourite> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Favourite> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Favourite, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }
}
