var wishlistApp = angular.module('wishlistApp', []);

wishlistApp.controller('wishlistCtrl', function ($scope){
    $scope.applicationName = "Ønskeliste"

    $scope.wishes = [
        {'title': 'turshorts', 'link': 'https://www.norrona.com/en-GB/Products/7021-10/8851/fjora-shorts-m/'},
        {'title': 'dagstursekk', 'link': ''},
        {'title': 'sommerdekk', 'link': ''},
    ]
});