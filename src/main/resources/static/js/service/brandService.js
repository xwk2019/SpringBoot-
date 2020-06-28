app.service('brandService', function ($http) {
    //service负责与后台进数据交互
    this.findAll = function () {
        return $http.get('../brand/getAllBrands');
    }
    this.update = function (entity) {
        return $http.post('../brand/updateBrand', entity);
    }
    this.addBrand = function (entity) {
        return $http.post('../brand/addBrand', entity);
    }
    this.findPage = function (pageNo, pageSize) {
        return $http.get('../brand/findPage?pageNo=' + pageNo + '&pageSize=' + pageSize);
    }
    this.findOne = function (id) {
        return $http.get('../brand/findOne?id=' + id);
    }
})