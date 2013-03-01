package com.x3mum.graph.core;

import java.awt.geom.Point2D;

public class GraphData {
  private double left;
  private double right;
  private double accuracy;
  private String function;
  private double[] solution;

  public double getLeft()
  {
    return left;
  }

  public void setLeft(double left)
  {
    this.left = left;
  }

  public double getRight()
  {
    return right;
  }

  public void setRight(double right)
  {
    this.right = right;
  }

  public double getAccuracy()
  {
    return accuracy;
  }

  public void setAccuracy(double accuracy)
  {
    this.accuracy = accuracy;
  }

  public String getFunction()
  {
    return function;
  }

  public void setFunction(String function)
  {
    this.function = function;
  }

  public double[] getSolution()
  {
    return solution;
  }

  public void setSolution(double[] solution)
  {
    this.solution = solution;
  }
}
