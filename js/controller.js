"use strict";

var wishlistApp = angular.module('wishlistApp', []);

wishlistApp.controller('wishlistCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.applicationName = "Ønskeliste";

    $http.get('http://localhost:1337/wishes').success(function (data) {
        console.log("gikk jo greit?")
        $scope.wishes = data;
    });

    $scope.addWish = function () {
        var input = inputParser($scope.wishInput);
        $scope.wishes.push({
            title: input.title,
            link: input.link
        });
        $scope.wishInput = '';
    };

    $scope.removeWish = function ($index) {
        $scope.wishes.splice($index, 1);
    };
}]);

var inputParser = function (input) {
    var splitted = input.split("@");
    var title = splitted[0];
    var link = linkFixer(splitted[1]);
    return {
        "title": title,
        "link": link
    };
};

var linkFixer = function (link) {
    if (link.indexOf("http") === 0) {
        return link;
    } else {
        return "http://" + link;
    }
}
