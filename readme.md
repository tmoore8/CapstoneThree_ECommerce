# Easyshop 
___
### Overview
Easyshop is an existing  E-commerce application built with Spring Boot and MySql on the backend. For this project I acted as backend developer implementing new features and fixing bugs.
___
## Features Implemented
___
### Category Management
Implemented complete CRUD operations for categories:
* GET /categories: View all categories.
![img_2.png](img_2.png)
* GET /categories{id}: View a category by ID.
* GET /categories/{id}/products: View all products from a given category.
* POST /categories: Creates a new category.
* PUT /categories/{id}: Updates an existing category.
* DELETE /categories/{id}: Deletes a category.
Editing categories can only be done by an admin
![img_3.png](img_3.png)
### Products Management
* GET /products: View all products.
* GET /products{id}: View a product by ID.
* POST /products: Creates a new product.
* PUT /products/{id}: Updates an existing product.
* DELETE /products/{id}: Deletes a product.
  ![img_7.png](img_7.png)
## Bug Fixes
* Corrected Search and Filter logic to return proper products based on search criteria.
![img_4.png](img_4.png)

* Identified the cause of duplicate product entries.
![img_6.png](img_6.png)
## Interesting piece of Code 
Fixed the maximum price on the frontend 

![img_1.png](img_1.png)

