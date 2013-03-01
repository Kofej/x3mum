previousGraphicPoints = null;
/////////////////////////////////////////////////*******************************************************
$.jqplot.config.enablePlugins = true;
function plot_graph(graphicPoints, minimumLinePoints)
{
  plot = null;
  var dx = 0.1; //TODO: must be some constant for graphic accuracy. It's difficult from method accuracy
  var points = [];
  var x_axis = [];
  var y_axis = [];
  var left = parseFloat($("#left").val());
  var right = parseFloat($("#right").val());
  var down = parseFloat($("#down").val());
  var up = parseFloat($("#up").val());

  // Calculate 'x' axis
  x_axis.push([left, 0]);
  x_axis.push([right, 0]);

  // Calculate 'y' axis
  y_axis.push([0, down]);
  y_axis.push([0, up]);

  var optionObj =
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
  };

  plot = $.jqplot('chartdiv', [x_axis, y_axis], optionObj)
  if(undefined != graphicPoints)
  {
    $("#chartdiv").empty();
    // Calculate graphic points
    var x_ = left;
    for(var i = 0; i < graphicPoints.length; i ++)
    {
      points.push([x_, graphicPoints[i]]);
      x_ += dx;
    }
    plot = $.jqplot('chartdiv', [points, x_axis, y_axis], optionObj)
    previousGraphicPoints = points;
  }
  else if(undefined != minimumLinePoints && null !=  previousGraphicPoints)
  {
    $("#chartdiv").empty();
    var min_line = [];
    min_line.push([minimumLinePoints[0], 0]);
    min_line.push([minimumLinePoints[0], minimumLinePoints[1]]);
    plot = $.jqplot('chartdiv', [previousGraphicPoints, x_axis, y_axis, min_line], optionObj)
  }
};

//////////////////////////////////////////************************************************************
$(document).ready(function()
{
  $("#function").blur(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data:
      {
        function : $("#function").val(),
        left: $("#left").val(),
        right: $("#right").val()
      }
    });
    request.done(function(data) {
      $("#function").css("color", "black")
      plot_graph(data, null)
      currentLeft = $("#left").val();
      currentRight = $("#right").val();
    });
    request.fail(function() {
      $("#function").css("color", "red")
    });
  });

  $("#findMin").click(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/findmin",
      data :
      {
        function : $("#function").val(),
        left: $("#left").val(),
        right: $("#right").val(),
        accuracy: $("#accuracy").val()
      }
    });
    request.done(function(data) {
      plot_graph(null, data.solution);
      currentLeft = $("#left").val();
      currentRight = $("#right").val();
    });
    request.fail(function() {
      $("#function").css("color", "red")
    });
  });

  $("#step").click(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/step",
      data :
      {
        function : $("#function").val(),
        left: currentLeft,
        right: currentRight,
        accuracy: $("#accuracy").val()
      }
    });
    request.done(function(data) {
      plot_graph(null, data.solution);
      currentLeft = data.left;
      currentRight = data.right;
    });
    request.fail(function() {
      $("#function").css("color", "red")
    });
  });

  $("#left").blur(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data:
      {
        function : $("#function").val(),
        left: $("#left").val(),
        right: $("#right").val()
      }
    });
    request.done(function(data) {
      plot_graph(data, null);
    });
  });

  $("#right").blur(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data:
      {
        function : $("#function").val(),
        left: $("#left").val(),
        right: $("#right").val()
      }
    });
    request.done(function(data) {
      plot_graph(data, null);
    });
  });

  $("#down").blur(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data:
      {
        function : $("#function").val(),
        left: $("#left").val(),
        right: $("#right").val()
      }
    });
    request.done(function(data) {
      plot_graph(data, null);
    });
  });

  $("#up").blur(function()
  {
    var request = $.ajax({
      type: "POST",
      url: "graph/grbuild",
      data:
      {
        function : $("#function").val(),
        left: $("#left").val(),
        right: $("#right").val()
      }
    });
    request.done(function(data) {
      plot_graph(data, null);
    });
  });

});
/////////////////////////////////////////////***********************************************************