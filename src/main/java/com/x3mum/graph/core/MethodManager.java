package com.x3mum.graph.core;

import java.util.List;

public class MethodManager {
  private List<Method> methods;

  public Method getMethod(int id)
  {
    return methods.get(id);
  }

  public List<Method> getMethodsList()
  {
    return methods;
  }

  public void setMethodsList(List<Method> methods)
  {
    this.methods = methods;
  }

  public void reset() {

  }
}
