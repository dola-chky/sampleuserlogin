'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={id:null,username:'',fullName:'',dateOfBirth:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.showtest = showtest;
    self.login = login;


    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

   function fetchUserById() {
	   UserService.fetchUserById(user)
       .then(
       function(d) {
           self.user = d;
       },
       function(errResponse){
           console.error('Error while fetching User');
       }
   );
   }

    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }

  
    function reset(){
        self.user={id:null,username:'',fullName:'',dateOfBirth:''};
        $scope.myForm.$setPristine(); //reset Form
    }
    
    function showtest(){
    	alert("inside method");
    	UserService.getStaticPage();
    }
    
    function login(user) {
    	  if(self.user.userId != null && self.user.password != null){
    		  UserService.userLogin(self.user);
    	  } 
    }

}]);
