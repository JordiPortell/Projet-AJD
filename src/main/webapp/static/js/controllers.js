'use strict';

var VenteControllers = angular.module('VenteControllers', ['ngRoute']);



/**
 * Controls the Blog
 */
VenteControllers.controller('BlogCtrl',function($scope,$http,$routeParams) {
  console.log("Blog Controller reporting for duty.");
  $http.get('http://localhost:8080/produit/').
  success(function(data, status, headers, config) {
		$scope.client=data;
		console.log(data);
  }).
  error(function(data, status, headers, config) {
  });
});

/**
 * Controls all other Pages
 */

VenteControllers.controller('NewClientCtrl',function($scope,$http,$routeParams,$location) {
	
	$location.path('/');
	$http.post('http://localhost:8080/inscription',$scope.nom,$scope.prenom,$scope.login,$scope.password,$scope.adresse);
});



<<<<<<< HEAD
VenteControllers.controller('PageCtrl',['$scope','$http','$routeParams','$location',function($scope,$http,$routeParams,$location) {
	console.log("Page Controller reporting for duty.");
  
<<<<<<< HEAD
	var _selected;
	$scope.choisirVoiture = function(nom,prenom,adresse,login,password) {
=======
=======
VenteControllers.controller('PageCtrl',['$scope','$http','$routeParams','$location','$rootScope',function($scope,$http,$routeParams,$location,$rootScope) {
  console.log("Page Controller reporting for duty.");
  console.log($rootScope.globals.currentUser.username);
>>>>>>> origin/master
  var _selected;
$scope.Inscription = function(nom,prenom,adresse,login,password) {
>>>>>>> origin/master
	var tab = [];
	tab.push(nom);
	tab.push(prenom);
	tab.push(adresse);
	tab.push(login);
	tab.push(password);
	console.log(tab);

	$http.post('http://localhost:8080/inscription',tab);	
	$location.path('/');
}
	
  $scope.selected = undefined;
  

  
  $scope.states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Dakota', 'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];
  // Any function returning a promise object can be used to load values asynchronously
  $scope.getLocation = function(val) {
    return $http.get('//maps.googleapis.com/maps/api/geocode/json', {
      params: {
        address: val,
        sensor: false
      }
    }).then(function(response){
      return response.data.results.map(function(item){
        return item.formatted_address;
      });
    });
  };

  $scope.ngModelOptionsSelected = function(value) {
    if (arguments.length) {
      _selected = value;
    } else {
      return _selected;
    }
  };

  $scope.modelOptions = {
    debounce: {
      default: 500,
      blur: 250
    },
    getterSetter: true
  };


	$http.get('http://localhost:8080/produit/').
	  success(function(data, status, headers, config) {
			$scope.produits=data;
	  }).
	  error(function(data, status, headers, config) {
	  });


 
}]);

VenteControllers.controller('auth', function ($scope, $location, $cookieStore, authorization, api) {
	  $scope.title = 'Likeastore. Analytics';

	  $scope.login = function () {
	      var credentials = {
	          username: this.username,
	          token: this.token
	      };

	      var success = function (data) {
	          var token = data.token;

	          api.init(token);

	          $cookieStore.put('token', token);
	          $location.path('/');
	      };

	      var error = function () {
	          // TODO: apply user notification here..
	      };

	      authorization.login(credentials).success(success).error(error);
	  };
	});

VenteControllers.factory('authorization', function ($http, config) {
	  var url = config.analytics.url;

	  return {
	      login: function (credentials) {
	          return $http.post(url + '/auth', credentials);
	      }
	  };
	});

VenteControllers.factory('api', function ($http, $cookies) {
	  return {
	      init: function (token) {
	          $http.defaults.headers.common['X-Access-Token'] = token || $cookies.token;
	      }
	  };
	});


//******************** PRODUCT CTRL
VenteControllers.controller('ProductCtrl',function($scope,$http,$routeParams) {
	  console.log("Page Controller reporting for duty.");
	  console.log($routeParams.id);
		$http.get('http://localhost:8080/product/'+$routeParams.id).
		  success(function(data, status, headers, config) {
				$scope.produit=data;
		  }).
		  error(function(data, status, headers, config) {
		  });
	});


//******************** AUTOCOMPLETE CTRL
VenteControllers.controller('AutocompleteControl',function($scope,$http) {
	//**************************** Récupération autocomplete
	  var states = [];
	  //récupération des origines
	  $http.get('http://localhost:8080/origine').
	  success(function(data, status, headers, config) {
	  		for(var i=0;i<data.length;i++)
	  		{
	  			if(states.indexOf(data[i].libelle)==-1)states.push(data[i].libelle);
	  		}
	  		console.log(states);
	  		
	  	//récupération des produits
	  	  $http.get('http://localhost:8080/produit').
	  	  success(function(data1, status1, headers1, config1) {
	  	  		for(var i=0;i<data1.length;i++)
	  	  		{
	  	  			if(states.indexOf(data1[i].libelle)==-1)states.push(data1[i].libelle);
	  	  			if(states.indexOf(data1[i].type)==-1)states.push(data1[i].type);
	  	  		}
	  	  		console.log(states);
	  	  		
	  	  		$scope.states=states;
	  	  }).
	  	  error(function(data1, status1, headers1, config1) {
	  	  });
	  	//**************************** Récupération autocomplete 
	  		
	  }).
	  error(function(data, status, headers, config) {
	  });

	  
	  
	});
