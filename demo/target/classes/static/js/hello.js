/**
 * Created by Ray on 16/7/2.
 */
angular.module('hello', [])
    .controller('home',function ($scope,$http) {
        // $scope.greeting = {
        //     id: 'Ray',
        //     content: 'hello world'
        // }
        $http.get("/resource/").then(function (response) {
            $scope.greeting = response.data;
        })
    })