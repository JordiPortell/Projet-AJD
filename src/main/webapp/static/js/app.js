'use strict';

//declare modules
angular.module('Authentication', []);
angular.module('VenteControllers',['ngRoute']);
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
  	//.when("/inscription", {templateUrl: "partials/home.html", controller: "NewClientCtrl"})
	.when("/product", {templateUrl: "partials/product.html", controller: "PageCtrl"})
    .when("/product/:id", {templateUrl: "partials/product.html", controller: "ProductCtrl"})
    .when("/search/:search", {templateUrl: "partials/search.html", controller: "SearchCtrl"})
    .when("/search", {templateUrl: "partials/search.html", controller: "PageCtrl"})
    .when("/message/:message", {templateUrl: "partials/message.html", controller: "MsgCtrl"})
	.when("/client", {templateUrl: "partials/home.html", controller: "PageCtrl"})
	.when("/register", {templateUrl: "modules/authentication/views/register.html", controller: "PageCtrl"})
    .when("/subscription", {templateUrl: "partials/subscription.html", controller: "SubCtrl"})
    .when("/abonnement/:nb/:login", {templateUrl: "partials/home.html", controller: "PageCtrl"})
   // .when("/inscription", {templateUrl: "partials/home.html", controller: "NewClientCtrl"})
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
         // redirect to login page if not logged in and trying to access a restricted page
         var restrictedPage = $.inArray($location.path(), ['/subscription']) === -1;
         var loggedIn = $rootScope.globals.currentUser;
        // console.log(loggedIn);
         if (!restrictedPage && !loggedIn) {
            $location.path('/login');
         }

     /*$rootScope.$on('$locationChangeStart', function (event, next, current) {
         // redirect to login page if not logged in
    	 var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
         var loggedIn = $rootScope.globals.currentUser;
    	 $location.path('/login');
    	 console.log(restrictedPage);
         if (restrictedPage && !loggedIn ) {
             //&& !$rootScope.globals.currentUser
        
         }*/
     });
 }]);