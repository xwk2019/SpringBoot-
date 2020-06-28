app.controller('brandController', function ($scope, $controller, brandService) {
    //controller继承
    $controller('baseController', {$scope: $scope});
    $scope.findAll = function () {
        //angular.js ajax的提交方法
        brandService.findAll().success(		//success:表示从后台取到数据的成功返回
            function (data) {
                $scope.entities = data;
            }
        )
    };
    $scope.update = function (entity) {
        brandService.update(entity).success(function (data) {
            if (data.success) {
                $scope.findPage();
                $scope.entity = {};
            } else {
                alert(data.message);
            }
        })
    };
    $scope.add = function (entity) {
        brandService.add(entity).success(function (data) {
            if (data.success) {
                $scope.findPage();
                $scope.entity = {};
            } else {
                alert(data.message);
            }
        })
    };
    $scope.findPage = function () {
        brandService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
            if (data != null) {
                $scope.entities = data.rows;
                $scope.paginationConf.totalItems = data.total;
            }
        })
    };
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (data) {
            $scope.entity = data;
        })
    };
})