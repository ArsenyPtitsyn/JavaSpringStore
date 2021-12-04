angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath= 'http://localhost:8189/app/products';

    $scope.fillTable = function () {
        $http({
            method: 'GET',
            url: contextPath,
            params: {
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    };

    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/' + productId)
        .then(function (response) {
            $scope.fillTable();
        });
    };

    $scope.createNewProduct = function () {
        $http.post(contextPath, $scope.newProduct)
        .then(function (response) {
            $scope.fillTable();
            $scope.newProduct = null;
        });
    };

    $scope.fillTable();
});