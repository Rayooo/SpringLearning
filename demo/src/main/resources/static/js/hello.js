/**
 * Created by Ray on 16/7/2.
 */
angular.module('hello', [])
    .controller('home',function ($scope) {
        $scope.greeting = {
            id: 'Ray',
            content: 'hello world'
        }
    })