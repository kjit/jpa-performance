var ffApp = angular.module('ffApp', []);
ffApp.controller('FlightFindCtrl', ['$scope', 'ffService', function($scope, ffService){
	
	$scope.filters = {};
	$scope.flights = [];
	
	$scope.searchFlights = function() {
		ffService.getFlights($scope.filters).then(function(response){
			$scope.flights = response.data.flights;
		});
	};
}]);

ffApp.controller('FlightGeneratorCtrl', ['$scope', 'ffService', function($scope, ffService){

	$scope.params = {
		count : 10
	};

	$scope.generateFlights = function() {
		ffService.generateFlights($scope.params.count).then(function(response){
			$scope.info = response.data.response;
		});
	};
}]);

ffApp.service('ffService', function($http){
	var self = this;
	
	self.getFlights = function(filters) {
		return $http.post('rest/flights', filters);
	}

	self.generateFlights = function(count) {
		return $http.post('rest/flights/generate', count);
	}
});

