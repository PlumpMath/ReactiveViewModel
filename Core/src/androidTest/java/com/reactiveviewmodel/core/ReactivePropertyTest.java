package com.reactiveviewmodel.core;

import junit.framework.TestCase;

import rx.functions.Action1;

public class ReactivePropertyTest extends TestCase {
  public void testSomething() {
    ReactiveProperty<String> name = ReactiveProperty.create("A");
    assertEquals("A", name.get());

    name.whenChanged().subscribe(new Action1<String>() {
      @Override
      public void call(String value) {
        assertEquals("B", value);
      }
    });
    name.set("B");
    assertEquals("B", name.get());
  }
}
