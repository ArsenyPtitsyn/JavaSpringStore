angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.fillTable = function (page = 1) {
        $http({
            method: 'GET',
            url: contextPath + '/products',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null,
                p: page
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
            $scope.PageArray = $scope.generatePages(1, $scope.ProductsPage.totalPages);
        });
    };

    $scope.generatePages = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
        .then(function (response) {
            $scope.fillTable();
        });
    };

    $scope.createNewProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
        .then(function (response) {
            $scope.fillTable();
            $scope.newProduct = null;
        });
    };

    $scope.fillTable();
});