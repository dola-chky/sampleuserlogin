'use strict';
 
angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/userloginexample/user';
 
    var factory = {
        fetchAllUsers: fetchAllUsers,
        fetchUserByName: fetchUserByName,
        createUser: createUser,
        loginUser: loginUser
    };
 
    return factory;
 
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchUserById (user){
    	 var deferred = $q.defer();
         $http.get('http://localhost:8080/userloginexample/user/{user.id}')
             .then(
             function (response) {
                 deferred.resolve(response.data);
             },
             function(errResponse){
                 console.error('Error while fetching Users');
                 deferred.reject(errResponse);
             }
         );
         return deferred.promise;
    }
 
    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function loginUser(user) {
        var deferred = $q.defer();
        $http.post("http://localhost:8080/userloginexample/login", user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('invalid userName/password');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);