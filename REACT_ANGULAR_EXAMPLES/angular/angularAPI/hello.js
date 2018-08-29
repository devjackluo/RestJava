angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/services/random').
        then(function(response) {
            $scope.data = response.data;
			console.log($scope.data);
        });
});