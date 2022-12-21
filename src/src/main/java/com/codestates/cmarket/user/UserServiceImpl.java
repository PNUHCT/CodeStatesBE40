package com.codestates.cmarket.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  //  private final UserRepository userRepository = new UserRepositoryImpl();
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void signup(User user) {
    userRepository.saveUser(user);
  }

  @Override
  public User findUser(Long userId) {
    return userRepository.findByUserId(userId);
  }
}