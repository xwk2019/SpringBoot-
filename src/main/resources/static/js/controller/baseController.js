app.controller('baseController', function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.findPage();
            //$scope.reloadList();//重新加载
        }
    };
    $scope.entities = [];
    $scope.entity = {};
    $scope.save = function () {
        if ($scope.entity.id != null)
            $scope.update($scope.entity);
        else
            $scope.add($scope.entity);
    }
    $scope.close = function () {
        $scope.entity = {};
    }
})
