
(function () {
    'use strict';
    angular
        .module('app')
        .controller('BookCtrl', BookCtrl);

    BookCtrl.$inject = ['$http'];

    function BookCtrl($http) {
        var bc = this;

        bc.books = [];
        bc.getAll = getAll;
        bc.getByRating = getByRating;
        bc.deleteBooks = deleteBooks;
        bc.addVote = addVote;
        bc.start = start;
        bc.createBooks = createBooks;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "api/books/all";
            var booksStore = $http.get(url);
            booksStore.then(function(response){
                bc.books = response.data;
                console.log(bc.books);
            });
        }

        function getByRating(rating){
            var url = "api/books/rating/" + rating;
            var booksStore = $http.get(url);
            booksStore.then(function(response){
                bc.books = response.data;
            });
        }

        function deleteBooks(id){
            var url = "api/books/delete/" + id;
            $http.post(url).then(function(response){
                bc.books = response.data;
            });
        }

        function createBooks(book){

            console.log("book title: "+book.title)
            var url = "api/books/create/";
            $http.post(url,book).then(function(response){
                bc.books = response.data;
            });
        }

        function addVote(id) {
            var url = "api/books/addvote/" + id;
            $http.put(url,id).then(function(response){

            });

            start();
            window.location.href = '/result';

        }
        function start() {
            bc.flag= true;

        };



    }
})();
