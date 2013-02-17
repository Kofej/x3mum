package com.x3mum.graph.core;

import org.equation.Equation;

public abstract class Method {
  protected Equation equation;
  protected double currentSolution;
  protected double left;
  protected double right;
  protected double accuracy;
  protected int numberOfIteration;

  Method(Equation equation)
  {
    this.equation = equation;
  }

  public Method() {}

  public double findSolution()
  {
    while(condition())
    {
      step();
      numberOfIteration++;
    }

    return getCurrentSolution();
  }

  public abstract void step();

  public abstract boolean condition();

  public void clear()
  {
    this.left = 0;
    this.right = 0;
    this.accuracy = 0;
    this.numberOfIteration = 0;
  }

  public void initialize(double left, double right, double accuracy)
  {
    this.left = left;
    this.right = right;
    this.accuracy = accuracy;
  }

  public void setEquation(Equation equation)
  {
    this.equation = equation;
  }

  public Equation getEquation()
  {
    return this.equation;
  }

  public double getCurrentSolution()
  {
    return this.currentSolution;
  }

  public int getNumberOfIteration()
  {
    return this.numberOfIteration;
  }
}
