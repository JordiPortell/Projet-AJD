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



//******************** MESSAGE CTRL
VenteControllers.controller('MsgCtrl',function($scope,$http,$routeParams,$location,$rootScope) {
		$scope.msg = $routeParams.message;
	  
});


//******************** SEARCH CTRL
VenteControllers.controller('SearchCtrl',function($scope,$http,$routeParams,$location,$rootScope) {
		$http.get('http://localhost:8080/search/'+$routeParams.search).
		  success(function(data, status, headers, config) {
				$scope.produits=data;
				$scope.search=$routeParams.search;
				console.log($rootScope);
				$scope.user = $rootScope.globals.currentUser.username;
		  }).
		  error(function(data, status, headers, config) {
		  });	
	  
});


//******************** SUB CTRL
VenteControllers.controller('SubCtrl',['$scope','$http','$routeParams','$location','$rootScope',function($scope,$http,$routeParams,$location,$rootScope) {

	$scope.user=$rootScope.globals.currentUser.username;
	
	$scope.Abonnemet = function(id) {
		var msg;
		var tab = [];
		tab.push(id.toString());
		tab.push($scope.user);
		$http.post('http://localhost:8080/subscription/',tab).
		success(function(data, status, headers, config) {
			msg = 'Abonnement réalisé avec succès';
			$location.path('/message/'+msg);
		}).
		  error(function(data, status, headers, config) {
			  msg = 'Une erreur est survenue pendant l\'abonnement'
			  $location.path('/message/'+msg);
		  });
		
	}
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


//******************** PAGE CTRL
VenteControllers.controller('PageCtrl',['$scope','$http','$routeParams','$location','$rootScope',function($scope,$http,$routeParams,$location,$rootScope) {

  var _selected;
  $scope.Inscription = function(nom,prenom,adresse,login,password) {

	var msg;
	var tab = [];
	tab.push(nom);
	tab.push(prenom);
	tab.push(adresse);
	tab.push(login);
	tab.push(password);
	console.log(tab);

	$http.post('http://localhost:8080/inscription',tab).
	success(function(data, status, headers, config) {
		msg = 'Vous êtes désormais inscrit';
		$location.path('/message/'+msg);
	}).
	  error(function(data, status, headers, config) {
		  msg = 'Une erreur est survenue pendant l\'inscription'
		  $location.path('/message/'+msg);
	  });
  }

  $scope.Search = function() {
	$location.path('/search/'+$scope.selected);
  }
	
  $scope.selected = undefined;
  

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

	//**************************** Récupération autocomplete
	  var states = [];
	  //récupération des origines
	  $http.get('http://localhost:8080/origine').
	  success(function(data, status, headers, config) {
	  		for(var i=0;i<data.length;i++)
	  		{
	  			if(states.indexOf(data[i].libelle)==-1)states.push(data[i].libelle);
	  		}
	  	//récupération des produits
	  	  $http.get('http://localhost:8080/produit').
	  	  success(function(data1, status1, headers1, config1) {
	  	  		for(var i=0;i<data1.length;i++)
	  	  		{
	  	  			if(states.indexOf(data1[i].libelle)==-1)states.push(data1[i].libelle);
	  	  			if(states.indexOf(data1[i].type)==-1)states.push(data1[i].type);
	  	  		}
	  	  		$scope.states=states;
	  	  }).
	  	  error(function(data1, status1, headers1, config1) {
	  	  });
	  	//**************************** Récupération autocomplete 
	  		
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
	  console.log($routeParams.id);
		$http.get('http://localhost:8080/product/'+$routeParams.id).
		  success(function(data, status, headers, config) {
				$scope.produit=data;
		  }).
		  error(function(data, status, headers, config) {
		  });
	});

