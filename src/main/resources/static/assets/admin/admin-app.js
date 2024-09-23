app = angular.module("admin-app", ["ngRoute"]);
app.config(function ($routeProvider) {
$routeProvider


.when("/product", {
	templateUrl: "/assets/admin/product/index.html",
	controller: "product-ctrl"
})

.otherwise("/product", {
	template: "/assets/admin/product/index.html",
	controller: "product-ctrl"
});

})