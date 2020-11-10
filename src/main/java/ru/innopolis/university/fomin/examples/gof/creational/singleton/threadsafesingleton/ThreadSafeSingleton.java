package ru.innopolis.university.fomin.examples.gof.creational.singleton.threadsafesingleton;

class ThreadSafeSingleton {
  private static ThreadSafeSingleton INSTANCE;

  private ThreadSafeSingleton() {
  }

  static synchronized ThreadSafeSingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ThreadSafeSingleton();
    }
    return INSTANCE;
  }
}