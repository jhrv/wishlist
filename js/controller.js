var wishlistApp = angular.module('wishlistApp', []);

wishlistApp.controller('wishlistCtrl', function ($scope){
    $scope.wishes = [
        {'title': 'turshorts'},
        {'title': 'dagstursekk'},
        {'title': 'sommerdekk'},
    ]
});