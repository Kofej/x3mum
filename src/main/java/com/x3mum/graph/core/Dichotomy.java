package com.x3mum.graph.core;

import org.equation.Equation;

public class Dichotomy extends Method
{
  double d;
  private double kf = 0;

  public Dichotomy(){}

  public Dichotomy(Equation equation) {
    super(equation);
  }

  @Override
  public void step() {
    double x = (left + right - d) / 2;
    double y = (left + right + d) / 2;
    if (equation.calculate(x) <= equation.calculate(y))
    {
      right = y; kf += 2;
    }
    else
    {
      left = x; kf += 2;
    }

    numberOfIteration++;
    currentSolution = (left + right) / 2;
  }

  @Override
  public boolean condition() {
    return (right - left) >= accuracy;
  }

  @Override
  public void clear() {
    super.clear();
    this.d = 0;
    this.kf = 0;
  }

  @Override
  public void initialize(double left, double right, double accuracy) {
    super.initialize(left, right, accuracy);
    this.d = accuracy /4;
  }

  public double getKf()
  {
    return kf;
  }
}
