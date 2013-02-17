package com.x3mum.graph.controllers;

import com.x3mum.graph.core.Method;
import com.x3mum.graph.core.MethodManager;
import com.x3mum.graph.core.ResultValue;
import org.equation.Equation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


@Controller
@RequestMapping("/graph")
public class GraphController
{
  private MethodManager methodManager;
  private double[] points = new double[800000];

  @RequestMapping("")
  public String index(
      Model model
  )
  {
    ResultValue resultValue = new ResultValue();
    model.addAttribute("resultValue", resultValue);
    return "graph/index";
  }

  @RequestMapping(value = "/findmin")
  @ResponseBody
  public String findmin(
      @RequestParam String function,
      @RequestParam String left,
      @RequestParam String right
  )
      throws Exception
  {
    Equation equation = Equation.createEquation(function);
    double left_ = Double.parseDouble(left);
    double right_ = Double.parseDouble(right);
    Method method = methodManager.getMethod(0);
    method.setEquation(equation);

    method.initialize(left_, right_, 0.0001);
    double min[] = new double[2];
    min[0] = method.findSolution();
    method.clear();
    min[1] = equation.calculate(min[0]);

    return Arrays.toString(min);
  }

  @RequestMapping(value = "/test")
  @ResponseBody
  public ResultValue test(
      @RequestParam String function,
      @RequestParam String left,
      @RequestParam String right,
      Model model
  )
  {
    ResultValue resultValue = new ResultValue();
    resultValue.setLeft(2.1);
    resultValue.setRight(2.2);
    model.addAttribute("resultValue", resultValue);
    return resultValue;
  }

  @RequestMapping(value = "/step")
  @ResponseBody
  public String step(
      @RequestParam String function,
      @RequestParam String left,
      @RequestParam String right
  )
      throws Exception
  {
    Equation equation = Equation.createEquation(function);
    double left_ = Double.parseDouble(left);
    double right_ = Double.parseDouble(right);
    Method method = methodManager.getMethod(0);
    method.setEquation(equation);

    method.initialize(left_, right_, 0.0001);
    method.step();

    double min[] = new double[2];
    min[0] = method.getCurrentSolution();
    min[1] = equation.calculate(min[0]);
    return Arrays.toString(min);
  }

  @RequestMapping(value = "/grbuild")
  @ResponseBody
  public String grbuild(
      @RequestParam String function,
      @RequestParam String left,
      @RequestParam String right
  )
      throws Exception
  {
    Equation equation = Equation.createEquation(function);
    double left_ = Double.parseDouble(left);
    double right_ = Double.parseDouble(right);

    int i = 0;
    for(double x = left_; x < right_; x = x + 0.1)
    {
      points[i++] = equation.calculate(x);
    }

    methodManager.reset();
    String ret = Arrays.toString(clone_doubles(points, i));
    return ret;
  }

  private double[] clone_doubles(
      double[] from,
      int size
  )
  {
    double[] to = new double[size];
    System.arraycopy(from, 0, to, 0, size);
    return to;
  }

  public MethodManager getMethodManager()
  {
    return methodManager;
  }

  public void setMethodManager(MethodManager methodManager)
  {
    this.methodManager = methodManager;
  }
}
