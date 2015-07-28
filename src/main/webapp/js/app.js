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

ffApp.service('ffService', function($http){
	var self = this;
	
	self.getFlights = function(filters) {
		return $http.get('rest/flights');
	}
});

