<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="vendorpage">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saloon Registration</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script type="text/javascript">
	(function() {
		var app = angular.module("vendorpage", [])
		var homectrl = function($scope, $http, $log) {

			var url = "http://localhost:8080/SaloonManagement";

			var onError = function(reason) {
				$scope.error = reason;
			}

			var onSaveComplete = function(response) {
				$scope.reply = response.data;
			}

			$scope.save = function() {
				$log.info(url + "/addVendor");
				$log.info($scope.vendor.name);
				var data = {};
				data["vendorName"] = $scope.vendor.name;

				$http.post(url + "/addVendor", data).then(onSaveComplete);
			}

		};
		app.controller("vendorcontroller", homectrl);

	}())
</script>
</head>
<body ng-controller="vendorcontroller">
	<center>
		<form ng-submit="save()" style="width: 600px;">

			<div class="form-group">
				<label>Vendor Name</label> <input type="text" ng-model="vendor.name"
					class="form-control">
			</div>

			<button type="submit" style="float: right;" class="btn btn-success">Save</button>
		</form>
	</center>
</body>
</html>