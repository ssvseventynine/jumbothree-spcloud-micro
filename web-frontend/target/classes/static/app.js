var app = angular.module('DashboardApp', []);

app.controller('DashboardController', function($scope, $http) {
    // State management for tabs: 'inventory', 'orders', 'customers', 'billing'
    $scope.activeTab = 'inventory';
    
    // Base Gateway Routing URL
	var azureGateway = window.env && window.env.GATEWAY_URL;
	var gatewayBase = azureGateway ? azureGateway + '/api/v1' : 'http://localhost:9090/api/v1';

    // Data arrays
    $scope.inventoryData = [];
    $scope.ordersData = [];
    $scope.customersData = [];
    $scope.billingData = [];

    // Switch tab function
    $scope.setTab = function(tabName) {
        $scope.activeTab = tabName;
        if (tabName === 'inventory') { $scope.loadInventory(); }
        if (tabName === 'orders') { $scope.loadOrders(); }
        if (tabName === 'customers') { $scope.loadCustomers(); }
        if (tabName === 'billing') { $scope.loadBilling(); }
    };

    // 1. Fetch Inventory Data via Gateway
    $scope.loadInventory = function() {
        $http.get(gatewayBase + '/inventory')
            .then(function(response) {
                $scope.inventoryData = response.data;
            }, function(error) {
                console.error('Error fetching inventory:', error);
            });
    };

	// 2. Fetch Orders Data AND Inventory Stock in a safe, sequential chain
	    $scope.loadOrders = function() {
	        console.log("Initiating chained order framework data load...");
	        
	        // Step 1: Request the standard order list from the Order Service database
	        $http.get(gatewayBase + '/orders')
	            .then(function(orderResponse) {
	                // Safely bind the orders list to the UI variable
	                $scope.ordersData = orderResponse.data;
	                console.log("Orders history loaded successfully. Launching backchannel call next...");
	                
	                // Step 2: Now that orders are safe, execute the Feign backchannel stock call
	                return $http.get(gatewayBase + '/orders/check-stock');
	            })
	            .then(function(stockResponse) {
	                // Safely bind the cross-service inventory data to its UI variable
	                $scope.backchannelStock = stockResponse.data;
	                console.log("Backchannel stock metrics loaded successfully.");
	            })
	            .catch(function(error) {
	                // Catches errors from either of the two requests above
	                console.error('Data sync pipeline failure:', error);
	            });
	    };

    // 3. Fetch Customers Data via Gateway
    $scope.loadCustomers = function() {
        $http.get(gatewayBase + '/customers')
            .then(function(response) {
                $scope.customersData = response.data;
            }, function(error) {
                console.error('Error fetching customers:', error);
            });
    };

    // 4. Fetch Billing Data via Gateway
    $scope.loadBilling = function() {
        $http.get(gatewayBase + '/billing')
            .then(function(response) {
                $scope.billingData = response.data;
            }, function(error) {
                console.error('Error fetching billing:', error);
            });
    };

    // Initial configuration load
    $scope.loadInventory();
});