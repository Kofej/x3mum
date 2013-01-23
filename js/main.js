input_massive_string = "";
input_min_line_string = "";
/////////////////////////////////////////////////*******************************************************
$.jqplot.config.enablePlugins = true;
function plot_graph()
{
  $("#chartdiv").empty();
  plot = null;
  var input_massive = input_massive_string.substring(1, input_massive_string.length -1).split(",");
  var input_min_line = input_min_line_string.substring(1, input_min_line_string.length -1).split(",");
  var dx = 0.1;
  //down = Math.min.apply(Math, input_massive);
  //up = Math.max.apply(Math, input_massive);
  var points = [];
  var x_axis = [];
  var y_axis = [];
  var min_line = [];
  min_line.push([input_min_line[0], 0]);
  min_line.push([input_min_line[0], input_min_line[1]]);
  var x_ = parseFloat($("#left").val());
  for(var i = 0; i < input_massive.length; i ++)
  {
    points.push([x_, input_massive[i]]);
    x_axis.push([x_, 0]);
    x_ += dx;
  }
  for(var y_ = parseFloat($("#down").val()); y_ < parseFloat($("#up").val()); y_ += 0.1)
  {
    y_axis.push([0, y_]);
  }
  var left = parseFloat($("#left").val());
  var right = parseFloat($("#right").val());
  var down = parseFloat($("#down").val());
  var up = parseFloat($("#up").val());
  optionObj =
  {
    seriesColors : ["f03030", "3030f0", "3030f0","30f030"],
    title: 'Graphic',
    seriesDefaults:
    {
      showMarker: false
    },
    axes:
    {
      xaxis:
      {
        label: 'x',
        min: left,
        max: right
      },
      yaxis:
      {
        label: 'y',
        min: down,
        max: up
      }
    },
    cursor:
    {
      zoom: true
    }
  }
  plot = $.jqplot('chartdiv', [points, x_axis, y_axis, min_line], optionObj);
}

//////////////////////////////////////////************************************************************
$().ready(function()
{
  $("#findMin").click(function()
  {
    $.ajax({
      type: "POST",
      url: "graph/findmin",
      data :
      {
        "function" : $("#function").val(),
        "left": $("#left_renge").val(),
        "right": $("#right_renge").val()
      },
      success: function(data)
      {
        input_min_line_string = data.toString()
        plot_graph()
      },
      error: function()
      {
        $("#function").css("color", "red")
      }
    })
  })

  $("#step").click(function()
  {
    $.ajax({
      type: "POST",
      url: "graph/step",
      data :
      {
        "function" : $("#function").val(),
        "left": $("#left_renge").val(),
        "right": $("#right_renge").val()
      },
      success: function(data)
      {
        input_min_line_string = data.toString()
        plot_graph()
      },
      error: function()
      {
        $("#function").css("color", "red")
      }
    })
  })

  $("#function").blur(function()
  {
    postData =
    {
      "function" : $("#function").val(),
      "left": $("#left").val(),
      "right": $("#right").val()
    };
    $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data: postData,
      success : function(data)
      {
        $("#function").css("color", "black")
        input_massive_string = data.toString();
        input_min_line_string = "";
        plot_graph()
      },
      error: function()
      {
        $("#function").css("color", "red")
      }
    })
  })

  $("#left").blur(function()
  {
    postData =
    {
      "function" : $("#function").val(),
      "left": $("#left").val(),
      "right": $("#right").val()
    };
    $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data: postData,
      success : function(data)
      {
        input_massive_string = data.toString();
        input_min_line_string = "";
        plot_graph()
      }
    })
  })

  $("#right").blur(function()
  {
    postData =
    {
      "function" : $("#function").val(),
      "left": $("#left").val(),
      "right": $("#right").val()
    };
    $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data: postData,
      success : function(data)
      {
        input_massive_string = data.toString();
        input_min_line_string = "";
        plot_graph()
      }
    })
  })

  $("#down").blur(function()
  {
    postData =
    {
      "function" : $("#function").val(),
      "left": $("#left").val(),
      "right": $("#right").val()
    };
    $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data: postData,
      success : function(data)
      {
        input_massive_string = data.toString();
        input_min_line_string = "";
        plot_graph()
      }
    })
  })

  $("#up").blur(function()
  {
    postData =
    {
      "function" : $("#function").val(),
      "left": $("#left").val(),
      "right": $("#right").val()
    };
    $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data: postData,
      success : function(data)
      {
        input_massive_string = data.toString();
        input_min_line_string = "";
        plot_graph()
      }
    })
  })
})
/////////////////////////////////////////////***********************************************************