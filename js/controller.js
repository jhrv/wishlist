var wishlistApp = angular.module('wishlistApp', []);

wishlistApp.controller('wishlistCtrl', function ($scope) {
    $scope.applicationName = "Ønskeliste";

    $scope.wishes = [
        {'title': 'turshorts', 'link': 'https://www.norrona.com/en-GB/Products/7021-10/8851/fjora-shorts-m/'},
        {'title': 'dagstursekk', 'link': 'http://www.oslosportslager.no/produkt/sea-to-summit-ultra-sil-dry-20l-dagstursekk-28109.aspx'},
        {'title': 'sommerdekk', 'link': ''},
    ];

    $scope.addWish = function () {
        $scope.wishes.push({
            title: $scope.wishInput,
            link: "https://encrypted.google.com"
        });
        $scope.wishInput = '';
    };

    $scope.removeWish = function ($index) {
        $scope.wishes.splice($index, 1);
    };
});