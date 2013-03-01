package com.x3mum.graph.controllers;

import com.x3mum.graph.core.GraphData;
import com.x3mum.graph.core.Method;
import com.x3mum.graph.core.MethodManager;
import org.equation.Equation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
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
    GraphData graphData = new GraphData();
    model.addAttribute("grapgData", graphData);
    return "graph/index";
  }

  @RequestMapping(value = "/grbuild")
  public @ResponseBody double[] grbuild(
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
    for(double x = left_; x < right_; x = x + 0.1) //TODO: must be some constant for graphic accuracy. It's difficult from method accuracy
    {
      points[i++] = equation.calculate(x);
    }

    methodManager.reset();
    return clone_doubles(points, i);
  }

  @RequestMapping(value = "/findmin")
  public @ResponseBody GraphData findmin(
      @RequestParam String function,
      @RequestParam String left,
      @RequestParam String right,
      @RequestParam String accuracy
  )
      throws Exception
  {
    //TODO: must come in JSON from client
    GraphData graphData = new GraphData();
    graphData.setLeft(Double.parseDouble(left));
    graphData.setRight(Double.parseDouble(right));
    graphData.setAccuracy(Double.parseDouble(accuracy));
    graphData.setFunction(function);

    Equation equation = Equation.createEquation(graphData.getFunction());

    Method method = methodManager.getMethod(0);
    method.setEquation(equation);
    method.initialize(graphData.getLeft(), graphData.getRight(), graphData.getAccuracy());

    double[] solution = new double[2];
    solution[0] = method.findSolution();
    solution[1] = equation.calculate(solution[0]);

    graphData.setSolution(solution);

    method.clear();
    return graphData;
  }

  @RequestMapping(value = "/step")
  @ResponseBody
  public GraphData step(
      @RequestParam String function,
      @RequestParam String left,
      @RequestParam String right,
      @RequestParam String accuracy
  )
      throws Exception
  {
    //TODO: must come in JSON from client
    GraphData graphData = new GraphData();
    graphData.setLeft(Double.parseDouble(left));
    graphData.setRight(Double.parseDouble(right));
    graphData.setAccuracy(Double.parseDouble(accuracy));
    graphData.setFunction(function);

    Equation equation = Equation.createEquation(function);

    Method method = methodManager.getMethod(0);
    method.setEquation(equation);
    method.initialize(graphData.getLeft(), graphData.getRight(), graphData.getAccuracy());

    double solution[] = new double[2];
    method.step();
    solution[0] = method.getCurrentSolution();
    solution[1] = equation.calculate(solution[0]);

    graphData.setSolution(solution);
    graphData.setLeft(method.getLeft());
    graphData.setRight(method.getRight());

    method.clear();
    return graphData;
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
