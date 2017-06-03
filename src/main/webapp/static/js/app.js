'use strict';

//declare modules
angular.module('Authentication', []);
angular.module('VenteControllers',[]);
angular.module('tutorialWebApp', [
 'Authentication',
 'ngRoute',
 'ngCookies','VenteControllers','ui.bootstrap'
])
.config(['$routeProvider', function ($routeProvider) {

 $routeProvider
	.when('/login', {
		controller: 'LoginController',
		templateUrl: 'modules/authentication/views/login.html'
	})
  	.when("/", {templateUrl: "partials/home.html", controller: "PageCtrl"})
	.when("/product", {templateUrl: "partials/product.html", controller: "PageCtrl"})
    .when("/product/:id", {templateUrl: "partials/product.html", controller: "ProductCtrl"})
	.when("/client", {templateUrl: "partials/home.html", controller: "PageCtrl"})
	.when("/register", {templateUrl: "modules/authentication/views/register.html", controller: "PageCtrl"})
    .when("/subscription", {templateUrl: "partials/subscription.html", controller: "PageCtrl"})

   
    // else 404
    .otherwise({ redirectTo: '/login' });
}])

.run(['$rootScope', '$location', '$cookieStore', '$http',
 function ($rootScope, $location, $cookieStore, $http) {
     // keep user logged in after page refresh
     $rootScope.globals = $cookieStore.get('globals') || {};
     if ($rootScope.globals.currentUser) {
         $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
     }

     $rootScope.$on('$locationChangeStart', function (event, next, current) {
         // redirect to login page if not logged in
         if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
             $location.path('/login');
         }
     });
 }]);