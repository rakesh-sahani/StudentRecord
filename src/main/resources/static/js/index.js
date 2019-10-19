var app = angular.module('student', []);
app.controller('studentData', function($scope, $http,$window) {

	$scope.title = "Student Record";
	$scope.sdata = [];
	$scope.name="";
	$scope.course="";
	
	
	$http({
		method : "GET",
		url : "http://localhost:8080/api/v1/view"
	}).then(function success(response) {
		for(let i=0;i<response.data.length;i++)
			{
			$scope.sdata.push(response.data[i]);
			console.log($scope.sdata);
			}
	}, function error(response) {
		console.log(response);

	});
	
	
	$scope.add = function()
	{
		$http({
			method : "POST",
			url : "http://localhost:8080/api/v1/add",
			data: {name:$scope.name,course :$scope.course}
		}).then(function success(response) {
			$window.location.reload();
		}, function error(response) {
			console.log(response);

		});
	}
	
	$scope.del = function(id)
	{
		$http({
			method : "DELETE",
			url : "http://localhost:8080/api/v1//delete/"+id,
		}).then(function success(response) {
			$window.location.reload();
		}, function error(response) {
			console.log(response);

		});
	}

});